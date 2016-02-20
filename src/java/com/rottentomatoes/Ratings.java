
package com.rottentomatoes;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * This class represents ratings
 */
@Generated("org.jsonschema2pojo")
public class Ratings implements Serializable {
    private static final long serialVersionUID = -403250971215465050L;
    
    @SerializedName("critics_score")
    @Expose
    private Integer criticsScore;
    @SerializedName("audience_score")
    @Expose
    private Integer audienceScore;

    /**
     * Get criticsScore
     * @return
     *     The criticsScore
     */
    public Integer getCriticsScore() {
        return criticsScore;
    }

    /**
     * Set criticsScore
     * @param criticsScore
     *     The critics_score
     */
    public void setCriticsScore(Integer criticsScore) {
        this.criticsScore = criticsScore;
    }

    /**
     * Get audienceScore
     * @return
     *     The audienceScore
     */
    public Integer getAudienceScore() {
        return audienceScore;
    }

    /**
     * Set audienceScore
     * @param audienceScore
     *     The audience_score
     */
    public void setAudienceScore(Integer audienceScore) {
        this.audienceScore = audienceScore;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(criticsScore).append(audienceScore).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Ratings) == false) {
            return false;
        }
        Ratings rhs = ((Ratings) other);
        return new EqualsBuilder().append(criticsScore, rhs.criticsScore).append(audienceScore, rhs.audienceScore).isEquals();
    }

}
