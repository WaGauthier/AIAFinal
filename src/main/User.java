package main;

import java.util.ArrayList;

public class User {

	private String username;
	private String password;
	private boolean admin = false;
	private ArrayList<Challenge> chall;

	public User(String username, String password, boolean admin) {
		this.username = username;
		this.password = password;
		this.admin = admin;
	}

	public String getUsername() {
		return this.username;
	}

	public String getPassword() {
		return this.password;
	}
	
	public boolean isAdmin(){
		return this.admin;
	}
	
	public void setAdmin() {
		this.admin = true;
	}
	
	public void removeAdmin() {
		this.admin = false;
	}
	
	public void addChall(Challenge chall) {
		this.chall.add(chall);
	}
	
	public void removeChall(Challenge chall) {
		this.chall.remove(chall);
	}
}
