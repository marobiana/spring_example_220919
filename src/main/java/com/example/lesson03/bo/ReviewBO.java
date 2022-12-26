package com.example.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson03.dao.ReviewDAO;
import com.example.lesson03.model.Review;

@Service
public class ReviewBO {
	
	@Autowired
	private ReviewDAO reviewDAO;
	
	public Review getReview(int id) {
		return reviewDAO.selectReview(id);
	}
	
	// input: Review 객체
	// output: int(인서트가 성공된 행 수)
	public int addReview(Review review) {
		return reviewDAO.insertReview(review);
	}
	
	// addReviewAsField(4, "콤비네이션R", "신바다", 5.0, "역시 맛있따!")
	public int addReviewAsField(
			int storeId, String menu, String userName, 
			Double point, String review) {
		
		return reviewDAO.insertReviewAsField(storeId, menu, userName, point, review);
	}
}









