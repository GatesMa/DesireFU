package cn.gatesma.desirefu.domain.api.generate;

import java.util.Objects;
import cn.gatesma.desirefu.domain.api.generate.LoginInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * 用户
 */
@ApiModel(description = "用户")
@Validated
public class User  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("user_id")
  private Long userId = null;

  @JsonProperty("logins")
  @Valid
  private java.util.List<LoginInfo> logins = null;

  @JsonProperty("user_name")
  private String userName = null;

  @JsonProperty("cellphone")
  private String cellphone = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("delete_status")
  private Integer deleteStatus = null;

  @JsonProperty("created_user_id")
  private Long createdUserId = null;

  @JsonProperty("created_time")
  private String createdTime = null;

  @JsonProperty("last_modified_user_id")
  private Long lastModifiedUserId = null;

  @JsonProperty("last_modified_time")
  private String lastModifiedTime = null;

  public User userId(Long userId) {
    this.userId = userId;
    return this;
  }

  /**
   * 用户ID
   * @return userId
  **/
  @ApiModelProperty(example = "17998821", readOnly = true, value = "用户ID")

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public User logins(java.util.List<LoginInfo> logins) {
    this.logins = logins;
    return this;
  }

  public User addLoginsItem(LoginInfo loginsItem) {
    if (this.logins == null) {
      this.logins = new java.util.ArrayList<LoginInfo>();
    }
    this.logins.add(loginsItem);
    return this;
  }

  /**
   * 所有login信息，包括绑定的
   * @return logins
  **/
  @ApiModelProperty(value = "所有login信息，包括绑定的")
  @Valid
  public java.util.List<LoginInfo> getLogins() {
    return logins;
  }

  public void setLogins(java.util.List<LoginInfo> logins) {
    this.logins = logins;
  }

  public User userName(String userName) {
    this.userName = userName;
    return this;
  }

  /**
   * 用户名称
   * @return userName
  **/
  @ApiModelProperty(value = "用户名称")

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public User cellphone(String cellphone) {
    this.cellphone = cellphone;
    return this;
  }

  /**
   * 手机号码
   * @return cellphone
  **/
  @ApiModelProperty(value = "手机号码")

  public String getCellphone() {
    return cellphone;
  }

  public void setCellphone(String cellphone) {
    this.cellphone = cellphone;
  }

  public User email(String email) {
    this.email = email;
    return this;
  }

  /**
   * 邮箱
   * @return email
  **/
  @ApiModelProperty(value = "邮箱")

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public User deleteStatus(Integer deleteStatus) {
    this.deleteStatus = deleteStatus;
    return this;
  }

  /**
   * 删除状态
   * @return deleteStatus
  **/
  @ApiModelProperty(example = "0", readOnly = true, value = "删除状态")

  public Integer getDeleteStatus() {
    return deleteStatus;
  }

  public void setDeleteStatus(Integer deleteStatus) {
    this.deleteStatus = deleteStatus;
  }

  public User createdUserId(Long createdUserId) {
    this.createdUserId = createdUserId;
    return this;
  }

  /**
   * 创建人userId
   * @return createdUserId
  **/
  @ApiModelProperty(example = "3453334", value = "创建人userId")

  public Long getCreatedUserId() {
    return createdUserId;
  }

  public void setCreatedUserId(Long createdUserId) {
    this.createdUserId = createdUserId;
  }

  public User createdTime(String createdTime) {
    this.createdTime = createdTime;
    return this;
  }

  /**
   * 创建时间，格式：yyyy-MM-dd HH:mm:ss
   * @return createdTime
  **/
  @ApiModelProperty(example = "2018-01-01 12:00:00", readOnly = true, value = "创建时间，格式：yyyy-MM-dd HH:mm:ss")

  public String getCreatedTime() {
    return createdTime;
  }

  public void setCreatedTime(String createdTime) {
    this.createdTime = createdTime;
  }

  public User lastModifiedUserId(Long lastModifiedUserId) {
    this.lastModifiedUserId = lastModifiedUserId;
    return this;
  }

  /**
   * 最后修改人userId
   * @return lastModifiedUserId
  **/
  @ApiModelProperty(example = "3453334", value = "最后修改人userId")

  public Long getLastModifiedUserId() {
    return lastModifiedUserId;
  }

  public void setLastModifiedUserId(Long lastModifiedUserId) {
    this.lastModifiedUserId = lastModifiedUserId;
  }

  public User lastModifiedTime(String lastModifiedTime) {
    this.lastModifiedTime = lastModifiedTime;
    return this;
  }

  /**
   * 最后修改时间，格式：yyyy-MM-dd HH:mm:ss
   * @return lastModifiedTime
  **/
  @ApiModelProperty(example = "2018-01-02 13:20:15", readOnly = true, value = "最后修改时间，格式：yyyy-MM-dd HH:mm:ss")

  public String getLastModifiedTime() {
    return lastModifiedTime;
  }

  public void setLastModifiedTime(String lastModifiedTime) {
    this.lastModifiedTime = lastModifiedTime;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(this.userId, user.userId) &&
        Objects.equals(this.logins, user.logins) &&
        Objects.equals(this.userName, user.userName) &&
        Objects.equals(this.cellphone, user.cellphone) &&
        Objects.equals(this.email, user.email) &&
        Objects.equals(this.deleteStatus, user.deleteStatus) &&
        Objects.equals(this.createdUserId, user.createdUserId) &&
        Objects.equals(this.createdTime, user.createdTime) &&
        Objects.equals(this.lastModifiedUserId, user.lastModifiedUserId) &&
        Objects.equals(this.lastModifiedTime, user.lastModifiedTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, logins, userName, cellphone, email, deleteStatus, createdUserId, createdTime, lastModifiedUserId, lastModifiedTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");
    
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    logins: ").append(toIndentedString(logins)).append("\n");
    sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
    sb.append("    cellphone: ").append(toIndentedString(cellphone)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    deleteStatus: ").append(toIndentedString(deleteStatus)).append("\n");
    sb.append("    createdUserId: ").append(toIndentedString(createdUserId)).append("\n");
    sb.append("    createdTime: ").append(toIndentedString(createdTime)).append("\n");
    sb.append("    lastModifiedUserId: ").append(toIndentedString(lastModifiedUserId)).append("\n");
    sb.append("    lastModifiedTime: ").append(toIndentedString(lastModifiedTime)).append("\n");
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
