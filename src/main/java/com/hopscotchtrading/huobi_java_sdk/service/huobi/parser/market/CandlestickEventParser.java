package com.hopscotchtrading.huobi_java_sdk.service.huobi.parser.market;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.hopscotchtrading.huobi_java_sdk.model.market.CandlestickEvent;
import com.hopscotchtrading.huobi_java_sdk.service.huobi.parser.HuobiModelParser;
import com.hopscotchtrading.huobi_java_sdk.service.huobi.utils.DataUtils;

public class CandlestickEventParser implements HuobiModelParser<CandlestickEvent> {

    @Override
    public CandlestickEvent parse(JSONObject json) {

        String dataKey = DataUtils.getDataKey(json);

        return CandlestickEvent.builder().ch(json.getString("ch")).ts(json.getLong("ts"))
                .candlestick(new CandlestickParser().parse(json.getJSONObject(dataKey))).build();
    }

    @Override
    public CandlestickEvent parse(JSONArray json) {
        return null;
    }

    @Override
    public List<CandlestickEvent> parseArray(JSONArray jsonArray) {
        return null;
    }
}
