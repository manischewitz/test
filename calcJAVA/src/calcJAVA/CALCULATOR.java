package calcJAVA;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class CALCULATOR {
	
	
	// загрузка в память кнопок +-итд
		JButton buttonMINUS = new JButton("-");
		JButton buttonPLUS = new JButton("+");
		JButton buttonMULTIPLY = new JButton("*");
		JButton buttonSPLIT = new JButton("/");
		JButton buttonDEGREE = new JButton("^");
		JButton buttonLEFTrbr = new JButton("(");
		JButton buttonRIGHTrbr = new JButton(")");
		JButton buttonZERO = new JButton("0");
		JButton buttonPI = new JButton("П");
		JButton buttonSQRT = new JButton("sqrt");
		JButton buttonCOS = new JButton("COS");
		JButton buttonTAN = new JButton("TAN");
		JButton buttonSIN = new JButton("SIN");
        JButton buttonLOG = new JButton("log");
		JButton buttonCANCEL = new JButton("Del");
		JButton buttonDOT = new JButton(".");
		JButton buttonEQUAL = new JButton("=");
	    
	JTextField dfe = new JTextField(30); //создаём поле для текста
	calcEngine calcMirror = new calcEngine(this);

	JButton[] buttonarr = new JButton[10]; 

	CALCULATOR(){

    JPanel newPanel = new JPanel();
	BorderLayout bl = new BorderLayout();
	newPanel.setLayout(bl); //задаём BorderLayout как основной для newPanel
	
    newPanel.add("North", dfe); //помещаем поле для текста на север
	
	
    //цифры 

	JPanel Panel4Grid = new JPanel(); 
	GridLayout gl = new GridLayout(5,5);
	Panel4Grid.setLayout(gl);
	
	for(byte i = 1;i<=9;i++){
		buttonarr[i]=new JButton(); 
        buttonarr[i].setText(""+i);
		Panel4Grid.add(buttonarr[i]);
		buttonarr[i].addActionListener(calcMirror);
		
	}
	
	newPanel.add("Center", Panel4Grid);
	Panel4Grid.add(buttonZERO);
	buttonZERO.addActionListener(calcMirror);
	
	//действия
	JPanel operands = new JPanel();
	GridLayout gl4operand = new GridLayout(5,1);
	operands.setLayout(gl4operand);
	
	operands.add(buttonMULTIPLY);
	operands.add(buttonSPLIT);
	operands.add(buttonPLUS);
	operands.add(buttonMINUS);
	operands.add(buttonDEGREE);
	
	buttonMULTIPLY.addActionListener(calcMirror);
	buttonSPLIT.addActionListener(calcMirror);
	buttonPLUS.addActionListener(calcMirror);
	buttonDEGREE.addActionListener(calcMirror);
	buttonMINUS.addActionListener(calcMirror);
	
	
	newPanel.add("East",operands);
	
	//info поле
	/*
	JTextField info = new JTextField(30);
	newPanel.add("South",info);
	*/
	//СКОБКА
	JPanel zero = new JPanel();
	GridLayout glZERO = new GridLayout(3,3);
	zero.setLayout(glZERO);
	
	zero.add(buttonLEFTrbr);
	zero.add(buttonRIGHTrbr);
	zero.add(buttonPI);
	zero.add(buttonCOS);
	zero.add(buttonSIN);
	zero.add(buttonTAN);
	zero.add(buttonSQRT);
	zero.add(buttonLOG);
	zero.add(buttonCANCEL);
    zero.add(buttonDOT);
    zero.add(buttonEQUAL);
	
    buttonLEFTrbr.addActionListener(calcMirror);
    buttonRIGHTrbr.addActionListener(calcMirror);
    buttonPI.addActionListener(calcMirror);
    buttonCOS.addActionListener(calcMirror);
    buttonSIN.addActionListener(calcMirror);
    buttonTAN.addActionListener(calcMirror);
    buttonSQRT.addActionListener(calcMirror);
    buttonLOG.addActionListener(calcMirror);
    buttonDOT.addActionListener(calcMirror);
    buttonEQUAL.addActionListener(calcMirror);
    
	newPanel.add("South",zero);
	
	//фрейм
	JFrame JFmain = new JFrame("Calculator");
	JFmain.setContentPane(newPanel);
	
	

	JFmain.pack();
	
	JFmain.setVisible(true);
	
	
	
	
	
	
	
	
	
	}
	}
