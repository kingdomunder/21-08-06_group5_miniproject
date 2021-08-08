package foodadmin.model.dto;

public class Review {
	
	/**��ü�� ������ ���� */
	private int score;
	/**��ü�� ������ ���� ���� */
	private int review;
	
	public Review() {}
	public Review(int score, int review) {
		super();
		this.review = review;
		this.score = score;
		
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getReview() {
		return review;
	}
	public void setReview(int review) {
		this.review = review;
	}
	
	@Override
	public String toString() {
		StringBuilder build = new StringBuilder();
		build.append("��ü ����: ");
		build.append(score);
		build.append("��");
		build.append(", ��ü�� ������ ���� ����: ");
		build.append(review);
		build.append("��");
		return build.toString();
	}
	
	

}
