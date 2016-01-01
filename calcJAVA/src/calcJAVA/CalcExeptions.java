package calcJAVA;

import java.util.ArrayList;


public class CalcExeptions {

	
	public static boolean emptyBrackets(ArrayList<String> s){
		
		boolean b = false;
		
		for(int k = s.lastIndexOf("("); k < s.lastIndexOf(")"); k++){
		
		   if(s.get(k).matches("[0-9]")){
			   continue;
		   }else{
			   b = true;
		   }
			
	    }
		
		return b;
	}
	
}
