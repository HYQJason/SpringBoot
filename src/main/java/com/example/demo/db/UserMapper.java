package com.example.demo.db;

import com.example.demo.bean.UsreInfo;

import java.util.List;

public interface UserMapper {

    /**
     * 新增用戶
     * @param user
     * @return
     * @throws Exception
     */
    public int insertUser(UsreInfo user) throws Exception;
    /**
     * 修改用戶
     * @param user
     * @param id
     * @return
     * @throws Exception
     */
    public int updateUser (UsreInfo user,int id) throws Exception;
    /**
     * 刪除用戶
     * @param id
     * @return
     * @throws Exception
     */
    public int deleteUser(int id) throws Exception;
    /**
     * 根据id查询用户信息
     * @param id
     * @return
     * @throws Exception
     */
    public UsreInfo selectUserById(int id) throws Exception;
    /**
     * 查询所有的用户信息
     * @return
     * @throws Exception
     */
    public List<UsreInfo> selectAllUser() throws Exception;
}
