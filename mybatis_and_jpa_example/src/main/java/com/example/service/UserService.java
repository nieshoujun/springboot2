package com.example.service;

import com.example.bean.question.User;

import java.util.Iterator;

/**
 * Created by niejun on 2018/11/25 10:17
 */
public interface UserService {
    /** 删除 */
    public void delete(int id);
    /** 增加*/
    public void insert(User user);
    /** 更新*/
    public int update(User user);
    /** 查询单个*/
    public User selectById(int id);
    /** 查询全部列表*/
    public Iterator<User> selectAll(int pageNum, int pageSize);
}
