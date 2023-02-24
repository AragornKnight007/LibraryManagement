package Library;
import java.awt.event.*;
import java.sql.ResultSet;
import java.awt.*;
import javax.swing.*;
public class ViewLibrarian extends JFrame{

	String x[]= {"Id","Name","Email","Contact","Address","City"};
	JButton bt;
	String y[][] = new String[20][6];
	int i= 0,j=0;
	JTable t;
	Font f,f1;
	
	ViewLibrarian(){
		
		super("Librarian Information");
		setLocation(1,1);
		setSize(1000,400);
		
		f = new Font("Arial",Font.BOLD,15);
		
		try {
			
			ConnectionClass obj = new ConnectionClass();
			
			String q = "select * from librarian";
			ResultSet rest = obj.stmt.executeQuery(q);
			
			while(rest.next()) {
				y[i][j++]= rest.getString("Lid");
				y[i][j++]= rest.getString("Name");
				y[i][j++]= rest.getString("Email");
				y[i][j++]= rest.getString("Contact");
				y[i][j++]= rest.getString("Address");
				y[i][j++]= rest.getString("City");
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
		
		new ViewLibrarian().setVisible(true);

	}


}
