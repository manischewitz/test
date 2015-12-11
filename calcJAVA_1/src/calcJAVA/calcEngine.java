package calcJAVA;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;


public class calcEngine implements ActionListener{

		CALCULATOR parent;
	
	RPn rpn = new RPn();
	
	Pattern pat = Pattern.compile(" ");
	Pattern pat2 = Pattern.compile("");
	
	boolean checker = false;
	
	String numbers = new String(); //������ ����
	String degree = new String();
	String minusDeg = new String();
	
	int o,c;
	
	ArrayList<String> inputStream = new ArrayList<String>(); //����
    ArrayList<String> numbersDump = new ArrayList<String>(); 
    ArrayList<String> operandsDump = new ArrayList<String>();
    ArrayList<String> operands = new ArrayList<String>();
	
    String[] operands1 = {};
	
	calcEngine(CALCULATOR parent){
        this.parent = parent;
     }
	
	public void actionPerformed(ActionEvent a){
		
		JButton enterButton = (JButton) a.getSource();
		String entersmth = enterButton.getText();
		
		String displaytextfield =parent.dfe.getText();
		parent.dfe.setText(displaytextfield+entersmth);
		
		
	Object src = a.getSource();
	
	 //degree
	
	if(src == parent.buttonDEGREE){
		numbers = numbers+" ";
        degree = "^";
     }
	/**
	*��������� � �������
	*��� ����� 
	*�����
	*��������
	*��� ���...
	*-(455+55)+(455+55)
	*-2-26--2
	*2*2-4/6-2+5-8*2
	*2*2-5+4-8/1+2-5-6-1+24*2
	*^ -2
	*������ (��� � ����� ���� �����)
	*/
	
	//pi,cos,sin WIP
	/*
	if(src == parent.buttonPI){
		numbers = numbers+"3.141";
        inputStream.add("3.141");
       }
	
	if(src == parent.buttonCOS){
		numbers = numbers+"9";
        parent.dfe.setText(displaytextfield+"9");
      }
	*/
	//dot
	
	if(src == parent.buttonDOT){
		numbers = numbers+".";
        inputStream.add(".");
    }
	
	//������
	
	if(src == parent.buttonLEFTrbr){
		o++;                                                       //+1 � ���������� ����������� ������
		inputStream.add("(");
		
		numbersDump.add(numbers);                 //��������� ������ � ������ �����
		numbers = "";                             //������� ������ ��� ������ � ���
		
		for(int i = 0;i < operands.size();i++){
			
			if(operands.get(i).equals(" ")){
				operands.remove(i);
			}
			
			operandsDump.add(i,operands.get(i));
		}
		
		operands.clear();
	}
	
	if(src == parent.buttonRIGHTrbr){
		c++;                                                          //+1 � ���������� ����������� ������
		inputStream.add(")");
		
		
		operands1 = operands.toArray(new String[operands.size()]);    //����������� ������ � ���������� � ������� ������
		String[] operandsFinal = new String[operands.size()]; 
		
		for(int j = 0; j<operands.size(); j++){
			try{
			operandsFinal[j] = operands1[operands.size()-j-1];
			numbers = numbers+operandsFinal[j];
			}catch(IndexOutOfBoundsException e){}
		}
		
		String ans =rpn.getAnswer(numbers)+"";
		numbers = "";
		numbers = numbers+numbersDump.get(numbersDump.size()-1)+ans+"";
		
		operands.clear();                                            //����� ���������� �������� ���� ������ ����� �� �����
		
		try{
			operands.add(operandsDump.get(0));
			operandsDump.remove(0);
		}catch(IndexOutOfBoundsException e){}
		
	
		numbersDump.remove(numbersDump.size()-1);
		
	}
	
	
	//*+/-
	
	int arrI = operands.lastIndexOf(" *");
	int arrSPLIT = operands.lastIndexOf(" /");
	int arrPLUS = operands.lastIndexOf(" +");
	int arrMINUS = operands.lastIndexOf(" -");
	
	
	//����
	
	if(src == parent.buttonPLUS){
		inputStream.add("+");
	}
	
	
	if(src == parent.buttonPLUS && operands.contains(" *") && !degree.equals("^")){
		operands.remove(arrI);
		numbers= numbers+" *";
	}else if(src == parent.buttonPLUS && operands.contains(" /") && !degree.equals("^")){
		operands.remove(arrSPLIT);
		numbers= numbers+" /";
	}
	
	if(src == parent.buttonPLUS && !operands.contains(" -") && !operands.contains(" +")){ //if ��� ���������, �������, ������, ������� 
		
		numbers= numbers+" ";   
		operands.add(" +");
		
	}else if(src == parent.buttonPLUS && operands.contains(" +")){ //if ���� ���� 
		
		operands.set(arrPLUS," +");
		numbers= numbers+" + ";
		
	}else if(src == parent.buttonPLUS && operands.contains(" -")){ //if ���� ����� 
		
		operands.set(arrMINUS," +");
		numbers= numbers+" - ";		

	}
	
	
	//���������
	if(src == parent.buttonMULTIPLY){
		inputStream.add("*");
	}
	
	if(src == parent.buttonMULTIPLY && !operands.contains(" *") && !operands.contains(" /")){ //if ��� ��������� � �������
		
		operands.add(" *");
		numbers= numbers+" ";
		
	}else if(src == parent.buttonMULTIPLY && operands.contains(" *")){//if  ���� ��������� � �������
		
		operands.set(arrI," *");
		numbers= numbers+" * ";
		
	}else if(src == parent.buttonMULTIPLY && operands.contains(" /")){ //if  ���� �������
		
		operands.set(arrSPLIT," *"); //��������� ��������� ������� � ������ ����� �� ��� �����
		numbers = numbers+" / ";
		
	}
	
	//�������
	if(src == parent.buttonSPLIT){            //�������� � inputStream �������
		inputStream.add("/");
	}
	
	if(src == parent.buttonSPLIT && !operands.contains(" *") && !operands.contains(" /")){ //���� � ������� ��� ��������� � �������
		
		operands.add(" /");
		numbers= numbers+" ";
		
	}else if(src == parent.buttonSPLIT && operands.contains(" *")){//if ���� ��������� � �������
		
		operands.set(arrI," /"); //������� ��������� ��������
		numbers= numbers+" * ";  //��������� ���������
		
	}else if(src == parent.buttonSPLIT && operands.contains(" /")){ //if  ���� �������
		
		operands.set(arrSPLIT," /"); //������� ��������� ������� � ������ ����� �� ��� �����
		numbers = numbers+" / ";
		
	}
	
	//�����
	boolean coupleMinus = false;
	
	if(src == parent.buttonMINUS && !inputStream.isEmpty()){                                                                                                //��������� � imputStream ����� ���� ��� �� ������ ����
		inputStream.add("-");
	}
	
	if(src == parent.buttonMINUS && operands.contains(" *") && !inputStream.get(inputStream.size()-2).equals("*") && !coupleMinus == true && !degree.equals("^")){                 //������� ��������� ��� ������� ���� ����� �� ��������� �� ���� ����
		operands.remove(arrI);
		numbers= numbers+" *";
	}else if(src == parent.buttonMINUS && operands.contains(" /") && !inputStream.get(inputStream.size()-2).equals("/")  && !coupleMinus == true && !degree.equals("^")){
		operands.remove(arrSPLIT);
		numbers= numbers+" /";
	}
    
	
	if(src == parent.buttonMINUS && inputStream.isEmpty()){                                                                                                 //if ������ ���� ����� �� ��������� ��� � numbers
		
		inputStream.add("-");
	    numbers = numbers+"-";
	  
	}else if(src == parent.buttonMINUS && inputStream.size() > 2 && inputStream.get(inputStream.size()-2).equals("(")){                                      //if ������ ���� ����� ������ ����� �� ��������� � numbers �����
		
		numbers = numbers+"-";
		
	}else if(src == parent.buttonMINUS && degree.equals("^")){                                                      
		                                                                                                                                                      //if ���� ����������� � ������������� �������
		minusDeg = "yes";
		
	}else if((src == parent.buttonMINUS && inputStream.get(inputStream.size()-2).equals("*")) || (src == parent.buttonMINUS && inputStream.get(inputStream.size()-2).equals("/")) ||
			(src == parent.buttonMINUS && inputStream.get(inputStream.size()-2).equals("+"))){ 
		                                                                                                                                                      //if ������ ������� ����� ���������, ������� ��� ����  
		numbers =numbers+"-";
		
	}else if(src == parent.buttonMINUS && !operands.contains(" -") && !operands.contains(" +") && !coupleMinus == true){
		
		operands.add(" -");
		numbers= numbers+" ";
		
	}else if(src == parent.buttonMINUS && operands.contains(" -") && !inputStream.get(inputStream.size()-2).equals("-") && !coupleMinus == true){ //if ���� minus ������ �������
		
		operands.set(arrMINUS," -");
		numbers= numbers+" - ";
		
	}else if(src == parent.buttonMINUS && operands.contains(" +") && !inputStream.get(inputStream.size()-2).equals("-") && !coupleMinus == true){ //if ���� plus 
		
		operands.set(arrPLUS," -");
		numbers= numbers+" + ";
		
	}
	
	
	
	if(src == parent.buttonMINUS && inputStream.size()>1 && inputStream.get(inputStream.size()-2).equals("-")){ 
		coupleMinus = true;
	}
	
	if(coupleMinus == true){
		try{operands.remove(arrMINUS);
		    operands.set(operands.size()-1, " +");
		    coupleMinus = false;
		}catch(ArrayIndexOutOfBoundsException e){
			operands.clear();
			operands.add(" +");
			coupleMinus = false;
		}
	}
	
	
	//�����
		for(byte i=0;i<parent.buttonarr.length;i++ ){
			
			if(src == parent.buttonarr[i] && !degree.equals("^") && !minusDeg.equals("yes")){
				numbers = numbers+i;
				inputStream.add(""+i);
			}else if(src == parent.buttonarr[i] && degree.equals("^") && !minusDeg.equals("yes")){
				numbers = numbers+"^ "+i;
				degree = "";
				inputStream.add("^"+i);
			}else if(src == parent.buttonarr[i] && degree.equals("^") && minusDeg.equals("yes")){
				numbers = numbers+"^ -"+i;
				degree = "";
				inputStream.add("^-"+i);
				minusDeg = "";
			}
		}
		
		
		if(src == parent.buttonZERO && !degree.equals("^") && !minusDeg.equals("yes")){
			numbers = numbers+"0";
			inputStream.add("0");
		}else if(src == parent.buttonZERO && degree.equals("^") && !minusDeg.equals("yes")){
			numbers = numbers+"^ 0";
			degree = "";
			inputStream.add("^0");
		}else if(src == parent.buttonZERO && degree.equals("^") && minusDeg.equals("yes")){
			numbers = numbers+"^ -0";
			degree = "";
			inputStream.add("^-0");
			minusDeg = "";
		}
	
	
		
	//EQUAL
		
	if(src == parent.buttonEQUAL && o==c){                            //���� �������������� ������
		
       for(int j = 0; j<operandsDump.size(); j++){                    //������ ���������� �������� 
		operands.add(operandsDump.get(j));
       }
       
       String[] array1 = pat2.split(numbers);                         //����� ������ ���� 
		
		for(int b = 0; b<array1.length; b++){
		try{
			if(array1[b].equals("-") && array1[b-1].equals("-")){    //���� ��� ������ ������ �������� �� ������
		
				array1[b] ="";
				array1[b-1] ="";
				checker = true;                                      
				numbers = "";
			}
		}catch(IndexOutOfBoundsException e){}
	}	
		
		for(int b = 0; b<array1.length; b++){                         //������ numbers ��������������� ����� �������� (���� ������ ���� �������)
			if(checker != false){
				numbers = numbers+array1[b];
			}
		}
	}
	
	if(src == parent.buttonEQUAL){
	
	operands1 = operands.toArray(new String[operands.size()]);
	String[] operandsFinal = new String[operands.size()]; 
	
	for(int j = 0; j<operands.size(); j++){
		
		operandsFinal[j] = operands1[operands.size()-j-1];
		numbers = numbers+operandsFinal[j];
	}
	
	String fin = rpn.getAnswer(numbers); 
	parent.dfe.setText(fin);
	}
	
	
	System.out.println(numbers);
	//System.out.println(coupleMinus);
	
	
	//numbersDump.forEach((String value) -> System.out.println(value));
    //operands.forEach((String val) -> System.out.println("oper^"+val));
    
	}
	
}
		
