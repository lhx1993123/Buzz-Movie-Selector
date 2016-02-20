
package com.rottentomatoes;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import java.io.Serializable;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * This class represents ReleaseDates
 * @author Lance
 */
@Generated("org.jsonschema2pojo")
public class ReleaseDates implements Serializable {
    private static final long serialVersionUID = -403250971215465050L;

    @Expose
    private String theater;

    /**
     * Get the theater
     * @return
     *     The theater
     */
    public String getTheater() {
        return theater;
    }

    /** 
     * Set the theater
     * @param theater
     *     The theater
     */
    public void setTheater(String theater) {
        this.theater = theater;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(theater).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ReleaseDates) == false) {
            return false;
        }
        ReleaseDates rhs = ((ReleaseDates) other);
        return new EqualsBuilder().append(theater, rhs.theater).isEquals();
    }

}
