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
 * UpdateAccountRequest
 */
@Validated
public class UpdateAccountRequest  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("accountId")
  private Long accountId = null;

  @JsonProperty("nickName")
  private String nickName = null;

  @JsonProperty("memo")
  private String memo = null;

  @JsonProperty("accountStatus")
  private Integer accountStatus = null;

  public UpdateAccountRequest accountId(Long accountId) {
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

  public UpdateAccountRequest nickName(String nickName) {
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

  public UpdateAccountRequest memo(String memo) {
    this.memo = memo;
    return this;
  }

  /**
   * 备注
   * @return memo
  **/
  @ApiModelProperty(example = "gatesma", value = "备注")

  public String getMemo() {
    return memo;
  }

  public void setMemo(String memo) {
    this.memo = memo;
  }

  public UpdateAccountRequest accountStatus(Integer accountStatus) {
    this.accountStatus = accountStatus;
    return this;
  }

  /**
   * 账号状态
   * @return accountStatus
  **/
  @ApiModelProperty(example = "1", value = "账号状态")

  public Integer getAccountStatus() {
    return accountStatus;
  }

  public void setAccountStatus(Integer accountStatus) {
    this.accountStatus = accountStatus;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateAccountRequest updateAccountRequest = (UpdateAccountRequest) o;
    return Objects.equals(this.accountId, updateAccountRequest.accountId) &&
        Objects.equals(this.nickName, updateAccountRequest.nickName) &&
        Objects.equals(this.memo, updateAccountRequest.memo) &&
        Objects.equals(this.accountStatus, updateAccountRequest.accountStatus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountId, nickName, memo, accountStatus);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateAccountRequest {\n");
    
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    nickName: ").append(toIndentedString(nickName)).append("\n");
    sb.append("    memo: ").append(toIndentedString(memo)).append("\n");
    sb.append("    accountStatus: ").append(toIndentedString(accountStatus)).append("\n");
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
