//아하.. 여기선 싱글톤이랑 데이터 추가하는 구조로 만드는 것이다. ㅇㅇ


package foodadmin.model;

import java.util.ArrayList;

import foodadmin.model.dto.AllFoodadminProject;
import foodadmin.model.dto.Owner;
import foodadmin.model.dto.Restaurant;
import foodadmin.model.dto.Review;

public class FoodadminProjectDB {  
	
	private static FoodadminProjectDB instance = new FoodadminProjectDB();
	
	private ArrayList<AllFoodadminProject> FoodadminProjectList = new ArrayList<AllFoodadminProject>();
	
	
	private FoodadminProjectDB() {
		FoodadminProjectList.add(new AllFoodadminProject("네네치킨",
							     new Restaurant("네네치킨 용산점","01치킨","서울시","스노윙치킨",15000,"02-222-11111",50000000),
							     new Owner("임우송","010-1111-2222","20180707",true),
							     new Review(99,204)));
		
		FoodadminProjectList.add(new AllFoodadminProject("피자스쿨",
								 new Restaurant("피자스쿨 인천역","02피자","인천광역시","포테이토피자",8000,"032-1111-3333",130000000),
								 new Owner("우용매","010-1111-2226","20060505",true),
								 new Review(65,10)));
		
		FoodadminProjectList.add(new AllFoodadminProject("두끼떡볶이",
								 new Restaurant("엽기떡볶이 일산점","03분식","고양시","로제떡볶이",6000,"031-444-5555",80000000),
								 new Owner("김혜경","010-1111-2224","20080101",true),
								 new Review(100,333)));
		
		FoodadminProjectList.add(new AllFoodadminProject("김밥천국",
								 new Restaurant("김밥천국 강남점","03분식","서울시","참치김밥",3000,"02-344-9999",70000000),
								 new Owner("정은진","010-1111-2224","20201204",true),
								 new Review(80,999)));
		
		FoodadminProjectList.add(new AllFoodadminProject("베스킨라빈스",
							 	 new Restaurant("베스킨라빈스 포일점","04디저트","의왕시","사랑에빠진딸기",3900,"031-777-8888",100000000),
							 	 new Owner("박서은","010-1111-2223","20190428",false),
							 	 new Review(45,111)));
		
		FoodadminProjectList.add(new AllFoodadminProject("교촌치킨",
								 new Restaurant("교촌치킨 **점","01치킨","안산시","허니콤보치킨",20000,"031-555-6666",190000000),
								 new Owner("김치킨","010-1111-2227","20101103",false),
								 new Review(19,50)));
		
	}

	public static FoodadminProjectDB getInstance() {
		return instance;
	}

	public ArrayList<AllFoodadminProject> getFoodadminProjectList() {
		return FoodadminProjectList;
	}

	public void insertProject(AllFoodadminProject newProject) {  
		FoodadminProjectList.add(newProject);
	}
	
}
