package rest;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.UserDTO;
import entities.User;
import facades.UserFacade;
import utils.EMF_Creator;

import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

@Path("user")
public class UserResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

    private static final UserFacade userFacade = UserFacade.getUserFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @Context
    private UriInfo context;

    @Context
    SecurityContext securityContext;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String user() {
        return "{\"msg\":\"Hello User\"}";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("all")
    public String allUsers() {

        EntityManager em = EMF.createEntityManager();
        try {
            TypedQuery<User> query = em.createQuery("select u from User u", entities.User.class);
            List<User> users = query.getResultList();
            return "[" + users.size() + "]";
        } finally {
            em.close();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("user")
    @RolesAllowed("user")
    public String getFromUser() {
        String thisuser = securityContext.getUserPrincipal().getName();
        return "{\"msg\": \"Hello to User: " + thisuser + "\"}";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("admin")
    @RolesAllowed("admin")
    public String getFromAdmin() {
        String thisuser = securityContext.getUserPrincipal().getName();
        return "{\"msg\": \"Hello to (admin) User: " + thisuser + "\"}";
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response createUser(String content) {
        System.out.println(content + "hejhej hjej");
        UserDTO udto = GSON.fromJson(content, UserDTO.class);
        User newUser = userFacade.addUser(udto.getUsername(), udto.getPassword());
        return Response.ok(GSON.toJson(newUser)).build();

    }

    @PUT
    @Path("/{name}")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response editUser(@PathParam("name") String name, String content) throws Exception {
        UserDTO udto = GSON.fromJson(content, UserDTO.class);
        udto.setUsername(name);
        User newUser = userFacade.editUser(udto.getUsername(), udto.getPassword());
        return Response.ok(GSON.toJson(newUser)).build();
    }

    @DELETE
    @Path("/{name}")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response deleteUser(@PathParam("name") String name) throws Exception {
        UserDTO udto = GSON.fromJson(name, UserDTO.class);
        udto.setUsername(name);
        User newUser = userFacade.deleteUser(udto.getUsername());
        return Response.ok(GSON.toJson(newUser)).build();
    }
}

