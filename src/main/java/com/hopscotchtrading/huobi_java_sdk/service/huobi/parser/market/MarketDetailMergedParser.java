package com.hopscotchtrading.huobi_java_sdk.service.huobi.parser.market;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.hopscotchtrading.huobi_java_sdk.model.market.MarketDetailMerged;
import com.hopscotchtrading.huobi_java_sdk.service.huobi.parser.HuobiModelParser;

public class MarketDetailMergedParser implements HuobiModelParser<MarketDetailMerged> {

    @Override
    public MarketDetailMerged parse(JSONObject json) {

        MarketDetailMerged detailMerged = json.toJavaObject(MarketDetailMerged.class);
        detailMerged.setAsk(new PriceLevelParser().parse(json.getJSONArray("ask")));
        detailMerged.setBid(new PriceLevelParser().parse(json.getJSONArray("bid")));
        return detailMerged;

    }

    @Override
    public MarketDetailMerged parse(JSONArray json) {
        return null;
    }

    @Override
    public List<MarketDetailMerged> parseArray(JSONArray jsonArray) {
        return null;
    }
}
