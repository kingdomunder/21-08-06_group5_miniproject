package foodadmin.model.dto;

public class AllFoodadminProject {  
	
	/**��ü ���� �̸� */   
	private String foodadminProjectName;
	
	/** ���� */
	private Restaurant projectRestaurant;
	
	/** ��ü ������ */
	private Owner projectOwner;
	
	/** ��ü ����*/
	private Review projectReview;

	public AllFoodadminProject() {
		super();
	}
	
	public AllFoodadminProject(String foodadminProjectName,Restaurant projectRestaurant,Owner projectOwner,Review projectReview ) {
		this.foodadminProjectName = foodadminProjectName;
		this.projectOwner = projectOwner;
		this.projectRestaurant = projectRestaurant;
		this.projectReview = projectReview;
	}

	public String getFoodadminProjectName() {
		return foodadminProjectName;
	}

	public void setFoodadminProjectName(String foodadminProjectName) {
		this.foodadminProjectName = foodadminProjectName;
	}

	public Restaurant getProjectRestaurant() {
		return projectRestaurant;
	}

	public void setProjectRestaurant(Restaurant projectRestaurant) {
		this.projectRestaurant = projectRestaurant;
	}

	public Owner getProjectOwner() {
		return projectOwner;
	}

	public void setProjectOwner(Owner projectOwner) {
		this.projectOwner = projectOwner;
	}

	public Review getProjectReview() {
		return projectReview;
	}

	public void setProjectReview(Review projectReview) {
		this.projectReview = projectReview;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[����ڵ�ϸ�] ");
		builder.append(foodadminProjectName);
		builder.append(", [��ü ���� ����] ");
		builder.append(projectRestaurant);
		builder.append(", [��ü ������] ");
		builder.append(projectOwner);
		builder.append(", [��ü ���� ����] ");
		builder.append(projectReview);
		
		return builder.toString();
	}

}
