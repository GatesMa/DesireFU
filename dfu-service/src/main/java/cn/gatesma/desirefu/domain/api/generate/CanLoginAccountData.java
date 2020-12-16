package cn.gatesma.desirefu.domain.api.generate;

import java.util.Objects;
import cn.gatesma.desirefu.domain.api.generate.CanLoginAccountItem;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CanLoginAccountData
 */
@Validated
public class CanLoginAccountData  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("account_list")
  @Valid
  private java.util.List<CanLoginAccountItem> accountList = null;

  @JsonProperty("platform_type")
  private Integer platformType = null;

  @JsonProperty("platform")
  private String platform = null;

  public CanLoginAccountData accountList(java.util.List<CanLoginAccountItem> accountList) {
    this.accountList = accountList;
    return this;
  }

  public CanLoginAccountData addAccountListItem(CanLoginAccountItem accountListItem) {
    if (this.accountList == null) {
      this.accountList = new java.util.ArrayList<CanLoginAccountItem>();
    }
    this.accountList.add(accountListItem);
    return this;
  }

  /**
   * 可以登录的账号列表
   * @return accountList
  **/
  @ApiModelProperty(value = "可以登录的账号列表")
  @Valid
  public java.util.List<CanLoginAccountItem> getAccountList() {
    return accountList;
  }

  public void setAccountList(java.util.List<CanLoginAccountItem> accountList) {
    this.accountList = accountList;
  }

  public CanLoginAccountData platformType(Integer platformType) {
    this.platformType = platformType;
    return this;
  }

  /**
   * 账号类型
   * @return platformType
  **/
  @ApiModelProperty(example = "1", value = "账号类型")

  public Integer getPlatformType() {
    return platformType;
  }

  public void setPlatformType(Integer platformType) {
    this.platformType = platformType;
  }

  public CanLoginAccountData platform(String platform) {
    this.platform = platform;
    return this;
  }

  /**
   * 账号类型名称
   * @return platform
  **/
  @ApiModelProperty(value = "账号类型名称")

  public String getPlatform() {
    return platform;
  }

  public void setPlatform(String platform) {
    this.platform = platform;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CanLoginAccountData canLoginAccountData = (CanLoginAccountData) o;
    return Objects.equals(this.accountList, canLoginAccountData.accountList) &&
        Objects.equals(this.platformType, canLoginAccountData.platformType) &&
        Objects.equals(this.platform, canLoginAccountData.platform);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountList, platformType, platform);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CanLoginAccountData {\n");
    
    sb.append("    accountList: ").append(toIndentedString(accountList)).append("\n");
    sb.append("    platformType: ").append(toIndentedString(platformType)).append("\n");
    sb.append("    platform: ").append(toIndentedString(platform)).append("\n");
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
