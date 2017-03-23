package main;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import currency.CurrencyFormatter;

@RestController
public class CurrencyRestController {

	@RequestMapping(method = RequestMethod.POST)
	public double createCustomer(@RequestBody() Map<String,String> currency) {

		double result;
		System.out.println(currency.get("amount"));

		System.out.println(currency.get("currency"));
		 CurrencyFormatter cf = new CurrencyFormatter();
		result = cf.currencyFormatter(Double.parseDouble(currency.get("amount")), currency.get("currency"));
		return result;
	}
}
