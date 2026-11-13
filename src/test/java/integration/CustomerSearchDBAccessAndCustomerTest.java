package integration;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.CustomerSearchDBAccess;
import model.Customer;

public class CustomerSearchDBAccessAndCustomerTest {

    private CustomerSearchDBAccess db;
    
    private int custId = 1;
    private String custName = "青木まゆみ";
    private String kana = "アオキマユミ";
    private String tel = "09012345678";
    private String address = "東京都千代田区神田小川町１－１－１";

    @BeforeEach
    public void prepare () {
        this.db = new CustomerSearchDBAccess();
    }

    @Test
    public void searchCustomerByTel () throws Exception {
        Customer cust = new Customer(custId, custName, kana, tel, address);
        assertEquals(custId, cust.getCustId());
        assertEquals(custName, cust.getCustName());
        assertEquals(kana, cust.getKana());
        assertEquals(tel, cust.getTel());
        assertEquals(address, cust.getAddress());

        ArrayList<Customer> result = db.searchCustomerByTel("09012345678");
        assertEquals(1, result.size());
        assertEquals(1, result.get(0).getCustId());
        assertEquals("青木まゆみ", result.get(0).getCustName());
        assertEquals("アオキマユミ", result.get(0).getKana());
        assertEquals("東京都千代田区神田小川町1-1-1", result.get(0).getAddress());
        assertEquals("09012345678", result.get(0).getTel());
    }

    @Test
    public void searchCustomerByKana () throws Exception {
        Customer cust = new Customer(custId, custName, kana, tel, address);
        assertEquals(custId, cust.getCustId());
        assertEquals(custName, cust.getCustName());
        assertEquals(kana, cust.getKana());
        assertEquals(tel, cust.getTel());
        assertEquals(address, cust.getAddress());

        ArrayList<Customer> result = db.searchCustomerByKana("アオキマユミ");
        assertEquals(1, result.size());
        assertEquals(1, result.get(0).getCustId());
        assertEquals("青木まゆみ", result.get(0).getCustName());
        assertEquals("アオキマユミ", result.get(0).getKana());
        assertEquals("東京都千代田区神田小川町1-1-1", result.get(0).getAddress());
        assertEquals("09012345678", result.get(0).getTel());
    }

    @Test
    public void searchCustomer () throws Exception {
        Customer cust = new Customer(custId, custName, kana, tel, address);
        assertEquals(custId, cust.getCustId());
        assertEquals(custName, cust.getCustName());
        assertEquals(kana, cust.getKana());
        assertEquals(tel, cust.getTel());
        assertEquals(address, cust.getAddress());

        ArrayList<Customer> result = db.searchCustomer("09012345678", "アオキマユミ");
        assertEquals(1, result.size());
        assertEquals(1, result.get(0).getCustId());
        assertEquals("青木まゆみ", result.get(0).getCustName());
        assertEquals("アオキマユミ", result.get(0).getKana());
        assertEquals("東京都千代田区神田小川町1-1-1", result.get(0).getAddress());
        assertEquals("09012345678", result.get(0).getTel());
    }
}
