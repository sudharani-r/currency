package main;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;

import currency.CurrencyFormatter;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
        CurrencyFormatter cf = new CurrencyFormatter();
		cf.currencyFormatter(10.00678, "AED");
       
    }

}