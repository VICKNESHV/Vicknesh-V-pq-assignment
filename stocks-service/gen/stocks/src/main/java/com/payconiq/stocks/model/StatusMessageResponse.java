package com.payconiq.stocks.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.payconiq.stocks.model.StatusMessage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * StatusMessageResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-06-18T13:03:15.216+05:30")


public class StatusMessageResponse   {
  @JsonProperty("statusMessages")
  @Valid
  private List<StatusMessage> statusMessages = new ArrayList<StatusMessage>();

  public StatusMessageResponse statusMessages(List<StatusMessage> statusMessages) {
    this.statusMessages = statusMessages;
    return this;
  }

  public StatusMessageResponse addStatusMessagesItem(StatusMessage statusMessagesItem) {
    this.statusMessages.add(statusMessagesItem);
    return this;
  }

  /**
   * Get statusMessages
   * @return statusMessages
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid
@Size(min=1) 
  public List<StatusMessage> getStatusMessages() {
    return statusMessages;
  }

  public void setStatusMessages(List<StatusMessage> statusMessages) {
    this.statusMessages = statusMessages;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StatusMessageResponse statusMessageResponse = (StatusMessageResponse) o;
    return Objects.equals(this.statusMessages, statusMessageResponse.statusMessages);
  }

  @Override
  public int hashCode() {
    return Objects.hash(statusMessages);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StatusMessageResponse {\n");
    
    sb.append("    statusMessages: ").append(toIndentedString(statusMessages)).append("\n");
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

