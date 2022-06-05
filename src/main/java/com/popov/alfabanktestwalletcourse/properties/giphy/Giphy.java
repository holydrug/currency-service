package com.popov.alfabanktestwalletcourse.properties.giphy;

import com.popov.alfabanktestwalletcourse.properties.giphy.query.Query;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Giphy {
    private String api_path;
    private String api_key;
    private String limit;
    private String rating;
    private Query query;
}
