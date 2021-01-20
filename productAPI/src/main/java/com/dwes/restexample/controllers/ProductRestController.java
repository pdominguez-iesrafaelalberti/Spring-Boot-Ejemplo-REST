package com.dwes.restexample.controllers;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dwes.restexample.entities.Product;
import com.dwes.restexample.repos.ProductRepository;


@RestController
public class ProductRestController {

	@Autowired
	ProductRepository repository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductRestController.class);

	@RequestMapping(value = "/products/", method = RequestMethod.GET)
	public List<Product> getProducts() {
		return repository.findAll();
	}

	@RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
	public Product getProduct(@PathVariable("id") int id) {
		LOGGER.info("Finding product by ID:"+id);
		return repository.findById(id).get();
	}

	@RequestMapping(value = "/products/", method = RequestMethod.POST)
	public Product createProduct(@RequestBody Product product) {
		return repository.save(product);
	}

	@RequestMapping(value = "/products/", method = RequestMethod.PUT)
	public Product updateProduct(@RequestBody Product product) {
		return repository.save(product);
	}
	
	@RequestMapping(value = "/products/{id}", method = RequestMethod.PATCH)
	public Product updatePatchProduct(@RequestBody Product product, @PathVariable("id") int id) {
		
		System.out.println("ID: " + id);
		Product oldProduct = repository.findById(id).get();
		
		product.setId(oldProduct.getId());

		if(product.getDescription() == null) {
			product.setDescription(oldProduct.getDescription());
		}
		
		if(product.getName() == null) {
			product.setName(oldProduct.getName());
		}
		
		if(product.getPrice() == null) {
			product.setName(oldProduct.getName());
		}
		
		return repository.save(product);
	}

	@RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
	public void deleteProduct(@PathVariable("id") int id) {
		repository.deleteById(id);
	}

}
	


	

