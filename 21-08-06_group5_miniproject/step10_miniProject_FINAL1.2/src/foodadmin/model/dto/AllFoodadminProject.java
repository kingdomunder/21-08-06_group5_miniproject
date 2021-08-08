package foodadmin.model.dto;

public class AllFoodadminProject {  
	
	/**업체 고유 이름 */   
	private String foodadminProjectName;
	
	/** 지점 */
	private Restaurant projectRestaurant;
	
	/** 업체 관리자 */
	private Owner projectOwner;
	
	/** 업체 리뷰*/
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
		builder.append("[사업자등록명] ");
		builder.append(foodadminProjectName);
		builder.append(", [업체 세부 사항] ");
		builder.append(projectRestaurant);
		builder.append(", [업체 관리자] ");
		builder.append(projectOwner);
		builder.append(", [업체 관련 리뷰] ");
		builder.append(projectReview);
		
		return builder.toString();
	}

}
