package kg.inai.legator.config;

import kg.inai.legator.mapper.BookMapper;
import kg.inai.legator.mapper.ItemMapper;
import kg.inai.legator.mapper.PatronMapper;
import kg.inai.legator.mapper.impl.BookMapperImpl;
import kg.inai.legator.mapper.impl.ItemMapperImpl;
import kg.inai.legator.mapper.impl.PatronMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public PatronMapper patronMapper() {
        return new PatronMapperImpl();
    }

    @Bean
    public BookMapper bookMapper() {
        return new BookMapperImpl();
    }

    @Bean
    public ItemMapper itemMapper() {
        return new ItemMapperImpl(bookMapper());
    }
}
