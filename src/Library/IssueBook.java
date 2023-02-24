package Library;

import java.awt.event.*;
import java.sql.ResultSet;
import java.awt.*;
import javax.swing.*;

public class IssueBook  extends JFrame implements ActionListener{



	JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	JButton bt1,bt2;
	JPanel p1,p2;
	Font f,f1;
	Choice ch;
	JTextField tf1,tf2,tf3,tf4,tf5,tf6;
	
	IssueBook(){
		super("Issue Book");
		setLocation(0,0);
		setSize(650,400);
		
		f = new Font("Arial",Font.BOLD,25);
		f1 = new Font("Arial",Font.BOLD,20);
		
		l1 = new JLabel("Issue Book");
		l2 = new JLabel("Book Id");
		l3 = new JLabel("Book No");
		l4 = new JLabel("Book Name");
		l5 = new JLabel("Student Id");
		l6 = new JLabel("Student Name");
		l7 = new JLabel("Student Contact");
		l8 = new JLabel("Book Quantity");
		
		l1.setForeground(Color.WHITE);
		l1.setHorizontalAlignment(JLabel.CENTER);
		
		tf1 = new JTextField();
		tf2 = new JTextField();
		tf3 = new JTextField();
		tf4 = new JTextField();
		tf5 = new JTextField();
		tf6 = new JTextField();
		
		bt1 =new JButton("Issue Book");
		bt2 =new JButton("Cancel");
		
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		
		l1.setFont(f);
		l2.setFont(f1);
		l3.setFont(f1);
		l4.setFont(f1);
		l5.setFont(f1);
		l6.setFont(f1);
		l7.setFont(f1);
		l8.setFont(f1);
		
		tf1.setFont(f1);
		tf1.setEditable(false);
		tf1.setForeground(Color.RED);
		tf2.setFont(f1);
		tf2.setEditable(false);
		tf3.setForeground(Color.RED);
		tf3.setFont(f1);
		
		tf4.setFont(f1);
		tf5.setFont(f1);
		tf6.setFont(f1);
		tf6.setEditable(false);
		tf6.setForeground(Color.RED);
		
		
		bt1.setFont(f1);
		bt2.setFont(f1);
		
		ch=new Choice();
		
		try {
			
			ConnectionClass obj = new ConnectionClass();
			String q = "Select Id from addbook";
			ResultSet rest= obj.stmt.executeQuery(q);
			
			while(rest.next()) {
				ch.add(rest.getString("Id"));
			}
			
					
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		ch.setFont(f1);
		p1 = new JPanel();
		p1.setLayout(new GridLayout(1,1,10,10));
		
		p1.add(l1);
		p1.setBackground(Color.BLUE); 
		
		p2 = new JPanel();
		p2.setLayout(new GridLayout(8,2,10,10));
		
		p2.add(l2);
		p2.add(ch);
		p2.add(l3);
		p2.add(tf1);
		p2.add(l4);
		p2.add(tf2);
		p2.add(l5);
		p2.add(tf3);
		p2.add(l6);
		p2.add(tf4);
		p2.add(l7);
		p2.add(tf5);
		p2.add(l8);
		p2.add(tf6);
		p2.add(bt1);
		p2.add(bt2);
		
		
		setLayout(new BorderLayout(10,10));
		add(p1,"North");
		add(p2,"Center");
		
		ch.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					ConnectionClass obj1 = new ConnectionClass();
					int id = Integer.parseInt(ch.getSelectedItem());
					String qi = "select * from addbook where Id='"+id+"'";
					ResultSet rest = obj1.stmt.executeQuery(qi);
					
					while(rest.next()) {
						
						tf1.setText(rest.getString("BookNo"));
						tf2.setText(rest.getString("BookName"));
						tf6.setText(rest.getString("Quantity"));
						
					}
					
					
				}catch(Exception ex){
					ex.printStackTrace();
				}
				
				
			}
			
			
			
		});
		
		
		
		
		
		
		
		
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==bt1) {
			int qnt=0;
			int Id = Integer.parseInt(ch.getSelectedItem());
			String BookNo=tf1.getText();
			String BookName=tf2.getText();
			int StuId = Integer.parseInt(tf3.getText());
			String StuName=tf4.getText();
			String StuCont=tf5.getText();
			String Date=new java.util.Date().toString();
			try {
				ConnectionClass obj3 = new ConnectionClass();
				
				String q1 = "select Quantity from addbook where Id='"+Id+"'";
				ResultSet rest0 = obj3.stmt.executeQuery(q1);
			
				while(rest0.next()) {
					qnt = Integer.parseInt(rest0.getString("Quantity"));
										
				}
				if(qnt<=0) {
					
					JOptionPane.showMessageDialog(null,"Book Quantity Is Less !!");
					this.setVisible(false);
				}
				else {
					
					String q2="Insert into issuebook(BookId,BookNo,BookName,StudentId,StudentName,StudentContact,Date) values('"+Id+"','"+BookNo+"','"+BookName+"','"+StuId+"','"+StuName+"','"+StuCont+"','"+Date+"')";
					String q3="update addbook set IssueBook=IssueBook+1 where Id='"+Id+"'";
					String q4="update addbook set Quantity=Quantity-1 where Id='"+Id+"'";
					int a1=obj3.stmt.executeUpdate(q2);					
					int a2=obj3.stmt.executeUpdate(q3);					
					int a3=obj3.stmt.executeUpdate(q4);	
					
					if(a1==1) {
						
						if(a2==1) {
							
							if(a3==1) {
								
								JOptionPane.showMessageDialog(null,"Your Data Successfully Update");
								this.setVisible(false);
									
								}
							else {
								JOptionPane.showMessageDialog(null,"Plese,Fill All Details CareFully");
								
							}
							
						}
						else {
							JOptionPane.showMessageDialog(null,"Plese,Fill All Details CareFully");
							
						}
						
					}
					else {
						JOptionPane.showMessageDialog(null,"Plese,Fill All Details CareFully");
						
					}
					
					
					
					
				}
				
				
			}catch(Exception ex){
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
		
		new IssueBook().setVisible(true);

	}

}
