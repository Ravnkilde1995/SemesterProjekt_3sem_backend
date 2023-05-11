package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.BookshelfDTO;
import entities.Bookshelf;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import facades.BookshelfFacade;
import utils.EMF_Creator;

/**
 * @author oliver
 */
@Path("bookshelf")
public class BookshelfResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final BookshelfFacade bookshelfFacade =  BookshelfFacade.getBookshelfFacade(EMF);
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


    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response createBookshelf(String content){
        BookshelfDTO bs = GSON.fromJson(content, BookshelfDTO.class);
        //tjekke om hvorvidt der er en bog med username & en titel

        Bookshelf b = bookshelfFacade.addBookshelf(bs.getUser_name(), bs.getTitle(), bs.getAuthor(), bs.getDescription());
        return Response.ok(GSON.toJson(new BookshelfDTO(b))).build();
    }


}
