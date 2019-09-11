package com.hellokoding.auth.service;

import com.hellokoding.auth.model.Product;
import com.hellokoding.auth.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.lang.Double.MAX_VALUE;

@Service
public class ProductService {
    @Autowired
    private ProductRepository pr;

    private List<Product> lista;

    public ProductService() {
        lista = new ArrayList<>();
    }

    public void save(Product product){
        pr.save(product);
    }

    public List<Product> getList(){
        return pr.findAll();
    }

    public List<Product> Search(String cuvant, String ordine, Double min, Double max){

        lista = pr.findAll();
        List<Product> rezultat = new ArrayList<>();

        if (ordine == null){
            ordine = "pret-crescator";
        }
        else if(min == null || max == null){
            min = 0.00;
            max = MAX_VALUE;
        }

        for (Product product : lista) {
            int lungime = product.getNume().split(" ").length;
            String[] a = product.getNume().split(" ");
            for (int j = 0; j < lungime; j++)
                if (a[j].equals(cuvant)) {
                    if (product.getPret() >= min)
                        if (product.getPret() <= max)
                            rezultat.add(product);
                }
        }
        if (ordine.equals("pret-crescator")) {
            rezultat.sort(Comparator.comparingDouble(Product::getPret));
        } else if (ordine.equals("pret-descrescator")) {
            rezultat.sort(Comparator.comparingDouble(Product::getPret).reversed());
        }

        return rezultat;
    }
}
