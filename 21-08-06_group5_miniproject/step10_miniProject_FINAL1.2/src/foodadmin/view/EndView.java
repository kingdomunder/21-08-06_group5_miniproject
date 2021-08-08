package foodadmin.view;

import java.util.ArrayList;
import java.util.Map.Entry;

import foodadmin.model.dto.AllFoodadminProject;

public class EndView {

	/**�������� ��� ������Ʈ ���*/
	public static void projectListView(ArrayList<AllFoodadminProject> allList) {
		for(AllFoodadminProject pp : allList) {
			System.out.println(pp);
		}
	}
	
	// Ư���� ��ü �ϳ��� ���
	public static void projectView(AllFoodadminProject project) {
			System.out.println(project);
	}	
	
	// ��Ʈ�ѷ����� �Է��� ���ϸ޽��� ��� 
	public static void messageView(String message) {
		System.out.println(message);
	}
	
	//���� ���� �˻��� ��ü ���
	public static void printMostSearched(Entry<String, Integer> MostSearch) {
		System.out.println(MostSearch.getKey() + " : " + MostSearch.getValue());
	}
	
}

	


