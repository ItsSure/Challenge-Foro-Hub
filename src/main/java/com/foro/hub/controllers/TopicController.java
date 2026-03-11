package com.foro.hub.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.foro.hub.Utils.SortT;
import com.foro.hub.dtos.TopicDto;
import com.foro.hub.models.Topic;
import com.foro.hub.service.ITopicService;

@RestController
@RequestMapping("/topic")
@RequiredArgsConstructor
public class TopicController {

    private final ITopicService service;

    @PostMapping
    public ResponseEntity<Topic> save(@Valid @RequestBody TopicDto topico) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(topico));
    }

    @PutMapping("{id}")
    public ResponseEntity<Topic> update(@PathVariable Long id, @RequestBody TopicDto topico) {
        return ResponseEntity.ok().body(service.update(id, topico));
    }

    @GetMapping("/all")
    public ResponseEntity<Page<Topic>> findAll(@RequestParam Integer page,
            @RequestParam Integer size,
            @RequestParam(required = false) SortT sortT) {
        if (sortT == null) {
            sortT = SortT.NONE;
        }
        return ResponseEntity.ok().body(service.findAll(page, size, sortT));
    }

    @GetMapping("{id}")
    public ResponseEntity<Topic> readById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
