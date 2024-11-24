package config;

import aspect.LoggingAspect;
import aspect.SecurityAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "service")
@EnableAspectJAutoProxy
public class ProjectConfig {

    @Bean
    public LoggingAspect loggingAspect(){
        return new LoggingAspect();
    }

    @Bean
    public SecurityAspect securityAspect(){
        return new SecurityAspect();
    }
}
