package com.spring.user.service;

import com.spring.user.vo.UserVo;

public abstract interface userService
{
  public abstract int userInsert(UserVo paramUserVo)
    throws Exception;

  public abstract int userIdChk(String paramString)
    throws Exception;
}

/* Location:           C:\workspace\springBoard\src\main\ImportedClasses\
 * Qualified Name:     com.spring.user.service.userService
 * JD-Core Version:    0.6.2
 */