package com.crud.project.service;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crud.project.entity.UserEntity;
import com.crud.project.repo.UserRepo;


@Service
public class UserRecordService {

	
	@Autowired
	UserRepo userRepo;

	public List<UserEntity> doSelectAll(){
		return userRepo.findAll();
	}
	
	public void doInsert(UserEntity userEntity) {
		userRepo.save(userEntity);
	}
	
	public UserEntity doSelectOne(String memberID){
		return userRepo.findById(memberID).get();
	}
	
//	save()
	public void doUpdate(UserEntity userEntity) {
		userRepo.save(userEntity);
	}
	
//	delete()
	public void doDelete(String key_id) {
		userRepo.deleteById(key_id);
	}
}
