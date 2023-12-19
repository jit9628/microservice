package com.product.productservice.controller;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.product.productservice.dto.ProductDto;
import com.product.productservice.service.ProductService;
@RestController("/api/product/")
@CrossOrigin(origins = "*")
public class ProductController {
	@Autowired
	private ProductService productService;
	@PostMapping("saveproduct")
	public ResponseEntity<?> addProduct(ProductDto productDto) {
		return (!this.productService.addProduct(productDto))
				? new ResponseEntity<>(Map.of("status", "CONFLICT", "message", "Can't Save Your Product"),
						org.springframework.http.HttpStatus.CONFLICT)

				: new ResponseEntity<>(Map.of("status", "OK", "message", "Saved Your Product"),
						org.springframework.http.HttpStatus.OK);

	}
}
