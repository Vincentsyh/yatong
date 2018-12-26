package com.lb.yatong.controller;

import com.lb.yatong.dao.CategoryEntityMapper;
import com.lb.yatong.entity.CategoryEntity;
import com.lb.yatong.entity.ProductEntity;
import com.lb.yatong.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: liangbin
 * @Date: 2018/9/25 22:19
 */

@RestController
@RequestMapping("/api/category")
public class CategoryController {

	@Autowired
	private CategoryEntityMapper categoryDao;

	@PostMapping("/upload")
	public Result upload(@RequestBody CategoryEntity category) {
		try {
			categoryDao.insertSelective(category);
			return new Result().setCode(1);
		} catch (Exception e) {
			return new Result().setCode(0).setMessage("上传失败");
		}
	}


	@GetMapping("/getAll")
	public Result getAll() {
		var allCategory = categoryDao.selectAll();
		return new Result<List<CategoryEntity>>().setCode(1).setData(allCategory);
	}

	@PostMapping("/deleteOne")
	public Result deleteOne(@RequestParam int id) {
		try {
			categoryDao.deleteByPrimaryKey(id);
			return new Result().setCode(1);
		} catch (Exception e) {
			return new Result().setCode(0).setMessage("删除失败");
		}
	}

	@PostMapping("/updateOne")
	public Result updateOne(@RequestBody CategoryEntity product) {
		try {
			categoryDao.updateByPrimaryKeySelective(product);
			return new Result().setCode(1);
		} catch (Exception e) {
			return new Result().setCode(0).setMessage("更新失败");
		}
	}
}
