package cn.azh.controller;

import cn.azh.fmmall.service.UserService;
import cn.azh.fmmall.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@RequestMapping("/user")
@Api(value = "用户的登陆和注册接口",tags = "用户管理")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/login")
    @ApiOperation("用户登录")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "文本",name="username",value = "用户名",required = true),
            @ApiImplicitParam(paramType = "文本",name="password",value = "密码",required = true),
    })
    public ResultVo login(String username,String password){
        return userService.checkLogin(username,password);
    }

    @PostMapping("/regist")
    @ApiOperation("用户注册接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "文本",name="username",value = "注册账号",required = true),
            @ApiImplicitParam(paramType = "文本",name="password",value = "注册密码",required = true),
    })
    public ResultVo regist(String username,String password){
        System.out.println("git test");
        return userService.userRegist(username,password);

    }
}
