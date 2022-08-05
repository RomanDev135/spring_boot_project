package com.nazarov.javaspringbootlessonfour.repositories;


import com.nazarov.javaspringbootlessonfour.entities.Product;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ProductDAO {

    private static AtomicLong identity = new AtomicLong(0);
    private final Map<Long, Product> identityMap = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        add(new Product(null, "MacBook", "Ultra low and Great Power", new BigDecimal(3000)));
        add(new Product(null, "iPhone", "The most expensive phone by credit", new BigDecimal(1000)));
        add(new Product(null, "iPad", "More size - more cost", new BigDecimal(2000)));
    }

    public void add(Product product){
        product.setId(identity.incrementAndGet());
        identityMap.put(product.getId(), product);
    }



    public void save(Product product) {
//        Session session = sessionFactory.getCurrentSession();
//        try {
//            session.beginTransaction();
//            session.saveOrUpdate(product);
//            session.getTransaction().commit();
//        } finally {
//            session.close();
//            sessionFactory.close();
//        }
//        entityManager.merge(product);


        product.setId(identity.incrementAndGet());
        identityMap.put(product.getId(), product);
    }


    public void update(Product product) {
        identityMap.put(product.getId(), product);
    }

    public void remove(long id) {
//        Session session = sessionFactory.getCurrentSession();
//        session.createQuery("delete from Product where id = :idProduct")
//                .setParameter("idProduct", id)
//                .executeUpdate();


        identityMap.remove(id);
    }


    public Product findById(long id) {
//        Session session = sessionFactory.getCurrentSession();
//        Product product = session.get(Product.class, id);
//        return product;


        return identityMap.get(id);
    }

    public List<Product> findAll() {
//        Session session = sessionFactory.getCurrentSession();
//        try {
//            session.beginTransaction();
//            List<Product> products = session.createQuery("from Product", Product.class).getResultList();
//            session.getTransaction().commit();
//            return products;
//        } finally {
//            session.close();
//            sessionFactory.close();
//        }


        return new ArrayList<>(identityMap.values());
    }
    //
//    private static AtomicLong identity = new AtomicLong(0);
//    private final Map<Long, Product> identityMap = new ConcurrentHashMap<>();
//
//    @PostConstruct
//    public void init() {
//        add(new Product(null, "MacBook", "Ultra low and Great Power", new BigDecimal(3000)));
//        add(new Product(null, "iPhone", "The most expensive phone by credit", new BigDecimal(1000)));
//        add(new Product(null, "iPad", "More size - more cost", new BigDecimal(2000)));
//    }
//    SessionFactory factory = new Configuration()
//            .configure("hibernate.cfg.xml")
//            .addAnnotatedClass(Product.class)
//            .buildSessionFactory();
////    Session session = null;
//
//    public void add(Product product) {
//        Session session = factory.getCurrentSession();
//        session.save(product);
//    }
//
//
//    public void update(Product product) {
//        Session session = factory.getCurrentSession();
//        session.update(product);
//    }
//
//    public void remove(long id) {
//        Session session = factory.getCurrentSession();
//        session.delete(id);
//    }
//
//
//    public Product findById(long id) {
//        Session session = factory.getCurrentSession();
//        Product product = session.get(Product.class, id);
//        return product;
//
//    }
//
//
//    public List<Product> findAll() {
//        Session session = factory.getCurrentSession();
//        List<Product> list = session.createQuery("from Product").getResultList();
//        return list;
//    }
}

