package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;


@Entity
@NamedQuery(name = "Movie.deleteAllRows", query = "DELETE from Movie")
public class Movie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int rating;
    private int runtime;
    private int releaseyear;
    private String actor;
    
    public Movie() {
    }
        
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    

    public Movie(String name, int rating, int runtime, int releaseyear, String actor) {
        this.name = name;
        this.rating = rating;
        this.runtime = runtime;
        this.releaseyear = releaseyear;
        this.actor = actor;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public int getRaiting() {
        return rating;
    }

    public int getRuntime() {
        return runtime;
    }

    public int getReleaseyear() {
        return releaseyear;
    }

    @Override
    public String toString() {
        return "Movie{" + "id=" + id + ", name=" + name + ", rating=" + rating + ", runtime=" + runtime + ", releaseyear=" + releaseyear + ", actor=" + actor + '}';
    }


   
}
