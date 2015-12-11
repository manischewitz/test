package calcJAVA;

import java.util.regex.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RPn {

	public String getAnswer(String a){
		
		String answer = new String();
		Pattern pat = Pattern.compile(" ");
		String[] arr1 = pat.split(a);
		ArrayList<String> arr2 = new ArrayList<String>(Arrays.asList(arr1));
		
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
	
	
	 for(int i = 0; i<arr2.size(); i++){
			answer = answer+arr2.get(i);
		}
		
		return answer;
	
	}
}
	

