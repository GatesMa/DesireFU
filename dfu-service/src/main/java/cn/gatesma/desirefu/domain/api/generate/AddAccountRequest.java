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
 * AddAccountRequest
 */
@Validated
public class AddAccountRequest  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("account_type")
  private Integer accountType = null;

  @JsonProperty("nick_name")
  private String nickName = null;

  @JsonProperty("memo")
  private String memo = null;

  @JsonProperty("created_user_id")
  private Long createdUserId = null;

  public AddAccountRequest accountType(Integer accountType) {
    this.accountType = accountType;
    return this;
  }

  /**
   * 账号类型
   * @return accountType
  **/
  @ApiModelProperty(example = "1", value = "账号类型")

  public Integer getAccountType() {
    return accountType;
  }

  public void setAccountType(Integer accountType) {
    this.accountType = accountType;
  }

  public AddAccountRequest nickName(String nickName) {
    this.nickName = nickName;
    return this;
  }

  /**
   * 账号名称
   * @return nickName
  **/
  @ApiModelProperty(example = "gatesma", value = "账号名称")

  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  public AddAccountRequest memo(String memo) {
    this.memo = memo;
    return this;
  }

  /**
   * 备注
   * @return memo
  **/
  @ApiModelProperty(example = "审核通过", value = "备注")

  public String getMemo() {
    return memo;
  }

  public void setMemo(String memo) {
    this.memo = memo;
  }

  public AddAccountRequest createdUserId(Long createdUserId) {
    this.createdUserId = createdUserId;
    return this;
  }

  /**
   * 创建者userId
   * @return createdUserId
  **/
  @ApiModelProperty(example = "3453454", value = "创建者userId")

  public Long getCreatedUserId() {
    return createdUserId;
  }

  public void setCreatedUserId(Long createdUserId) {
    this.createdUserId = createdUserId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AddAccountRequest addAccountRequest = (AddAccountRequest) o;
    return Objects.equals(this.accountType, addAccountRequest.accountType) &&
        Objects.equals(this.nickName, addAccountRequest.nickName) &&
        Objects.equals(this.memo, addAccountRequest.memo) &&
        Objects.equals(this.createdUserId, addAccountRequest.createdUserId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountType, nickName, memo, createdUserId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddAccountRequest {\n");
    
    sb.append("    accountType: ").append(toIndentedString(accountType)).append("\n");
    sb.append("    nickName: ").append(toIndentedString(nickName)).append("\n");
    sb.append("    memo: ").append(toIndentedString(memo)).append("\n");
    sb.append("    createdUserId: ").append(toIndentedString(createdUserId)).append("\n");
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
