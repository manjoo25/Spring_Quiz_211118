package com.quiz.lesson05;

public class Member {

	private String name;
	private String phoneNumber;
	private String email;
	private String nationality;
	private String introduce;
	
	public String getName() {
		return name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public String getNationality() {
		return nationality;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
}
