package app.test;

import app.dao.ProductDao;
import app.dao.ProductDaoImpl;
import app.entities.Product;
import java.util.List;

public class Test
{
    public static void main(String[] args) 
    {
        ProductDao dao = new ProductDaoImpl();
        List<Product> products = dao.getAll();
        
        products.forEach(p ->{
            System.out.println(p.getId() + " - " + p.getName());
        });
        
        System.out.println("done....");
        System.exit(0);
    }
}
