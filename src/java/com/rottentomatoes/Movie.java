
package com.rottentomatoes;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * This class represents a movie
 */
@Generated("org.jsonschema2pojo")
public class Movie implements Serializable {
    private static final long serialVersionUID = -403250971215465050L;
    
    @Expose
    private String id;
    @Expose
    private String title;
    @Expose
    private Integer year;
    @SerializedName("mpaa_rating")
    @Expose
    private String mpaaRating;
    @Expose
    private Integer runtime;
    @SerializedName("release_dates")
    @Expose
    private ReleaseDates releaseDates;
    @Expose
    private Ratings ratings;
    @Expose
    private String synopsis;
    @Expose
    private Posters posters;
    @SerializedName("abridged_cast")
    @Expose
    private List<AbridgedCast> abridgedCast = new ArrayList<AbridgedCast>();
    @SerializedName("alternate_ids")
    @Expose
    private AlternateIds alternateIds;
    @Expose
    private Links links;

    /**
     * Get ID
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * Set ID
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Get title
     * @return
     *     The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set title
     * @param title
     *     The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get year
     * @return
     *     The year
     */
    public Integer getYear() {
        return year;
    }

    /**
     * Set year
     * @param year
     *     The year
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * Get MPAA rating
     * @return
     *     The mpaaRating
     */
    public String getMpaaRating() {
        return mpaaRating;
    }

    /**
     * Set MPAA rating
     * @param mpaaRating
     *     The mpaa_rating
     */
    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    /**
     * Get runtime
     * @return
     *     The runtime
     */
    public Integer getRuntime() {
        return runtime;
    }

    /**
     * Set runtime
     * @param runtime
     *     The runtime
     */
    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    /**
     * Get release date
     * @return
     *     The releaseDates
     */
    public ReleaseDates getReleaseDates() {
        return releaseDates;
    }

    /**
     * Set release date
     * @param releaseDates
     *     The release_dates
     */
    public void setReleaseDates(ReleaseDates releaseDates) {
        this.releaseDates = releaseDates;
    }

    /**
     * Get ratings
     * @return
     *     The ratings
     */
    public Ratings getRatings() {
        return ratings;
    }

    /**
     * Set ratings
     * @param ratings
     *     The ratings
     */
    public void setRatings(Ratings ratings) {
        this.ratings = ratings;
    }

    /**
     * Get synopsis
     * @return
     *     The synopsis
     */
    public String getSynopsis() {
        return synopsis;
    }

    /**
     * Set synopsis
     * @param synopsis
     *     The synopsis
     */
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    /**
     * Get posters
     * @return
     *     The posters
     */
    public Posters getPosters() {
        return posters;
    }

    /**
     * Set posters
     * @param posters
     *     The posters
     */
    public void setPosters(Posters posters) {
        this.posters = posters;
    }

    /**
     * Get abridgedCast
     * @return
     *     The abridgedCast
     */
    public List<AbridgedCast> getAbridgedCast() {
        return abridgedCast;
    }
  
    /**
     * Set abridged cast
     * @param abridgedCast
     *     The abridged_cast
     */
    public void setAbridgedCast(List<AbridgedCast> abridgedCast) {
        this.abridgedCast = abridgedCast;
    }

    /**
     * Get alternative ID
     * @return
     *     The alternateIds
     */
    public AlternateIds getAlternateIds() {
        return alternateIds;
    }

    /**
     * Set alternative ID
     * @param alternateIds
     *     The alternate_id
     */
    public void setAlternateIds(AlternateIds alternateIds) {
        this.alternateIds = alternateIds;
    }

    /**
     * Get links
     * @return
     *     The links
     */
    public Links getLinks() {
        return links;
    }

    /**
     * Set links
     * @param links
     *     The links
     */
    public void setLinks(Links links) {
        this.links = links;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(title).append(year).append(mpaaRating).append(runtime).append(releaseDates).append(ratings).append(synopsis).append(posters).append(abridgedCast).append(alternateIds).append(links).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Movie) == false) {
            return false;
        }
        Movie rhs = ((Movie) other);
        return new EqualsBuilder().append(id, rhs.id).append(title, rhs.title).append(year, rhs.year).append(mpaaRating, rhs.mpaaRating).append(runtime, rhs.runtime).append(releaseDates, rhs.releaseDates).append(ratings, rhs.ratings).append(synopsis, rhs.synopsis).append(posters, rhs.posters).append(abridgedCast, rhs.abridgedCast).append(alternateIds, rhs.alternateIds).append(links, rhs.links).isEquals();
    }

}
