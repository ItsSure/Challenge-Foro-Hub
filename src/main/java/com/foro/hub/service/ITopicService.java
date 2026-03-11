package com.foro.hub.service;

import org.springframework.data.domain.Page;

import com.foro.hub.Utils.SortT;
import com.foro.hub.dtos.TopicDto;
import com.foro.hub.models.Topic;

public interface ITopicService {
    String FIELD_BY_SORT = "fechaCreacion";

    Page<Topic> findAll(Integer page, Integer size, SortT sortT);

    Topic findById(Long id);

    Topic save(TopicDto topico);

    Topic update(Long id, TopicDto topico);

    void deleteById(Long id);

}
