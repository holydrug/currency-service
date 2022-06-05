package com.popov.alfabanktestwalletcourse.properties.openexchange;

import lombok.Getter;
import lombok.Setter;

import java.net.URI;
import java.util.List;

@Getter
@Setter
public class Openexchange {
    private URI apiPath;
    private String appId;
    private String base;
    private List<String> symbols;
    private String toCompare;
}
