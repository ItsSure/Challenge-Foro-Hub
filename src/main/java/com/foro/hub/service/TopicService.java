package com.foro.hub.service;

import org.springframework.data.domain.PageRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.foro.hub.Utils.SortT;
import com.foro.hub.Utils.TopicNotFoundException;
import com.foro.hub.dtos.TopicDto;
import com.foro.hub.models.Topic;
import com.foro.hub.repositories.TopicRepository;

@Service
@RequiredArgsConstructor
public class TopicService implements ITopicService {
    private final TopicRepository repository;

    @Override
    @Transactional
    public Page<Topic> findAll(Integer page, Integer size, SortT sortT) {
        PageRequest pageRequest = null;

        switch (sortT) {
            case NONE -> pageRequest = PageRequest.of(page, size);
            case LOWER -> pageRequest = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());
            case UPPER -> pageRequest = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
        }
        return repository.findAll(pageRequest);
    }

    @Override
    public Topic findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new TopicNotFoundException("No existe este Topic con id " + id));
    }

    @Override
    @Transactional
    public Topic save(TopicDto Topic) {
        var topicN = new Topic(null, Topic.titulo(), Topic.mensaje(), Topic.fechaCreacion(), Topic.autor(),
                Topic.curso());

        return repository.save(topicN);
    }

    @Override
    @Transactional
    public Topic update(Long id, TopicDto Topic) {

        var topicUpdate = repository.findById(id)
                .orElseThrow(() -> new TopicNotFoundException("No existe este Topic con id " + id));

        topicUpdate.setAutor(Topic.autor());
        topicUpdate.setTitulo(Topic.titulo());
        topicUpdate.setCurso(Topic.curso());
        topicUpdate.setMensaje(Topic.mensaje());
        return repository.save(topicUpdate);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        if (repository.findById(id).isEmpty()) {
            throw new TopicNotFoundException("No existe este Topic " + id);
        }
        repository.deleteById(id);
    }
}
