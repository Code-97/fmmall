package cn.azh.fmmall.service;

import cn.azh.fmmall.vo.ResultVo;

public interface UserService {

    /**
     * 用户登陆
     * @param username
     * @param password
     * @return
     */
    public ResultVo checkLogin(String username, String password);

    /**
     * 用户注册
     * @param username,password
     * @return
     */
    public ResultVo userRegist(String username,String password);

}
