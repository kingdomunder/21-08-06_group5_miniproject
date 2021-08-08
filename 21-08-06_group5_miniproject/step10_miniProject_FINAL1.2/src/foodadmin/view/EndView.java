package foodadmin.view;

import java.util.ArrayList;
import java.util.Map.Entry;

import foodadmin.model.dto.AllFoodadminProject;

public class EndView {

	/**진행중인 모든 프로젝트 출력*/
	public static void projectListView(ArrayList<AllFoodadminProject> allList) {
		for(AllFoodadminProject pp : allList) {
			System.out.println(pp);
		}
	}
	
	// 특정한 업체 하나만 출력
	public static void projectView(AllFoodadminProject project) {
			System.out.println(project);
	}	
	
	// 컨트롤러에서 입력한 리턴메시지 출력 
	public static void messageView(String message) {
		System.out.println(message);
	}
	
	//가장 많이 검색된 업체 출력
	public static void printMostSearched(Entry<String, Integer> MostSearch) {
		System.out.println(MostSearch.getKey() + " : " + MostSearch.getValue());
	}
	
}

	


