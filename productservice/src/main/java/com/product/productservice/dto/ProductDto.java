package com.product.productservice.dto;

import java.sql.Timestamp;

import org.springframework.stereotype.Service;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Service
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
	private int pid;
	private String productname;
	private int quantity;
	@Temporal(TemporalType.TIMESTAMP)
	private Timestamp createddate;
}
