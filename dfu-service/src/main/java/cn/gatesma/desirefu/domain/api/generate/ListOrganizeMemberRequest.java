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
 * ListOrganizeMemberRequest
 */
@Validated
public class ListOrganizeMemberRequest  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("organizeId")
  private Long organizeId = null;

  public ListOrganizeMemberRequest organizeId(Long organizeId) {
    this.organizeId = organizeId;
    return this;
  }

  /**
   * 账号ID
   * @return organizeId
  **/
  @ApiModelProperty(example = "100000", value = "账号ID")

  public Long getOrganizeId() {
    return organizeId;
  }

  public void setOrganizeId(Long organizeId) {
    this.organizeId = organizeId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListOrganizeMemberRequest listOrganizeMemberRequest = (ListOrganizeMemberRequest) o;
    return Objects.equals(this.organizeId, listOrganizeMemberRequest.organizeId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(organizeId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListOrganizeMemberRequest {\n");
    
    sb.append("    organizeId: ").append(toIndentedString(organizeId)).append("\n");
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
