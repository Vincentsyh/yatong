package com.lb.yatong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: liangbin
 * @Date: 2018/9/22 18:05
 */
@Controller
public class ViewController {

	@RequestMapping("/")
	public String welcome() {
		return "index";
	}

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@RequestMapping("/product")
	public String product() {
		return "product";
	}

	@RequestMapping("/about")
	public String about() {
		return "about";
	}

	@RequestMapping("/contact")
	public String contact() {
		return "contact";
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/home")
	public String home() {
		return "home";
	}

	@RequestMapping("/upload")
	public String upload() {
		return "upload";
	}

	@RequestMapping("/online")
	public String online() {
		return "online";
	}

	@RequestMapping("/hotspot")
	public String hotspot() {
		return "hotspot";
	}
}
