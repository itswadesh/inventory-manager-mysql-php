package com.aleggeup.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

@Controller
@RequestMapping("/api/v1")
public class ProductController {

        @Autowired
        private ProductRepository productRepository;

        @RequestMapping("/products")
        @ResponseBody
        public List<Product> allProducts() {
            final List<Product> products = new ArrayList<>();

            for (final Iterator<Product> iterator = productRepository.findAll().iterator(); iterator.hasNext(); ) {
                products.add(iterator.next());
            }

            return products;
        }

        @RequestMapping(method = RequestMethod.POST, value="/products")
        @ResponseBody
        public List<Product> add(@RequestBody Product product) {
            final List<Product> products = new ArrayList<>();
            final long newId = 1000 + productRepository.count();
            product.setId(newId);
            productRepository.save(product);
            products.add(product);

            return products;
        }

        @RequestMapping(method = RequestMethod.PUT, value="/products/{id}")
        @ResponseBody
        public void update(@PathVariable Long id, @RequestBody Product product) {
            final Product savedProduct = productRepository.findOne(id);

            if (product.getId() == null) {
                savedProduct.setStatus(product.getStatus());
                productRepository.save(savedProduct);
            } else {
                productRepository.save(product);
            }
        }

        @RequestMapping(method = RequestMethod.DELETE, value="/products/{id}")
        @ResponseBody
        public void delete(@PathVariable Long id) {
            productRepository.delete(id);
        }
}

