package calcJAVA;

import java.util.regex.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RPn {

	public String getAnswer(String a){
		
		double finalA =1;
		Pattern pat = Pattern.compile(" ");
		String[] arr1 = pat.split(a);
		ArrayList<String> arr2 = new ArrayList<String>(Arrays.asList(arr1));
		
		//List arr1 = Arrays.asList(arr);
		
		for(int j = 0; j < arr2.size(); j++){
			
			if(arr2.get(j).equals("+")){
				
				Double d1 = Double.parseDouble(arr2.get(j-2));
				Double d2 = Double.parseDouble(arr2.get(j-1));
				Double Final = d1+d2;
				String FinaltoString = Double.toString(Final);
				
				arr2.set(j, FinaltoString);
				arr2.remove(j-1);
				arr2.remove(j-2);
				
				j--;
				j--;
			}else if(arr2.get(j).equals("-")){
				Double d1 = Double.parseDouble(arr2.get(j-2));
				Double d2 = Double.parseDouble(arr2.get(j-1));
				Double Final = d1-d2;
				String FinaltoString = Double.toString(Final);
				
				arr2.set(j, FinaltoString);
				arr2.remove(j-1);
				arr2.remove(j-2);
				
				j--;
				j--;
			}else if(arr2.get(j).equals("*")){
				Double d1 = Double.parseDouble(arr2.get(j-2));
				Double d2 = Double.parseDouble(arr2.get(j-1));
				Double Final = d1*d2;
				String FinaltoString = Double.toString(Final);
				
				arr2.set(j, FinaltoString);
				arr2.remove(j-1);
				arr2.remove(j-2);
				
				j--;
				j--;
			}else if(arr2.get(j).equals("/")){
				Double d1 = Double.parseDouble(arr2.get(j-2));
				Double d2 = Double.parseDouble(arr2.get(j-1));
				Double Final = d1/d2;
				String FinaltoString = Double.toString(Final);
				
				arr2.set(j, FinaltoString);
				arr2.remove(j-1);
				arr2.remove(j-2);
				
				j--;
				j--;
			}else if(arr2.get(j).equals("^")){
				Double d1 = Double.parseDouble(arr2.get(j+1));
				Double d2 = Double.parseDouble(arr2.get(j-1));
				Double Final = Math.pow(d2, d1);
				String FinaltoString = Double.toString(Final);
				
				arr2.set(j, FinaltoString);
				arr2.remove(j+1);
				arr2.remove(j-1);
				
				j--;
				j--;
			}
			
			
		}
	
	
	
	
	
	
	
	
	
		System.out.println(arr2.size());
		arr2.forEach((String val) -> System.out.println(val));
		
		

		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
        String testing = new String();
        testing = arr2.toString();
        for(int i = 0; i<arr1.length; i++){
			
			
		}
		
		
		/*for(int i = 0; i<arr1.length; i++){
			System.out.println(arr1[i]);
		}*/
		
		return testing;
	}
	
}
	

