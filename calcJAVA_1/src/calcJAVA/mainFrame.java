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
		//�������� ������

		JPanel windowSContent = new JPanel();
		
		//��� ����������� ��� ������
		
		//������������ �� ��� ������(X) ��� �������(Y)
		
		/*JPanel boxl = new JPanel();
		BoxLayout boxlay = new BoxLayout(boxl, BoxLayout.Y_AXIS);
		boxl.setLayout(boxlay);*/
		
		//���������� �� ��������
		/*BorderLayout bl = new BorderLayout();
		windowSContent.setLayout(bl);
		JTextField textF = new JTextField(200);
		windowSContent.add("North", textF);
		windowSContent.add("South", textF);*/
		
		//��� �������
		/*GridLayout newGL = new GridLayout(9,6,5,5);
		windowSContent.setLayout(newGL);*/
		
		//���������� �����������
		/*FlowLayout somename = new FlowLayout();
		windowSContent.setLayout(somename);*/
		
		//������ ���������� � ������
		
		JLabel lab1 =  new JLabel("����� 1:");
		JTextField TEXTf1 = new JTextField(9);
		JLabel lab2 = new JLabel("����� 2:");
		JTextField TEXTf2 = new JTextField(9);
		JLabel lab3 = new JLabel("���������:");
		JTextField TEXTf3 = new JTextField(9);
		JButton button1 = new JButton("Show");
		
		//��������� ���������� �� ������
		
		windowSContent.add(lab1);
		windowSContent.add(TEXTf1);
		windowSContent.add(lab2);
		windowSContent.add(TEXTf2);
		windowSContent.add(lab3);
		windowSContent.add(TEXTf3);
		windowSContent.add(button1);
		
		//�������� ������ ����(������)
		
		JFrame mainframe = new JFrame("CALC");
		mainframe.setContentPane(windowSContent);
		
		//������ ������ � ������ ���� �������
		
	    mainframe.setSize(274,293);
	    mainframe.setVisible(true);
		
		
		
		
		
		
	}

}
