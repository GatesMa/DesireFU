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
 * ListOrganizeRequest
 */
@Validated
public class ListOrganizeRequest  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("organizeId")
  private Long organizeId = null;

  @JsonProperty("competitionId")
  private Long competitionId = null;

  @JsonProperty("srcAccountId")
  private Long srcAccountId = null;

  public ListOrganizeRequest organizeId(Long organizeId) {
    this.organizeId = organizeId;
    return this;
  }

  /**
   * 账号ID
   * @return organizeId
  **/
  @ApiModelProperty(example = "100000", value = "账号ID")

  public Long getOrganizeId() {
    return organizeId;
  }

  public void setOrganizeId(Long organizeId) {
    this.organizeId = organizeId;
  }

  public ListOrganizeRequest competitionId(Long competitionId) {
    this.competitionId = competitionId;
    return this;
  }

  /**
   * 比赛ID
   * @return competitionId
  **/
  @ApiModelProperty(example = "2211", value = "比赛ID")

  public Long getCompetitionId() {
    return competitionId;
  }

  public void setCompetitionId(Long competitionId) {
    this.competitionId = competitionId;
  }

  public ListOrganizeRequest srcAccountId(Long srcAccountId) {
    this.srcAccountId = srcAccountId;
    return this;
  }

  /**
   * 队长账号ID
   * @return srcAccountId
  **/
  @ApiModelProperty(example = "1111", value = "队长账号ID")

  public Long getSrcAccountId() {
    return srcAccountId;
  }

  public void setSrcAccountId(Long srcAccountId) {
    this.srcAccountId = srcAccountId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListOrganizeRequest listOrganizeRequest = (ListOrganizeRequest) o;
    return Objects.equals(this.organizeId, listOrganizeRequest.organizeId) &&
        Objects.equals(this.competitionId, listOrganizeRequest.competitionId) &&
        Objects.equals(this.srcAccountId, listOrganizeRequest.srcAccountId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(organizeId, competitionId, srcAccountId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListOrganizeRequest {\n");
    
    sb.append("    organizeId: ").append(toIndentedString(organizeId)).append("\n");
    sb.append("    competitionId: ").append(toIndentedString(competitionId)).append("\n");
    sb.append("    srcAccountId: ").append(toIndentedString(srcAccountId)).append("\n");
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
