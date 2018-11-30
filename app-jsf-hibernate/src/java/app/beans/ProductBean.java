package app.beans;

import app.dao.ProductDao;
import app.dao.ProductDaoImpl;
import app.entities.Product;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named(value = "productBean")
@RequestScoped
public class ProductBean implements Serializable{

    List<Product> products;
    ProductDao dao = new ProductDaoImpl();
    
    
    public ProductBean() {
    }
    
    @PostConstruct
    public void init()
    {
        products = dao.getAll();
    }

    public List<Product> getProducts() 
    {
        return products;
    }

    public void setProducts(List<Product> products) 
    {
        this.products = products;
    }
  
}
