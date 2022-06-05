package com.popov.alfabanktestwalletcourse.properties;

import com.popov.alfabanktestwalletcourse.properties.db.Database;
import com.popov.alfabanktestwalletcourse.properties.giphy.Giphy;
import com.popov.alfabanktestwalletcourse.properties.openexchange.Openexchange;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class YAMLProperties {

    private String name;
    private Database database;
    private Openexchange openexchange;
    private Giphy giphy;
}
