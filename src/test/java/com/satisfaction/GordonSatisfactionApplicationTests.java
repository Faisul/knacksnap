package com.satisfaction;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.satisfaction.compute.KnackSnap;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class GordonSatisfactionApplicationTests {

	KnackSnap k = new KnackSnap();

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void contextLoads() {

	}

	@Test
	public void hitService() {
		String body = this.restTemplate.getForObject("/", String.class);
		assertThat(body).isNotEmpty();
	}

	@Test
	public void testMax() {
		int a = 10;
		int b = 20;
		assertEquals(20, k.max(a, b));
	}

	@Test
	public void testKnackSnap() {
		int val[] = new int[] { 60, 100, 120 };
		int wt[] = new int[] { 10, 20, 30 };
		int W = 60;
		int n = val.length;

		assertEquals(280, k.knapSack(W, wt, val, n));
	}
	
	@Test
	public void testKnackSnap_noValue() {
		int val[] = new int[] { 60, 100, 120 };
		int wt[] = new int[] { 10, 20, 30 };
		int W = 8;
		int n = val.length;

		assertEquals(0, k.knapSack(W, wt, val, n));
	}

}
