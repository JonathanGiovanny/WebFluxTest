package com.jjo.utils;

import org.springframework.data.domain.Pageable;

import com.jjo.model.Pagination;

import lombok.experimental.UtilityClass;

@UtilityClass
public class PaginationUtils {

	public static Pagination buildPagination(int totalElements, Pageable pageable) {
		int pageSize = pageable.getPageSize();
		int pageNumber = pageable.getPageNumber();
		int totalPages = calculateTotalPages(pageSize, totalElements);
		return Pagination.builder()
				.withPageSize(pageSize)
				.withPageNumber(pageNumber)
				.withTotalPages(totalPages)
				.withTotalElements(totalElements)
				.withHasNextPage(hasNextPage(pageNumber, totalPages))
				.build();
	}

	private static int calculateTotalPages(int pageSize, int totalElements) {
		return Double.valueOf(Math.ceil(totalElements / pageSize)).intValue();
	}

	private static boolean hasNextPage(int pageNumber, int totalPages) {
		return pageNumber < totalPages;
	}

}
