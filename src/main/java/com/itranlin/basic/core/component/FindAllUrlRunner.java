package com.itranlin.basic.core.component;

import com.itranlin.basic.common.util.SpringUtils;
import com.itranlin.basic.core.bean.BasicConfig;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;

/**
 * @author itranlin
 * @date 2021/4/21 14:17
 */
@Slf4j
@Component
public class FindAllUrlRunner implements ApplicationRunner {

    @Resource
    private BasicConfig basicConfig;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        RequestMappingHandlerMapping mapping = SpringUtils.getBean(RequestMappingHandlerMapping.class);
        List<String> urls = new ArrayList<>();
        mapping.getHandlerMethods().forEach((key, value) -> {
            if (value.getBeanType().getName().startsWith(basicConfig.getBasicPackage())) {
                if (key.getPatternsCondition() != null) {
                    urls.addAll(key.getPatternsCondition().getPatterns());
                }
            }
        });
        log.debug(String.join("\n", urls));


    }
}
