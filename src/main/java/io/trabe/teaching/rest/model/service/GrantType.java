package io.trabe.teaching.rest.model.service;

import java.io.Serializable;

import lombok.Data;

@Data
public class GrantType implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4972364072093494324L;
	private String grant_type;

}
