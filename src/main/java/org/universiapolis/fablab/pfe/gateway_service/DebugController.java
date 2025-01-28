package org.universiapolis.fablab.pfe.gateway_service;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RefreshScope
@RestController
public class DebugController {

    private final Environment environment;

    public DebugController(Environment environment) {
        this.environment = environment;
    }

    @RequestMapping("/debug-config")
    public String debugConfig() {
        String paramX = environment.getProperty("param.x", "not-found");
        String paramY = environment.getProperty("param.y", "not-found");
        return "param.x: " + paramX + ", param.y: " + paramY;
    }
}
