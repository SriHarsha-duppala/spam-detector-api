package com.example.spamdetector.service;

import com.example.spamdetector.entity.Message;
import com.example.spamdetector.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public Message saveMessage(Message message) {
        message.setSpam(detectSpam(message.getContent()));
        return messageRepository.save(message);
    }

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    public List<Message> getSpamMessages() {
        return messageRepository.findBySpamTrue();
    }

    public List<Message> getNonSpamMessages() {
        return messageRepository.findBySpamFalse();
    }

    public List<Message> searchMessages(String keyword) {
        return messageRepository.findByContentContainingIgnoreCase(keyword);
    }

    public long countSpam() {
        return messageRepository.countBySpamTrue();
    }

    public long countNonSpam() {
        return messageRepository.countBySpamFalse();
    }

    private boolean detectSpam(String content) {
        if (content == null) return false;
        String lower = content.toLowerCase();
        String[] spamKeywords = {"win", "free", "offer", "click here", "money", "prize"};
        for (String keyword : spamKeywords) {
            if (lower.contains(keyword)) return true;
        }
        return false;
    }
}
