package com.lb.yatong.dao;

import com.lb.yatong.entity.ProductEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductEntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductEntity record);

    int insertSelective(ProductEntity record);

    ProductEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductEntity record);

    int updateByPrimaryKey(ProductEntity record);

    List<ProductEntity> selectAll();

    ProductEntity selectOne(int id);

    List<ProductEntity> selectAllByCategory(int cId);
}