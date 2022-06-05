package com.popov.alfabanktestwalletcourse.service.distribution;

import com.popov.alfabanktestwalletcourse.service.gif.GifServiceImpl;
import com.popov.alfabanktestwalletcourse.service.wallet.CurrencyServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DistributionServiceImpl implements DistributionService {

    private final CurrencyServiceImpl currencyService;
    private final GifServiceImpl gifService;

    @SneakyThrows
    @Override
    public byte[] getGifOnRatesResponse() {
        if (currencyService.compareRates() == -1)
            return gifService.getBrokeGif();

        if (currencyService.compareRates() == 0)
            return gifService.getNothingGif();

        if (currencyService.compareRates() == 1)
            return gifService.getRichGif();

        return gifService.getQueryGif("ERROR");
    }
}
