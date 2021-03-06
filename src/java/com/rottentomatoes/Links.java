
package com.rottentomatoes;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import java.io.Serializable;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * This class represents links
 */
@Generated("org.jsonschema2pojo")
public class Links implements Serializable {
    private static final long serialVersionUID = -403250971215465050L;
    
    @Expose
    private String self;
    @Expose
    private String alternate;
    @Expose
    private String cast;
    @Expose
    private String reviews;
    @Expose
    private String similar;

    /**
     * Get self
     * @return
     *     The self
     */
    public String getSelf() {
        return self;
    }

    /**
     * Set self
     * @param self
     *     The self
     */
    public void setSelf(String self) {
        this.self = self;
    }

    /**
     * Get alternative
     * @return
     *     The alternate
     */
    public String getAlternate() {
        return alternate;
    }

    /**
     * Set alternative
     * @param alternate
     *     The alternate
     */
    public void setAlternate(String alternate) {
        this.alternate = alternate;
    }

    /**
     * Get cast
     * @return
     *     The cast
     */
    public String getCast() {
        return cast;
    }

    /**
     * Set cast
     * @param cast
     *     The cast
     */
    public void setCast(String cast) {
        this.cast = cast;
    }

    /**
     * Get reviews
     * @return
     *     The reviews
     */
    public String getReviews() {
        return reviews;
    }

    /**
     * Set reviews
     * @param reviews
     *     The reviews
     */
    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

    /**
     * Get similar
     * @return
     *     The similar
     */
    public String getSimilar() {
        return similar;
    }

    /**
     * Set similar
     * @param similar
     *     The similar
     */
    public void setSimilar(String similar) {
        this.similar = similar;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(self).append(alternate).append(cast).append(reviews).append(similar).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Links) == false) {
            return false;
        }
        Links rhs = ((Links) other);
        return new EqualsBuilder().append(self, rhs.self).append(alternate, rhs.alternate).append(cast, rhs.cast).append(reviews, rhs.reviews).append(similar, rhs.similar).isEquals();
    }

}
