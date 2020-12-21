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
 * CodeToWxOpenIdRequest
 */
@Validated
public class CodeToWxOpenIdRequest  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("code")
  private String code = null;

  public CodeToWxOpenIdRequest code(String code) {
    this.code = code;
    return this;
  }

  /**
   * 临时登录凭证 code
   * @return code
  **/
  @ApiModelProperty(example = "063UK5Ga1mTabA0qKAGa1aRBAv2UK5Ga", value = "临时登录凭证 code")

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CodeToWxOpenIdRequest codeToWxOpenIdRequest = (CodeToWxOpenIdRequest) o;
    return Objects.equals(this.code, codeToWxOpenIdRequest.code);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CodeToWxOpenIdRequest {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
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
