package com.ilia.tacos.data;

import com.ilia.tacos.Ingredient;
import com.ilia.tacos.Ingredient.Type;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;

import javax.sql.DataSource;

@Configuration
public class DataConfig {


//    @Bean
//    public DataSource dataSource() {
//        return DataSourceBuilder.create().url("jdbc:h2:mem:tacocloud").build();
//    }
}
