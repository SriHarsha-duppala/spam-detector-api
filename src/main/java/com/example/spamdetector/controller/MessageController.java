package com.example.spamdetector.controller;

import com.example.spamdetector.entity.Message;
import com.example.spamdetector.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Message addMessage(@RequestBody Message message) {
        return messageService.saveMessage(message);
    }

    @GetMapping
    public List<Message> getAllMessages() {
        return messageService.getAllMessages();
    }

    @GetMapping("/spam")
    public List<Message> getSpamMessages() {
        return messageService.getSpamMessages();
    }

    @GetMapping("/non-spam")
    public List<Message> getNonSpamMessages() {
        return messageService.getNonSpamMessages();
    }

    @GetMapping("/search")
    public List<Message> searchMessages(@RequestParam(required = false) String keyword) {
        if (keyword == null || keyword.isEmpty()) {
            return messageService.getAllMessages();
        }
        return messageService.searchMessages(keyword);
    }

    @GetMapping("/count/spam")
    public long countSpam() {
        return messageService.countSpam();
    }

    @GetMapping("/count/non-spam")
    public long countNonSpam() {
        return messageService.countNonSpam();
    }
}
