package com.popov.alfabanktestwalletcourse.controllers.distribution;

import com.popov.alfabanktestwalletcourse.service.distribution.DistributionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DistributionController {

    private final DistributionServiceImpl distributionService;

    @GetMapping(value = "check", produces = "image/jpeg")
    public byte[] getGifOnRatesResponse() {
        return distributionService.getGifOnRatesResponse();
    }
}
