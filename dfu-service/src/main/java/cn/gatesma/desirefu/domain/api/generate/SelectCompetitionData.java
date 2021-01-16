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
 * SelectCompetitionData
 */
@Validated
public class SelectCompetitionData  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("competition_id")
  private Long competitionId = null;

  @JsonProperty("account_id")
  private Long accountId = null;

  @JsonProperty("account_type")
  private Integer accountType = null;

  @JsonProperty("type")
  private Integer type = null;

  @JsonProperty("title")
  private String title = null;

  @JsonProperty("founder")
  private String founder = null;

  @JsonProperty("content")
  private String content = null;

  @JsonProperty("pv")
  private Integer pv = null;

  @JsonProperty("status")
  private Integer status = null;

  @JsonProperty("begin_time")
  private String beginTime = null;

  @JsonProperty("end_time")
  private String endTime = null;

  @JsonProperty("created_ime")
  private String createdIme = null;

  @JsonProperty("overview_img")
  private String overviewImg = null;

  @JsonProperty("overview_text")
  private String overviewText = null;

  public SelectCompetitionData competitionId(Long competitionId) {
    this.competitionId = competitionId;
    return this;
  }

  /**
   * 比赛id
   * @return competitionId
  **/
  @ApiModelProperty(example = "3939494", value = "比赛id")

  public Long getCompetitionId() {
    return competitionId;
  }

  public void setCompetitionId(Long competitionId) {
    this.competitionId = competitionId;
  }

  public SelectCompetitionData accountId(Long accountId) {
    this.accountId = accountId;
    return this;
  }

  /**
   * 账号ID
   * @return accountId
  **/
  @ApiModelProperty(example = "3939494", value = "账号ID")

  public Long getAccountId() {
    return accountId;
  }

  public void setAccountId(Long accountId) {
    this.accountId = accountId;
  }

  public SelectCompetitionData accountType(Integer accountType) {
    this.accountType = accountType;
    return this;
  }

  /**
   * 账号类型
   * @return accountType
  **/
  @ApiModelProperty(example = "1", value = "账号类型")

  public Integer getAccountType() {
    return accountType;
  }

  public void setAccountType(Integer accountType) {
    this.accountType = accountType;
  }

  public SelectCompetitionData type(Integer type) {
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

  public SelectCompetitionData title(String title) {
    this.title = title;
    return this;
  }

  /**
   * 比赛名称
   * @return title
  **/
  @ApiModelProperty(example = "大创", value = "比赛名称")

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public SelectCompetitionData founder(String founder) {
    this.founder = founder;
    return this;
  }

  /**
   * 创办方
   * @return founder
  **/
  @ApiModelProperty(example = "教育部", value = "创办方")

  public String getFounder() {
    return founder;
  }

  public void setFounder(String founder) {
    this.founder = founder;
  }

  public SelectCompetitionData content(String content) {
    this.content = content;
    return this;
  }

  /**
   * 内容
   * @return content
  **/
  @ApiModelProperty(example = "内容", value = "内容")

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public SelectCompetitionData pv(Integer pv) {
    this.pv = pv;
    return this;
  }

  /**
   * 浏览量
   * @return pv
  **/
  @ApiModelProperty(example = "1", value = "浏览量")

  public Integer getPv() {
    return pv;
  }

  public void setPv(Integer pv) {
    this.pv = pv;
  }

  public SelectCompetitionData status(Integer status) {
    this.status = status;
    return this;
  }

  /**
   * 比赛通知状态
   * @return status
  **/
  @ApiModelProperty(example = "1", value = "比赛通知状态")

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public SelectCompetitionData beginTime(String beginTime) {
    this.beginTime = beginTime;
    return this;
  }

  /**
   * 开始时间，格式：yyyy-MM-dd HH:mm:ss
   * @return beginTime
  **/
  @ApiModelProperty(example = "2020-01-01 12:00:00", value = "开始时间，格式：yyyy-MM-dd HH:mm:ss")

  public String getBeginTime() {
    return beginTime;
  }

  public void setBeginTime(String beginTime) {
    this.beginTime = beginTime;
  }

  public SelectCompetitionData endTime(String endTime) {
    this.endTime = endTime;
    return this;
  }

  /**
   * 结束时间，格式：yyyy-MM-dd HH:mm:ss
   * @return endTime
  **/
  @ApiModelProperty(example = "2020-01-01 12:00:00", value = "结束时间，格式：yyyy-MM-dd HH:mm:ss")

  public String getEndTime() {
    return endTime;
  }

  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }

  public SelectCompetitionData createdIme(String createdIme) {
    this.createdIme = createdIme;
    return this;
  }

  /**
   * 创建时间，格式：yyyy-MM-dd HH:mm:ss
   * @return createdIme
  **/
  @ApiModelProperty(example = "2020-01-01 12:00:00", value = "创建时间，格式：yyyy-MM-dd HH:mm:ss")

  public String getCreatedIme() {
    return createdIme;
  }

  public void setCreatedIme(String createdIme) {
    this.createdIme = createdIme;
  }

  public SelectCompetitionData overviewImg(String overviewImg) {
    this.overviewImg = overviewImg;
    return this;
  }

  /**
   * 概览图片URL
   * @return overviewImg
  **/
  @ApiModelProperty(example = "https://xxxx", value = "概览图片URL")

  public String getOverviewImg() {
    return overviewImg;
  }

  public void setOverviewImg(String overviewImg) {
    this.overviewImg = overviewImg;
  }

  public SelectCompetitionData overviewText(String overviewText) {
    this.overviewText = overviewText;
    return this;
  }

  /**
   * 概览文本
   * @return overviewText
  **/
  @ApiModelProperty(example = "概览文本", value = "概览文本")

  public String getOverviewText() {
    return overviewText;
  }

  public void setOverviewText(String overviewText) {
    this.overviewText = overviewText;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SelectCompetitionData selectCompetitionData = (SelectCompetitionData) o;
    return Objects.equals(this.competitionId, selectCompetitionData.competitionId) &&
        Objects.equals(this.accountId, selectCompetitionData.accountId) &&
        Objects.equals(this.accountType, selectCompetitionData.accountType) &&
        Objects.equals(this.type, selectCompetitionData.type) &&
        Objects.equals(this.title, selectCompetitionData.title) &&
        Objects.equals(this.founder, selectCompetitionData.founder) &&
        Objects.equals(this.content, selectCompetitionData.content) &&
        Objects.equals(this.pv, selectCompetitionData.pv) &&
        Objects.equals(this.status, selectCompetitionData.status) &&
        Objects.equals(this.beginTime, selectCompetitionData.beginTime) &&
        Objects.equals(this.endTime, selectCompetitionData.endTime) &&
        Objects.equals(this.createdIme, selectCompetitionData.createdIme) &&
        Objects.equals(this.overviewImg, selectCompetitionData.overviewImg) &&
        Objects.equals(this.overviewText, selectCompetitionData.overviewText);
  }

  @Override
  public int hashCode() {
    return Objects.hash(competitionId, accountId, accountType, type, title, founder, content, pv, status, beginTime, endTime, createdIme, overviewImg, overviewText);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SelectCompetitionData {\n");
    
    sb.append("    competitionId: ").append(toIndentedString(competitionId)).append("\n");
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    accountType: ").append(toIndentedString(accountType)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    founder: ").append(toIndentedString(founder)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    pv: ").append(toIndentedString(pv)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    beginTime: ").append(toIndentedString(beginTime)).append("\n");
    sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
    sb.append("    createdIme: ").append(toIndentedString(createdIme)).append("\n");
    sb.append("    overviewImg: ").append(toIndentedString(overviewImg)).append("\n");
    sb.append("    overviewText: ").append(toIndentedString(overviewText)).append("\n");
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
