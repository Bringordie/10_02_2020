package facades;

import entities.Movie;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class MovieFacade {

    private static MovieFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    public MovieFacade() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static MovieFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new MovieFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public List<Movie> getMovies(){
        EntityManager em = emf.createEntityManager();
        try{
            List<Movie> movies = em.createQuery("SELECT m FROM Movie m order by m.name desc").getResultList();
            return movies;
        }finally{  
            em.close();
        }
        
    }
    
    public long countOfMovies(){
        EntityManager em = emf.createEntityManager();
        try{
            long renameMeCount = (long)em.createQuery("SELECT COUNT(m) FROM Movie m").getSingleResult();
            return renameMeCount;
        }finally{  
            em.close();
        }
        
    }
    
    public void addMovie(Movie movie) {
       EntityManager em = getEntityManager();
       em.createNativeQuery("INSERT INTO Movie (name, raiting, runtime, releaseyear) VALUES (?,?,?,?)")
      .setParameter(1, movie.getName())
      .setParameter(2, movie.getRaiting())
      .setParameter(3, movie.getRuntime())
      .setParameter(4, movie.getReleaseyear())
      .executeUpdate();
    }

    public Movie findByName(String name) {
        EntityManager em = getEntityManager();
        TypedQuery q = em.createQuery("SELECT m FROM Movie m where m.name = :name", Movie.class);
        q.setParameter("name", name);
        return (Movie) q.getSingleResult();
    }

    public Object findById(Long id) {
        EntityManager em = getEntityManager();
        TypedQuery q = em.createQuery("SELECT m FROM Movie m where m.id = :id", Movie.class);
        q.setParameter("id", id);
        return q.getResultList();
    }
    
    public Movie getMovieById(Long id){
        EntityManager em = emf.createEntityManager();
        try{
            return em.find(Movie.class, id);
        }finally{
            em.close();
        }
    }
    
    
}
