package com.edukid.backend.controller;

import com.edukid.backend.model.Subscriber;
import com.edukid.backend.service.SubscribeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SubscribeController {

    private final SubscribeService subscribeService;

    public SubscribeController(SubscribeService subscribeService) {
        this.subscribeService = subscribeService;
    }

    @PostMapping("/subscribe")
    public ResponseEntity<String> subscribe(@RequestBody Subscriber subscriber) {
        try {
            subscribeService.savePhone(subscriber);
            return ResponseEntity.ok("OK");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("ERROR");
        }
    }
}