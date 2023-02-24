package Library;

import java.awt.event.*;
import java.sql.ResultSet;
import java.awt.*;
import javax.swing.*;

public class ReturnBook extends JFrame implements ActionListener{

	JPanel p1,p2;
	JLabel l1,l2,l3;
	JTextField tf1,tf2;
	JButton bt1,bt2;
	Font f,f1;
	
	
	ReturnBook(){
		
		super("Return Book");
		setLocation(0,0);
		setSize(800,250);
		
		f = new Font("Arial",Font.BOLD,25);
		f1 = new Font("Arial",Font.BOLD,20);
		
		l1 = new JLabel("Return Book");
		l2 = new JLabel("Book No");
		l3 = new JLabel("Student Id");
		
		l1.setForeground(Color.WHITE);
		l1.setHorizontalAlignment(JLabel.CENTER);
		
		tf1 = new JTextField();
		tf2 = new JTextField();
		
		bt1 =new JButton("Return Book");
		bt2 =new JButton("Cancel");
		
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		
		l1.setFont(f);
		l2.setFont(f1);
		l3.setFont(f1);
		
		tf1.setFont(f1);
		tf2.setFont(f1);
		bt1.setFont(f1);
		bt2.setFont(f1);
		
		
		p1 = new JPanel();
		p1.setLayout(new GridLayout(1,1,10,10));
		
		p1.add(l1);
		p1.setBackground(Color.BLUE); 
		
		p2 = new JPanel();
		p2.setLayout(new GridLayout(3,2,10,10));
		p2.add(l2);
		p2.add(tf1);
		p2.add(l3);
		p2.add(tf2);
		p2.add(bt1);
		p2.add(bt2);
		
		setLayout(new BorderLayout(10,10));
		add(p1,"North");
		add(p2,"Center");
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String BookNo = tf1.getText();
		String StuId = tf2.getText();
		
		if(e.getSource()==bt1) {
			
			try {
				
				ConnectionClass obj = new ConnectionClass();
				String q ="delete from issuebook where BookNo='"+BookNo+"'and StudentId='"+StuId+"'" ;
				   int res =obj.stmt.executeUpdate(q);
				   if(res==0){
					   
					   JOptionPane.showMessageDialog(null,"Book Did Not Issue");
					   this.setVisible(false);
					   
				   }
				   else {
					   String q1="update addbook set IssueBook=IssueBook-1 where BookNo='"+BookNo+"'";
						String q2="update addbook set Quantity=Quantity+1 where BookNo='"+BookNo+"'";
						int a1=obj.stmt.executeUpdate(q1);					
						int a2=obj.stmt.executeUpdate(q2);	
						
						
						if(a1==1) {
							
							if(a2==1) {
								JOptionPane.showMessageDialog(null,"Book Is Successfully Updated");
								  this.setVisible(false);
								
							}else {
								JOptionPane.showMessageDialog(null,"Please Fill All Details Carefully");

							}
							
							
						}else {
							JOptionPane.showMessageDialog(null,"Please Fill All Details Carefully");

						}				
						
					   
				   }
				
				
				
			}
			catch(Exception ex) {
				
				ex.printStackTrace();
			}
			
			
			
		}
		if(e.getSource()==bt2) {
		
			JOptionPane.showMessageDialog(null,"Are You Sure !");
			this.setVisible(false);
		}
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		new ReturnBook().setVisible(true);

	}
}
