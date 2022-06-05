package com.popov.alfabanktestwalletcourse.controllers.currency;

import com.popov.alfabanktestwalletcourse.service.wallet.CurrencyServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CurrencyController {

    private final CurrencyServiceImpl currencyService;


    @GetMapping(value = "currency")
    public int getRates() {
        return currencyService.compareRates();
    }


}
