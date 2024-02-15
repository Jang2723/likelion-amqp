package com.example.publisher;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PublisherController {
    private final PublisherService service;

    @PostMapping("fanout")
    public void fanout(
            @RequestParam("message")
            String message
    ) {
        service.fanoutMessage(message);
    }

    @PostMapping("direct")
    public void direct(
            @RequestParam("key")
            String key,
            @RequestParam("message")
            String message
    ) {
        service.directExchange(key, message);
    }

    @PostMapping("topic")
    public void topic(
            @RequestParam("topic")
            String topic,
            @RequestParam("message")
            String message
    ) {
        service.sendTopic(topic, message);
    }
}
