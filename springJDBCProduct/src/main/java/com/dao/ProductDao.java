package com.dao;

import com.entity.Product;
import org.springframework.stereotype.Component;


public interface ProductDao
{
    //to insert data
    void insert(Product product);

    //to update data
    void update(Product product);

    //to delete data by ID
    void delete(int id);

    //to fecth data by ID
    Product read(int id);


}
