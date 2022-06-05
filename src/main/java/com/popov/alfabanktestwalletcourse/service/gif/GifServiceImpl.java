package com.popov.alfabanktestwalletcourse.service.gif;

import com.popov.alfabanktestwalletcourse.service.gif.api.GifApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GifServiceImpl implements GifService {

    private final GifApi gifApi;

    @Override
    public byte[] getRichGif() {

        return gifApi.getQueryGif("rich");
    }

    @Override
    public byte[] getBrokeGif() {

        return gifApi.getQueryGif("broke");
    }

    @Override
    public byte[] getNothingGif() {
        return gifApi.getQueryGif("nothing");
    }

    @Override
    public byte[] getQueryGif(String query) {
        return gifApi.getQueryGif(query);
    }

}
