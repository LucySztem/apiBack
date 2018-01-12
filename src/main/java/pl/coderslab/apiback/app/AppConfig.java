package pl.coderslab.apiback.app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"pl.coderslab.apiback.model", "pl.coderslab.apiback.controller" })
public class AppConfig extends WebMvcConfigurerAdapter {

}
