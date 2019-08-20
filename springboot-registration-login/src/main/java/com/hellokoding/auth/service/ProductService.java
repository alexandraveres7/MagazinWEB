package com.hellokoding.auth.service;

import com.hellokoding.auth.model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static java.lang.Double.MAX_VALUE;

public class ProductService {

    private ArrayList<Product> lista;

    public ProductService(){
        lista = new ArrayList<>();
        lista.add(new Product("Cirese", 100, 1.99));
        lista.add(new Product("Biscuiti cu cereale", 100, 6.99));
        lista.add(new Product("Biscuiti de ciocolata", 100, 9.99));
        lista.add(new Product("Paine", 100, 1.99));
        lista.add(new Product("Iaurt", 100, 3.99));
        lista.add(new Product("Iaurt cu fructe", 100, 5.99));
        lista.add(new Product("Iaurt cu seminte", 100, 7.99));
        lista.add(new Product("Iaurtel Danonino (copii)", 100, 7.99));
    }

    public ArrayList<Product> Search(String cuvant, String ordine, Double min, Double max){
        ArrayList<Product> rezultat = new ArrayList<>();

        if (ordine == null){
            ordine = "pret-crescator";
        }
        else if(min == null || max == null){
            min = 0.00;
            max = MAX_VALUE;
        }

        for (int i = 0; i < lista.size(); i++) {
            int lungime = lista.get(i).getNume().split(" ").length;
            String[]  a = lista.get(i).getNume().split(" ");
            for (int j=0; j<lungime; j++)
                if (a[j].equals(cuvant)) {
                    if (lista.get(i).getPret() >= min)
                        if (lista.get(i).getPret() <= max)
                            rezultat.add(lista.get(i));
                }
        }
        if (ordine == "pret-crescator") {
            Collections.sort(rezultat,
                    Comparator.comparingDouble(Product::getPret));
        } else if (ordine == "pret-descrescator") {
            Collections.sort(rezultat,
                    Comparator.comparingDouble(Product::getPret).reversed());
        }

        return rezultat;
    }

    public ArrayList<Product> getList(){
        return this.lista;
    }
}
