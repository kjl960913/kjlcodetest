package controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import boundary.MyPanel;

public class Selectbeforelogin {
	
	
	JFrame frame=new JFrame("Welcome to Bank System! ");
	JPanel contentPane=new MyPanel();
	  String figure;  
	    public void choosefigure() {  
	        JLabel figureLabel = new JLabel("Please select tour attempt!");  
	        figureLabel.setBounds(20, 290, 50, 20);  
	        JRadioButton adminRadioButton = new JRadioButton("Customer Login");  
	        adminRadioButton.setBounds(70, 290, 100, 20);  
	        adminRadioButton.setSelected(true);  
	        adminRadioButton.addActionListener(new ActionListener() {  
	            public void actionPerformed(ActionEvent e) {  
	  
	                if (adminRadioButton.isSelected()) {  
	                    figure = adminRadioButton.getText(); 
	                    System.out.println(figure);
	                    try {
							UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
						} catch (ClassNotFoundException e1) {
							
							e1.printStackTrace();
						} catch (InstantiationException e1) {
							
							e1.printStackTrace();
						} catch (IllegalAccessException e1) {
							
							e1.printStackTrace();
						} catch (UnsupportedLookAndFeelException e1) {
							
							e1.printStackTrace();
						}  
	                    new Customerlogin().setVisible(true); 
	                    
	    
	                    
	                }  
	            }  
	        });  
	  
	        JRadioButton userRadioButton = new JRadioButton("Customer Register");  
	        userRadioButton.setBounds(200, 290, 100, 20);  
	        System.out.println("register");
	        userRadioButton.addActionListener(new ActionListener() {  
	            public void actionPerformed(ActionEvent e) {  
	            	  if (userRadioButton.isSelected()) {  
		                    figure = userRadioButton.getText(); 
		                    System.out.println(figure);
		                    try {
								UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
							} catch (ClassNotFoundException e1) {
								
								e1.printStackTrace();
							} catch (InstantiationException e1) {
								
								e1.printStackTrace();
							} catch (IllegalAccessException e1) {
								
								e1.printStackTrace();
							} catch (UnsupportedLookAndFeelException e1) {
								
								e1.printStackTrace();
							}  
		                  
		                   new Customerregister().setVisible(true);
		                    
		                }  
	            }  
	        });  
	      //This code is to group JRadioButton to achieve mutual exclusion effect
	        ButtonGroup figureGroup = new ButtonGroup();  
	        figureGroup.add(adminRadioButton);  
	        figureGroup.add(userRadioButton);  
	  
	        contentPane.add(figureLabel);  
	        contentPane.add(adminRadioButton);  
	        contentPane.add(userRadioButton);  
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	frame.getContentPane().add(contentPane,BorderLayout.CENTER);	
	    	frame.setSize(1000, 600);
	    	frame.setVisible(true);
	        
	        
	        
	        
	        
	  
	    }  	
public static void main(String[]args){
	
	Selectbeforelogin page=new Selectbeforelogin();
	page.choosefigure();
}
	
}

