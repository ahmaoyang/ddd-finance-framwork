package com.example.cp.oms.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@Configuration

@ComponentScan(basePackages = {"com.maoyang.enforce", "com.example.cp", "com.example.bp", "com.example.oms"})
public class AppConfig {
}
