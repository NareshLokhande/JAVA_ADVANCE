package com.newproductrest.app;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.newproductrest.app.model.Product;
import com.newproductrest.app.service.ProductService;

//@SpringBootTest
@WebMvcTest
class NewproductrestApplicationTests {

	// JUnit demo
//	@Autowired
//	Operations op;
//	
//	@Test
//	void sumTest() {
//		int expectedResult = 4;
//		int actualResult = op.add(4, 2);
//		assertThat(actualResult).isEqualTo(expectedResult);
//	}
//	
//	@Test
//	void mulTest() {
//		int exceptedResult = 12;
//		int actualResult = op.multiply(2, 6);
//		assertThat(actualResult).isEqualTo(exceptedResult);
//	}
//	
//	@Test
//	void compareTest() {
//		boolean actualResult = op.compare(4, 4);
//		assertThat(actualResult).isTrue();
//	}

	// Mockito demo
	@Autowired
	private MockMvc mockMvc; // to mock request , response and data

	@Autowired
	private ObjectMapper objectMapper; // to json <-> java object

	@MockBean
	private ProductService productService; // to make productservice point towards mock data

	// Example
	@Test
	public void getProductsListTest() {

		List<Product> list = new ArrayList<>();

		Product p1 = new Product();
		p1.setId(101);
		p1.setName("Keyboard");
		p1.setPrice(1000);
		p1.setQuantity(25);

		Product p2 = new Product();
		p2.setId(102);
		p2.setName("Mouse");
		p2.setPrice(500);
		p2.setQuantity(5);

		Product p3 = new Product();
		p3.setId(103);
		p3.setName("USB drive");
		p3.setPrice(400);
		p3.setQuantity(5);

		list.add(p1);
		list.add(p2);
		list.add(p3);

		when(productService.findAll()).thenReturn(list);
		when(productService.countAll()).thenReturn((long) list.size());

		try {
			ResultActions response = mockMvc.perform(get("/products/"));

			response.andExpect(status().isOk())
			.andDo(print())
			.andExpect(jsonPath("$.count", is(list.size())));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void getByIdTest() {
		Product p1 = new Product();
		p1.setId(101);
		p1.setName("Keyboard");
		p1.setPrice(1000.0f);
		p1.setQuantity(25);
		
		when(productService.findById(101)).thenReturn(Optional.of(p1));
		
		try {
			ResultActions response = mockMvc.perform(get("/products/{id}",101));
			response.andExpect(status().isOk())
			.andDo(print())
			.andExpect(jsonPath("$.id", is(p1.getId())))
			.andExpect(jsonPath("$.name", is(p1.getName())))
			.andExpect(jsonPath("$.price", is(Double.valueOf(p1.getPrice()) )))
			.andExpect(jsonPath("$.quantity", is(p1.getQuantity())));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
