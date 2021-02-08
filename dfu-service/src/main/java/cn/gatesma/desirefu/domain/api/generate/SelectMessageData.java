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
 * SelectMessageData
 */
@Validated
public class SelectMessageData  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("accountId")
  private Long accountId = null;

  @JsonProperty("type")
  private Integer type = null;

  @JsonProperty("title")
  private String title = null;

  @JsonProperty("content")
  private String content = null;

  @JsonProperty("status")
  private Integer status = null;

  @JsonProperty("createdTime")
  private String createdTime = null;

  public SelectMessageData id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * id
   * @return id
  **/
  @ApiModelProperty(example = "100000", value = "id")

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public SelectMessageData accountId(Long accountId) {
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

  public SelectMessageData type(Integer type) {
    this.type = type;
    return this;
  }

  /**
   * 类型
   * @return type
  **/
  @ApiModelProperty(example = "1", value = "类型")

  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  public SelectMessageData title(String title) {
    this.title = title;
    return this;
  }

  /**
   * 标题
   * @return title
  **/
  @ApiModelProperty(example = "1", value = "标题")

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public SelectMessageData content(String content) {
    this.content = content;
    return this;
  }

  /**
   * 内容
   * @return content
  **/
  @ApiModelProperty(example = "1", value = "内容")

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public SelectMessageData status(Integer status) {
    this.status = status;
    return this;
  }

  /**
   * 状态
   * @return status
  **/
  @ApiModelProperty(example = "1", value = "状态")

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public SelectMessageData createdTime(String createdTime) {
    this.createdTime = createdTime;
    return this;
  }

  /**
   * 创建时间，格式：yyyy-MM-dd HH:mm:ss
   * @return createdTime
  **/
  @ApiModelProperty(example = "2020-01-01 12:00:00", value = "创建时间，格式：yyyy-MM-dd HH:mm:ss")

  public String getCreatedTime() {
    return createdTime;
  }

  public void setCreatedTime(String createdTime) {
    this.createdTime = createdTime;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SelectMessageData selectMessageData = (SelectMessageData) o;
    return Objects.equals(this.id, selectMessageData.id) &&
        Objects.equals(this.accountId, selectMessageData.accountId) &&
        Objects.equals(this.type, selectMessageData.type) &&
        Objects.equals(this.title, selectMessageData.title) &&
        Objects.equals(this.content, selectMessageData.content) &&
        Objects.equals(this.status, selectMessageData.status) &&
        Objects.equals(this.createdTime, selectMessageData.createdTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, accountId, type, title, content, status, createdTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SelectMessageData {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    createdTime: ").append(toIndentedString(createdTime)).append("\n");
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
