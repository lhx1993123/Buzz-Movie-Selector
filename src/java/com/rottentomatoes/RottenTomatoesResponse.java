package com.rottentomatoes;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Create response from rottenTomatoes
 *
 */
@Generated("org.jsonschema2pojo")
public class RottenTomatoesResponse {

    @Expose
    private Integer total;
    @Expose
    private List<Movie> movies = new ArrayList<>();
    @Expose
    private Links_ links;
    @SerializedName("link_template")
    @Expose
    private String linkTemplate;

    /**
     * Get total
     * @return The total
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * Set total
     * @param total The total
     */
    public void setTotal(Integer total) {
        this.total = total;
    }

    /**
     * Get list of movies
     * @return The movies
     */
    public List<Movie> getMovies() {
        return movies;
    }

    /**
     * Set list of movies
     * @param movies The movies
     */
    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    /**
     * Get a link
     * @return The links
     */
    public Links_ getLinks() {
        return links;
    }

    /**
     * Set a link
     * @param links The links
     */
    public void setLinks(Links_ links) {
        this.links = links;
    }

    /**
     * Get a linkTemplate
     * @return The linkTemplate
     */
    public String getLinkTemplate() {
        return linkTemplate;
    }

    /**
     * Set linkTemplate
     * @param linkTemplate The link_template
     */
    public void setLinkTemplate(String linkTemplate) {
        this.linkTemplate = linkTemplate;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(total).append(movies).append(links).append(linkTemplate).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RottenTomatoesResponse) == false) {
            return false;
        }
        RottenTomatoesResponse rhs = ((RottenTomatoesResponse) other);
        return new EqualsBuilder().append(total, rhs.total).append(movies, rhs.movies).append(links, rhs.links).append(linkTemplate, rhs.linkTemplate).isEquals();
    }

}
