package wave.config.autoconfig;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import wave.config.MyAutoConfiguration;

@MyAutoConfiguration
public class TomcatWebServerConfig {

    @Bean("tomcatWebServerFactory")

    public ServletWebServerFactory servletWebServerFactory() {

        return new TomcatServletWebServerFactory();
    }
}