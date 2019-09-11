package com.hellokoding.auth.test;

import com.hellokoding.auth.model.Product;
import com.hellokoding.auth.repository.ProductRepository;
import com.hellokoding.auth.service.ProductService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {
    Product p1, p2, p3;

    private ProductService productService;

    private ProductRepository productRepositoryMock;

    @Before
    public void setUp() {
        productService = new ProductService();

        productRepositoryMock = mock(ProductRepository.class);
    }

    @Before
   public void before(){
       System.out.println("Before");

       p1 = new Product("Cirese", 50, 1);
       p2 = new Product("Banane", 60, 0.5);
       p3 = new Product("Biscuiti", 570, 1.5);

       /*productServiceMock.save(p1);
       productServiceMock.save(p2);
       productServiceMock.save(p3);

       a = productServiceMock.getList();*/
   }

    @After
   public void after(){
       System.out.println("After");
   }

    @Test
    public void testFindOneProduct(){
        b = new ArrayList<Product>();
        b.add(p1);
        List<Product> expected = productServiceMock.Search("Cirese","pret-crescator", 0.00, 100.00);


//        assertEquals(expected.getNume(), is(p1.getNume()));

   }
}