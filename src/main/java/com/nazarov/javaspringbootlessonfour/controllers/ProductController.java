package com.nazarov.javaspringbootlessonfour.controllers;


import com.nazarov.javaspringbootlessonfour.entities.Product;
import com.nazarov.javaspringbootlessonfour.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public String indexPage(Model model) {
        model.addAttribute("products", productService.getAllProduct());
        return "product_view/index";
    }


    @GetMapping({"/{id}"})
    public String editProduct(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("product", productService.getById(id));
        return "product_view/product_form";
    }

    @PostMapping("/productUpdate")
    public String updateProduct(@ModelAttribute Product product) {
        productService.addOrUpdate(product);
        return "redirect:/product";
    }

    @GetMapping("/new")
    public String newProduct(Model model) {
        model.addAttribute(new Product());
        return "product_view/product_form";
    }

    @GetMapping("/delete/{id}")
    public String removeProduct(@PathVariable(value = "id") Long id) {
        productService.remove(id);
        return "redirect:/product";
    }

}


