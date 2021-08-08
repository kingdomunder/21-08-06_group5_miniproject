package foodadmin.model.dto;

public class Restaurant {

	/** �Ĵ��ü  �̸�*/
	private String restauranName;
	/** ��ü ī�װ� */
	private String category;
	/** ��ü  ��ġ*/
	private String location;
	/** ��ü  ��ǥ �޴�*/
	private String menu;
	/** ��ü ��ǥ�޴� ����*/
	private int	price;
	/** ��ü  ����ó*/
	private String contactNum;
	/** ��ü ������*/
	private int	annualSales;
	
	
	public Restaurant() {}
	
	public Restaurant(String restauranName, String category, String	location, String menu, int price, String contactNum, int annualSales) {
		super();
		this.restauranName = restauranName;
		this.category = category;
		this.location = location;
		this.menu = menu;
		this.price = price;
		this.contactNum = contactNum;
		this.annualSales = annualSales;

	}
	
	public String getRestauranName() {
		return restauranName;
	}


	public void setRestauranName(String restauranName) {
		this.restauranName = restauranName;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getMenu() {
		return menu;
	}
	

	public void setMenu(String menu) {
		this.menu = menu;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getContactNum() {
		return contactNum;
	}


	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}


	public int getAnnualSales() {
		return annualSales;
	}


	public void setAnnualSales(int annualSales) {
		this.annualSales = annualSales;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("�Ĵ� �̸� : ");
		builder.append(restauranName);
		builder.append(", ī�װ� : ");
		builder.append(category);
		builder.append(", ��ġ : ");
		builder.append(location);
		builder.append(", ��ǥ �޴� : ");
		builder.append(menu);
		builder.append(", ���� : ");
		builder.append(price);
		builder.append("��");
		builder.append(", ����ó : ");
		builder.append(contactNum);
		builder.append(", ������ : ");
		builder.append(annualSales);
		builder.append("��");
		
		return builder.toString();
	}
	

}
