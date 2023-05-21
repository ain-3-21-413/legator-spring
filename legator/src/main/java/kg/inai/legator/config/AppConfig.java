package kg.inai.legator.config;

import kg.inai.legator.mapper.PatronMapper;
import kg.inai.legator.mapper.impl.PatronMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public PatronMapper patronMapper() {
        return new PatronMapperImpl();
    }
}
