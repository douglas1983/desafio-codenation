package com.codenation.desafio.desafio.endpoints;

import com.codenation.desafio.desafio.dto.EventLogDTO;
import com.codenation.desafio.desafio.entity.EventLog;
import com.codenation.desafio.desafio.service.Impl.EventLogService;
import com.querydsl.core.types.Predicate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/eventlog")
public class EventLogController {

    private EventLogService service;

    @GetMapping("/{id}")
    public EventLog findById(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @GetMapping()
    public Page<EventLogDTO> findAll(@QuerydslPredicate(root = EventLog.class) Predicate predicate, Pageable pageable) {
        return service.findAll(predicate, pageable);
    }

    @PostMapping
    public ResponseEntity<EventLog> create(@RequestBody EventLog event) {
        return ResponseEntity.ok().body(service.save(event));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody EventLog event) {
        return service.findById(id).map(record -> {
            record.setDataUpdate(event);
            EventLog updated = service.save(record);
            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = { "/{id}" })
    public ResponseEntity<?> delete(@PathVariable long id) {
        return service.findById(id).map(record -> {
            service.deleleById(id);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }

}