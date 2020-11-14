package com.hopscotchtrading.huobi_java_sdk.client.req.trade;

import java.util.Date;
import java.util.List;

import com.hopscotchtrading.huobi_java_sdk.constant.enums.OrderTypeEnum;
import com.hopscotchtrading.huobi_java_sdk.constant.enums.QueryDirectionEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MatchResultRequest {

  private String symbol;

  private List<OrderTypeEnum> types;

  private Date startDate;

  private Date endDate;

  private Integer size;

  private String from;

  private QueryDirectionEnum direction;


  public String getTypeString(){
    if (types == null || types.size() <= 0) {
      return null;
    }

    StringBuffer typeBuffer = new StringBuffer();
    this.getTypes().forEach(orderType -> {
      typeBuffer.append(orderType.getCode()).append(",");
    });

    return typeBuffer.substring(0, typeBuffer.length() - 1);
  }

}
