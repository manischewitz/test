package calcJAVA;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.util.ArrayList;

public class calcEngine implements ActionListener{

		CALCULATOR parent;
	
	String numbers = new String(); //������ ����
	String spstr = new String(); //������
	String degree = new String();
	String minusDeg = new String();
	int o,c;
	String operDump = new String();
	
	ArrayList <String> inputStream = new ArrayList<String>(); //����
    ArrayList<String> first = new ArrayList<String>();
	String[] first1 = {}; 
	
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
	
	if(src == parent.buttonLEFTrbr && !spstr.equals("open")){
		o++;
		spstr = "open";
		numbers = numbers+"";
		inputStream.add("(");
	}else if(src == parent.buttonLEFTrbr && spstr.equals("open")){
		o++;
		spstr ="close";
		inputStream.add("(");
		numbers = numbers+"";
		for(int i = 0; i < operands.size(); i++){
			operDump = operDump+operands.get(i);
		}
		operands.clear();
	}
	
	if(src == parent.buttonRIGHTrbr && spstr.equals("open")){
		c++;
		numbers = numbers+"";
		spstr = "close";
		inputStream.add(")");
		first1 = first.toArray(new String[first.size()]); //��������� arrList � ������������
		String[] firstreverse = new String[first1.length];
		
		for(byte i = 0; i < first1.length; i++){
		   firstreverse[i] = first1[first1.length-i-1];
		   numbers= numbers+firstreverse[i];
		}
		for(byte i = 0; i < first.size(); i++){
			first.remove(i);
		}
	}else if(src == parent.buttonRIGHTrbr && spstr.equals("close")){
		c++;
		numbers = numbers+"";
		spstr = "open";
		inputStream.add(")");
		first1 = operands.toArray(new String[operands.size()]); //��������� arrList � ������������
		String[] firstreverse = new String[first1.length];
		
		for(byte i = 0; i < first1.length; i++){
		   firstreverse[i] = first1[first1.length-i-1];
		   numbers= numbers+firstreverse[i];
		}
		for(byte i = 0; i < operands.size(); i++){
			operands.remove(i);
		}
	}
	
	//*+/-
	
	int arrI = operands.lastIndexOf(" *");
	int arrSPLIT = operands.lastIndexOf(" /");
	int arr4OPENBRACES = first.lastIndexOf(" *");
	int arr4SPLITBRACES = first.lastIndexOf(" /");
	int arrPLUS = operands.lastIndexOf(" +");
	int arrMINUS = operands.lastIndexOf(" -");
	int arrPLUSBraces = first.lastIndexOf(" +");
	int arrMINUSBraces = first.lastIndexOf(" -");
	
	//����
	
	if(src == parent.buttonPLUS){
		inputStream.add("+");
	}
	
	
	if(src == parent.buttonPLUS && !spstr.equals("open") && operands.contains(" *")){
		operands.remove(arrI);
		numbers= numbers+" *";
	}else if(src == parent.buttonPLUS && !spstr.equals("open") && operands.contains(" /")){
		operands.remove(arrSPLIT);
		numbers= numbers+" /";
	}else if(src == parent.buttonPLUS && spstr.equals("open") && first.contains(" *")){
		first.remove(arr4OPENBRACES);
		numbers= numbers+" /";
	}else if(src == parent.buttonPLUS && spstr.equals("open") && first.contains(" /")){
		first.remove(arr4SPLITBRACES);
		numbers= numbers+" /";
	}
	
	
	if(src == parent.buttonPLUS && !spstr.equals("open") && !operands.contains(" -") && !operands.contains(" +")){ //if ��� ���������, �������, ������, ������� ������ �������
		
		numbers= numbers+" ";   
		operands.add(" +");
		
	}else if(src == parent.buttonPLUS && !spstr.equals("open") && operands.contains(" +")){ //if ���� ���� ������ �������
		
		operands.set(arrPLUS," +");
		numbers= numbers+" + ";
		
	}else if(src == parent.buttonPLUS && !spstr.equals("open") && operands.contains(" -")){ //if ���� ����� ������ �������
		
		operands.set(arrMINUS," +");
		numbers= numbers+" - ";		

	}else if(src == parent.buttonPLUS && spstr.equals("open") && !first.contains(" -") && !first.contains(" +")){
		
		first.add(" +");
		numbers= numbers+" ";
		
	}else if(src == parent.buttonPLUS && spstr.equals("open") && first.contains(" +")){
		
		first.set(arrPLUSBraces," +");
		numbers= numbers+" + ";
		
	}else if(src == parent.buttonPLUS && spstr.equals("open") && first.contains(" -")){
		
		first.set(arrMINUSBraces," +");
		numbers= numbers+" - ";
		
	}
	
	
	//���������
	if(src == parent.buttonMULTIPLY){
		inputStream.add("*");
	}
	
	if(src == parent.buttonMULTIPLY && !spstr.equals("open") && !operands.contains(" *") && !operands.contains(" /")){ //if ������ ������� ��� ��������� � �������
		
		operands.add(" *");
		numbers= numbers+" ";
		
	}else if(src == parent.buttonMULTIPLY && !spstr.equals("open") && operands.contains(" *")){//if ������ ������� ���� ��������� � �������
		
		operands.set(arrI," *");
		numbers= numbers+" * ";
		
	}else if(src == parent.buttonMULTIPLY && !spstr.equals("open") && operands.contains(" /")){ //if ������ ������� ���� �������
		
		operands.set(arrSPLIT," *"); //��������� ��������� ������� � ������ ����� �� ��� �����
		numbers = numbers+" / ";
		
	}else if(src == parent.buttonMULTIPLY && spstr.equals("open") && !first.contains(" *") && !operands.contains(" /")){//if ������ ������� � ������� ������ ���
		
		first.add(" *");
		numbers= numbers+" ";
		
	}else if(src == parent.buttonMULTIPLY && spstr.equals("open") && first.contains(" *")){
		
		first.set(arr4OPENBRACES," *");
        numbers = numbers+" * ";
        
	}else if(src == parent.buttonMULTIPLY && spstr.equals("open") && first.contains(" /")){
		
		first.set(arr4SPLITBRACES, " *");
		numbers = numbers+" / ";
	}
	
	//�������
	if(src == parent.buttonSPLIT){            //�������� � inputStream �������
		inputStream.add("/");
	}
	
	if(src == parent.buttonSPLIT && !spstr.equals("open") && !operands.contains(" *") && !operands.contains(" /")){ //���� � ������� ��� ��������� � �������
		
		operands.add(" /");
		numbers= numbers+" ";
		
	}else if(src == parent.buttonSPLIT && !spstr.equals("open") && operands.contains(" *")){//if ������ ������� ���� ��������� � �������
		
		operands.set(arrI," /"); //������� ��������� ��������
		numbers= numbers+" * ";  //��������� ���������
		
	}else if(src == parent.buttonSPLIT && !spstr.equals("open") && operands.contains(" /")){ //if ������ ������� ���� �������
		
		operands.set(arrSPLIT," /"); //������� ��������� ������� � ������ ����� �� ��� �����
		numbers = numbers+" / ";
		
	}else if(src == parent.buttonSPLIT && spstr.equals("open") && !first.contains(" *") && !operands.contains(" /")){  //���� � ������� ��� �������,��������� ������ �������
		
		first.add(" /");
		numbers= numbers+" ";
		
	}else if(src == parent.buttonSPLIT && spstr.equals("open") && first.contains(" *")){
		
		first.set(arr4OPENBRACES," /");
		numbers= numbers+" * ";
		
	}else if(src == parent.buttonSPLIT && spstr.equals("open") && first.contains(" /")){
		
		first.set(arr4SPLITBRACES," /");
		numbers= numbers+" / ";
	}
	
	//�����
	boolean coupleMinus = false;
	boolean coupleMinus4braces = false;
	
	
	if(src == parent.buttonMINUS && !inputStream.isEmpty()){                                                                                                //��������� � imputStream ����� ���� ��� �� ������ ����
		inputStream.add("-");
	}
	
	if(src == parent.buttonMINUS && !spstr.equals("open") && operands.contains(" *") && !coupleMinus == true){
		operands.remove(arrI);
		numbers= numbers+" *";
	}else if(src == parent.buttonMINUS && !spstr.equals("open") && operands.contains(" /") && !coupleMinus == true){
		operands.remove(arrSPLIT);
		numbers= numbers+" /";
	}else if(src == parent.buttonMINUS && spstr.equals("open") && first.contains(" *") && !coupleMinus == true){
		operands.remove(arr4OPENBRACES);
		numbers= numbers+" *";
	}else if(src == parent.buttonMINUS && spstr.equals("open") && first.contains(" /") && !coupleMinus == true){
		operands.remove(arr4SPLITBRACES);
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
		System.out.println("wed");
	}else if((src == parent.buttonMINUS && inputStream.get(inputStream.size()-2).equals("*")) || (src == parent.buttonMINUS && inputStream.get(inputStream.size()-2).equals("/")) ||
			(src == parent.buttonMINUS && inputStream.get(inputStream.size()-2).equals("+"))){ 
		                                                                                                                                                      //if ������ ������� ����� ���������, ������� ��� ����  
		numbers =numbers+"-";
		
	}else if(src == parent.buttonMINUS && !spstr.equals("open") && !operands.contains(" -") && !operands.contains(" +") && !coupleMinus == true){
		
		operands.add(" -");
		numbers= numbers+" ";
		
	}else if(src == parent.buttonMINUS && !spstr.equals("open") && operands.contains(" -") && !inputStream.get(inputStream.size()-2).equals("-") && !coupleMinus == true){ //if ���� minus ������ �������
		
		operands.set(arrMINUS," -");
		numbers= numbers+" - ";
		
	}else if(src == parent.buttonMINUS && !spstr.equals("open") && operands.contains(" +") && !inputStream.get(inputStream.size()-2).equals("-") && !coupleMinus == true){ //if ���� plus ������ �������
		
		operands.set(arrPLUS," -");
		numbers= numbers+" + ";
		
	}else if(src == parent.buttonMINUS && spstr.equals("open") && !first.contains(" -") && !first.contains(" +") && !coupleMinus4braces == true){
		
		first.add(" -");
		numbers= numbers+" ";
		
	}else if(src == parent.buttonMINUS && spstr.equals("open") && first.contains(" -") && !coupleMinus4braces == true){
		
		first.set(arrMINUSBraces," -");
		numbers= numbers+" - ";
		
	}else if(src == parent.buttonMINUS && spstr.equals("open") && first.contains(" +") && !coupleMinus4braces == true){
		
		first.set(arrPLUSBraces," -");
		numbers= numbers+" + ";
		
	}
	
	
	
	if(src == parent.buttonMINUS && inputStream.size()>1 && inputStream.get(inputStream.size()-2).equals("-") && !spstr.equals("open")){ 
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
	
	if(src == parent.buttonMINUS && inputStream.size()>2 && inputStream.get(inputStream.size()-2).equals("-") && spstr.equals("open")){
		coupleMinus4braces = true;
	}
	
	if(coupleMinus4braces == true){
		first.remove(operands.size()-1);
		first.set(operands.size()-1, " +");
		coupleMinus4braces = false;
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
	
	if(!operDump.isEmpty() && operands.isEmpty() && o==c){
		numbers = numbers+operDump;
	}
	
	if(src == parent.buttonEQUAL){
	parent.dfe.setText(displaytextfield+"");
		
	operands1 = operands.toArray(new String[operands.size()]);
	String[] operandsFinal = new String[operands.size()]; 
	
	for(int j = 0; j<operands.size(); j++){
		
		operandsFinal[j] = operands1[operands.size()-j-1];
		numbers = numbers+operandsFinal[j];
	}
	}
	
	
	System.out.println(numbers);
	//System.out.println(coupleMinus);
	
	
	//inputStream.forEach((String value) -> System.out.println(value));
    operands.forEach((String val) -> System.out.println("oper^"+val));
	}
	
}
		
