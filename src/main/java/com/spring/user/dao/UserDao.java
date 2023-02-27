package com.spring.user.dao;

import com.spring.user.vo.UserVo;

public abstract interface UserDao
{
  public abstract int userInsert(UserVo paramUserVo)
    throws Exception;

  public abstract int userIdChk(String paramString)
    throws Exception;
}

/* Location:           C:\workspace\springBoard\src\main\ImportedClasses\
 * Qualified Name:     com.spring.user.dao.UserDao
 * JD-Core Version:    0.6.2
 */