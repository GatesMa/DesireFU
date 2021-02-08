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
 * SelectMessageRequest
 */
@Validated
public class SelectMessageRequest  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("page")
  private Page page = null;

  @JsonProperty("accountId")
  private Long accountId = null;

  @JsonProperty("type")
  private Integer type = null;

  @JsonProperty("status")
  private Integer status = null;

  public SelectMessageRequest page(Page page) {
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

  public SelectMessageRequest accountId(Long accountId) {
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

  public SelectMessageRequest type(Integer type) {
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

  public SelectMessageRequest status(Integer status) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SelectMessageRequest selectMessageRequest = (SelectMessageRequest) o;
    return Objects.equals(this.page, selectMessageRequest.page) &&
        Objects.equals(this.accountId, selectMessageRequest.accountId) &&
        Objects.equals(this.type, selectMessageRequest.type) &&
        Objects.equals(this.status, selectMessageRequest.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(page, accountId, type, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SelectMessageRequest {\n");
    
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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
