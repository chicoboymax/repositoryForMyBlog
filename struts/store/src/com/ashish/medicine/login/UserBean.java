package com.ashish.medicine.login;

import java.util.ArrayList;
import java.util.List;

import com.ashish.medicine.admin.usermanagement.UserManagementBean;
import com.ashish.medicine.entity.User;

public class UserBean {
	private String msg;
	private String errMsg;
	private int userId;
	private String address;
	private String description;
	private String emailId;
	private String mobile;
	private String name;
	private String password;
	private String phone;
	private String role;
	private String userName;
	private boolean isLoginSuccessful; 
	private User user;
	
	//Owner details
	private String ownerAddr1;
	private String ownerAddr2;
	private String ownerDesc;
	private String ownerName;
	private String fax;
	private String mob1;
	private String mob2;
	private String phone1;
	private String phone2;
	private String pin;
	private String state;
	private String website;
	private String shopNo;
	private String shopName;
	private String licenceNo;
	private String babyFoodLcNo;
	
	private int questionId[];
	private String question[];
	private String answer[];
	private List<UserManagementBean> securityQuestionsList = new ArrayList<UserManagementBean>();
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public boolean isLoginSuccessful() {
		return isLoginSuccessful;
	}
	public void setLoginSuccessful(boolean isLoginSuccessful) {
		this.isLoginSuccessful = isLoginSuccessful;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getOwnerAddr1() {
		return ownerAddr1;
	}
	public void setOwnerAddr1(String ownerAddr1) {
		this.ownerAddr1 = ownerAddr1;
	}
	public String getOwnerAddr2() {
		return ownerAddr2;
	}
	public void setOwnerAddr2(String ownerAddr2) {
		this.ownerAddr2 = ownerAddr2;
	}
	public String getOwnerDesc() {
		return ownerDesc;
	}
	public void setOwnerDesc(String ownerDesc) {
		this.ownerDesc = ownerDesc;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getMob1() {
		return mob1;
	}
	public void setMob1(String mob1) {
		this.mob1 = mob1;
	}
	public String getMob2() {
		return mob2;
	}
	public void setMob2(String mob2) {
		this.mob2 = mob2;
	}
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getShopNo() {
		return shopNo;
	}
	public void setShopNo(String shopNo) {
		this.shopNo = shopNo;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getLicenceNo() {
		return licenceNo;
	}
	public void setLicenceNo(String licenceNo) {
		this.licenceNo = licenceNo;
	}
	public String getBabyFoodLcNo() {
		return babyFoodLcNo;
	}
	public void setBabyFoodLcNo(String babyFoodLcNo) {
		this.babyFoodLcNo = babyFoodLcNo;
	}
	public int[] getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int[] questionId) {
		this.questionId = questionId;
	}
	public String[] getQuestion() {
		return question;
	}
	public void setQuestion(String[] question) {
		this.question = question;
	}
	public String[] getAnswer() {
		return answer;
	}
	public void setAnswer(String[] answer) {
		this.answer = answer;
	}
	public List<UserManagementBean> getSecurityQuestionsList() {
		return securityQuestionsList;
	}
	public void setSecurityQuestionsList(
			List<UserManagementBean> securityQuestionsList) {
		this.securityQuestionsList = securityQuestionsList;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
}
