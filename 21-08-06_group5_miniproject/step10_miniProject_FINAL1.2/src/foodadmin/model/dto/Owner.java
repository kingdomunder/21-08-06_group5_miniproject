package foodadmin.model.dto;

public class Owner {
	/** 업체 관리자 이름*/
	private String name;
	/** 업체 관리자 연락처*/
	private String phone;
	/** 업체 관리자 가입일자*/
	private String registrationDate;
	/** 업체 관리자 정회원 여부*/
	private Boolean vipmembership;
	
	public Owner() {}
	
	public Owner(String name, String phone, String registrationDate, Boolean vipmembership) {
		super();
		this.name =name;
		this.phone = phone;
		this.registrationDate = registrationDate;
		this.vipmembership = vipmembership;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getRegistrationDate() {
		return registrationDate;
	}


	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}


	public Boolean getVipmembership() {
		return vipmembership;
	}


	public void setVipmembership(Boolean vipmembership) {
		this.vipmembership = vipmembership;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("업체 관리자 이름: ");
		builder.append(name);
		builder.append(", 업체 관리자 연락처: ");
		builder.append(phone);
		builder.append(", 업체 관리자 가입일자: ");
		builder.append(registrationDate);
		builder.append(", 업체 관리자 정회원 여부: ");
		builder.append(vipmembership);
		
		return builder.toString();
	}
	
	

}
