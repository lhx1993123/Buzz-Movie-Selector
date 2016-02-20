/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lightningfalcons;

import com.rottentomatoes.Movie;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RateEvent;

/**
 * This is the controller for the selected movie
 *
 * @author Yufan
 */
@ManagedBean(eager = true)
@SessionScoped
public class MovieGridViewController implements Serializable {

    private Movie selectedMovie;
    private List<BuzzRating> ratingList;
    private static final long serialVersionUID = -403250971215465050L;
    private int scores;
    private String comments;

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

    @PostConstruct
    public void init() {
        //ratingList = RatingManager.getRatings(selectedMovie.getId());
    }

    /**
     * Set the selectedMovie
     *
     * @param selectedMovie a movie to be set to selectedMovie
     */
    public void setSelectedMovie(Movie selectedMovie) {
        this.selectedMovie = selectedMovie;
        ratingList = RatingManager.getRatings(selectedMovie.getId());
    }

    /**
     * Get the selectedMovie
     *
     * @return Movie the selectedMovie
     */
    public Movie getSelectedMovie() {
        return selectedMovie;
    }

    /**
     * Get score
     * @return scores an int
     */
    public int getScores() {
        return scores;
    }

    /**
     * Set score
     * @param scores an int
     */
    public void setScores(int scores) {
        this.scores = scores;
    }

    /**
     * Get Comment
     * @return comments a string
     */
    public String getComments() {
        return comments;
    }

    /**
     *  Set comments
     * @param comments a String
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * Get rating list
     *
     * @return ratingList a List
     */
    public List<BuzzRating> getRatingList() {
        return ratingList;
    }

    /**
     * Set the new rating list
     *
     * @param ratingList a List
     */
    public void setRatingList(List<BuzzRating> ratingList) {
        this.ratingList = ratingList;
    }

    /**
     * Update the database according to the current rating
     */
    public String submitRating() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        if (selectedMovie == null) {
            return "";
        }
        if (loginBean == null) {
            return "";
        }
        if (scores > 0) {
            RatingManager.addRating(scores, comments, selectedMovie.getId(),
                loginBean.getInputUsername());
            facesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Successful",
                    "Your rating has been submitted"));
        } else {
            facesContext.addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Sample info message", "PrimeFaces rocks!"));
        }
        return "welcome";
    }

    /**
     * The rate event show
     *
     * @param rateEvent an rateEvent
     */
    public void onrate(RateEvent rateEvent) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
            "Rate Event", "You rated:"
                + ((Integer) rateEvent.getRating()).intValue());
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /**
     * The rate event cancel
     */
    public void oncancel() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
            "Cancel Event", "Rate Reset");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
