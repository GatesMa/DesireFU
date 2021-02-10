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
 * UpdateMessageStatusRequest
 */
@Validated
public class UpdateMessageStatusRequest  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("ids")
  @Valid
  private java.util.List<Long> ids = null;

  @JsonProperty("status")
  private Integer status = null;

  @JsonProperty("userId")
  private Long userId = null;

  public UpdateMessageStatusRequest ids(java.util.List<Long> ids) {
    this.ids = ids;
    return this;
  }

  public UpdateMessageStatusRequest addIdsItem(Long idsItem) {
    if (this.ids == null) {
      this.ids = new java.util.ArrayList<Long>();
    }
    this.ids.add(idsItem);
    return this;
  }

  /**
   * Get ids
   * @return ids
  **/
  @ApiModelProperty(example = "[177953, 177954, 177955]", value = "")

  public java.util.List<Long> getIds() {
    return ids;
  }

  public void setIds(java.util.List<Long> ids) {
    this.ids = ids;
  }

  public UpdateMessageStatusRequest status(Integer status) {
    this.status = status;
    return this;
  }

  /**
   * 更新后的状态
   * @return status
  **/
  @ApiModelProperty(example = "100000", value = "更新后的状态")

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public UpdateMessageStatusRequest userId(Long userId) {
    this.userId = userId;
    return this;
  }

  /**
   * 操作者
   * @return userId
  **/
  @ApiModelProperty(example = "3453454", value = "操作者")

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateMessageStatusRequest updateMessageStatusRequest = (UpdateMessageStatusRequest) o;
    return Objects.equals(this.ids, updateMessageStatusRequest.ids) &&
        Objects.equals(this.status, updateMessageStatusRequest.status) &&
        Objects.equals(this.userId, updateMessageStatusRequest.userId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ids, status, userId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateMessageStatusRequest {\n");
    
    sb.append("    ids: ").append(toIndentedString(ids)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
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
