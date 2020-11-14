package com.hopscotchtrading.huobi_java_sdk.service.huobi.parser.trade;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.hopscotchtrading.huobi_java_sdk.model.trade.FeeRate;
import com.hopscotchtrading.huobi_java_sdk.service.huobi.parser.HuobiModelParser;

public class FeeRateParser implements HuobiModelParser<FeeRate> {

  @Override
  public FeeRate parse(JSONObject json) {
    return json.toJavaObject(FeeRate.class);
  }

  @Override
  public FeeRate parse(JSONArray json) {
    return null;
  }

  @Override
  public List<FeeRate> parseArray(JSONArray jsonArray) {

    if (jsonArray == null || jsonArray.size() <= 0) {
      return new ArrayList<>();
    }

    return jsonArray.toJavaList(FeeRate.class);
  }
}
