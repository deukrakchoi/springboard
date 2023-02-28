package com.spring.user.service.impl;
 
import com.spring.user.dao.UserDao;
import com.spring.user.service.userService;
import com.spring.user.vo.UserVo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
@Service
public class userServiceImpl implements userService{
 
	@Autowired
	UserDao userDao;
 
	public int userInsert(UserVo userVo) throws Exception {
		return this.userDao.userInsert(userVo);
	}
 
	public int userIdChk(String userId) throws Exception {
		return this.userDao.userIdChk(userId);
	}

	@Override
	public List<UserVo> phoneOption() throws Exception {
		List<UserVo> userVo = new ArrayList<UserVo>();
		userVo = userDao.phoneOption();
		//System.out.println("userVo!!!!!!!===="+userVo);
		return userVo;
	}
	
	@Override
	public UserVo userLogin(HashMap<String, String> map) throws Exception {
		// TODO Auto-generated method stub
		return userDao.userLogin(map);
	}
}