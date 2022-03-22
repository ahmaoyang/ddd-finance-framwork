package com.example.cp.oms.plugin;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.maoyang.ddd", "com.example.cp", "com.example.oms"})
public class PluginConfig {
}
