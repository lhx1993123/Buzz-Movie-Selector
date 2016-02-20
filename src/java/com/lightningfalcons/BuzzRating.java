/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lightningfalcons;

import java.io.Serializable;

/**
 * The Rating class is to store the information of user's rating
 * @author Yufan
 */
public class BuzzRating implements Serializable {
    private String movieId;
    private int scores;
    private String comments;
    private String username;
    private static final long serialVersionUID = -403250971215465050L;

    /**
     * Get movie id
     *
     * @return movieID
     */
    public String getMovieId() {
        return movieId;
    }

    /**
     * Set movie ID
     *
     * @param movieID a String
     */
    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    /**
     * Get score of a movie
     *
     * @return score an int
     */
    public int getScores() {
        return scores;
    }

    /**
     * Set the score
     *
     * @param scores an int
     */
    public void setScores(int scores) {
        this.scores = scores;
    }

    /**
     * Get comments
     *
     * @return list of comments
     */
    public String getComments() {
        return comments;
    }

    /**
     * Set comments
     *
     * @param comment of a movie
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * Get the name of user
     *
     * @return list of username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set username
     *
     * @param username of user
     */
    public void setUsername(String u) {
        this.username = u;
    }

}
