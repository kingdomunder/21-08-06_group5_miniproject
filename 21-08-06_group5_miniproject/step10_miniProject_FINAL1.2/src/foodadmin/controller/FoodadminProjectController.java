package foodadmin.controller;

import java.util.ArrayList;
import java.util.Map.Entry;

import foodadmin.exception.DuplicateException;
import foodadmin.exception.NotExistException;
import foodadmin.model.dto.AllFoodadminProject;
import foodadmin.model.dto.Owner;
import foodadmin.model.dto.Restaurant;
import foodadmin.service.FoodadminProjectService;
import foodadmin.view.EndView;
import foodadmin.view.FailView;

public class FoodadminProjectController {
	
	private static FoodadminProjectController instance = new FoodadminProjectController();
	private FoodadminProjectService service = FoodadminProjectService.getInstance();  //그래 여기선 그 전단계인 service로 getInstance를 하네. 예상대로군..
	private FoodadminProjectController () {}

	public static FoodadminProjectController getInstance() {
		return instance;
	}
	
 // 평점 순서대로 업체 출력
	public void gettopfiveList() {
		try {
			service.topfiveList();
			EndView.messageView("(※실시간 업체 평점 순위.txt 다운로드 성공!) ");
		} catch (NotExistException e) {
			EndView.messageView("(※업체가 존재하지 않습니다.)");
			FailView.failMessageView(e.getMessage());
		}
	}
	
	// 모든 프로젝트 검색 //
	public void getFoodadminProjectList () {   
		ArrayList<AllFoodadminProject> ProjectList = service.getFoodadminProjectList();  
		if(ProjectList.size() != 0) {
			EndView.projectListView(ProjectList);
		}else {
			EndView.messageView("등록된 업체가 존재하지 않습니다.");
		}
	}

	// 검색한 업체 출력
	public void getProject(String projectName) {
		AllFoodadminProject project = service.getLogProject(projectName);
		if(project != null) {
			EndView.projectView(project);
		}else {
			EndView.messageView("검색하신 업체는 존재하지 않습니다.");
		}
	}
	
		
	// 관리자정보 수정 
	public void updateProjectOwner(String projectName, Owner owner) {
		if(projectName != null) {
			try {
				service.projectOwnerUpdate(projectName,owner);
			} catch (NotExistException e) {
				FailView.failMessageView(e.getMessage());
			}	
		}else {
			EndView.messageView("수정하려는 관리자정보가 무효합니다, 재 확인 해 주세요");
		}
	}
		
	// 식당정보 수정
	public void updateProjectOwner(String projectName, Restaurant restaurant) {
		if(projectName != null) {
			try {
				service.projectRestaurantUpdate(projectName,restaurant);
			} catch (NotExistException e) {
				FailView.failMessageView(e.getMessage());
			}	
		}else {
			EndView.messageView("수정하려는 식당정보가 무효합니다, 재 확인 해 주세요");
		}
	}
	
	// 업체 정보 삭제 
	public void deleteProject(String projectName) {
		if(projectName != null) {
			try {
				service.projectDelete(projectName);
				EndView.messageView(projectName + " 삭제 성공");
			}catch(NotExistException e) {
				FailView.failMessageView(e.getMessage());
				e.printStackTrace();
			}	
		}else {
			EndView.messageView("삭제하고자 하는 업체가 존재하지 않습니다. 재 확인 해 주세요");
		}
	}
	
	//카테고리 기준으로 가져오기  
	public void getCategoty(String category) {
		ArrayList<AllFoodadminProject> project1 = service.getProjectCategory(category);
		if(project1 != null) {
			EndView.projectListView(project1);
		}else {
			EndView.messageView("검색하신 업체는 존재하지 않습니다.");
		}
	}
	
	//업체 추가
	public void insertProject(AllFoodadminProject newlist) {
		if(newlist != null) {
			try {
				service.projectInsert(newlist);
				EndView.messageView("업체등록 성공");
			} catch (DuplicateException e) {
				FailView.failMessageView(e.getMessage());
				e.printStackTrace();
			}
		}else {
			EndView.messageView("신규 업체 추가 실패");
		}	
	}

	//가장 많이 검색된 업체 출력
	public void MostSearched() {
		Entry<String, Integer> MostSearch = service.MostSearchedService();
		
		if(MostSearch != null) {
			EndView.printMostSearched(MostSearch);
			
		}else {
			EndView.messageView("업체 검색기록이 없습니다");
		}
	}
	
	
}