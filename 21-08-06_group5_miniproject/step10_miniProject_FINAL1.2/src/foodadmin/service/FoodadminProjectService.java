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

//log4j�߰�

import foodadmin.controller.FoodadminProjectController;
import foodadmin.exception.DuplicateException;
import foodadmin.exception.NotExistException;
import foodadmin.model.FoodadminProjectDB;
import foodadmin.model.dto.AllFoodadminProject;
import foodadmin.model.dto.Owner;
import foodadmin.model.dto.Restaurant;

public class FoodadminProjectService {
	//log4j�߰�
	static Logger logger = Logger.getLogger("foodadmin.service.FoodadminProjectService");
	
	private static FoodadminProjectService instance = new FoodadminProjectService();
	private static FoodadminProjectDB projectDB = FoodadminProjectDB.getInstance(); 
																					
	static FoodadminProjectController controller = FoodadminProjectController.getInstance();

	private FoodadminProjectService() {
	}

	public static FoodadminProjectService getInstance() {
		return instance;
	}

	/** ��ü���� ������ ���� ������� ���  */
	public static void topfiveList() throws NotExistException {
		// ��ü ��ü ����Ʈ�� �ҷ���
		ArrayList<AllFoodadminProject> FoodadminProjectList = projectDB.getFoodadminProjectList();
		
		if(FoodadminProjectList.size()==0) {
			throw new NotExistException("�����Ϸ��� ��ü�� �������ϴ� ������ �߻��߽��ϴ�.");
		} else {
			// ��ü��� ������ ���� (HashMap)
			HashMap<String, Integer> map = new HashMap<>();

			// scorelist�� ��ü��� ���� ����, score�迭�� ���� ����
			for (AllFoodadminProject data : FoodadminProjectList) {
				map.put(data.getFoodadminProjectName(), data.getProjectReview().getScore());
			}
			
			List<String> listKeySet = new ArrayList<>(map.keySet());

			// �������� ���� ��� System.out.println("-------------- �������� ���� --------------");
			Collections.sort(listKeySet, (value1, value2) -> (map.get(value1).compareTo(map.get(value2))));
			
			
			BufferedWriter out = null;
			
			try {
				out = new BufferedWriter(new FileWriter ("�ǽð���ü��������.txt"));
				out.write("-------------------------------\n");
				out.write("��  ���ǽð� ��ü ���� ������ �����մϴ�!��   ��\n");
				out.write("-------------------------------\n");
				String data = null;
				for (String key : listKeySet) {
					data = "��ü�� : " + key + " , " + "���� : " + map.get(key);
					out.write(data);
					System.out.print(data);
					if (map.get(key)>99) {
						out.write("  �ڡڡڡڡ�");
						System.out.println("  �ڡڡڡڡ�");
					} else if (map.get(key)>80) {
						out.write("  �ڡڡڡڡ�");
						System.out.println("  �ڡڡڡڡ�"); 
					} else if (map.get(key)>60) {
						out.write("  �ڡڡڡ١�");
						System.out.println("  �ڡڡڡ١�");
					} else if (map.get(key)>40) {
						out.write("  �ڡڡ١١�");
						System.out.println("  �ڡڡ١١�");	
					} else {
						out.write("  �ڡ١١١�");
						System.out.println("  �ڡ١١١�");
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
	
	/** ��� ��ü �˻� */ 
	public ArrayList<AllFoodadminProject> getFoodadminProjectList() {
		return projectDB.getFoodadminProjectList();
	}

	// �˻��� ��ü ��� (������ �����ϴ� �޼ҵ忡�� ��� - ������)
	public AllFoodadminProject getGetProejct(String projectName) {
		ArrayList<AllFoodadminProject> FoodadminProjectList = projectDB.getFoodadminProjectList();
		for (AllFoodadminProject project : FoodadminProjectList) {
			if (project.getFoodadminProjectName().equals(projectName)) {
				return project;
			}
		}
		return null;
	}
	
	// �˻��� ��ü ��� (�αױ�Ͽ� - startView���� ��ü�ϳ� �˻��Ҷ�) - �����)
	public AllFoodadminProject getLogProject(String projectName) {
		ArrayList<AllFoodadminProject> FoodadminProjectList = projectDB.getFoodadminProjectList();
		for (AllFoodadminProject project : FoodadminProjectList) {
			if (project.getFoodadminProjectName().equals(projectName)) {
				//log4j�߰�
				logger.info(project.getFoodadminProjectName());
				return project;
			}
		}
		return null;
	}

	// ���������� ���� 
	public void projectOwnerUpdate(String projectName, Owner owner) throws NotExistException {
		AllFoodadminProject project = getGetProejct(projectName);
		if(project == null){
			throw new NotExistException("������������ ������Ʈ�Ϸ��� ��ü�� �������ϴ� ������ �߻��߽��ϴ�.");
		}else {
			project.setProjectOwner(owner); 
		}
	}	
	
	// �Ĵ����� ����
	public void projectRestaurantUpdate(String projectName, Restaurant restaurant) throws NotExistException {
		AllFoodadminProject project = getGetProejct(projectName);
		if(project == null){
			throw new NotExistException("�Ĵ������� ������Ʈ�Ϸ��� ��ü�� �������ϴ� ������ �߻��߽��ϴ�.");
		}else {
			project.setProjectRestaurant(restaurant); 
		}
	}	
	
	// ��ü ���� ���� 
	public void projectDelete(String projectName) throws NotExistException{
		AllFoodadminProject project = getGetProejct(projectName);
		if(project == null) {
			throw new NotExistException("�����ϰ��� �ϴ� ��ü�� �������ϴ� ������ �߻��߽��ϴ�");
		}else {
			getFoodadminProjectList().remove(project);
		}
	}
	
	/**ī�װ� ġŲ �˻��� ���� ��ü ��� */
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
	
	//��ü �߰�	
	public void projectInsert(AllFoodadminProject newlist) throws DuplicateException{
		AllFoodadminProject insertlist = getGetProejct(newlist.getFoodadminProjectName());
		if(insertlist != null) {
			throw new DuplicateException("�߰��ϰ��� �ϴ� ��ü�� �̹� �����ϴ� ������ �߻��߽��ϴ�");
		}else {
			projectDB.insertProject(newlist);
		}
	}
	
	//���� ���� �˻��� ��ü ��� ------>6�� �ڵ� 90%
	public static Entry<String, Integer> MostSearchedService() {
		BufferedReader in =null;
		Entry<String, Integer> maxEntry = null; //null���� ��Ʈ�� ����? -> [��ü:�˻�Ƚ��] ��ųʸ��� �ִ�
		
		try {
			in = new BufferedReader(new FileReader("C:\\20210628_lab\\1.java\\step10_miniProject_FINAL1.2\\newLog.log"));
			String data = null;
			ArrayList<String> rank = new ArrayList<>();
			while( (data = in.readLine()) != null ) {	//�αױ���� null�� �ƴϸ� 
				rank.add(data);   //����Ʈrank�� �αױ���� add
			}
			
			Set<String> set = new HashSet<String>(rank);  //����Ʈ rank�� �������� ����� (�ߺ��Ǵ� �αױ�� ����)
			HashMap<String ,Integer> hm = new HashMap<>();  //���ο� ��ųʸ����� 
			for(String str : set) {		 //���� rank�� �ִ� �αױ�ϵ��� ��ȯ
				hm.put(str,Collections.frequency(rank, str)); //(Ű:�αױ�� , ���:�˻��� ����) ��ųʸ� �Է� 
			}
		
			Set<Entry<String, Integer>> entrySet = hm.entrySet();//(Ű:�αױ�� , ���:�˻��� ����)��ųʸ��� entry ����ȭ? 
			for (Entry<String, Integer> entry : entrySet) { //entry������ ��ȯ
				if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {  //maxEntry�� null�� �����ϰ�, entry�� ��ȯ�ϸ鼭 maxEntry�� ��
					maxEntry = entry;  //entry �ִ밪���� ū entry���� ���ͼ� if���� �����ϸ�, �� entry���� �ִ밪���� ����
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

