package com.example.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import com.example.demo.model.Greetings;
import com.example.demo.stream.GreetingsStreams;
@Service
@Slf4j
public class GreetingsService {
    private final GreetingsStreams greetingsStreams;
    public GreetingsService(GreetingsStreams greetingsStreams) {
        this.greetingsStreams = greetingsStreams;
    }
    public void sendGreeting(final Greetings greetings) {
        log.info("Sending greetings {}", greetings);
        MessageChannel messageChannel = greetingsStreams.outboundGreetings();
        messageChannel.send(MessageBuilder
                .withPayload(greetings)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build());
    }
}