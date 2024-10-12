package com.dao;

import com.entity.Product;
import com.rowmapper.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class ProductDaoImpl  implements ProductDao
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void insert(Product product)
    {
        String query="INSERT INTO product(id,name,cost) VALUES(?,?,?)";
        jdbcTemplate.update(query,product.getId(),product.getName(),product.getCost());
    }

    @Override
    public void update(Product product)
    {
      String query="UPDATE product SET name=?,cost=? WHERE id=?";
      jdbcTemplate.update(query,product.getName(),product.getCost(),product.getId());
    }

    @Override
    public void delete(int id)
    {
      String query="DELETE  FROM product WHERE id=?";
      int update=jdbcTemplate.update(query,id);
      //System.out.println("rows affected = "+update);
    }

    @Override
    public Product read(int id)
    {
        ProductRowMapper rowMapper=new ProductRowMapper();
        String query="SELECT * FROM product WHERE id=?";
        return jdbcTemplate.queryForObject(query,rowMapper,id);
    }
}
