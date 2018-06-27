package com.znsd.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.mapping.Value;
@Entity
@Table(name ="t_classes")
public class Classes implements Serializable {
	@Id
	@GeneratedValue
	@Column(name = "class_id")
	private Integer id;
	
	@Column(name = "class_name")
	private String className;
	
	@ManyToMany(mappedBy = "setCl")  
	@Cascade(value = {CascadeType.ALL})
	private Set<Student> stus = new HashSet<Student>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Set<Student> getStus() {
		return stus;
	}

	public void setStus(Set<Student> stus) {
		this.stus = stus;
	}
}
