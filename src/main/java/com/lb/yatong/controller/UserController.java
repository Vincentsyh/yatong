package com.lb.yatong.controller;

import com.lb.yatong.dao.UserEntityMapper;
import com.lb.yatong.entity.UserEntity;
import com.lb.yatong.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @Author: liangbin
 * @Date: 2018/9/24 22:37
 */

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserEntityMapper userDao;

	@PostMapping("/login")
	public Result login(@RequestParam String username, @RequestParam String password, HttpSession session) {
		System.out.println("用户登录。。。。");
		var user = userDao.login(username, password);
		if (user==null) {
			System.out.println("登陆失败");
			return new Result<String>().setCode(0).setMessage("登录失败，账号或密码错误");
		} else if (user.getStatus()!=0) {
			System.out.println("登陆失败");
			return new Result<String>().setCode(0).setMessage("账号异常");
		}
		System.out.println("设置session");
		session.setAttribute("user",user.getId());
		System.out.println("返回信息");
		return new Result<UserEntity>().setCode(1).setData(user);
	}
}
