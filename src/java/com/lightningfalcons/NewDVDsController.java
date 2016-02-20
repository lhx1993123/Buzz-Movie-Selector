package com.lightningfalcons;

import com.rottentomatoes.Movie;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * Controller that supports 'getting new DVDs' function
 * @author Yufan
 */
@ManagedBean(eager = true)
@ViewScoped
public class NewDVDsController implements Serializable {

    private List<Movie> movies;
    private static final long serialVersionUID = -403250971215465050L;

    /**
     * Initialize the list of movies
     */
    @PostConstruct
    public void init() {
        RottenTomatoes rt = new RottenTomatoes();
        movies = rt.newDVDReleases();
    }

    /**
     * Get the new DVDs list
     *
     * @return list of movies
     */
    public List<Movie> getMovies() {
        return movies;
    }
}
