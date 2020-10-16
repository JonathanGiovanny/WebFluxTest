package com.jjo.repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;

import com.jjo.model.Note;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface NoteRepository extends ReactiveSortingRepository<Note, Long> {

	@Query("SELECT * FROM note")
	Flux<Note> findAll(Pageable pageable);

	@Query("SELECT COUNT(id) FROM note")
	Mono<Integer> countAll();

}
