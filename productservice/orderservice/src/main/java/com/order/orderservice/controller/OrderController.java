package com.order.orderservice.controller;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.order.orderservice.pojo.Data;
import com.order.orderservice.pojo.Root;

@RestController
@RequestMapping("/api/order")
public class OrderController {
@Autowired
private RestTemplate restTemplate;
	@GetMapping("/{id}")
	public ResponseEntity<?> getSingleProductUsingRestTemplate(@PathVariable int id) {
//String forObject = this.restTemplate.getForObject("http://localhost:8085/api/product/singledata/6",String.class);
//String forObject = this.restTemplate.getForObject("http://localhost:8085/api/product/singledata/6",String.class);
 Root forObject = this.restTemplate.getForObject("http://localhost:8085/api/product/singledata/"+id+"", Root.class); 
 Data data = forObject.getData();
		return new ResponseEntity<>(Map.of("data",data),HttpStatus.OK);
	}
}
