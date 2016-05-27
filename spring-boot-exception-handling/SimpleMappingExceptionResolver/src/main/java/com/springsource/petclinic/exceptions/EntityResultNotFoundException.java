package com.springsource.petclinic.exceptions;

public class EntityResultNotFoundException extends RuntimeException {

	public EntityResultNotFoundException(){
		super("ERROR: Entity not found.");
	}
	
}
