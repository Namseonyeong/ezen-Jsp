package com.ezen.javabean;

public class MemberBeans {

	private String name;
	private String userid;
	
	public MemberBeans() {
//		09_jspl_set에 대한 기본생성자 생성
	}
	
	public MemberBeans(String name, String userid) {
		super();
		this.name = name;
		this.userid = userid;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "MemberBean [name=" + name + ", userid=" + userid + "]";
	}

		
	
}
