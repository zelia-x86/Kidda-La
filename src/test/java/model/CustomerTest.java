package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CustomerTest {
    @Test
    public void getters () {
        int custId = 1;
        String custName = "青木まゆみ";
        String kana = "アオキマユミ";
        String tel = "09012345678";
        String address = "東京都千代田区神田小川町１－１－１";

        Customer cust = new Customer();
        assertEquals(0, cust.getCustId());

        cust = new Customer(0, null, null, null, null);
        assertEquals(0, cust.getCustId());

        cust = new Customer(custId, custName, kana, tel, address);
        assertEquals(custId, cust.getCustId());
        assertEquals(custName, cust.getCustName());
        assertEquals(kana, cust.getKana());
        assertEquals(tel, cust.getTel());
        assertEquals(address, cust.getAddress());
    }

    @Test
    public void setCustId () {
        Customer cust = new Customer();

        cust.setCustId(2);
        assertEquals(2, cust.getCustId());
        cust.setCustId(0);
        assertEquals(0, cust.getCustId());
    }

    @Test
    public void setCustName () {
        Customer cust = new Customer();

        cust.setCustName(null);
        assertEquals(null, cust.getCustName());
        cust.setCustName("TEST");
        assertEquals(cust.getCustName(), "TEST");
    }

    @Test
    public void setKana () {
        Customer cust = new Customer();

        cust.setKana(null);
        assertEquals(null, cust.getKana());
        cust.setKana("カナ");
        assertEquals("カナ", cust.getKana());
    }

    @Test
    public void setTel () {
        Customer cust = new Customer();

        cust.setTel(null);
        assertEquals(null, cust.getTel());
        cust.setTel("09012345678");
        assertEquals("09012345678", cust.getTel());
    }

    @Test
    public void setAddress () {
        Customer cust = new Customer();

        cust.setAddress(null);
        assertEquals(null, cust.getAddress());
        cust.setAddress("東京都１－１－１");
        assertEquals("東京都１－１－１", cust.getAddress());
    }
}
