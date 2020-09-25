package com.hopscotchtrading.huobi_java_sdk.service.huobi.parser.trade;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.hopscotchtrading.huobi_java_sdk.model.trade.OrderUpdateEvent;
import com.hopscotchtrading.huobi_java_sdk.service.huobi.parser.HuobiModelParser;

public class OrderUpdateEventParser implements HuobiModelParser<OrderUpdateEvent> {

    @Override
    public OrderUpdateEvent parse(JSONObject json) {
        return OrderUpdateEvent.builder().topic(json.getString("topic")).ts(json.getLong("ts"))
                .update(new OrderUpdateParser().parse(json.getJSONObject("data"))).build();
    }

    @Override
    public OrderUpdateEvent parse(JSONArray json) {
        return null;
    }

    @Override
    public List<OrderUpdateEvent> parseArray(JSONArray jsonArray) {
        return null;
    }
}
