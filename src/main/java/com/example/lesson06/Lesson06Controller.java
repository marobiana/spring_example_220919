package com.example.lesson06;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.lesson04.bo.UserBO;

@RequestMapping("/lesson06")
@Controller
public class Lesson06Controller {
	
	@Autowired
	private UserBO userBO;
	
	// 회원가입 화면
	@GetMapping("/ex01/add_user_view")
	public String addUserView() {
		return "lesson06/ex01/addUser";
	}
	
	// 회원가입(form)
//	@PostMapping("/ex01/add_user")
//	public String addUser(
//			@RequestParam("name") String name,
//			@RequestParam("yyyymmdd") String yyyymmdd,
//			@RequestParam(value="email", required=false) String email,
//			@RequestParam(value="introduce", required=false) String introduce) {
//		
//		// db insert 생략
//		
//		return "lesson06/ex01/afterAddUser";
//	}
	
	// 회원가입 - AJAX 통신으로 오는 요청
	@ResponseBody
	@PostMapping("/ex01/add_user")
	public String addUser(
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam(value="email", required=false) String email,
			@RequestParam(value="introduce", required=false) String introduce) {
		
		// db insert
		userBO.addUser(name, yyyymmdd, email, introduce);
		
		return "성공"; // AJAX의 응답값은 항상 String이다.
	}
	
	@GetMapping("/ex01/after_add_user_view")
	public String afterAddUserView() {
		return "lesson06/ex01/afterAddUser";
	}
	
	// 이름 추가하는 화면
	@GetMapping("/ex02/add_name_view")
	public String addNameView() {
		return "lesson06/ex02/addName";
	}
	
	// 이름 중복확인 - AJAX 통신 요청
	@ResponseBody
	@GetMapping("/ex02/is_duplication")
	public Map<String, Boolean> isDuplication(
			@RequestParam("name") String name) {
		
		Map<String, Boolean> result = new HashMap<>();
		result.put("is_duplication", userBO.existUserByName(name));
		return result;
	}
}








