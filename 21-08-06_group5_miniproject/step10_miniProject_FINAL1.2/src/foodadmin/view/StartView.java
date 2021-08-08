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
	
		//��ü���� ������ ���� ������� ���  
		System.out.println("\n*** ���� ������ �����ּ���");
		controller.gettopfiveList();
		
		System.out.println("\n*** ������ ��� ��ü�� �����ּ���.");
		controller.getFoodadminProjectList();
		
		System.out.println("\n*** �˻��� ��ü�� �����ּ���");
		controller.getProject("����ġŲ");
		
		// ��ü ���� �߰�
		AllFoodadminProject newlist = new AllFoodadminProject("���ҸӴϺ���",
			     new Restaurant("���ҸӴϺ��� ������","05��������","�����","�����߼�Ʈ",38000,"02-222-9999",140000000),
			     new Owner("������","010-1111-8752","20000713",false),
			     new Review(29,99));
		
		System.out.println("\n======��ü(ī�װ� : ����) �ű��߰�======");
		controller.insertProject(newlist);
		
		// ���������� ����
		System.out.println("\n*** �˻��� ��ü�� ������������ �����մϴ�");
		controller.updateProjectOwner("�׳�ġŲ", new Owner("�����", "031-432-6541", "20210805", true));
		// ���������� ���� ��, �ش� ��ü���� ���
		controller.getProject("�׳�ġŲ");
		
		// �Ĵ����� ����
		System.out.println("\n*** �˻��� ��ü�� �Ĵ������� �����մϴ�");
		controller.updateProjectOwner("�׳�ġŲ", new Restaurant("�׳�ġŲ ȭ����", "01ġŲ", "ȭ����", "�Ķ��̵�ġŲ", 12000, "031-821-8212", 20000000));
		// �Ĵ����� ���� ��, �ش� ��ü���� ���
		controller.getProject("�׳�ġŲ");
		
		//ī�װ� �������� ��ü���
		System.out.println("\n======ġŲ ���� ��ü �˻�======");
		controller.getCategoty("ġŲ");
		
		System.out.println("\n======���� ���� ��ü �˻�======");
		controller.getCategoty("����");
		
		// ��ü ���� ���� 
		System.out.println("\n*** �Է��� ��ü�� �����մϴ�");
		controller.deleteProject("����ġŲ");
		// �߸��� �Է°� ����ó��
		controller.deleteProject("�ＺġŲ");
		
		System.out.println("\n*** ���� �� �ش� ī�װ� ������ ����մϴ�");
		controller.getCategoty("ġŲ");
		
		//���� ���� �˻��� ��ü ��� ---from 6��
		System.out.println("\n*** ���� ���� �˻��� ��ü �����Դϴ�");
		controller.MostSearched();
		
	}

}
