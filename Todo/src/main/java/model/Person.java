package model;

public class Person {
	private int id;
	private String name;
	private String mail;
	private String pass;
	
	public Person(int id, String name, String mail, String pass) {
		this.id = id;
		this.name = name;
		this.mail = mail;
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public String getMail() {
		return mail;
	}

	public String getPass() {
		return pass;
	}
}
