package action;

import java.util.ArrayList;

import model.Customer;
import dao.CustomerSearchDBAccess;

public class CustomerSearchAction {

	public String[][] execute(String[] data) throws Exception {
		String tel = data[0].trim();
		String kana = data[1].trim();

		ArrayList<Customer> arr = new ArrayList<Customer>();

		CustomerSearchDBAccess search = new CustomerSearchDBAccess();

		if (tel.isEmpty() && kana.isEmpty()) {
			throw new Exception("【エラー】\nDB電話番号と氏名カナのいずれか、また両方を入力してください。");
		} else if (tel.isEmpty()) {
			arr = search.searchCustomerByKana(kana);
		} else if (kana.isEmpty()) {
			arr = search.searchCustomerByTel(tel);
		} else {
			arr = search.searchCustomer(tel, kana);
		}

		String[][] ret = new String[arr.size()][];
		int cnt = 0;
		for (Customer cus : arr) {
			String[] row = {
				Integer.toString(cus.getCustId()),
				cus.getCustName(),
				cus.getKana(),
				cus.getAddress()
			};
			ret[cnt++] = row;
		}

		return ret;
	}
}
