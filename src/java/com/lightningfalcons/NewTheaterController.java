package com.lightningfalcons;

import com.rottentomatoes.Movie;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
//import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author xinmin shi
 */
@ManagedBean(eager = true)
@ViewScoped
public class NewTheaterController implements Serializable {

    private List<Movie> movies;
    private static final long serialVersionUID = -403250971215465050L;
    /**
     * Initialize the list of movies
     */
    @PostConstruct
    public void init() {
        RottenTomatoes rt2 = new RottenTomatoes();
        movies = rt2.newTheaterReleases();
    }

    /**
     * Get the new theaters release list
     *
     * @return list of movies
     */
    public List<Movie> getMovies() {
        return movies;
    }
}
