package model;

import java.io.InputStream;
import java.sql.Blob;

public class Staff {

	private static int id;
	private static String firstname,middlename,lastname,gender,dob,email,password,mobile_number,security_answer;
	private static InputStream picture;
	public static int getId() {
		return id;
	}
	public static void setId(int id) {
		Staff.id = id;
	}
	public static String getFirstname() {
		return firstname;
	}
	public static void setFirstname(String firstname) {
		Staff.firstname = firstname;
	}
	public static String getMiddlename() {
		return middlename;
	}
	public static void setMiddlename(String middlename) {
		Staff.middlename = middlename;
	}
	public static String getLastname() {
		return lastname;
	}
	public static void setLastname(String lastname) {
		Staff.lastname = lastname;
	}
	public static String getGender() {
		return gender;
	}
	public static void setGender(String gender) {
		Staff.gender = gender;
	}
	public static String getDob() {
		return dob;
	}
	public static void setDob(String dob) {
		Staff.dob = dob;
	}
	public static String getEmail() {
		return email;
	}
	public static void setEmail(String email) {
		Staff.email = email;
	}
	public static String getPassword() {
		return password;
	}
	public static void setPassword(String password) {
		Staff.password = password;
	}
	public static String getMobile_number() {
		return mobile_number;
	}
	public static void setMobile_number(String mobile_number) {
		Staff.mobile_number = mobile_number;
	}
	public static InputStream getPicture() {
		return picture;
	}
	public static void setPicture(InputStream picture) {
		Staff.picture = picture;
	}
	public static String getSecurity_answer() {
		return security_answer;
	}
	public static void setSecurity_answer(String security_answer) {
		Staff.security_answer = security_answer;
	}
	
}
