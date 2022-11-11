package cn.azh.fmmall.service.impl;

import cn.azh.fmmall.dao.UsersMapper;
import cn.azh.fmmall.entity.Users;
import cn.azh.fmmall.service.UserService;
import cn.azh.fmmall.utils.MD5Utils;
import cn.azh.fmmall.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;


    public ResultVo checkLogin(String username, String password) {
        System.out.println("user:"+username+","+password);
        Example example = new Example(Users.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username",username);
        List<Users> users = usersMapper.selectByExample(example);
        System.out.println(MD5Utils.md5(password)+",md5");
        System.out.println(users.get(0));
        if(users.size()>0){
            if(MD5Utils.md5(password).equals(users.get(0).getPassword())){
                return new ResultVo(10000,"登录成功",users.get(0));
            }else{
                return new ResultVo(10004,"登陆失败，密码错误",null);
            }
        }else{
            return new ResultVo(10003,"登陆失败，用户名不存在",null);
        }

    }

    @Transactional
    public ResultVo userRegist(String username, String password) {
        synchronized (this) {
            //1.查询用户名是否已经被注册
            Example example = new Example(Users.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("username",username);

            List<Users> users = usersMapper.selectByExample(example);
            if (users.size() == 0) {
                //2.没有被注册则开始
                String password_md5 = MD5Utils.md5(password);
                Users user = new Users();
                user.setUsername(username);
                user.setPassword(password_md5);
                user.setUserImg("img/default.png");
                user.setUserRegtime(new Date());
                user.setUserModtime(new Date());

                if (usersMapper.insert(user) > 0) {
                    return new ResultVo(10000, "注册成功", user);
                } else {
                    return new ResultVo(10002, "注册失败", null);
                }

            } else {
                System.out.println("----name exist");
                return new ResultVo(10001, "用户名已被注册", null);
            }
        }

    }
}
