package cn.gatesma.desirefu.domain.api.generate;

import java.util.Objects;
import cn.gatesma.desirefu.domain.api.generate.Page;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SelectCompetitionRequest
 */
@Validated
public class SelectCompetitionRequest  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("page")
  private Page page = null;

  @JsonProperty("competition_ids")
  @Valid
  private java.util.List<Long> competitionIds = null;

  @JsonProperty("account_id")
  private Long accountId = null;

  @JsonProperty("type")
  private Integer type = null;

  @JsonProperty("title")
  private String title = null;

  @JsonProperty("founder")
  private String founder = null;

  @JsonProperty("status")
  private Integer status = null;

  @JsonProperty("state")
  private Integer state = null;

  @JsonProperty("sort_field")
  private String sortField = null;

  @JsonProperty("sort_seq")
  private String sortSeq = null;

  public SelectCompetitionRequest page(Page page) {
    this.page = page;
    return this;
  }

  /**
   * Get page
   * @return page
  **/
  @ApiModelProperty(value = "")

  @Valid
  public Page getPage() {
    return page;
  }

  public void setPage(Page page) {
    this.page = page;
  }

  public SelectCompetitionRequest competitionIds(java.util.List<Long> competitionIds) {
    this.competitionIds = competitionIds;
    return this;
  }

  public SelectCompetitionRequest addCompetitionIdsItem(Long competitionIdsItem) {
    if (this.competitionIds == null) {
      this.competitionIds = new java.util.ArrayList<Long>();
    }
    this.competitionIds.add(competitionIdsItem);
    return this;
  }

  /**
   * Get competitionIds
   * @return competitionIds
  **/
  @ApiModelProperty(example = "[177953, 177954, 177955]", value = "")

  public java.util.List<Long> getCompetitionIds() {
    return competitionIds;
  }

  public void setCompetitionIds(java.util.List<Long> competitionIds) {
    this.competitionIds = competitionIds;
  }

  public SelectCompetitionRequest accountId(Long accountId) {
    this.accountId = accountId;
    return this;
  }

  /**
   * 创建比赛的账号Id, 用于筛选
   * @return accountId
  **/
  @ApiModelProperty(example = "100001", value = "创建比赛的账号Id, 用于筛选")

  public Long getAccountId() {
    return accountId;
  }

  public void setAccountId(Long accountId) {
    this.accountId = accountId;
  }

  public SelectCompetitionRequest type(Integer type) {
    this.type = type;
    return this;
  }

  /**
   * 比赛类型
   * @return type
  **/
  @ApiModelProperty(example = "1", value = "比赛类型")

  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  public SelectCompetitionRequest title(String title) {
    this.title = title;
    return this;
  }

  /**
   * 比赛名称（支持模糊查询）
   * @return title
  **/
  @ApiModelProperty(example = "大创", value = "比赛名称（支持模糊查询）")

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public SelectCompetitionRequest founder(String founder) {
    this.founder = founder;
    return this;
  }

  /**
   * 创办方（支持模糊查询）
   * @return founder
  **/
  @ApiModelProperty(example = "教育部", value = "创办方（支持模糊查询）")

  public String getFounder() {
    return founder;
  }

  public void setFounder(String founder) {
    this.founder = founder;
  }

  public SelectCompetitionRequest status(Integer status) {
    this.status = status;
    return this;
  }

  /**
   * 是否草稿
   * @return status
  **/
  @ApiModelProperty(example = "1", value = "是否草稿")

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public SelectCompetitionRequest state(Integer state) {
    this.state = state;
    return this;
  }

  /**
   * 比赛状态，0 - 未开始，1 - 进行中，2 - 已结束
   * @return state
  **/
  @ApiModelProperty(example = "1", value = "比赛状态，0 - 未开始，1 - 进行中，2 - 已结束")

  public Integer getState() {
    return state;
  }

  public void setState(Integer state) {
    this.state = state;
  }

  public SelectCompetitionRequest sortField(String sortField) {
    this.sortField = sortField;
    return this;
  }

  /**
   * 排序字段
   * @return sortField
  **/
  @ApiModelProperty(example = "createTime", value = "排序字段")

  public String getSortField() {
    return sortField;
  }

  public void setSortField(String sortField) {
    this.sortField = sortField;
  }

  public SelectCompetitionRequest sortSeq(String sortSeq) {
    this.sortSeq = sortSeq;
    return this;
  }

  /**
   * 排序方式
   * @return sortSeq
  **/
  @ApiModelProperty(example = "asc", value = "排序方式")

  public String getSortSeq() {
    return sortSeq;
  }

  public void setSortSeq(String sortSeq) {
    this.sortSeq = sortSeq;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SelectCompetitionRequest selectCompetitionRequest = (SelectCompetitionRequest) o;
    return Objects.equals(this.page, selectCompetitionRequest.page) &&
        Objects.equals(this.competitionIds, selectCompetitionRequest.competitionIds) &&
        Objects.equals(this.accountId, selectCompetitionRequest.accountId) &&
        Objects.equals(this.type, selectCompetitionRequest.type) &&
        Objects.equals(this.title, selectCompetitionRequest.title) &&
        Objects.equals(this.founder, selectCompetitionRequest.founder) &&
        Objects.equals(this.status, selectCompetitionRequest.status) &&
        Objects.equals(this.state, selectCompetitionRequest.state) &&
        Objects.equals(this.sortField, selectCompetitionRequest.sortField) &&
        Objects.equals(this.sortSeq, selectCompetitionRequest.sortSeq);
  }

  @Override
  public int hashCode() {
    return Objects.hash(page, competitionIds, accountId, type, title, founder, status, state, sortField, sortSeq);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SelectCompetitionRequest {\n");
    
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
    sb.append("    competitionIds: ").append(toIndentedString(competitionIds)).append("\n");
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    founder: ").append(toIndentedString(founder)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    sortField: ").append(toIndentedString(sortField)).append("\n");
    sb.append("    sortSeq: ").append(toIndentedString(sortSeq)).append("\n");
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
