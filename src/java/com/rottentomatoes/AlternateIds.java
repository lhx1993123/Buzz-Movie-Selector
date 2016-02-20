
package com.rottentomatoes;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import java.io.Serializable;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * This class represents alternative ID
 */
@Generated("org.jsonschema2pojo")
public class AlternateIds implements Serializable {
    private static final long serialVersionUID = -403250971215465050L;

    @Expose
    private String imdb;

    /**
     * Get IMBD
     * @return
     *     The imdb
     */
    public String getImdb() {
        return imdb;
    }

    /**
     * Set IMDB
     * @param imdb
     *     The imdb
     */
    public void setImdb(String imdb) {
        this.imdb = imdb;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(imdb).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AlternateIds) == false) {
            return false;
        }
        AlternateIds rhs = ((AlternateIds) other);
        return new EqualsBuilder().append(imdb, rhs.imdb).isEquals();
    }

}
