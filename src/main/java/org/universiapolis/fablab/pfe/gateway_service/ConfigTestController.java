package org.universiapolis.fablab.pfe.gateway_service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class ConfigTestController {
    @Value("${param.x:default-value-x}")
    private String paramX;

    @Value("${param.y:default-value-y}")
    private String paramY;

    @GetMapping("/config-test")
    public String testConfig() {
        return "Value of param.x: " + paramX + ", Value of param.y: " + paramY;
    }
}

