package foodadmin.view;

import foodadmin.controller.FoodadminProjectController;
import foodadmin.model.dto.AllFoodadminProject;
import foodadmin.model.dto.Owner;
import foodadmin.model.dto.Restaurant;
import foodadmin.model.dto.Review;
import foodadmin.service.FoodadminProjectService;
public class StartView {

	public static void main(String[] args) {

		FoodadminProjectController controller = FoodadminProjectController.getInstance();
	
		//업체들을 평점이 높은 순서대로 출력  
		System.out.println("\n*** 평점 순으로 보여주세요");
		controller.gettopfiveList();
		
		System.out.println("\n*** 가입한 모든 업체를 보여주세요.");
		controller.getFoodadminProjectList();
		
		System.out.println("\n*** 검색한 업체를 보여주세요");
		controller.getProject("교촌치킨");
		
		// 업체 정보 추가
		AllFoodadminProject newlist = new AllFoodadminProject("원할머니보쌈",
			     new Restaurant("원할머니보쌈 종로점","05보쌈족발","서울시","불족발세트",38000,"02-222-9999",140000000),
			     new Owner("원보쌈","010-1111-8752","20000713",false),
			     new Review(29,99));
		
		System.out.println("\n======업체(카테고리 : 보쌈) 신규추가======");
		controller.insertProject(newlist);
		
		// 관리자정보 수정
		System.out.println("\n*** 검색한 업체의 관리자정보를 수정합니다");
		controller.updateProjectOwner("네네치킨", new Owner("이재용", "031-432-6541", "20210805", true));
		// 관리자정보 수정 후, 해당 업체정보 출력
		controller.getProject("네네치킨");
		
		// 식당정보 수정
		System.out.println("\n*** 검색한 업체의 식당정보를 수정합니다");
		controller.updateProjectOwner("네네치킨", new Restaurant("네네치킨 화성점", "01치킨", "화성시", "후라이드치킨", 12000, "031-821-8212", 20000000));
		// 식당정보 수정 후, 해당 업체정보 출력
		controller.getProject("네네치킨");
		
		//카테고리 기준으로 업체출력
		System.out.println("\n======치킨 관련 업체 검색======");
		controller.getCategoty("치킨");
		
		System.out.println("\n======보쌈 관련 업체 검색======");
		controller.getCategoty("보쌈");
		
		// 업체 정보 삭제 
		System.out.println("\n*** 입력한 업체를 삭제합니다");
		controller.deleteProject("교촌치킨");
		// 잘못된 입력값 예외처리
		controller.deleteProject("삼성치킨");
		
		System.out.println("\n*** 삭제 후 해당 카테고리 정보를 출력합니다");
		controller.getCategoty("치킨");
		
		//가장 많이 검색된 업체 출력 ---from 6조
		System.out.println("\n*** 가장 많이 검색된 업체 정보입니다");
		controller.MostSearched();
		
	}

}
