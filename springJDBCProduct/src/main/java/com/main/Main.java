package com.main;

import com.config.AppConfig;
import com.dao.ProductDao;
import com.entity.Product;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main
{
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);

        ProductDao productDao=context.getBean(ProductDao.class);
        //insert
//        Product product1=new Product(503,"Mobile",144000);
//        productDao.insert(product1);

        //update
          Product product2=productDao.read(502);
          product2.setName("AUDIOBOOK");
          product2.setCost(9014);
          productDao.update(product2);

        //read
          Product product3=productDao.read(502);
          System.out.println(product3.getId() +" "+ product3.getName()  +" "+ product3.getCost());

         //delete
        // productDao.delete(501);

    }
}
