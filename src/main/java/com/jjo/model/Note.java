package com.jjo.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Since r2dbc seems to not support @ManyToOne, @ManyToMany and @OneToMany,
 * people do that manually on the service layer...
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Note implements Serializable {

	private static final long serialVersionUID = 7325460465644662524L;

	@Id
	private Long id; // UUID is not a supported value yet for the miku.mysql lib for r2dbc...
	private String title;
	private String body;

}
