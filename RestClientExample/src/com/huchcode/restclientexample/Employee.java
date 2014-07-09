package com.huchcode.restclientexample;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable {

		private static final long serialVersionUID = -7788619177798333712L;
		
		public Employee() {
			
		}
		
		public Employee(int id, String name, Date createdDate) {
			super();
			this.id = id;
			this.name = name;
			this.createdDate = createdDate;
		}
		
		private int id;
		private String name;
		private Date createdDate;
		
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
		
		public Date getCreatedDate() {
			return createdDate;
		}
		public void setCreatedDate(Date createdDate) {
			this.createdDate = createdDate;
		}
		
		
	}