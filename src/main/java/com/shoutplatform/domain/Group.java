package com.shoutplatform.domain;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;

public class Group {    
	private int id;
	private String name;
	private int unresolved;
    
        public Group() {		
	}
	
	public Group(int id, String name, int unresolved) {
		super();
		this.id = id;
		this.name = name;
		this.unresolved = unresolved;
	}
        
       	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUnresolved() {
		return unresolved;
	}

	public void setUnresolved(int unresolved) {
		this.unresolved = unresolved;
	}
	
	
	
}
