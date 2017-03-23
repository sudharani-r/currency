package currency;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

import org.springframework.core.io.ClassPathResource;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CurrencyFormatter {

	ObjectMapper mapper = new ObjectMapper();
	HashMap<String,Integer> map = new HashMap<String,Integer>();
	double d;
	
   public double currencyFormatter(Double amount, String currency){
    	try {
    		ClassPathResource file = null;
    		     file = new ClassPathResource("currencies.json");
    		      if(file.getFile().exists()){
    		        
    	       
			 map = mapper.readValue(
					 file.getFile(),
					new TypeReference<Map<String, Integer>>() {
			});
    		      }
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	System.out.println(map.get(currency));
    	//if(map.get(currency) != 0){
    	BigDecimal bd = new BigDecimal(amount).setScale(map.get(currency), RoundingMode.HALF_EVEN);
    	System.out.println("amount " + bd.doubleValue());
    	d = bd.doubleValue();
    	/*}
    	else{
    		long mStrippedValue = new Double(amount).longValue();
        	System.out.println("amount " + mStrippedValue);
        	d = mStrippedValue;

    	}*/
    	return d;
    }
}