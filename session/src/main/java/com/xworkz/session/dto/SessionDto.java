package com.xworkz.session.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class SessionDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String course;
	private String trainer;
	private int numberOfClasses;
	
	public SessionDto() {
		System.out.println("Session Dto");
	}
	
	public SessionDto(int id, String name, String course, String trainer, int numberOfClasses) {
		super();
		this.id=id;
		this.name = name;
		this.course = course;
		this.trainer = trainer;
		this.numberOfClasses = numberOfClasses;
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

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	public int getNumberOfClasses() {
		return numberOfClasses;
	}

	public void setNumberOfClasses(int numberOfClasses) {
		this.numberOfClasses = numberOfClasses;
	}

	@Override
	public String toString() {
		return "SessionDto [name=" + name + ", course=" + course + ", trainer=" + trainer + ", numberOfClasses="
				+ numberOfClasses + "]";
	}
	
	

}
