package com.spring.user.vo;

public class UserVo
{
	private String userId;
	private String userPw;
	private String userName;
	private String userPhone1;
	private String userPhone2;
	private String userPhone3;
	private String userAddr1;
	private String userAddr2;
	private String userCompany;
	private String creator;
	private String createTime;
	private String modifier;
	private String modifiedTime;

	private String userPhone;
 
	public String getUserId(){
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	} 
	public String getUserPw() {
		return this.userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	} 
	public String getUserName() {
		return this.userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPhone1() {
		return this.userPhone1;
	}
	public void setUserPhone1(String userPhone1) {
		this.userPhone1 = userPhone1;
	}
	public String getUserPhone2() {
		return this.userPhone2;
	}
	public void setUserPhone2(String userPhone2) {
		this.userPhone2 = userPhone2;
	} 
	public String getUserPhone3() {
		return this.userPhone3;
	}
	public void setUserPhone3(String userPhone3) {
		this.userPhone3 = userPhone3;
	} 
	public String getUserAddr1() {
		return this.userAddr1;
	}
	public void setUserAddr1(String userAddr1) {
		this.userAddr1 = userAddr1;
	} 
	public String getUserAddr2() {
		return this.userAddr2;
	}
	public void setUserAddr2(String userAddr2) {
		this.userAddr2 = userAddr2;
	}
	public String getUserCompany() {
		return this.userCompany;
	}
	public void setUserCompany(String userCompany) {
		this.userCompany = userCompany;
	}
	public String getCreator() {
		return this.creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getCreateTime() {
		return this.createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getModifier() {
		return this.modifier;
	}
	public void setModifier(String modifier) {
		this.modifier = modifier;
	}
	public String getModifiedTime() {
		return this.modifiedTime;
	}
	public void setModifiedTime(String modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
}