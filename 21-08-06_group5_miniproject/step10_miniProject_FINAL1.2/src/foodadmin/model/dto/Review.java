package foodadmin.model.dto;

public class Review {
	
	/**업체에 남겨진 별점 */
	private int score;
	/**업체에 남겨진 리뷰 개수 */
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
		build.append("업체 평점: ");
		build.append(score);
		build.append("점");
		build.append(", 업체에 남겨진 리뷰 개수: ");
		build.append(review);
		build.append("개");
		return build.toString();
	}
	
	

}
