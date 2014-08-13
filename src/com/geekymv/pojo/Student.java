package com.geekymv.pojo;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity	//这家伙是个实体类
@Table(name="T_STUDENTS")	//指定实体对应的表名
public class Student {
	
	private Long id;
	private String name;
	private Integer age;
	private Date birthday;
	private Gender gender;	//枚举
	
	
	@Id
	@GeneratedValue	//默认是auto相当于native
	public Long getId() {	//注解可以写在get方法上，也可以写在属性上。
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="_name", length=20)	//字段名与属性名不同时添加注解，如果某个属性不希望保存在数据库中可以使用@Transient注解
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
	
	//在数据库中默认是timestamp类型
//	@Temporal(value=TemporalType.DATE)
//	@Temporal(TemporalType.DATE)	//属性是value时可以不写
//	@Temporal(TemporalType.TIME);
//	@Temporal(TemporalType.TIMESTAMP)
	
	@Temporal(TemporalType.DATE)
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@Enumerated(EnumType.STRING)
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}

}
