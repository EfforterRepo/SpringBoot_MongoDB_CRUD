package com.crud.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.crud.project.entity.UserEntity;
import com.crud.project.model.UserModel;
import com.crud.project.service.UserRecordService;

@Controller
@RequestMapping("")
public class UserRecordController {
	@Autowired
	UserRecordService userRcordService;
	
	@GetMapping("/home")
	public String homePage() {
		return "index";
	}
	
	@GetMapping("/list")
	public String doStudyList(Model model) {
		System.out.println("list");
		List<UserEntity> list = userRcordService.doSelectAll();
		model.addAttribute("list",list);
		return "userList";
	}
	
	@RequestMapping("/insert")
	public String doInsert(@ModelAttribute UserModel insertModel, Model model) {
	    model.addAttribute("existId",false);
		System.out.println("insert");
		return "userInsert";
	}
	
	@RequestMapping("/insert_exe")
	public String doInsert_exe(@ModelAttribute UserModel insertModel, Model model) {
	    	UserEntity userEntity = UserEntity.builder()
					.id(insertModel.getId())
					.name(insertModel.getName())
					.address(insertModel.getAddress())
					.build();
			userRcordService.doInsert(userEntity);
		return "userInsertOk";
	}
	
	@RequestMapping("/update")
	public String doUpdate(@ModelAttribute UserModel deleteModel) {
		return "userUpdate";
	}
	
	@RequestMapping("/update_exe")
	public String doUpdate_exe(@ModelAttribute UserModel updateModel) {
		System.out.println("Update 진행");
		
		UserEntity userEntity = userRcordService.doSelectOne(updateModel.getId());
		System.out.println("user_Table이란: " + userEntity);
		userEntity.setId(updateModel.getId());
		userEntity.setName(updateModel.getName());
		userEntity.setAddress(updateModel.getAddress());
		userRcordService.doUpdate(userEntity);
		return "userUpdateOk";
	}	
	
	@RequestMapping("/delete")
	public String doDelete(@ModelAttribute UserModel deleteModel) {
		return "userDelete";
	}
	
	@RequestMapping("/delete_exe")
	public String doDelete_exe(@ModelAttribute UserModel deleteModel) {
		System.out.println("Delete 진행");
		userRcordService.doDelete(deleteModel.getId());
		return "userDeleteOk";
	}

}