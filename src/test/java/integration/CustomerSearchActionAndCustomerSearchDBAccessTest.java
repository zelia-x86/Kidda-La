package integration;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import action.CustomerSearchAction;
import dao.CustomerSearchDBAccess;
import model.Customer;
import model.OrderControlUtility;

public class CustomerSearchActionAndCustomerSearchDBAccessTest {

    private  CustomerSearchDBAccess db;
    private CustomerSearchAction action;

    @BeforeEach
    public void prepare () {
        db = new CustomerSearchDBAccess();
        action = new CustomerSearchAction();
    }

    @Test 
    public void CustomerSearchDBAccess () {
        CustomerSearchDBAccess customerSearchDBAccess = new CustomerSearchDBAccess();
        assertInstanceOf(CustomerSearchDBAccess.class, customerSearchDBAccess);
    }

    @Test
    public void Customer () {
        Customer customer = new Customer();
        assertInstanceOf(Customer.class, customer);
    }

    @Test 
    public void searchCustomerByKana () throws Exception {
        String[] input = {"", "マユミ"};
        String[][] result1 = action.execute(input);
        String[][] result2 = OrderControlUtility.customerToArray(db.searchCustomerByKana("マユミ"));
        assertArrayEquals(result1, result2);
    }

    @Test 
    public void searchCustomerByTel () throws Exception {
        String[] input = {"", "マユミ"};
        String[][] result1 = action.execute(input);
        String[][] result2 = OrderControlUtility.customerToArray(db.searchCustomerByTel("09012345678"));
        assertArrayEquals(result1, result2);
    }


    @Test 
    public void searchCustomer () throws Exception {
        String[] input = {"", "マユミ"};
        String[][] result1 = action.execute(input);
        String[][] result2 = OrderControlUtility.customerToArray(db.searchCustomer("09012345678", "マユミ"));
        assertArrayEquals(result1, result2);
    }
}
