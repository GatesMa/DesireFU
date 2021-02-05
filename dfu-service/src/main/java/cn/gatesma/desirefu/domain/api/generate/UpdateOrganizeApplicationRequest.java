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
 * UpdateOrganizeApplicationRequest
 */
@Validated
public class UpdateOrganizeApplicationRequest  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("status")
  private Integer status = null;

  @JsonProperty("userId")
  private Long userId = null;

  public UpdateOrganizeApplicationRequest id(Long id) {
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

  public UpdateOrganizeApplicationRequest status(Integer status) {
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

  public UpdateOrganizeApplicationRequest userId(Long userId) {
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
    UpdateOrganizeApplicationRequest updateOrganizeApplicationRequest = (UpdateOrganizeApplicationRequest) o;
    return Objects.equals(this.id, updateOrganizeApplicationRequest.id) &&
        Objects.equals(this.status, updateOrganizeApplicationRequest.status) &&
        Objects.equals(this.userId, updateOrganizeApplicationRequest.userId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, status, userId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateOrganizeApplicationRequest {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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
