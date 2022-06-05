package com.popov.alfabanktestwalletcourse.client.currency;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "${feign.currency.name}", url = "${feign.currency.url}")
public interface CurrencyClient {

    @RequestMapping(method = RequestMethod.GET, value = "latest.json")
    JsonNode getRatesAsDataUpdated(@RequestParam(name = "app_id") String appId,
                                   @RequestParam String base,
                                   @RequestParam String symbols);

    @RequestMapping(method = RequestMethod.GET, value = "historical/{date}.json")
    JsonNode getRatesAsDataHistorical(@PathVariable String date,
                                      @RequestParam(name = "app_id") String appId,
                                      @RequestParam String base,
                                      @RequestParam String symbols);

}
