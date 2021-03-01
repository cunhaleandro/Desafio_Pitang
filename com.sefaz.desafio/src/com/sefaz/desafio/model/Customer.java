package com.sefaz.desafio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private static final long serialVersionUID = 1L;
	private int id;
    private String login;
    private String pass;
    
    public Customer() {
		
	}

	public Customer(String login, String pass) {
		super();
		this.login = login;
		this.pass = pass;
	}

	public Customer(int id, String login, String pass) {
		super();
		this.id = id;
		this.login = login;
		this.pass = pass;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	
}
