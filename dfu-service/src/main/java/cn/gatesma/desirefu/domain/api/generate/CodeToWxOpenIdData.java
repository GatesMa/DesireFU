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
 * CodeToWxOpenIdData
 */
@Validated
public class CodeToWxOpenIdData  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("code")
  private String code = null;

  @JsonProperty("open_id")
  private String openId = null;

  public CodeToWxOpenIdData code(String code) {
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

  public CodeToWxOpenIdData openId(String openId) {
    this.openId = openId;
    return this;
  }

  /**
   * WX账号的openId
   * @return openId
  **/
  @ApiModelProperty(example = "oNMqH5BpVtDgoo7zdvcjej_w-mwE", value = "WX账号的openId")

  public String getOpenId() {
    return openId;
  }

  public void setOpenId(String openId) {
    this.openId = openId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CodeToWxOpenIdData codeToWxOpenIdData = (CodeToWxOpenIdData) o;
    return Objects.equals(this.code, codeToWxOpenIdData.code) &&
        Objects.equals(this.openId, codeToWxOpenIdData.openId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, openId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CodeToWxOpenIdData {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    openId: ").append(toIndentedString(openId)).append("\n");
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
