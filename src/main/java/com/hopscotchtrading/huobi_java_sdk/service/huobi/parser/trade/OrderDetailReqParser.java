package com.hopscotchtrading.huobi_java_sdk.service.huobi.parser.trade;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.hopscotchtrading.huobi_java_sdk.model.trade.OrderDetailReq;
import com.hopscotchtrading.huobi_java_sdk.service.huobi.parser.HuobiModelParser;

public class OrderDetailReqParser implements HuobiModelParser<OrderDetailReq> {

    @Override
    public OrderDetailReq parse(JSONObject json) {
        return OrderDetailReq.builder().topic(json.getString("topic")).ts(json.getLong("ts"))
                .order(new OrderParser().parse(json.getJSONObject("data"))).build();
    }

    @Override
    public OrderDetailReq parse(JSONArray json) {
        return null;
    }

    @Override
    public List<OrderDetailReq> parseArray(JSONArray jsonArray) {
        return null;
    }
}
