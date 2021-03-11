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
 * DeleteRoleRelationRequest
 */
@Validated
public class DeleteRoleRelationRequest  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("accountRoleId")
  private Long accountRoleId = null;

  public DeleteRoleRelationRequest accountRoleId(Long accountRoleId) {
    this.accountRoleId = accountRoleId;
    return this;
  }

  /**
   * accountRoleId
   * @return accountRoleId
  **/
  @ApiModelProperty(example = "1", value = "accountRoleId")

  public Long getAccountRoleId() {
    return accountRoleId;
  }

  public void setAccountRoleId(Long accountRoleId) {
    this.accountRoleId = accountRoleId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeleteRoleRelationRequest deleteRoleRelationRequest = (DeleteRoleRelationRequest) o;
    return Objects.equals(this.accountRoleId, deleteRoleRelationRequest.accountRoleId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountRoleId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeleteRoleRelationRequest {\n");
    
    sb.append("    accountRoleId: ").append(toIndentedString(accountRoleId)).append("\n");
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
