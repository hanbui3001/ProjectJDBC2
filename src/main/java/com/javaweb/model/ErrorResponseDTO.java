package com.javaweb.model;

import java.awt.List;
import java.util.ArrayList;

public class ErrorResponseDTO {
	private String error;
	private ArrayList<String>detal = new ArrayList<String>();
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public ArrayList<String> getDetal() {
		return detal;
	}
	public void setDetal(ArrayList<String> detal) {
		this.detal = detal;
	} 
}
