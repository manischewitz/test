package calcJAVA;
import javax.swing.*;
//import javax.swing.JFrame;
//import javax.swing.JButton;
import java.util.regex.*;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;

public class mainFrame {

	public static void main(String[] args) {
		//создание панели

		JPanel windowSContent = new JPanel();
		
		//тип отображения для панели
		
		//расположение по оси аБцисс(X) или ординат(Y)
		
		/*JPanel boxl = new JPanel();
		BoxLayout boxlay = new BoxLayout(boxl, BoxLayout.Y_AXIS);
		boxl.setLayout(boxlay);*/
		
		//разделённое по областям
		/*BorderLayout bl = new BorderLayout();
		windowSContent.setLayout(bl);
		JTextField textF = new JTextField(200);
		windowSContent.add("North", textF);
		windowSContent.add("South", textF);*/
		
		//как матрица
		/*GridLayout newGL = new GridLayout(9,6,5,5);
		windowSContent.setLayout(newGL);*/
		
		//Построчное итображение
		/*FlowLayout somename = new FlowLayout();
		windowSContent.setLayout(somename);*/
		
		//создаём компоненты в памяти
		
		JLabel lab1 =  new JLabel("Число 1:");
		JTextField TEXTf1 = new JTextField(9);
		JLabel lab2 = new JLabel("Число 2:");
		JTextField TEXTf2 = new JTextField(9);
		JLabel lab3 = new JLabel("Результат:");
		JTextField TEXTf3 = new JTextField(9);
		JButton button1 = new JButton("Show");
		
		//добавляем компоненты на панель
		
		windowSContent.add(lab1);
		windowSContent.add(TEXTf1);
		windowSContent.add(lab2);
		windowSContent.add(TEXTf2);
		windowSContent.add(lab3);
		windowSContent.add(TEXTf3);
		windowSContent.add(button1);
		
		//Создание самого окна(фрейма)
		
		JFrame mainframe = new JFrame("CALC");
		mainframe.setContentPane(windowSContent);
		
		//задайм размер и делаем окно видимым
		
	    mainframe.setSize(274,293);
	    mainframe.setVisible(true);
		
		
		
		
		
		
	}

}
