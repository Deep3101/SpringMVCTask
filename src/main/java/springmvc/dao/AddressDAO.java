package springmvc.dao;

import org.springframework.stereotype.Repository;
import springmvc.model.Address;

import java.util.List;

@Repository
public interface AddressDAO {
    List<Address> getUserAddresses(int userId);

    void updateAddress(Address address);

    void deleteAddress(Address address);

    void saveAddress(Address address);
}
