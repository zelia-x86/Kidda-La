package dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Customer;

public class CustomerSearchDBAccessTest {

    private CustomerSearchDBAccess db;

    @BeforeEach
    public void prepare () {
        this.db = new CustomerSearchDBAccess();
    }

    // by tel
    @Test
    public void byTelCase1 () throws Exception {
        ArrayList<Customer> result = db.searchCustomerByTel("09012345678");
        assertEquals(1, result.size());
        assertEquals(1, result.get(0).getCustId());
    }

    // by tel
    @Test
    public void byTelCase2 () throws Exception {
        ArrayList<Customer> result = db.searchCustomerByTel("");
        assertEquals(0, result.size());
    }

    @Test
    public void byTelCase3 () throws Exception {
        ArrayList<Customer> result = db.searchCustomerByTel(null);
        assertEquals(0, result.size());
    }

    @Test
    public void byTelCase4 () throws Exception {
        ArrayList<Customer> result = db.searchCustomerByTel("0314142135");
        assertEquals(3, result.size());
        assertEquals(15, result.get(0).getCustId());
        assertEquals(16, result.get(1).getCustId());
        assertEquals(17, result.get(2).getCustId());
    }

    @Test
    public void byTelCase5 () throws Exception {
        ArrayList<Customer> result = db.searchCustomerByTel("01012345678");
        assertEquals(0, result.size());
    }

    // by kana
    @Test
    public void byKanaCase1 () throws Exception {
        ArrayList<Customer> result = db.searchCustomerByKana("アオキマユミ");
        assertEquals(1, result.size());
        assertEquals(1, result.get(0).getCustId());
    }

     public void byKanaCase2 () throws Exception {
        ArrayList<Customer> result = db.searchCustomerByKana("");
        assertEquals(0, result.size());
    }

    public void byKanaCase3 () throws Exception {
        ArrayList<Customer> result = db.searchCustomerByKana(null);
        assertEquals(0, result.size());
    }

    public void byKanaCase4 () throws Exception {
        ArrayList<Customer> result = db.searchCustomerByKana("マユミ");
        assertEquals(1, result.size());
        assertEquals(1, result.get(0).getCustId());
    }

    public void byKanaCase5 () throws Exception {
        ArrayList<Customer> result = db.searchCustomerByKana("スズキ");
        assertEquals(3, result.size());
    }

    // by general
    public void bySearchCase1 () throws Exception {
        ArrayList<Customer> result = db.searchCustomer("09012345678", "アオキマユミ");
        assertEquals(1, result.size());
        assertEquals(1, result.get(0).getCustId());
    }

    public void bySearchCase2 () throws Exception {
        ArrayList<Customer> result = db.searchCustomer("", "");
        assertEquals(0, result.size());
    }

    public void bySearchCase3 () throws Exception {
        ArrayList<Customer> result = db.searchCustomer("09013245678", null);
        assertEquals(0, result.size());
    }

    public void bySearchCase4 () throws Exception {
        ArrayList<Customer> result = db.searchCustomer("09012345678", "");
        assertEquals(0, result.size());
    }

    public void bySearchCase5 () throws Exception {
        ArrayList<Customer> result = db.searchCustomer(null, null);
        assertEquals(0, result.size());
    }

    public void bySearchCase6 () throws Exception {
        ArrayList<Customer> result = db.searchCustomer("0314142135", "コ");
        assertEquals(2, result.size());
        assertEquals(15, result.get(0).getCustId());
        assertEquals(17, result.get(1).getCustId());
    }

    public void bySearchCase7 () throws Exception {
        ArrayList<Customer> result = db.searchCustomer("", "マユミ");
        assertEquals(0, result.size());
    }
}
