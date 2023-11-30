package com.gbfpcl.exceptions;

import lombok.Data;

@Data
public class ResourceNotFoundException  extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String resourseName;
	String feildName;
	long feildValue;
	public ResourceNotFoundException(String resourseName, String feildName, long feildValue) {
		super(String.format("%s Not Found with %s :%s",resourseName,feildName,feildValue ));
		this.resourseName = resourseName;
		this.feildName = feildName;
		this.feildValue = feildValue;
	}
	
	public String getResourseName() {
		return resourseName;
	}
	public void setResourseName(String resourseName) {
		this.resourseName = resourseName;
	}
	public String getFeildName() {
		return feildName;
	}
	public void setFeildName(String feildName) {
		this.feildName = feildName;
	}
	public Long getFeildValue() {
		return feildValue;
	}
	public void setFeildValue(long feildValue) {
		this.feildValue = feildValue;
	}

}
