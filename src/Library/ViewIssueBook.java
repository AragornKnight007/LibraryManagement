package Library;

import java.awt.event.*;
import java.sql.ResultSet;
import java.awt.*;
import javax.swing.*;

public class ViewIssueBook extends JFrame {
	String x[]= {"BookId","BookNo","BookName","StudentId","StudentName","StudentContact","Date"};
	JButton bt;
	String y[][] = new String[20][7];
	int i= 0,j=0;
	JTable t;
	Font f,f1;
	ViewIssueBook(){
		super("View Issue Book");
		setLocation(1,1);
		setSize(1000,400);
		
		f = new Font("Arial",Font.BOLD,15);
		
		try {
			
			ConnectionClass obj = new ConnectionClass();
			
			String q = "select * from issuebook";
			ResultSet rest = obj.stmt.executeQuery(q);
			
			while(rest.next()) {
				y[i][j++]= rest.getString("BookId");
				y[i][j++]= rest.getString("BookNo");
				y[i][j++]= rest.getString("BookName");
				y[i][j++]= rest.getString("StudentId");
				y[i][j++]= rest.getString("StudentName");
				y[i][j++]= rest.getString("StudentContact");
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
		
		new ViewIssueBook().setVisible(true);

	}
}
