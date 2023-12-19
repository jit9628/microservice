package com.product.productservice.serviceimpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.productservice.dto.ProductDto;
import com.product.productservice.entity.Product;
import com.product.productservice.repositories.ProductRepository;
import com.product.productservice.service.ProductService;

@Service
public class ProductServiceImplementation implements ProductService {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ModelMapper mapper;

	@Override
	public Boolean addProduct(ProductDto productDto) {
		// product is existe or not
		// this.mapper.map(productDto, Product.class)
		// this.productRepository.save(this.mapper.map(productDto, Product.class));
//		if(this.productRepository.save(this.mapper.map(productDto, Product.class)) instanceof Product)
		return (!this.productRepository.existsByProductname(productDto.getProductname())) ? false
				: (this.productRepository.save(this.mapper.map(productDto, Product.class)) instanceof Product) ? true
						: false;
		// return null;
	}
}
