package com.popov.alfabanktestwalletcourse.controllers.gif;

import com.popov.alfabanktestwalletcourse.service.gif.GifServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GifController {

    private final GifServiceImpl gifService;

    @GetMapping(value = "gif", produces = "image/jpeg")
    public byte[] getQueryGif(@RequestParam(name = "q") String query) {
        return gifService.getQueryGif(query);
    }


}
