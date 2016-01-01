package calcJAVA;

import java.util.regex.*;
import java.util.ArrayList;
import java.util.Arrays;


public class RPn {
	//â static
	//skins
	Pattern pat = Pattern.compile(" ");
	
	public static int minusBefTrigonometric(String b){
		int m;
		if(b.startsWith("-")){
			return m=1;
		}else{
			return m=0;
		}
	}
	
	public String getAnswer(String a){
		
		String answer = new String();
		String[] arr1 = pat.split(a);
		ArrayList<String> arr2 = new ArrayList<String>(Arrays.asList(arr1));
		
	 for(int j = 0; j < arr2.size(); j++){
			
		 if(arr2.get(j).equals("SIN") || arr2.get(j).equals("COS") || arr2.get(j).equals("TAN") || arr2.get(j).equals("LOG") || arr2.get(j).equals("SQRT")
				  || arr2.get(j).equals("-SIN") || arr2.get(j).equals("-COS") || arr2.get(j).equals("-TAN") || arr2.get(j).equals("-LOG") || arr2.get(j).equals("-SQRT")){
			try{
				Double d1 = Double.parseDouble(arr2.get(j+1));
				Double Final;
				
				switch(arr2.get(j)){
				
				case "SIN": Final = Math.sin(d1);
				break;
				case "COS": Final = Math.cos(d1);
				break;
				case "TAN": Final = Math.tan(d1);
				break;
				case "LOG": Final = Math.log(d1);
				break;
				case "SQRT": Final = Math.sqrt(d1);
				break;
				case "-SIN": Final = Math.sin(d1);
				break;
				case "-COS": Final = Math.cos(d1);
				break;
				case "-TAN": Final = Math.tan(d1);
				break;
				case "-LOG": Final = Math.log(d1);
				break;
				case "-SQRT": Final = Math.sqrt(d1);
				break;
				default:Final = 0.00;
				break;
				}
				
				String FinaltoString;
				int m = RPn.minusBefTrigonometric(arr2.get(j));
				switch(m){
				
				case 1: FinaltoString = "-"+Double.toString(Final);
				break;
				case 0: FinaltoString = Double.toString(Final);
				break;
				default: FinaltoString = "";
				break;
				}
				
				arr2.set(j, FinaltoString);
				arr2.remove(j+1);
				
				j--;
			}catch(NumberFormatException e){}
		}else if(arr2.get(j).equals("^")){
			try{
				Double d1 = Double.parseDouble(arr2.get(j+1));
				Double d2 = Double.parseDouble(arr2.get(j-1));
				Double Final = Math.pow(d2, d1);
				String FinaltoString = Double.toString(Final);
				
				arr2.set(j, FinaltoString);
				arr2.remove(j+1);
				arr2.remove(j-1);
				
				j--;
				j--;
			}catch(NumberFormatException e){}
		}else if(arr2.get(j).equals("*") || arr2.get(j).equals("-") || arr2.get(j).equals("+") || arr2.get(j).equals("/")){
			try{
			Double d1 = Double.parseDouble(arr2.get(j-2));
			Double d2 = Double.parseDouble(arr2.get(j-1));
			Double Final;
			
			switch(arr2.get(j)){
			case "*":
				 Final = d1*d2;
				break;
			case "-":	
				 Final = d1-d2;
				break;
			case "+":
				Final = d1+d2;
				break;
			case "/":
				Final = d1/d2;
				break;
			default:
				Final = 0.00;
				break;
			}
			
			String FinaltoString = Double.toString(Final);
			
			arr2.set(j, FinaltoString);
			arr2.remove(j-1);
			arr2.remove(j-2);
			
			j--;
			j--;
			}catch(Exception e){}
		}
	 }
	
	 for(int i = 0; i<arr2.size(); i++){
			answer = answer+arr2.get(i);
		}
		
		return answer;
	 
	   }
	}



