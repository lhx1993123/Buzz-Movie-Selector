
package com.lightningfalcons;

import com.rottentomatoes.Movie;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * The controller that supports the search function
 *
 * @author Lance
 */
@ManagedBean(eager = true)
@SessionScoped
public class SearchMoviesController implements Serializable {
    private List<Movie> movies;
    private String keyWord;
    private static final long serialVersionUID = -403250971215465050L;
    /**
     * Get the movies
     *
     * @return movies
     */
    public List<Movie> getMovies() {
        return movies;
    }

    /**
     * Set movies
     *
     * @param movies the movieList to be set
     */
    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    /**
     * Get the keyWord
     *
     * @return keyWord
     */
    public String getKeyWord() {
        return keyWord;
    }

    /**
     * Set keyWord
     *
     * @param movies the keyWord to be set
     */
    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    /**
     * Get the movieList
     *
     * @return searchpage
     */
    public String getMovieList() {
        RottenTomatoes rt = new RottenTomatoes();
        //System.out.println("In get movie list method key word is: "+ keyWord);
        movies = rt.searchMovies(keyWord);
        return "searchpage?faces-redirect=true";
    }
}
