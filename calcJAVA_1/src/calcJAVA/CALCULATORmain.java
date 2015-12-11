package calcJAVA;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.*;
import java.util.List;


public class CALCULATORmain {

	public static void main(String[] args) {
		 
		
		CALCULATOR clc = new CALCULATOR();
		
		RPn sd = new RPn();
		
		String test1 = "3 4 2 * -4.0 ^ 2 / +";
		String gh = sd.getAnswer(test1);
		System.out.println(gh);
		
		
		
		
		
		
		
		
		
	}

}
