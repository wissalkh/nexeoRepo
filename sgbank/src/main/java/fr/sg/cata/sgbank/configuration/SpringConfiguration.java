package fr.sg.cata.sgbank.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"fr.sg.cata.sgbank.dao", "fr.sg.cata.sgbank.service"})
public class SpringConfiguration {

}
