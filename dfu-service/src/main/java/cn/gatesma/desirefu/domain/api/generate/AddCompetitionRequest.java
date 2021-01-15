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
 * AddCompetitionRequest
 */
@Validated
public class AddCompetitionRequest  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("account_id")
  private Long accountId = null;

  @JsonProperty("account_type")
  private Integer accountType = null;

  @JsonProperty("type")
  private Integer type = null;

  @JsonProperty("title")
  private String title = null;

  @JsonProperty("status")
  private Integer status = null;

  @JsonProperty("founder")
  private String founder = null;

  @JsonProperty("content")
  private String content = null;

  @JsonProperty("begin_time")
  private String beginTime = null;

  @JsonProperty("end_time")
  private String endTime = null;

  @JsonProperty("user_id")
  private Long userId = null;

  @JsonProperty("overview_img")
  private String overviewImg = null;

  @JsonProperty("overview_text")
  private String overviewText = null;

  public AddCompetitionRequest accountId(Long accountId) {
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

  public AddCompetitionRequest accountType(Integer accountType) {
    this.accountType = accountType;
    return this;
  }

  /**
   * 账号类型
   * @return accountType
  **/
  @ApiModelProperty(example = "1", required = true, value = "账号类型")
  @NotNull

  public Integer getAccountType() {
    return accountType;
  }

  public void setAccountType(Integer accountType) {
    this.accountType = accountType;
  }

  public AddCompetitionRequest type(Integer type) {
    this.type = type;
    return this;
  }

  /**
   * 比赛类型 - 省级、校级等(枚举值)
   * @return type
  **/
  @ApiModelProperty(example = "1", value = "比赛类型 - 省级、校级等(枚举值)")

  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  public AddCompetitionRequest title(String title) {
    this.title = title;
    return this;
  }

  /**
   * 比赛名称
   * @return title
  **/
  @ApiModelProperty(example = "互联网+", value = "比赛名称")

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public AddCompetitionRequest status(Integer status) {
    this.status = status;
    return this;
  }

  /**
   * 比赛状态
   * @return status
  **/
  @ApiModelProperty(example = "1", value = "比赛状态")

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public AddCompetitionRequest founder(String founder) {
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

  public AddCompetitionRequest content(String content) {
    this.content = content;
    return this;
  }

  /**
   * 具体通知内容，富文本
   * @return content
  **/
  @ApiModelProperty(example = "富文本", value = "具体通知内容，富文本")

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public AddCompetitionRequest beginTime(String beginTime) {
    this.beginTime = beginTime;
    return this;
  }

  /**
   * 创建时间，格式：yyyy-MM-dd HH:mm:ss
   * @return beginTime
  **/
  @ApiModelProperty(example = "2020-01-01 12:00:00", value = "创建时间，格式：yyyy-MM-dd HH:mm:ss")

  public String getBeginTime() {
    return beginTime;
  }

  public void setBeginTime(String beginTime) {
    this.beginTime = beginTime;
  }

  public AddCompetitionRequest endTime(String endTime) {
    this.endTime = endTime;
    return this;
  }

  /**
   * 创建时间，格式：yyyy-MM-dd HH:mm:ss
   * @return endTime
  **/
  @ApiModelProperty(example = "2020-01-01 12:00:00", value = "创建时间，格式：yyyy-MM-dd HH:mm:ss")

  public String getEndTime() {
    return endTime;
  }

  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }

  public AddCompetitionRequest userId(Long userId) {
    this.userId = userId;
    return this;
  }

  /**
   * 创建者userId
   * @return userId
  **/
  @ApiModelProperty(example = "3453454", value = "创建者userId")

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public AddCompetitionRequest overviewImg(String overviewImg) {
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

  public AddCompetitionRequest overviewText(String overviewText) {
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
    AddCompetitionRequest addCompetitionRequest = (AddCompetitionRequest) o;
    return Objects.equals(this.accountId, addCompetitionRequest.accountId) &&
        Objects.equals(this.accountType, addCompetitionRequest.accountType) &&
        Objects.equals(this.type, addCompetitionRequest.type) &&
        Objects.equals(this.title, addCompetitionRequest.title) &&
        Objects.equals(this.status, addCompetitionRequest.status) &&
        Objects.equals(this.founder, addCompetitionRequest.founder) &&
        Objects.equals(this.content, addCompetitionRequest.content) &&
        Objects.equals(this.beginTime, addCompetitionRequest.beginTime) &&
        Objects.equals(this.endTime, addCompetitionRequest.endTime) &&
        Objects.equals(this.userId, addCompetitionRequest.userId) &&
        Objects.equals(this.overviewImg, addCompetitionRequest.overviewImg) &&
        Objects.equals(this.overviewText, addCompetitionRequest.overviewText);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountId, accountType, type, title, status, founder, content, beginTime, endTime, userId, overviewImg, overviewText);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddCompetitionRequest {\n");
    
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    accountType: ").append(toIndentedString(accountType)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    founder: ").append(toIndentedString(founder)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    beginTime: ").append(toIndentedString(beginTime)).append("\n");
    sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
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
