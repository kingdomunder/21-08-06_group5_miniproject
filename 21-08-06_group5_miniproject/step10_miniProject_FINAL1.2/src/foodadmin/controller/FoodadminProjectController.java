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
	private FoodadminProjectService service = FoodadminProjectService.getInstance();  //�׷� ���⼱ �� ���ܰ��� service�� getInstance�� �ϳ�. �����α�..
	private FoodadminProjectController () {}

	public static FoodadminProjectController getInstance() {
		return instance;
	}
	
 // ���� ������� ��ü ���
	public void gettopfiveList() {
		try {
			service.topfiveList();
			EndView.messageView("(�ؽǽð� ��ü ���� ����.txt �ٿ�ε� ����!) ");
		} catch (NotExistException e) {
			EndView.messageView("(�ؾ�ü�� �������� �ʽ��ϴ�.)");
			FailView.failMessageView(e.getMessage());
		}
	}
	
	// ��� ������Ʈ �˻� //
	public void getFoodadminProjectList () {   
		ArrayList<AllFoodadminProject> ProjectList = service.getFoodadminProjectList();  
		if(ProjectList.size() != 0) {
			EndView.projectListView(ProjectList);
		}else {
			EndView.messageView("��ϵ� ��ü�� �������� �ʽ��ϴ�.");
		}
	}

	// �˻��� ��ü ���
	public void getProject(String projectName) {
		AllFoodadminProject project = service.getLogProject(projectName);
		if(project != null) {
			EndView.projectView(project);
		}else {
			EndView.messageView("�˻��Ͻ� ��ü�� �������� �ʽ��ϴ�.");
		}
	}
	
		
	// ���������� ���� 
	public void updateProjectOwner(String projectName, Owner owner) {
		if(projectName != null) {
			try {
				service.projectOwnerUpdate(projectName,owner);
			} catch (NotExistException e) {
				FailView.failMessageView(e.getMessage());
			}	
		}else {
			EndView.messageView("�����Ϸ��� ������������ ��ȿ�մϴ�, �� Ȯ�� �� �ּ���");
		}
	}
		
	// �Ĵ����� ����
	public void updateProjectOwner(String projectName, Restaurant restaurant) {
		if(projectName != null) {
			try {
				service.projectRestaurantUpdate(projectName,restaurant);
			} catch (NotExistException e) {
				FailView.failMessageView(e.getMessage());
			}	
		}else {
			EndView.messageView("�����Ϸ��� �Ĵ������� ��ȿ�մϴ�, �� Ȯ�� �� �ּ���");
		}
	}
	
	// ��ü ���� ���� 
	public void deleteProject(String projectName) {
		if(projectName != null) {
			try {
				service.projectDelete(projectName);
				EndView.messageView(projectName + " ���� ����");
			}catch(NotExistException e) {
				FailView.failMessageView(e.getMessage());
				e.printStackTrace();
			}	
		}else {
			EndView.messageView("�����ϰ��� �ϴ� ��ü�� �������� �ʽ��ϴ�. �� Ȯ�� �� �ּ���");
		}
	}
	
	//ī�װ� �������� ��������  
	public void getCategoty(String category) {
		ArrayList<AllFoodadminProject> project1 = service.getProjectCategory(category);
		if(project1 != null) {
			EndView.projectListView(project1);
		}else {
			EndView.messageView("�˻��Ͻ� ��ü�� �������� �ʽ��ϴ�.");
		}
	}
	
	//��ü �߰�
	public void insertProject(AllFoodadminProject newlist) {
		if(newlist != null) {
			try {
				service.projectInsert(newlist);
				EndView.messageView("��ü��� ����");
			} catch (DuplicateException e) {
				FailView.failMessageView(e.getMessage());
				e.printStackTrace();
			}
		}else {
			EndView.messageView("�ű� ��ü �߰� ����");
		}	
	}

	//���� ���� �˻��� ��ü ���
	public void MostSearched() {
		Entry<String, Integer> MostSearch = service.MostSearchedService();
		
		if(MostSearch != null) {
			EndView.printMostSearched(MostSearch);
			
		}else {
			EndView.messageView("��ü �˻������ �����ϴ�");
		}
	}
	
	
}