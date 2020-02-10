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
    private int raiting;
    private int runtime;
    private int releaseyear;
    
    public Movie() {
    }
        
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    

    public Movie(String name, int raiting, int runtime, int releaseyear) {
        this.name = name;
        this.raiting = raiting;
        this.runtime = runtime;
        this.releaseyear = releaseyear;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public int getRaiting() {
        return raiting;
    }

    public int getRuntime() {
        return runtime;
    }

    public int getReleaseyear() {
        return releaseyear;
    }

    @Override
    public String toString() {
        return "Movie{" + "id=" + id + ", name=" + name + ", raiting=" + raiting + ", runtime=" + runtime + ", releaseyear=" + releaseyear + '}';
    }

    
    
    
    
    

   
}
