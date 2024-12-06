package com.example.app.Controller;

import com.example.app.Model.Product;
import com.example.app.Service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping
    public List<Product>getPro(){
        return service.getPro();
    }

    @GetMapping("/{id}")
    public Product getId(@PathVariable int id){
        return service.getId(id);
    }

    @PostMapping
    public void AddPro(@RequestBody Product pro){
        service.AddPro(pro);
    }

    @PutMapping
    public void UpdatePro(@RequestBody Product pro){
        service.UpdatePro(pro);
    }

    @DeleteMapping("/{id}")
    public void DeletePro(@PathVariable int id){
        service.DeletePro(id);
    }

    @GetMapping("/csrf")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return(CsrfToken) request.getAttribute("_csrf");
    }

    @GetMapping("/session")
    public String getSession(HttpServletRequest request){
        return "The session Id :  "+request.getSession().getId();
    }

}
