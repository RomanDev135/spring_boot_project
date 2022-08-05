package com.nazarov.javaspringbootlessonfour.services;

import com.nazarov.javaspringbootlessonfour.entities.Product;
import com.nazarov.javaspringbootlessonfour.repositories.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class ProductService {

    @Autowired
    private ProductDAO productDAO;


//    @Autowired
//    public void setProductRepository(ProductDAO productDAO) {
//        this.productDAO = productDAO;
//    }

//    @Transactional
    public List<Product> getAllProduct() {
        return productDAO.findAll();
    }

    @Transactional
    public Product getById(Long id) {
        return productDAO.findById(id);
    }

    @Transactional
    public void remove(Long id) {
        productDAO.remove(id);
    }


//    @Transactional
    public void addOrUpdate(Product product) {
        productDAO.update(product);
//        productDAO.save(product);
    }
}
