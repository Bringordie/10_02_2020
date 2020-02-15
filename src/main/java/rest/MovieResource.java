package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.Movie;
import utils.EMF_Creator;
import facades.MovieFacade;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.google.gson.Gson;
import javax.ws.rs.QueryParam;

//Todo Remove or change relevant parts before ACTUAL use
@Path("movie")
public class MovieResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(
                "pu",
                "jdbc:mysql://localhost:3307/startcode",
                "dev",
                "ax2",
                EMF_Creator.Strategy.CREATE);
    
    //An alternative way to get the EntityManagerFactory, whithout having to type the details all over the code
    //EMF = EMF_Creator.createEntityManagerFactory(DbSelector.DEV, Strategy.CREATE);
    
    private static final MovieFacade FACADE =  MovieFacade.getFacadeExample(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
            
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello World\"}";
    }
    
    @Path("/all")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getAll() {
        List<Movie> movies = FACADE.getMovies();
        Gson gson = new Gson();
        //return "{\"Movie: \":"+movies+"}";  
        String json = gson.toJson(movies);
        return json;
    }
    
    @Path("/count")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getCount() {
        long movies = FACADE.countOfMovies();
        return "{\"count\":"+movies+"}";  
    }
    
//    @GET
//    @Path("/name/{name}")
//    @Produces({MediaType.APPLICATION_JSON})
//    public String getUserByID(@QueryParam("name") String name) {
//        //Gson gson = new Gson();
//        String json = GSON.toJson(FACADE.findByName(name));
//        return json;
//    }
    
    @GET
    @Path("/name/{name}")
    @Produces({MediaType.APPLICATION_JSON})
    public String getUserByID(@PathParam("name") String name) {
        //Gson gson = new Gson();
        return GSON.toJson(FACADE.findByName(name));
    }
    
    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public String getUserByID(@PathParam("id") Long id) {
        //Gson gson = new Gson();
        return GSON.toJson(FACADE.getMovieById(id));
    }
    
}
