package com.popov.alfabanktestwalletcourse.service.wallet.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.popov.alfabanktestwalletcourse.client.currency.CurrencyClient;
import com.popov.alfabanktestwalletcourse.properties.YAMLProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class RatesApi {

    private static final int SECONDS_IN_DAY = 86400;

    private final YAMLProperties config;
    private final ObjectMapper mapper;
    private final Instant instantNow;
    private final CurrencyClient client;


    public Map<String, Double> getUpdatedRatesFullJson() {

        JsonNode root = getRatesAsDataUpdated();
        JsonNode rates = root.path("rates");

        return mapper.convertValue(rates, HashMap.class);
    }

    public Map<String, Double> getRatesYesterday() {
        JsonNode root = getRatesAsDataYesterday();
        JsonNode rates = root.path("rates");

        return mapper.convertValue(rates, HashMap.class);
    }

    private JsonNode getRatesAsDataUpdated() {
        return client.getRatesAsDataUpdated(
                config.getOpenexchange().getAppId(),
                config.getOpenexchange().getBase(),
                String.join(",", config.getOpenexchange().getSymbols()));
    }

    private JsonNode getRatesAsDataYesterday() {
        return client.getRatesAsDataHistorical(
                getYesterdayDateAsString(),
                config.getOpenexchange().getAppId(),
                config.getOpenexchange().getBase(),
                String.join(",", config.getOpenexchange().getSymbols()));
    }

    private String getYesterdayDateAsString() {

        return DateTimeFormatter.ofPattern("yyyy-MM-dd")
                .withZone(ZoneId.of("UTC"))
                .format(Instant.parse(instantNow.minusSeconds(SECONDS_IN_DAY).toString()));
    }

}
