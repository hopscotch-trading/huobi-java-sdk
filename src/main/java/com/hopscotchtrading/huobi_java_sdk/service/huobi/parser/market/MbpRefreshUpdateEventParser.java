package com.hopscotchtrading.huobi_java_sdk.service.huobi.parser.market;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.hopscotchtrading.huobi_java_sdk.model.market.MbpRefreshUpdateEvent;
import com.hopscotchtrading.huobi_java_sdk.service.huobi.parser.HuobiModelParser;
import com.hopscotchtrading.huobi_java_sdk.service.huobi.utils.DataUtils;

public class MbpRefreshUpdateEventParser implements HuobiModelParser<MbpRefreshUpdateEvent> {

  @Override
  public MbpRefreshUpdateEvent parse(JSONObject json) {
    String dataKey = DataUtils.getDataKey(json);

    JSONObject data = json.getJSONObject(dataKey);

    return MbpRefreshUpdateEvent.builder()
        .topic(json.getString("ch"))
        .ts(json.getLong("ts"))
        .seqNum(data.getLong("seqNum"))
        .bids(new PriceLevelParser().parseArray(data.getJSONArray("bids")))
        .asks(new PriceLevelParser().parseArray(data.getJSONArray("asks")))
        .build();
  }

  @Override
  public MbpRefreshUpdateEvent parse(JSONArray json) {
    return null;
  }

  @Override
  public List<MbpRefreshUpdateEvent> parseArray(JSONArray jsonArray) {
    return null;
  }
}
