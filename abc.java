package minip;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class abc implements ActionListener
{ JFrame f = new JFrame("Welcome");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try { abc a = new abc(); } 
				catch (Exception e) { e.printStackTrace(); }
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public abc() 
	{ 
	   f.getContentPane().setBackground(Color.WHITE);
	   f.setSize(1380,750);
	   f.getContentPane().setLayout(null);
	   f.setVisible(true);
	   f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("images/main.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(abc.class.getResource("/minip/Images/main.png")));
		lblNewLabel.setBounds(344, 97, 762, 515);
		f.getContentPane().add(lblNewLabel);
		
		JButton btnGo = new JButton("CONTINUE");
		btnGo.setFont(new Font("Arial", Font.PLAIN, 15));
		btnGo.setIcon(new ImageIcon(abc.class.getResource("/minip/Images/lo.png")));
		btnGo.setBackground(new Color(204, 255, 255));
		btnGo.setBounds(633, 566, 185, 48);
		f.getContentPane().add(btnGo);
		
		 
		   btnGo.addActionListener(this);
	   }
		   
	   public void actionPerformed(ActionEvent e)
	   {   f.setVisible(false);
		   new Login();
	   }

}
