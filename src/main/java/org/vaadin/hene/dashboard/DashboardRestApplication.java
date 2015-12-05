package org.vaadin.hene.dashboard;

import com.google.common.cache.CacheBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCache;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableCaching
public class DashboardRestApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(DashboardRestApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DashboardRestApplication.class);
    }

    @Bean
    public Cache rssCache() {
        return createCache(CacheNames.RSS, 15);
    }

    @Bean
    public Cache twitterCache() {
        return createCache(CacheNames.TWITTER, 15);
    }

    @Bean
    public Cache addonsCache() {
        return createCache(CacheNames.ADDONS, 15);
    }

    @Bean
    public Cache vaadinVersionCache() {
        return createCache(CacheNames.VAADIN_VERSION, 15);
    }

    private static Cache createCache(String name, long expirationInMinutes) {
        return new GuavaCache(name, CacheBuilder.newBuilder().expireAfterWrite(expirationInMinutes, TimeUnit.MINUTES).build());
    }
}
