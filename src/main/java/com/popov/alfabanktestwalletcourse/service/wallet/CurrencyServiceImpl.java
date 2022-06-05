package com.popov.alfabanktestwalletcourse.service.wallet;

import com.popov.alfabanktestwalletcourse.properties.YAMLProperties;
import com.popov.alfabanktestwalletcourse.service.wallet.api.RatesApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

    private final RatesApi ratesApi;
    private final YAMLProperties config;

    @Override
    public int compareRates() {
        return Double.compare(getCurrentRateOfCurrency(), getPreviousDayRateOfCurrency());
    }


    private Double getCurrentRateOfCurrency() {
        Map<String, Double> updatedRatesInMap = ratesApi.getUpdatedRatesFullJson();
        return updatedRatesInMap.get(config.getOpenexchange().getToCompare());
    }

    private Double getPreviousDayRateOfCurrency() {
        Map<String, Double> yesterdayRatesInMap = ratesApi.getRatesYesterday();
        return yesterdayRatesInMap.get(config.getOpenexchange().getToCompare());
    }

}
