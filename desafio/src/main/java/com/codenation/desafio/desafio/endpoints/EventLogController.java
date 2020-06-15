package com.codenation.desafio.desafio.endpoints;

import com.codenation.desafio.desafio.annotations.PredicateAsQueryParamEventLog;
import com.codenation.desafio.desafio.dto.EventLogDTO;
import com.codenation.desafio.desafio.dto.EventLogUpdateDTO;
import com.codenation.desafio.desafio.entity.EventLog;
import com.codenation.desafio.desafio.service.Impl.EventLogService;
import com.querydsl.core.types.Predicate;

import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/eventlog")
public class EventLogController {
    @Autowired
    private EventLogService service;

    @GetMapping("/{id}")
    public EventLog findById(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @GetMapping()
    @PredicateAsQueryParamEventLog
    @PageableAsQueryParam
    public Page<EventLogDTO> findAll(
            @Parameter(hidden = true) @QuerydslPredicate(root = EventLog.class) Predicate predicate,
            @Parameter(hidden = true) @PageableDefault(size = 10) Pageable pageable) {
        return service.findAll(predicate, pageable);
    }

    @PostMapping
    public ResponseEntity<EventLog> create(@RequestBody EventLogUpdateDTO event) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveDTO(event));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody EventLogUpdateDTO event) {
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
