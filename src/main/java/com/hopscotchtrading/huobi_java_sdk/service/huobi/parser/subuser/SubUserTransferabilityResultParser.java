package com.hopscotchtrading.huobi_java_sdk.service.huobi.parser.subuser;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.hopscotchtrading.huobi_java_sdk.model.subuser.SubUserTransferabilityResult;
import com.hopscotchtrading.huobi_java_sdk.service.huobi.parser.HuobiModelParser;

public class SubUserTransferabilityResultParser implements HuobiModelParser<SubUserTransferabilityResult> {

  @Override
  public SubUserTransferabilityResult parse(JSONObject json) {
    return SubUserTransferabilityResult.builder()
        .list(new SubUserTransferabilityStateParser().parseArray(json.getJSONArray("data")))
        .build();
  }

  @Override
  public SubUserTransferabilityResult parse(JSONArray json) {
    return null;
  }

  @Override
  public List<SubUserTransferabilityResult> parseArray(JSONArray jsonArray) {
    return null;
  }
}
