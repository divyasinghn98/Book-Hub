package minip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Mainp implements ActionListener
{  
	JFrame f = new JFrame("Main Page");
	JPanel panel=new JPanel();
	JPanel panel_1 = new JPanel();
	Database db;
	Bookl B;
	JButton btnAuthor,btnTitle;
	JComboBox comboBox1,comboBox2;
	
	Mainp() 
	{   f.getContentPane().setBackground(new Color(255, 204, 255));
        f.setSize(1380,750);
        f.getContentPane().setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		btnAuthor = new JButton("AUTHOR");
		btnAuthor.setIcon(new ImageIcon(Mainp.class.getResource("/minip/Images/a.png")));
		btnAuthor.setFont(new Font("Arial", Font.PLAIN, 15));
		btnAuthor.setBounds(287, 150, 156, 57);
		f.getContentPane().add(btnAuthor);
		
		btnTitle = new JButton("TYPE");
		btnTitle.setIcon(new ImageIcon(Mainp.class.getResource("/minip/Images/t.png")));
		btnTitle.setFont(new Font("Arial", Font.PLAIN, 15));
		btnTitle.setBounds(858, 150, 149, 57);
		f.getContentPane().add(btnTitle);
		
		JLabel lblSearchBookBy = new JLabel("Search Book by ---");
		lblSearchBookBy.setBounds(555, 72, 232, 44);
		f.getContentPane().add(lblSearchBookBy);
		lblSearchBookBy.setFont(new Font("Monotype Corsiva", Font.ITALIC, 25));
		lblSearchBookBy.setForeground(new Color(102, 0, 102));
		
		btnAuthor.addActionListener(this);
		btnTitle.addActionListener(this);
	    
	}
	
	 public void actionPerformed(ActionEvent e)
	 { db=new Database();
	  
		  if(e.getSource()==btnAuthor)
	      {   panel.setVisible(false);
			  panel_1 = new JPanel();
			  panel_1.setBounds(400,300,500,300);
			  f.getContentPane().add(panel_1);
			  panel_1.setBackground(new Color(204, 204, 255));
			  panel_1.setLayout(null); 
			  comboBox1 = new JComboBox(db.author());
		      comboBox1.setBounds(150, 32, 186, 20);
		      panel_1.add(comboBox1);
		      comboBox1.addActionListener(new ActionListener() 
		      { public void actionPerformed(ActionEvent e) 
		           { String[] newa = new String[100];
		    	     String cont=(String) comboBox1.getSelectedItem(); 
		             f.setVisible(false);
		             newa=db.itema(cont);
		             B=new Bookl(newa); } } );           
	      }
		  
		  if(e.getSource()==btnTitle)
	      {   panel_1.setVisible(false);
			  panel = new JPanel();
			  panel.setBounds(400,300,500,300);
			  f.getContentPane().add(panel);
			  panel.setBackground(new Color(204, 204, 255));
			  panel.setLayout(null);
			  comboBox2 = new JComboBox(db.books());
		      comboBox2.setBounds(150, 32, 186, 20);
		      panel.add(comboBox2);
		      comboBox2.addActionListener(new ActionListener() 
		      { public void actionPerformed(ActionEvent e) 
		           { String[] newa=new String[100];
		    	     String cont=(String) comboBox2.getSelectedItem(); 
		             f.setVisible(false);
		             newa=db.itemt(cont);
		             B=new Bookl(newa); } } );  

	      }
	  }
}
