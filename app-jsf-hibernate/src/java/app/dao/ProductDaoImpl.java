
package app.dao;

import app.entities.Product;
import app.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

public class ProductDaoImpl implements ProductDao
{
    @Override
    public List<Product> getAll() 
    {
        List<Product> products = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();  
        try  
        {  
            session.beginTransaction();  
            products = session.createCriteria(Product.class).list();  
            int count = products.size();  
            // FacesMessage message1 = new FacesMessage(FacesMessage.SEVERITY_INFO, "List Size", Integer.toString(count));//Debugging Purpose  
            //RequestContext.getCurrentInstance().showMessageInDialog(message1);  
            session.getTransaction().commit();  
        }  
        catch (Exception e)  
        {  
            e.printStackTrace();  
            session.getTransaction().rollback();  
        }  
        session.close();
        return products;
    }
    
}
