package springmvc.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import springmvc.model.Address;

import java.util.List;

@Repository
public class AddressDAOImpl implements AddressDAO{
    @Autowired
    private SessionFactory sessionFactory;

    public List<Address> getUserAddresses(int userId) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Address WHERE user.userId = :userId", Address.class)
                .setParameter("userId", userId)
                .list();
    }

    @Transactional
    public void updateAddress(Address address) {
        Session session = sessionFactory.getCurrentSession();
        session.update(address);
    }

    @Transactional
    public void deleteAddress(Address address) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(address);
    }

    @Transactional
    public void saveAddress(Address address){
        Session session = sessionFactory.getCurrentSession();
        session.save(address);
    }
}
