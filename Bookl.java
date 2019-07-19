package minip;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Bookl implements ActionListener
{ JFrame f = new JFrame("Book Selection");
  JLabel l1;
  JComboBox comboBox;
  Database db;
  Display D;

	public Bookl(String[] cont) 
	{ f.getContentPane().setBackground(new Color(255, 204, 255));
 f.setSize(1380,750);
      f.getContentPane().setLayout(null);
      f.setVisible(true);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
      l1=new JLabel("List of Books--");
      l1.setFont(new Font("Monotype Corsiva", Font.ITALIC, 25));
	  l1.setForeground(new Color(128, 0, 128));
	  l1.setBounds(363, 76, 166, 31);
	  f.getContentPane().add(l1);
	  
	  comboBox= new JComboBox(cont);
      comboBox.setBounds(264,167, 350, 20);
      f.getContentPane().add(comboBox);
      
      JLabel label = new JLabel("");
      label.setIcon(new ImageIcon(Bookl.class.getResource("/minip/Images/b.png")));
      label.setBounds(673, 72, 540, 512);
      f.getContentPane().add(label);
      comboBox.addActionListener(this);
  
	}
	
 	 public void actionPerformed(ActionEvent e)
	 { db=new Database();                      
	   String abc=(String) comboBox.getSelectedItem(); 
       f.setVisible(false);
       String[] inf =new String[200];
       inf=db.getinfo(abc);
       D=new Display(inf);
       
     }
}		
		
	