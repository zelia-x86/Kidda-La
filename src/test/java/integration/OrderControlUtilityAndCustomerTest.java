package integration;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Customer;
import model.OrderControlUtility;

public class OrderControlUtilityAndCustomerTest {

    private ArrayList<Customer> customers;
    
    private int custId = 1;
    private String custName = "青木まゆみ";
    private String kana = "アオキマユミ";
    private String tel = "09012345678";
    private String address = "東京都千代田区神田小川町１－１－１";

    
    String[][] expected = {
        {"1", "青木まゆみ", "アオキマユミ", "東京都千代田区神田小川町１－１－１"},
        {"1", "青木まゆみ", "アオキマユミ", "東京都千代田区神田小川町１－１－１"},
        {"1", "青木まゆみ", "アオキマユミ", "東京都千代田区神田小川町１－１－１"},
    };

    @BeforeEach
    public void prepare () {
        this.customers = new ArrayList<>();
        this.customers.add(new Customer(custId, custName, kana, tel, address));
        this.customers.add(new Customer(custId, custName, kana, tel, address));
        this.customers.add(new Customer(custId, custName, kana, tel, address));
    }

    @Test
    public void Customer () {
        Customer customer = new Customer();
        assertInstanceOf(Customer.class, customer);
    }

    @Test
    public void getCustId () {
        assertEquals(custId, customers.get(0).getCustId());
        assertEquals(custId, customers.get(1).getCustId());
        assertEquals(custId, customers.get(2).getCustId());
        assertArrayEquals(expected, OrderControlUtility.customerToArray(customers));
    }

    @Test
    public void getCustName () {
        assertEquals(custName, customers.get(0).getCustName());
        assertEquals(custName, customers.get(1).getCustName());
        assertEquals(custName, customers.get(2).getCustName());
        assertArrayEquals(expected, OrderControlUtility.customerToArray(customers));
    }

    @Test
    public void getKana () {
        assertEquals(kana, customers.get(0).getKana());
        assertEquals(kana, customers.get(1).getKana());
        assertEquals(kana, customers.get(2).getKana());
        assertArrayEquals(expected, OrderControlUtility.customerToArray(customers));
    }

    @Test
    public void getAddress () {
        assertEquals(address, customers.get(0).getAddress());
        assertEquals(address, customers.get(1).getAddress());
        assertEquals(address, customers.get(2).getAddress());
        assertArrayEquals(expected, OrderControlUtility.customerToArray(customers));
    }
}
