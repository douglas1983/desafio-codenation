package com.codenation.desafio.desafio.service.Impl;

import lombok.AllArgsConstructor;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.codenation.desafio.desafio.dto.EventLogDTO;
import com.codenation.desafio.desafio.entity.EventLog;
import com.codenation.desafio.desafio.mappers.EventLogMapper;
import com.codenation.desafio.desafio.repository.EventLogRepository;
import com.codenation.desafio.desafio.service.EventLogServiceInterface;
import com.querydsl.core.types.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EventLogService implements EventLogServiceInterface {

    private EventLogRepository repository;
    private EventLogMapper mapper;

    public Optional<EventLog> findById(Long id) {
        return repository.findById(id);
    }

    public Page<EventLogDTO> findAll(Predicate predicate, Pageable pageable) {
        Page<EventLog> eventlogs = repository.findAll(predicate, pageable);
        List<EventLogDTO> eventslogDTO = eventlogs.get().map(mapper::map).collect(Collectors.toList());
        return new PageImpl<EventLogDTO>(eventslogDTO, eventlogs.getPageable(), eventlogs.getSize());
    }

    public EventLog save(EventLog event) {
        return repository.save(event);
    }

    public void deleleById(Long id) {
        repository.deleteById(id);
    }

}
