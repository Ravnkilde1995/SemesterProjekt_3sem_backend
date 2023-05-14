package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.BookshelfDTO;
import entities.Bookshelf;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import entities.User;
import facades.BookshelfFacade;
import utils.EMF_Creator;

import java.util.List;

/**
 * @author oliver
 */
@Path("bookshelf")
public class BookshelfResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final BookshelfFacade bookshelfFacade = BookshelfFacade.getBookshelfFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @Context
    private UriInfo context;

    @Context
    SecurityContext securityContext;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getInfoForAll() {
        return "{\"msg\":\"Hello to bookshelf\"}";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("all")
    public List<Bookshelf> allInBookshelf() {

        EntityManager em = EMF.createEntityManager();
        try {
            TypedQuery<Bookshelf> query = em.createQuery("select b from Bookshelf b", entities.Bookshelf.class);
            List<Bookshelf> bookshelves = query.getResultList();
            return bookshelves;
        } finally {
            em.close();
        }
    }
    
    @GET
    @Path("/{user_name}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Bookshelf> getBookshelvesByUsername(@PathParam("user_name") String user_name) {
        List<Bookshelf> bookshelves = bookshelfFacade.getByUsername(user_name);

        return bookshelves;
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response createBookshelf(String content) {
        BookshelfDTO bs = GSON.fromJson(content, BookshelfDTO.class);
        //tjekke om hvorvidt der er en bog med username & en titel

        Bookshelf b = bookshelfFacade.addBookshelf(bs.getUser_name(), bs.getTitle(), bs.getAuthor(), bs.getDescription(),bs.getGoogle_id());
        return Response.ok(GSON.toJson(new BookshelfDTO(b))).build();
    }

    /*
    Todo: edit update function if time.
    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Response putHobby(@PathParam("id") long id, String input) throws Exception {
        HobbyDTO hdto = GSON.fromJson(input, HobbyDTO.class);
        System.out.println(hdto);

        System.out.println("Get the id yes: " + hdto.getId());
        hdto = FACADE.updateHobby(id, hdto);
        hdto.setId(id);
        return Response.ok().entity(hdto).build();
    }*/

}
