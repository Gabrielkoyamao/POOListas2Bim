package sistema;

import java.util.HashMap;
import java.util.Map;

public class sandbox {

	public static void main(String[] args) {
		Map<String, Integer> raca = new HashMap<>();
		
		int a;
		raca.put("dog", 1);
		raca.put("teste", 1);
		
		System.out.println(raca.toString());
		
//		if(raca.get("doaag") != null) {
//			a = raca.get("doaag");			
//		}else {
//			System.out.println("nao existe");
//		}
		
		
		for (Map.Entry<String, Integer> entry : raca.entrySet()) {
		    if(entry.getKey().equals("dog")) {
		    	int aux=0;
		    	aux = entry.getValue() + 10;
		    	raca.replace(entry.getKey(), aux);
		    }
		}
		System.out.println(raca.toString());
	}
}
