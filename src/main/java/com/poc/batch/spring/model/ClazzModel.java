package com.poc.batch.spring.model;

import java.io.Serializable;

public class ClazzModel implements Serializable{

	private static final long serialVersionUID = -4428437775285684624L;
	
	private String nameAny;
	
	private String codeAny;

	public String getNameAny() {
		return nameAny;
	}

	public void setNameAny(String nameAny) {
		this.nameAny = nameAny;
	}

	public String getCodeAny() {
		return codeAny;
	}

	public void setCodeAny(String codeAny) {
		this.codeAny = codeAny;
	}
	
	
}
