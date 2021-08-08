package foodadmin.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.log4j.Logger;

//log4j추가

import foodadmin.controller.FoodadminProjectController;
import foodadmin.exception.DuplicateException;
import foodadmin.exception.NotExistException;
import foodadmin.model.FoodadminProjectDB;
import foodadmin.model.dto.AllFoodadminProject;
import foodadmin.model.dto.Owner;
import foodadmin.model.dto.Restaurant;

public class FoodadminProjectService {
	//log4j추가
	static Logger logger = Logger.getLogger("foodadmin.service.FoodadminProjectService");
	
	private static FoodadminProjectService instance = new FoodadminProjectService();
	private static FoodadminProjectDB projectDB = FoodadminProjectDB.getInstance(); 
																					
	static FoodadminProjectController controller = FoodadminProjectController.getInstance();

	private FoodadminProjectService() {
	}

	public static FoodadminProjectService getInstance() {
		return instance;
	}

	/** 업체들을 평점이 높은 순서대로 출력  */
	public static void topfiveList() throws NotExistException {
		// 전체 업체 리스트를 불러옴
		ArrayList<AllFoodadminProject> FoodadminProjectList = projectDB.getFoodadminProjectList();
		
		if(FoodadminProjectList.size()==0) {
			throw new NotExistException("정렬하려는 업체가 미존재하는 문제가 발생했습니다.");
		} else {
			// 업체명과 평점을 저장 (HashMap)
			HashMap<String, Integer> map = new HashMap<>();

			// scorelist에 업체명과 평점 저장, score배열에 평점 저장
			for (AllFoodadminProject data : FoodadminProjectList) {
				map.put(data.getFoodadminProjectName(), data.getProjectReview().getScore());
			}
			
			List<String> listKeySet = new ArrayList<>(map.keySet());

			// 내림차순 정렬 방법 System.out.println("-------------- 내림차순 정렬 --------------");
			Collections.sort(listKeySet, (value1, value2) -> (map.get(value1).compareTo(map.get(value2))));
			
			
			BufferedWriter out = null;
			
			try {
				out = new BufferedWriter(new FileWriter ("실시간업체평점순위.txt"));
				out.write("-------------------------------\n");
				out.write("│  ♥실시간 업체 평점 순위를 공개합니다!♥   │\n");
				out.write("-------------------------------\n");
				String data = null;
				for (String key : listKeySet) {
					data = "업체명 : " + key + " , " + "평점 : " + map.get(key);
					out.write(data);
					System.out.print(data);
					if (map.get(key)>99) {
						out.write("  ★★★★★");
						System.out.println("  ★★★★★");
					} else if (map.get(key)>80) {
						out.write("  ★★★★☆");
						System.out.println("  ★★★★☆"); 
					} else if (map.get(key)>60) {
						out.write("  ★★★☆☆");
						System.out.println("  ★★★☆☆");
					} else if (map.get(key)>40) {
						out.write("  ★★☆☆☆");
						System.out.println("  ★★☆☆☆");	
					} else {
						out.write("  ★☆☆☆☆");
						System.out.println("  ★☆☆☆☆");
					}
					out.newLine();
					out.flush();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/** 모든 업체 검색 */ 
	public ArrayList<AllFoodadminProject> getFoodadminProjectList() {
		return projectDB.getFoodadminProjectList();
	}

	// 검색한 업체 출력 (정보를 수정하는 메소드에서 사용 - 관리자)
	public AllFoodadminProject getGetProejct(String projectName) {
		ArrayList<AllFoodadminProject> FoodadminProjectList = projectDB.getFoodadminProjectList();
		for (AllFoodadminProject project : FoodadminProjectList) {
			if (project.getFoodadminProjectName().equals(projectName)) {
				return project;
			}
		}
		return null;
	}
	
	// 검색한 업체 출력 (로그기록용 - startView에서 업체하나 검색할때) - 사용자)
	public AllFoodadminProject getLogProject(String projectName) {
		ArrayList<AllFoodadminProject> FoodadminProjectList = projectDB.getFoodadminProjectList();
		for (AllFoodadminProject project : FoodadminProjectList) {
			if (project.getFoodadminProjectName().equals(projectName)) {
				//log4j추가
				logger.info(project.getFoodadminProjectName());
				return project;
			}
		}
		return null;
	}

	// 관리자정보 수정 
	public void projectOwnerUpdate(String projectName, Owner owner) throws NotExistException {
		AllFoodadminProject project = getGetProejct(projectName);
		if(project == null){
			throw new NotExistException("관리자정보를 업데이트하려는 업체가 미존재하는 문제가 발생했습니다.");
		}else {
			project.setProjectOwner(owner); 
		}
	}	
	
	// 식당정보 수정
	public void projectRestaurantUpdate(String projectName, Restaurant restaurant) throws NotExistException {
		AllFoodadminProject project = getGetProejct(projectName);
		if(project == null){
			throw new NotExistException("식당정보를 업데이트하려는 업체가 미존재하는 문제가 발생했습니다.");
		}else {
			project.setProjectRestaurant(restaurant); 
		}
	}	
	
	// 업체 정보 삭제 
	public void projectDelete(String projectName) throws NotExistException{
		AllFoodadminProject project = getGetProejct(projectName);
		if(project == null) {
			throw new NotExistException("삭제하고자 하는 업체가 미존재하는 문제가 발생했습니다");
		}else {
			getFoodadminProjectList().remove(project);
		}
	}
	
	/**카테고리 치킨 검색시 관련 업체 출력 */
	public ArrayList<AllFoodadminProject> getProjectCategory(String categoryName) {
		ArrayList<AllFoodadminProject> projectlist1 = projectDB.getFoodadminProjectList();
		ArrayList<AllFoodadminProject> pp = new ArrayList<>();

		for(AllFoodadminProject project1 : projectlist1) {
			if(project1.getProjectRestaurant().getCategory().contains(categoryName)) {
			pp.add(project1);
			}
		}
		if(pp.size() < 1 ) { 
			return null;
		}else {
			return pp;
		}
	}
	
	//업체 추가	
	public void projectInsert(AllFoodadminProject newlist) throws DuplicateException{
		AllFoodadminProject insertlist = getGetProejct(newlist.getFoodadminProjectName());
		if(insertlist != null) {
			throw new DuplicateException("추가하고자 하는 업체가 이미 존재하는 문제가 발생했습니다");
		}else {
			projectDB.insertProject(newlist);
		}
	}
	
	//가장 많이 검색된 업체 출력 ------>6조 코드 90%
	public static Entry<String, Integer> MostSearchedService() {
		BufferedReader in =null;
		Entry<String, Integer> maxEntry = null; //null값의 엔트리 생성? -> [업체:검색횟수] 딕셔너리의 최댓값
		
		try {
			in = new BufferedReader(new FileReader("C:\\20210628_lab\\1.java\\step10_miniProject_FINAL1.2\\newLog.log"));
			String data = null;
			ArrayList<String> rank = new ArrayList<>();
			while( (data = in.readLine()) != null ) {	//로그기록이 null이 아니면 
				rank.add(data);   //리스트rank에 로그기록을 add
			}
			
			Set<String> set = new HashSet<String>(rank);  //리스트 rank를 집합으로 만든다 (중복되는 로그기록 제거)
			HashMap<String ,Integer> hm = new HashMap<>();  //새로운 딕셔너리생성 
			for(String str : set) {		 //집합 rank에 있는 로그기록들을 순환
				hm.put(str,Collections.frequency(rank, str)); //(키:로그기록 , 밸류:검색된 숫자) 딕셔너리 입력 
			}
		
			Set<Entry<String, Integer>> entrySet = hm.entrySet();//(키:로그기록 , 밸류:검색된 숫자)딕셔너리를 entry 집합화? 
			for (Entry<String, Integer> entry : entrySet) { //entry집합을 순환
				if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {  //maxEntry는 null로 시작하고, entry를 순환하면서 maxEntry와 비교
					maxEntry = entry;  //entry 최대값보다 큰 entry값이 나와서 if문을 충족하면, 그 entry값을 최대값으로 설정
				}
			}
		}catch (Exception e) {
			
		}finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(maxEntry == null){
			return null;
		}else {
			return maxEntry;
		}
	}
	
}

