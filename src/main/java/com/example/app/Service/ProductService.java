package com.example.app.Service;

import com.example.app.Model.Product;
import com.example.app.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository repo;

    public List<Product> getPro(){
        return repo.findAll();
    }

    public Product getId(int id){
        return repo.findById(id).orElse(new Product(0,"zero",0));
    }

    public void AddPro(Product pro){
        repo.save(pro);
    }

    public void UpdatePro(Product pro){
        repo.save(pro);
    }

    public void DeletePro(int id){
        repo.deleteById(id);
    }


}
