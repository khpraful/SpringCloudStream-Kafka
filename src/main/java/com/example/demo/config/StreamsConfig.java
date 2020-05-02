package com.example.demo.config;


import org.springframework.cloud.stream.annotation.EnableBinding;

import com.example.demo.stream.GreetingsStreams;
@EnableBinding(GreetingsStreams.class)
public class StreamsConfig {
}