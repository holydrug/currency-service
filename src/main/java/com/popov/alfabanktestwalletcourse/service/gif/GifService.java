package com.popov.alfabanktestwalletcourse.service.gif;

import org.springframework.web.bind.annotation.RequestParam;

public interface GifService {

    byte[] getRichGif();

    byte[] getBrokeGif();

    byte[] getNothingGif();

    byte[] getQueryGif(@RequestParam(name = "q") String query);
}
