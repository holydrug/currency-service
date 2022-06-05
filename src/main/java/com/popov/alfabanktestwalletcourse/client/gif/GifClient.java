package com.popov.alfabanktestwalletcourse.client.gif;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "${feign.gif.name}", url = "${feign.gif.url}")
public interface GifClient {


    @RequestMapping(method = RequestMethod.GET, value = "/gifs/search")
    JsonNode getGifData(@RequestParam(name = "q") String query,
                        @RequestParam(name = "api_key") String apiKey,
                        @RequestParam String limit,
                        @RequestParam String rating);
}
