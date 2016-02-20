/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lightningfalcons;

import com.rottentomatoes.Movie;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * The Manager to manage movies from RottenTomatoes
 * @author Yufan
 */
@ManagedBean(name = "movieManager")
@SessionScoped
public class MovieManager {

    private List<Movie> searchResultMovies;
    private List<Movie> newTheaterReleases;
    private List<Movie> newDVDReleases;

    private String searchKey;

    /**
     * Get the search key
     *
     * @return search key
     */
    public String getSearchKey() {
        return searchKey;
    }

    /**
     * Set the search key
     *
     * @param searchKey a string
     */
    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    /**
     * Get a list of newTheaterReleases
     *
     * @return newTheaterReleases a List
     */
    public List<Movie> getNewTheaterReleases() {
        return newTheaterReleases;
    }

    /**
     * Set the list of newTheaterReleases
     *
     * @param  newTheaterReleases a List
     */
    public void setNewTheaterReleases(List<Movie> newTheaterReleases) {
        this.newTheaterReleases = newTheaterReleases;
    }

    /**
     * Get a list of searchResultMovies
     *
     * @return searchResultMovies a List
     */
    public List<Movie> getSearchResultMovies() {
        return searchResultMovies;
    }

    /**
     * Set list of searchResultMovies
     *
     * @param searchResultMovies a List
     */
    public void setSearchResultMovies(List<Movie> searchResultMovies) {
        this.searchResultMovies = searchResultMovies;
    }

    /**
     * Get a list of newDVDReleases
     *
     * @return newDVDRelease a List
     */
    public List<Movie> getNewDVDReleases() {
        return newDVDReleases;
    }

    /**
     * Set list of newDVDReleases
     *
     * @param newDVDReleases a List
     */
    public void setNewDVDReleases(List<Movie> newDVDReleases) {
        this.newDVDReleases = newDVDReleases;
    }

    /**
     * Search movies
     */
    public void searchMovies() {
        RottenTomatoes rt = new RottenTomatoes();
        searchResultMovies = rt.searchMovies(searchKey);
    }

    /**
     * Search newTheaterReleases
     */
    public void newTheaterReleases() {
        RottenTomatoes rt = new RottenTomatoes();
        newTheaterReleases = rt.newTheaterReleases();
    }

    /**
     * Search newDVDReleases
     */
    public void newDVDReleases() {
        RottenTomatoes rt = new RottenTomatoes();
        newDVDReleases = rt.newDVDReleases();
    }
}
