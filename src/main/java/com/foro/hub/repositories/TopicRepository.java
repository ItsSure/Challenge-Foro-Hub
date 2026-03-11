package com.foro.hub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foro.hub.models.Topic;

public interface TopicRepository extends JpaRepository<Topic, Long> {
}
