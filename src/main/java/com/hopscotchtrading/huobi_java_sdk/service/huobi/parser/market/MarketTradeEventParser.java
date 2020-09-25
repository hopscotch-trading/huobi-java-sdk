package com.hopscotchtrading.huobi_java_sdk.service.huobi.parser.market;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.hopscotchtrading.huobi_java_sdk.model.market.MarketTradeEvent;
import com.hopscotchtrading.huobi_java_sdk.service.huobi.parser.HuobiModelParser;
import com.hopscotchtrading.huobi_java_sdk.service.huobi.utils.DataUtils;

public class MarketTradeEventParser implements HuobiModelParser<MarketTradeEvent> {

    @Override
    public MarketTradeEvent parse(JSONObject json) {
        String dataKey = DataUtils.getDataKey(json);

        JSONObject data = json.getJSONObject(dataKey);
        JSONArray dataArray = data.getJSONArray("data");

        return MarketTradeEvent.builder().ch(json.getString("ch")).ts(json.getLong("ts"))
                .list(new MarketTradeParser().parseArray(dataArray)).build();
    }

    @Override
    public MarketTradeEvent parse(JSONArray json) {
        return null;
    }

    @Override
    public List<MarketTradeEvent> parseArray(JSONArray jsonArray) {
        return null;
    }
}
