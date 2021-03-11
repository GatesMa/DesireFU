package cn.gatesma.desirefu.domain.api.generate;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CheckCollectCompetitionData
 */
@Validated
public class CheckCollectCompetitionData  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("isLiked")
  private Integer isLiked = null;

  public CheckCollectCompetitionData isLiked(Integer isLiked) {
    this.isLiked = isLiked;
    return this;
  }

  /**
   * 是否收藏
   * @return isLiked
  **/
  @ApiModelProperty(example = "1", value = "是否收藏")

  public Integer getIsLiked() {
    return isLiked;
  }

  public void setIsLiked(Integer isLiked) {
    this.isLiked = isLiked;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CheckCollectCompetitionData checkCollectCompetitionData = (CheckCollectCompetitionData) o;
    return Objects.equals(this.isLiked, checkCollectCompetitionData.isLiked);
  }

  @Override
  public int hashCode() {
    return Objects.hash(isLiked);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CheckCollectCompetitionData {\n");
    
    sb.append("    isLiked: ").append(toIndentedString(isLiked)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
