package com.hopscotchtrading.huobi_java_sdk.utils;

import com.hopscotchtrading.huobi_java_sdk.constant.enums.ConnectionStateEnum;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class WebSocketWatchDog {

    public static final long RECEIVE_LIMIT_TS = 60_000;

    public static final int DELAY_ON_FAILURE = 15;

    private static final Map<Long, WebSocketConnection> TIME_HELPER = new ConcurrentHashMap<>();

    static {
        long t = 1_000;
        ScheduledExecutorService exec = Executors.newScheduledThreadPool(1);
        exec.scheduleAtFixedRate(() -> {
            TIME_HELPER.entrySet().forEach(entry -> {
                WebSocketConnection connection = entry.getValue();
                if (connection.getState() == ConnectionStateEnum.CONNECTED) {
                    // Check response

                    long ts = System.currentTimeMillis() - connection.getLastReceivedTime();
                    if (ts > RECEIVE_LIMIT_TS) {
                        // log.warn("[Sub][" + connection.getConnectionId() + "] No response from server");
                        connection.reConnect(DELAY_ON_FAILURE);
                    }

                } else if (connection.getState() == ConnectionStateEnum.DELAY_CONNECT) {
                    connection.reConnect();
                } else if (connection.getState() == ConnectionStateEnum.CLOSED_ON_ERROR) {

                    connection.reConnect(DELAY_ON_FAILURE);

                }
            });
        }, t, t, TimeUnit.MILLISECONDS);
        Runtime.getRuntime().addShutdownHook(new Thread(exec::shutdown));
    }

    private WebSocketWatchDog() {
    }

    public static void onConnectionCreated(WebSocketConnection connection) {
        TIME_HELPER.put(connection.getConnectionId(), connection);
    }

    public static void onClosedNormally(WebSocketConnection connection) {
        TIME_HELPER.remove(connection);
    }
}
