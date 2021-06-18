package com.itranlin.basic.core.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author itranlin
 * @date 2021/4/21 14:33
 */
@Data
@ConfigurationProperties(prefix = "com.itranlin.basic-config")
public class BasicConfig {
    private String basicPackage;
}
