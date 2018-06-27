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
@Entity
@Table(name = "t_student")
public class Student implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "stu_id")
	private Integer id;

	@Column(name = "stu_name")
	private String name;

	@Column(name = "stu_age")
	private Integer age;
	
	@ManyToMany
	@Cascade(value = {CascadeType.ALL})
	//name = 指定一个中间表名      joinColumns=指定一个中间表的字段   inverseJoinColumns= 指定一个外键字段
	@JoinTable(name = "t_class_stu",joinColumns = @JoinColumn(name = "stu_id"),inverseJoinColumns = @JoinColumn(name ="class_id"))
	private Set<Classes> setCl = new HashSet<Classes>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Set<Classes> getSetCl() {
		return setCl;
	}

	public void setSetCl(Set<Classes> setCl) {
		this.setCl = setCl;
	}

}
