package com.lightningfalcons;

import com.rottentomatoes.Movie;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 * Controller that supports 'getting Recommendations ' function
 *
 * @author Yufan
 */
@ManagedBean(eager = true)
@ViewScoped
public class RecommendationsController implements Serializable {
    private static final long serialVersionUID = 6106269076155338045L;

    @ManagedProperty(value = "#{loginBean}")

    private LoginBean loginBean;

    /**
     * Set the login bean
     *
     * @param loginBean the given login bean
     */
    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }
    private List<Movie> movies;

    /**
     * Initialize the list of movies
     */
    @PostConstruct
    public void init() {
        if (loginBean == null) {
            return;
        }
        movies = RatingManager.getRecommendations(loginBean.getCurrentUser()
            .getMajor());
    }

    /**
     * Get the Recommendations list
     *
     * @return list of movies
     */
    public List<Movie> getMovies() {
        return movies;
    }
}
