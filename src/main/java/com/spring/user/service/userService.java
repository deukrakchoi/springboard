package com.spring.user.service;

import java.util.HashMap;
import java.util.List;
import com.spring.user.vo.UserVo;

public interface userService
{
  public int userInsert(UserVo paramUserVo) throws Exception;

  public int userIdChk(String paramString) throws Exception;

  public List<UserVo> phoneOption() throws Exception;

  public UserVo userLogin(HashMap<String, String> map) throws Exception;

}
