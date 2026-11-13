package action;

import java.util.ArrayList;

import model.Customer;
import dao.CustomerSearchDBAccess;

public class CustomerSearchAction {

	public String[][] execute(String[] data) throws Exception {
		data[0] = data[0].strip().replaceAll("[　\\s]+", " ");
		data[1] = data[1].strip().replaceAll("[　\\s]+", " ");

		ArrayList<Customer> arr = new ArrayList<Customer>();

		CustomerSearchDBAccess search = new CustomerSearchDBAccess();

		if (data[0].isEmpty()) {
			arr = search.searchCustomerByKana(data[1]);
		} else if (data[1].isEmpty()) {
			arr = search.searchCustomerByTel(data[0]);
		} else {
			arr = search.searchCustomer(data[0], data[1]);
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
