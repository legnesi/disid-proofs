package com.example;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.persistence.GeneratedValue;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

@Entity
public class MyEntity {

	@Id
	@GeneratedValue
	private Long id;

	@Version
	private int version;

	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Calendar calendar;

	@DateTimeFormat(pattern="dd/MM/yy")
	private Date date;

	@NumberFormat(pattern="#0.00000")
	private Double aDouble;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Calendar getCalendar() {
		return calendar;
	}

	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getaDouble() {
		return aDouble;
	}

	public void setaDouble(Double aDouble) {
		this.aDouble = aDouble;
	}


}
