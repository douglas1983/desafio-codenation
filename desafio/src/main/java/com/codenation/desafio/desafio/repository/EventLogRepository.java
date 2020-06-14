package com.codenation.desafio.desafio.repository;

import com.codenation.desafio.desafio.entity.EventLog;
import com.codenation.desafio.desafio.entity.QEventLog;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;
import org.springframework.stereotype.Repository;

@Repository
public interface EventLogRepository extends JpaRepository<EventLog, Long>, QuerydslPredicateExecutor<EventLog>,
        QuerydslBinderCustomizer<QEventLog> {

    @SuppressWarnings("NullableProblems")
    @Override
    default void customize(QuerydslBindings bindings, QEventLog eventlog) {

        // Exclude id from filtering
        bindings.excluding(eventlog.id);

        // Make case-insensitive 'like' filter for all string properties
        bindings.bind(String.class)
                .first((SingleValueBinding<StringPath, String>) StringExpression::containsIgnoreCase);

        // Make a kind of 'between' filter for Person.age property
        bindings.bind(eventlog.eventDate).first((path, value) -> {
            return path.eq(value);
        });

        // Make a kind of 'between' filter for Person.dob property
        bindings.bind(eventlog.quantity).first((path, value) -> {
            return path.eq(value);
        });
    }

}
