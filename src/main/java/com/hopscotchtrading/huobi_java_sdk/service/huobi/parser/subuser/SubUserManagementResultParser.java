package com.hopscotchtrading.huobi_java_sdk.service.huobi.parser.subuser;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.hopscotchtrading.huobi_java_sdk.model.subuser.SubUserManagementResult;
import com.hopscotchtrading.huobi_java_sdk.service.huobi.parser.HuobiModelParser;

public class SubUserManagementResultParser implements HuobiModelParser<SubUserManagementResult> {

  @Override
  public SubUserManagementResult parse(JSONObject json) {
    return json.toJavaObject(SubUserManagementResult.class);
  }

  @Override
  public SubUserManagementResult parse(JSONArray json) {
    return null;
  }

  @Override
  public List<SubUserManagementResult> parseArray(JSONArray jsonArray) {
    return null;
  }
}
