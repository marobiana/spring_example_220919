package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;
import com.example.lesson03.model.Review;

@RequestMapping("/lesson03/ex02")
@RestController
public class Lesson03Ex02RestController {
	
	@Autowired
	private ReviewBO reviewBO;
	
	// http://localhost:8080/lesson03/ex02/1
	@RequestMapping("/1")
	public String ex02_1() {
		Review review = new Review();
		review.setStoreId(7);
		review.setMenu("삼겹혼밥세트");
		review.setUserName("신보람");
		review.setPoint(4.5);
		review.setReview("혼자 먹기 딱 적당하네요");
		
		int row = reviewBO.addReview(review);
		return "성공한 행의 개수:" + row; // html
	}
	
	// http://localhost:8080/lesson03/ex02/2
	@RequestMapping("/2")
	public String ex02_2() {
		int row = reviewBO.addReviewAsField(4, "콤비네이션R", "신바다", 5.0, "역시 맛있따!");
		return "success row count:" + row;
	}
}



