package com.popov.alfabanktestwalletcourse.service.gif.api;


import com.fasterxml.jackson.databind.JsonNode;
import com.popov.alfabanktestwalletcourse.client.gif.GifClient;
import com.popov.alfabanktestwalletcourse.properties.YAMLProperties;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class GifApi {

    private final GifClient gifClient;
    private final YAMLProperties config;
    private final RestTemplate restTemplate;


    @SneakyThrows
    public byte[] getQueryGif(String query) {

        String path = getGifData(query)
                .path("data")
                .get(0)
                .path("images")
                .path("original")
                .path("url")
                .asText();

        return getImageFromSourcePath(path);
    }

    private JsonNode getGifData(String query) {
        return gifClient.getGifData(query,
                config.getGiphy().getApi_key(),
                config.getGiphy().getLimit(),
                config.getGiphy().getRating());
    }

    @SneakyThrows
    private byte[] getImageFromSourcePath(String path) {
        return restTemplate.getForObject(path, byte[].class);
    }
}
