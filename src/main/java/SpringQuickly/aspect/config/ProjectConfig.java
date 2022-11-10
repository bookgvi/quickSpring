package SpringQuickly.aspect.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"SpringQuickly.aspect.service", "SpringQuickly.aspect.aspect"})
@EnableAspectJAutoProxy
public class ProjectConfig {
}
