package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.ReviewDTO;
import entities.Review;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import facades.ReviewFacade;
import utils.EMF_Creator;

/**
 * @author Christoffer
 */
@Path("review")
public class ReviewResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final ReviewFacade reviewFacade = ReviewFacade.getReviewFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @Context
    private UriInfo context;

    @Context
    SecurityContext securityContext;

    //Just to verify if the database is setup
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getInfoForAll() {
        return "{\"msg\":\"Hello user\"}";
    }

    //Get all reviews
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("all")
    public String allReviews() {

        EntityManager em = EMF.createEntityManager();
        try {
            TypedQuery<Review> query = em.createQuery("select r from Review r", entities.Review.class);
            List<Review> reviews = query.getResultList();
            return "[" + reviews.size() + "]";
        } finally {
            em.close();
        }
    }

    //Create a review
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response createReview(String content) {
        ReviewDTO rd = GSON.fromJson(content, ReviewDTO.class);
        Review r = reviewFacade.addReview(rd.getBookshelf_id(), rd.getBook_id(), rd.getReview_score(), rd.getReview_text());
        return Response.ok(GSON.toJson(new ReviewDTO(r))).build();
    }

}
