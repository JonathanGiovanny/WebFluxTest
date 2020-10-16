package com.jjo.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jjo.model.Note;
import com.jjo.model.Pagination;
import com.jjo.service.NoteService;
import com.jjo.utils.PaginationUtils;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("note")
@RequiredArgsConstructor
public class NoteController {

	private @NonNull NoteService noteService;

	@GetMapping("{id}")
	@ResponseBody
	public Mono<Note> getNote(@PathVariable("id") Long id) {
		log.info("Processing request");
		return noteService.getNote(id);
	}

	@GetMapping
	@ResponseBody
	public Flux<Note> getAllNotes(Pageable pageable) {
		return noteService.getAllNotes(pageable);
	}

	@GetMapping("/page/info")
	@ResponseBody
	public Mono<Pagination> getPaginationInfo(Pageable pageable) {
		return noteService.countAllNotes()
				.map(totalElements -> PaginationUtils.buildPagination(totalElements, pageable));
	}

	@PostMapping
	@ResponseBody
	public Mono<Note> createNote(@RequestBody Note note) {
		log.info("Processing request");
		return noteService.saveNote(note);
	}

}
