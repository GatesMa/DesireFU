package cn.gatesma.desirefu.domain.api.generate;

import java.util.Objects;
import cn.gatesma.desirefu.domain.api.generate.AddAccountRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AddOrganizeRequest
 */
@Validated
public class AddOrganizeRequest extends AddAccountRequest implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("competitionId")
  private Long competitionId = null;

  @JsonProperty("srcAccountId")
  private Long srcAccountId = null;

  public AddOrganizeRequest competitionId(Long competitionId) {
    this.competitionId = competitionId;
    return this;
  }

  /**
   * 比赛ID
   * @return competitionId
  **/
  @ApiModelProperty(example = "1", value = "比赛ID")

  public Long getCompetitionId() {
    return competitionId;
  }

  public void setCompetitionId(Long competitionId) {
    this.competitionId = competitionId;
  }

  public AddOrganizeRequest srcAccountId(Long srcAccountId) {
    this.srcAccountId = srcAccountId;
    return this;
  }

  /**
   * 比赛ID
   * @return srcAccountId
  **/
  @ApiModelProperty(example = "1", value = "比赛ID")

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
    AddOrganizeRequest addOrganizeRequest = (AddOrganizeRequest) o;
    return Objects.equals(this.competitionId, addOrganizeRequest.competitionId) &&
        Objects.equals(this.srcAccountId, addOrganizeRequest.srcAccountId) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(competitionId, srcAccountId, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddOrganizeRequest {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
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
