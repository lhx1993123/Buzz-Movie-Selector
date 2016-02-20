
package com.rottentomatoes;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import java.io.Serializable;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * This class represents abridged cast
 */
@Generated("org.jsonschema2pojo")
public class AbridgedCast implements Serializable {
    private static final long serialVersionUID = -403250971215465050L;

    @Expose
    private String name;
    @Expose
    private String id;

    /**
     * Get name
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * Set name
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

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

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(name).append(id).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AbridgedCast) == false) {
            return false;
        }
        AbridgedCast rhs = ((AbridgedCast) other);
        return new EqualsBuilder().append(name, rhs.name).append(id, rhs.id).isEquals();
    }

}
