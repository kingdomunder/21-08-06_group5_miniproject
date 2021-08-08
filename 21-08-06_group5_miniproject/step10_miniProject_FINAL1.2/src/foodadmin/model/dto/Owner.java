package foodadmin.model.dto;

public class Owner {
	/** ��ü ������ �̸�*/
	private String name;
	/** ��ü ������ ����ó*/
	private String phone;
	/** ��ü ������ ��������*/
	private String registrationDate;
	/** ��ü ������ ��ȸ�� ����*/
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
		builder.append("��ü ������ �̸�: ");
		builder.append(name);
		builder.append(", ��ü ������ ����ó: ");
		builder.append(phone);
		builder.append(", ��ü ������ ��������: ");
		builder.append(registrationDate);
		builder.append(", ��ü ������ ��ȸ�� ����: ");
		builder.append(vipmembership);
		
		return builder.toString();
	}
	
	

}
