package com.registration.enrollment.method;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="STUDENTS_TBL")
public class Student {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private long phone;
	private String email;
	private int passout_year;
	private String subject;
	private String comments;
	
	

}
