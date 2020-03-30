package com.hgsachin.springWebApp.configs;

import com.hgsachin.springWebApp.testBeans.FakeDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:fakeDBConnection.properties")
public class PropertyConfig {

    @Autowired
    Environment env;

    @Value("${c.h.username}")
    private String username;

    @Value("${c.h.password}")
    private String password;

    @Value("${c.h.url}")
    private String dburl;

    @Bean
    public FakeDataSource fakeDataSource() {
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUsername(username);
        fakeDataSource.setPassword(password);
        fakeDataSource.setDburl(dburl);
        System.out.println("created fakeDB with: user: " + username + ", url: " + dburl);
        return fakeDataSource;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
