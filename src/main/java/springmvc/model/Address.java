package springmvc.model;

import javax.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "user_addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id",unique = true)
    private int addressId;
    @Column(name = "street_address")
    private String address1;
    @Column(name = "apartment_number")
    private String apartment1;

    @Column(name = "zip_code")
    private String zipcode1;
    @Column(name = "city")
    private String selectCity;
    @Column(name = "state")
    private String selectState;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public Address(){

    }

//    public Address(String s, String address1, String apartment1, String zipcode1, String selectCity, int addressIdInt) {
//    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

//    public int getUserId() {
//        return userId;
//    }
//
//    public void setUserId(int userId) {
//        this.userId = userId;
//    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getApartment1() {
        return apartment1;
    }

    public void setApartment1(String apartment1) {
        this.apartment1 = apartment1;
    }

    public String getZipcode1() {
        return zipcode1;
    }

    public void setZipcode1(String zipcode1) {
        this.zipcode1 = zipcode1;
    }

    public String getSelectCity() {
        return selectCity;
    }

    public void setSelectCity(String selectCity) {
        this.selectCity = selectCity;
    }

    public String getSelectState() {
        return selectState;
    }

    public void setSelectState(String selectState) {
        this.selectState = selectState;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Address(int addressId, String address1, String apartment1, String zipcode1, String selectCity, String selectState) {
        this.addressId = addressId;
        this.address1 = address1;
        this.apartment1 = apartment1;
        this.zipcode1 = zipcode1;
        this.selectCity = selectCity;
        this.selectState = selectState;
    }

    public Address(String address1, String apartment1, String zipcode1, String selectCity, String selectState) {
        this.address1 = address1;
        this.apartment1 = apartment1;
        this.zipcode1 = zipcode1;
        this.selectCity = selectCity;
        this.selectState = selectState;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", address1='" + address1 + '\'' +
                ", apartment1='" + apartment1 + '\'' +
                ", zipcode1='" + zipcode1 + '\'' +
                ", selectCity='" + selectCity + '\'' +
                ", selectState='" + selectState + '\'' +
                ", user=" + (user != null ? user.getUserId() : null) + // Use a specific field to represent the relationship
                '}';
    }

}
