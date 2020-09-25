package com.hopscotchtrading.huobi_java_sdk.service.huobi.parser.market;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.hopscotchtrading.huobi_java_sdk.model.market.MarketDetail;
import com.hopscotchtrading.huobi_java_sdk.service.huobi.parser.HuobiModelParser;

public class MarketDetailParser implements HuobiModelParser<MarketDetail> {

    @Override
    public MarketDetail parse(JSONObject json) {
        return json.toJavaObject(MarketDetail.class);
    }

    @Override
    public MarketDetail parse(JSONArray json) {
        return null;
    }

    @Override
    public List<MarketDetail> parseArray(JSONArray jsonArray) {
        return null;
    }
}
