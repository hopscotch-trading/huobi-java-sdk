package com.hopscotchtrading.huobi_java_sdk.client;

import java.util.List;

import com.hopscotchtrading.huobi_java_sdk.client.req.generic.CurrencyChainsRequest;
import com.hopscotchtrading.huobi_java_sdk.constant.Options;
import com.hopscotchtrading.huobi_java_sdk.constant.enums.ExchangeEnum;
import com.hopscotchtrading.huobi_java_sdk.exception.SDKException;
import com.hopscotchtrading.huobi_java_sdk.model.generic.CurrencyChain;
import com.hopscotchtrading.huobi_java_sdk.model.generic.MarketStatus;
import com.hopscotchtrading.huobi_java_sdk.model.generic.Symbol;
import com.hopscotchtrading.huobi_java_sdk.service.huobi.HuobiGenericService;

public interface GenericClient {

    String getSystemStatus();

    MarketStatus getMarketStatus();

    List<Symbol> getSymbols();

    List<String> getCurrencys();

    List<CurrencyChain> getCurrencyChains(CurrencyChainsRequest request);

    Long getTimestamp();

    static GenericClient create(Options options) {

        if (options.getExchange().equals(ExchangeEnum.HUOBI)) {
            return new HuobiGenericService(options);
        }
        throw new SDKException(SDKException.INPUT_ERROR, "Unsupport Exchange.");
    }
}
