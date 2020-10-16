package com.jjo.service;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jjo.model.Note;
import com.jjo.repositories.NoteRepository;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class NoteService {

	private @NonNull NoteRepository noteRepository;

	@Transactional(readOnly = true)
	public Mono<Note> getNote(Long id) {
		return noteRepository.findById(id);
	}

	@Transactional(readOnly = true)
	public Flux<Note> getAllNotes(Pageable pageable) {
		return noteRepository.findAll(pageable);
	}

	@Transactional(readOnly = true)
	public Mono<Integer> countAllNotes() {
		return noteRepository.countAll();
	}

	public Mono<Note> saveNote(Note note) {
		log.debug("Saving note: {}", note);
		return noteRepository.save(note);
	}

}
