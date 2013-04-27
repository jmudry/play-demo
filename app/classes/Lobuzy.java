package classes;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Lobuzy {

	public static Integer cyfrokrad(Integer liczba) {	
		String strLiczba = liczba.toString();
		int max = strLiczba.length() - 1;
		if (max == 0) {
			return null;
		}
		int rand = new Random().nextInt(max - 0);
		String newStrLiczba = new String("");
		newStrLiczba = strLiczba.substring(0, rand) + strLiczba.substring(rand+1);
		
		return Integer.parseInt(newStrLiczba);
	}
	
	
	public static Integer hultajchochla(Integer liczba) {
		Random random = new Random();
		String strLiczba = liczba.toString();
		int max;
		if (strLiczba.length() > 1) {		
			max = strLiczba.length() - 1;
			String tempStr1,tempStr2;
			int rand1, rand2;
			for (int i = 0; i < 10; i++) {
				rand1 = random.nextInt(max);
				rand2 = random.nextInt(max);
				tempStr1 = ""+strLiczba.charAt(rand1);
				tempStr2 = ""+strLiczba.charAt(rand2);
				strLiczba = strLiczba.substring(0, rand1) + tempStr2 + strLiczba.substring(rand1+1);
				strLiczba = strLiczba.substring(0, rand2) + tempStr1 + strLiczba.substring(rand2+1);		
			}
		}
		
		return Integer.parseInt(strLiczba);
	}
	
	
	public static Integer nieksztaltek(Integer liczba){
		Random random = new Random();
		String strLiczba = liczba.toString();
		Map<Integer, Integer> coNaCo= new HashMap<Integer, Integer>();
		coNaCo.put(1, 7);
		coNaCo.put(3, 8);
		coNaCo.put(6, 9);
		
		int rand = random.nextInt(coNaCo.size());
		Integer key = (Integer) coNaCo.keySet().toArray()[rand];
		
		strLiczba = strLiczba.replace(key.toString(), coNaCo.get(key).toString());
		
		return Integer.parseInt(strLiczba);	
		
	}

}
