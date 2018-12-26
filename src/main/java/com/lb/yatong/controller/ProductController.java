package com.lb.yatong.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lb.yatong.dao.ProductEntityMapper;
import com.lb.yatong.entity.ProductEntity;
import com.lb.yatong.util.Result;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @Author: liangbin
 * @Date: 2018/9/25 20:44
 */
@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private ProductEntityMapper productDao;

	@PostMapping("/upload")
	public Result upload(@RequestBody ProductEntity product) {
		try {
			productDao.insertSelective(product);
			return new Result().setCode(1);
		} catch (Exception e) {
			return new Result().setCode(0).setMessage("上传失败");
		}
	}

	@GetMapping("/getAll/{page}")
	public PageInfo getAll(@PathVariable int page) {
		PageHelper.startPage(page, 10);
		var allProducts = productDao.selectAll();
		return new PageInfo(allProducts);
	}

	@GetMapping("/getAllByCategory/{cId}/{page}")
	public PageInfo getAllByCategory(@PathVariable int cId, @PathVariable int page) {
		PageHelper.startPage(page, 9);
		var allProducts = productDao.selectAllByCategory(cId);
		return new PageInfo(allProducts);
	}

	@GetMapping("/getOne")
	public Result getOne(@RequestParam int id) {
		var product = productDao.selectOne(id);
		return new Result<ProductEntity>().setCode(1).setData(product);
	}

	@PostMapping("/deleteOne")
	public Result deleteOne(@RequestParam int id) {
		try {
			productDao.deleteByPrimaryKey(id);
			return new Result().setCode(1);
		} catch (Exception e) {
			return new Result().setCode(0).setMessage("删除失败");
		}
	}

	@PostMapping("/updateOne")
	public Result updateOne(@RequestBody ProductEntity product) {
		try {
			productDao.updateByPrimaryKeySelective(product);
			return new Result().setCode(1);
		} catch (Exception e) {
			return new Result().setCode(0).setMessage("更新失败");
		}
	}

	@GetMapping("/getAccessKey")
	public Result getAccessKey() {
		String accessKey = "hy0F6grFuuv9bR7f4fZzQJhy_Bu6LS-uvEMJQrgk";
		String secretKey = "6Fp99ya5DjmI7dPHamkaFb0WL0YgaFu0ZtKNYkye";
		String bucket = "yatong";

//		Integer userId = (Integer) session.getAttribute("user");
		if (true) {
			Auth auth = Auth.create(accessKey, secretKey);
			String upToken = auth.uploadToken(bucket);
			return new Result().setCode(1).setData(upToken);
		}
		return new Result().setCode(0).setMessage("获取失败，请先登录");
	}

}
