package com.example.spamdetector.repository;

import com.example.spamdetector.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findBySpamTrue();

    List<Message> findBySpamFalse();

    List<Message> findByContentContainingIgnoreCase(String keyword);

    long countBySpamTrue();

    long countBySpamFalse();
}
