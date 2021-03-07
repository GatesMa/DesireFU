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
 * CollectCompetitionRequest
 */
@Validated
public class CollectCompetitionRequest  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("accountId")
  private Long accountId = null;

  @JsonProperty("competitionId")
  private Long competitionId = null;

  @JsonProperty("like")
  private Integer like = null;

  public CollectCompetitionRequest accountId(Long accountId) {
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

  public CollectCompetitionRequest competitionId(Long competitionId) {
    this.competitionId = competitionId;
    return this;
  }

  /**
   * 比赛ID
   * @return competitionId
  **/
  @ApiModelProperty(example = "100000", value = "比赛ID")

  public Long getCompetitionId() {
    return competitionId;
  }

  public void setCompetitionId(Long competitionId) {
    this.competitionId = competitionId;
  }

  public CollectCompetitionRequest like(Integer like) {
    this.like = like;
    return this;
  }

  /**
   * 是否收藏 0-收藏，1-取消
   * @return like
  **/
  @ApiModelProperty(value = "是否收藏 0-收藏，1-取消")

  public Integer getLike() {
    return like;
  }

  public void setLike(Integer like) {
    this.like = like;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CollectCompetitionRequest collectCompetitionRequest = (CollectCompetitionRequest) o;
    return Objects.equals(this.accountId, collectCompetitionRequest.accountId) &&
        Objects.equals(this.competitionId, collectCompetitionRequest.competitionId) &&
        Objects.equals(this.like, collectCompetitionRequest.like);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountId, competitionId, like);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CollectCompetitionRequest {\n");
    
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    competitionId: ").append(toIndentedString(competitionId)).append("\n");
    sb.append("    like: ").append(toIndentedString(like)).append("\n");
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
