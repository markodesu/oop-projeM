package com.mariiam.portfolio.controller;

import com.mariiam.portfolio.entity.ContactMessage;
import com.mariiam.portfolio.repository.ContactMessageRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class ContactMessageController {

    private final ContactMessageRepository repository;

    public ContactMessageController(ContactMessageRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<ContactMessage> saveMessage(@RequestBody ContactMessage message) {
        return new ResponseEntity<>(repository.save(message), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ContactMessage>> getAllMessages() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }
}
