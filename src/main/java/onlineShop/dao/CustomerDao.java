package onlineShop.dao;

import onlineShop.entity.Authorities;
import onlineShop.entity.Customer;
import onlineShop.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void addCustomer(Customer customer){
        Authorities authorities = new Authorities();
        authorities.setAuthorities("ROLE_USER");
        authorities.setEmailId(customer.getUser().getEmailId());
        Session session = null;

        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(authorities);
            session.save(customer);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }
    public Customer getCustomerByUserName(String userName){
        User user = null;
        Session session = null;
        try{
            session = sessionFactory.openSession();
            user = session.get(User.class, userName);
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if (session != null){
                session.close();
            }
        }
        if(user !=null){
            return user.getCustomer();
        }
        return null;
    }

}
