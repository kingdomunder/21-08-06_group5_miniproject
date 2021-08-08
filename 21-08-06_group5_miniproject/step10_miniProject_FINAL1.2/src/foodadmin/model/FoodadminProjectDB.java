//����.. ���⼱ �̱����̶� ������ �߰��ϴ� ������ ����� ���̴�. ����


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
		FoodadminProjectList.add(new AllFoodadminProject("�׳�ġŲ",
							     new Restaurant("�׳�ġŲ �����","01ġŲ","�����","������ġŲ",15000,"02-222-11111",50000000),
							     new Owner("�ӿ��","010-1111-2222","20180707",true),
							     new Review(99,204)));
		
		FoodadminProjectList.add(new AllFoodadminProject("���ڽ���",
								 new Restaurant("���ڽ��� ��õ��","02����","��õ������","������������",8000,"032-1111-3333",130000000),
								 new Owner("����","010-1111-2226","20060505",true),
								 new Review(65,10)));
		
		FoodadminProjectList.add(new AllFoodadminProject("�γ�������",
								 new Restaurant("���ⶱ���� �ϻ���","03�н�","����","����������",6000,"031-444-5555",80000000),
								 new Owner("������","010-1111-2224","20080101",true),
								 new Review(100,333)));
		
		FoodadminProjectList.add(new AllFoodadminProject("���õ��",
								 new Restaurant("���õ�� ������","03�н�","�����","��ġ���",3000,"02-344-9999",70000000),
								 new Owner("������","010-1111-2224","20201204",true),
								 new Review(80,999)));
		
		FoodadminProjectList.add(new AllFoodadminProject("����Ų���",
							 	 new Restaurant("����Ų��� ������","04����Ʈ","�ǿս�","�������������",3900,"031-777-8888",100000000),
							 	 new Owner("�ڼ���","010-1111-2223","20190428",false),
							 	 new Review(45,111)));
		
		FoodadminProjectList.add(new AllFoodadminProject("����ġŲ",
								 new Restaurant("����ġŲ **��","01ġŲ","�Ȼ��","����޺�ġŲ",20000,"031-555-6666",190000000),
								 new Owner("��ġŲ","010-1111-2227","20101103",false),
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
