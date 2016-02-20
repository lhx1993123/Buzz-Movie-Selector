
package com.rottentomatoes;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import java.io.Serializable;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * This class represents Posters
 */
@Generated("org.jsonschema2pojo")
public class Posters implements Serializable {
    private static final long serialVersionUID = -403250971215465050L;

    @Expose
    private String thumbnail;
    @Expose
    private String profile;
    @Expose
    private String detailed;
    @Expose
    private String original;

    /**
     * Get thumbnail poster
     * @return
     *     The thumbnail
     */
    public String getThumbnail() {
        return thumbnail;
    }

    /**
     * Set thumbnail poster
     * @param thumbnail
     *     The thumbnail
     */
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    /**
     *  Get profile poster
     * @return
     *     The profile
     */
    public String getProfile() {
        return profile;
    }

    /**
     * Set profile poster
     * @param profile
     *     The profile
     */
    public void setProfile(String profile) {
        this.profile = profile;
    }

    /**
     * Get detailed poster
     * @return
     *     The detailed
     */
    public String getDetailed() {
        return detailed;
    }

    /**
     * Set detailed poster
     * @param detailed
     *     The detailed
     */
    public void setDetailed(String detailed) {
        this.detailed = detailed;
    }

    /**
     * Get original poster
     * @return
     *     The original
     */
    public String getOriginal() {
        return original;
    }

    /**
     * Set original poster
     * @param original
     *     The original
     */
    public void setOriginal(String original) {
        this.original = original;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(thumbnail).append(profile).append(detailed).append(original).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Posters) == false) {
            return false;
        }
        Posters rhs = ((Posters) other);
        return new EqualsBuilder().append(thumbnail, rhs.thumbnail).append(profile, rhs.profile).append(detailed, rhs.detailed).append(original, rhs.original).isEquals();
    }

}
