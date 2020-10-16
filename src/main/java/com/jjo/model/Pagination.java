package com.jjo.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true, setterPrefix = "with")
@AllArgsConstructor
@NoArgsConstructor
public class Pagination implements Serializable {

	private static final long serialVersionUID = -8524415547808263248L;

	private int pageSize;
	private int pageNumber;
	private int totalPages;
	private int totalElements;
	private boolean hasNextPage;

}
