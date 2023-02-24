package Library;

import java.awt.event.*;
import java.sql.ResultSet;
import java.awt.*;
import javax.swing.*;

public class ViewBook extends JFrame{
	
	String x[]= {"Id","BookNo","BookName","Author","Publisher","Quantity","IssueBook","Date"};
	JButton bt;
	String y[][] = new String[20][8];
	int i= 0,j=0;
	JTable t;
	Font f,f1;
	
	ViewBook(){
		super("View Book");
		setLocation(1,1);
		setSize(1000,400);
		
		f = new Font("Arial",Font.BOLD,15);
		
		try {
			
			ConnectionClass obj = new ConnectionClass();
			
			String q = "select * from addbook";
			ResultSet rest = obj.stmt.executeQuery(q);
			
			while(rest.next()) {
				y[i][j++]= rest.getString("Id");
				y[i][j++]= rest.getString("BookNo");
				y[i][j++]= rest.getString("BookName");
				y[i][j++]= rest.getString("Author");
				y[i][j++]= rest.getString("Publisher");
				y[i][j++]= rest.getString("Quantity");
				y[i][j++]= rest.getString("IssueBook");
				y[i][j++]= rest.getString("Date");
				i++;
				j=0;
									
			}
			
			t= new JTable(y,x);
			t.setFont(f);
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
						
		}
		JScrollPane sp = new JScrollPane(t);
		add(sp);
		
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new ViewBook().setVisible(true);

	}

}
