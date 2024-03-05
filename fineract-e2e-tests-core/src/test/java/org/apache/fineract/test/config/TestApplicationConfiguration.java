package org.apache.fineract.test.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(value = "org.apache.fineract.test", excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = "org\\.apache\\.fineract\\.test\\.initializer.*"))
@PropertySource("classpath:fineract-test-application.properties")
public class TestApplicationConfiguration {}
