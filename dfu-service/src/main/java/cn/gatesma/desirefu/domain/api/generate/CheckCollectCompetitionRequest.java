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
 * CheckCollectCompetitionRequest
 */
@Validated
public class CheckCollectCompetitionRequest  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("accountId")
  private Long accountId = null;

  @JsonProperty("competitionId")
  private Long competitionId = null;

  public CheckCollectCompetitionRequest accountId(Long accountId) {
    this.accountId = accountId;
    return this;
  }

  /**
   * 账号ID
   * @return accountId
  **/
  @ApiModelProperty(example = "100000", value = "账号ID")

  public Long getAccountId() {
    return accountId;
  }

  public void setAccountId(Long accountId) {
    this.accountId = accountId;
  }

  public CheckCollectCompetitionRequest competitionId(Long competitionId) {
    this.competitionId = competitionId;
    return this;
  }

  /**
   * 比赛id
   * @return competitionId
  **/
  @ApiModelProperty(example = "100000", value = "比赛id")

  public Long getCompetitionId() {
    return competitionId;
  }

  public void setCompetitionId(Long competitionId) {
    this.competitionId = competitionId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CheckCollectCompetitionRequest checkCollectCompetitionRequest = (CheckCollectCompetitionRequest) o;
    return Objects.equals(this.accountId, checkCollectCompetitionRequest.accountId) &&
        Objects.equals(this.competitionId, checkCollectCompetitionRequest.competitionId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountId, competitionId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CheckCollectCompetitionRequest {\n");
    
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    competitionId: ").append(toIndentedString(competitionId)).append("\n");
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
