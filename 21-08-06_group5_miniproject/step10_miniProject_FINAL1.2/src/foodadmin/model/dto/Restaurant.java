package foodadmin.model.dto;

public class Restaurant {

	/** 식당업체  이름*/
	private String restauranName;
	/** 업체 카테고리 */
	private String category;
	/** 업체  위치*/
	private String location;
	/** 업체  대표 메뉴*/
	private String menu;
	/** 업체 대표메뉴 가격*/
	private int	price;
	/** 업체  연락처*/
	private String contactNum;
	/** 업체 연매출*/
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
		builder.append("식당 이름 : ");
		builder.append(restauranName);
		builder.append(", 카테고리 : ");
		builder.append(category);
		builder.append(", 위치 : ");
		builder.append(location);
		builder.append(", 대표 메뉴 : ");
		builder.append(menu);
		builder.append(", 가격 : ");
		builder.append(price);
		builder.append("원");
		builder.append(", 연락처 : ");
		builder.append(contactNum);
		builder.append(", 연매출 : ");
		builder.append(annualSales);
		builder.append("원");
		
		return builder.toString();
	}
	

}
