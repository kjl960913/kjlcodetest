package controller;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Container;  
import java.awt.Font;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import java.io.BufferedReader;  
import java.io.BufferedWriter;  
import java.io.File;  
import java.io.FileReader;  
import java.io.FileWriter;  
import java.io.IOException;  
import java.io.Writer;  
  
import javax.swing.JButton;  
import javax.swing.JFrame;  
import javax.swing.JLabel;  
import javax.swing.JOptionPane;  
import javax.swing.JPasswordField;  
import javax.swing.JTextField;  
import javax.swing.UIManager;  
import javax.swing.UnsupportedLookAndFeelException;  
import boundary.MyPanel;
import entities.User;
	
	public class Customerregister extends JFrame{
		  
		    //设置一个含有背景图片的面板  
		    private MyPanel panel;  
		    private JLabel lab_zhanghao = new JLabel("name:");  
		    private JTextField jta_text = new JTextField();  
		    Font lab = new Font("楷体",1,30);  
		    private JLabel lab_address  = new JLabel("address:");
		    private JTextField jtc_text = new JTextField();  
 		    private JLabel lat_password = new JLabel("dateofbirth:"); 
		    
		    Font lat  = new Font("楷体",1,30);  
		    private JTextField jtb_text = new JTextField();  
		    private JButton btn_register = new JButton("REGIS");  
		   
		    Font btn = new Font("黑体",2,30);  
		    public static  int pd = 0;  
		    public static String ak1, ak2,ak3;
		    private Container contentPane = this.getContentPane();  
		   
		    public Customerregister () {  
		        this.setSize(500,267);  
		        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
		        this.setLocationRelativeTo(null);  
		        this.setTitle("New Customer Register");  
		        this.setResizable(false);  
		        btn_register.addActionListener(new ActionListener() {  
		            @SuppressWarnings("deprecation")  
		            public void actionPerformed(ActionEvent e) {  
		                pd = 1;  
		                ak1 = jta_text .getText();  
		                ak2 = jtb_text .getText();  
		                ak3 = jtc_text .getText();
		                String fileName = "customer.txt"; 
		                
		                try {  
		                	File myfile=new File("customer.txt");
		                	
		    		        if(!myfile.exists()){
		    		        	myfile.createNewFile();}
		                	FileReader fileReader=new FileReader(myfile);
		                	
							BufferedReader reader=new BufferedReader(fileReader);
		                	
		                	
		                	
		                	
		                     
		                    String line=reader.readLine();
		                    int flag=1;
		                    if(line == null){                 
		                        FileWriter writer = new FileWriter(fileName,true);  
		                        BufferedWriter outWriter=new BufferedWriter(writer);
		                        System.out.println(ak1+"----"+ak3+"----"+ak2+"----"+"true");                        
		                        outWriter.write(ak1+"----"+ak3+"----"+ak2+"----"+"true");                         
		                         outWriter.close();  
		                         writer.close();  
		                          flag=0;
		                         JOptionPane.showMessageDialog(null,"恭喜，注册成功  name:"+ak1+"----"+"address:"+ak3+"dateofbirth:"+ak2);		
		                    }
		                                        
		                    else  while(line!=null){
		                    	
		           
		                    	String[]buff=line.split("----");
		                    	if(buff[0].equals(ak1)){
		                       JOptionPane.showMessageDialog(null,"Sorry,the name has been registered! ");	
		                       flag=0;	
		                      
		                       break;
		                    	
		                    	}
		                    	
		                    	line=reader.readLine();
		                    }
		                    if(flag == 1){
		                    	FileWriter writer = new FileWriter(fileName,true);  
		                        BufferedWriter outWriter=new BufferedWriter(writer);
		                        outWriter.newLine();
		                       
		                        outWriter.write(ak1+"----"+ak3+"----"+ak2+"----"+"true");  
		                          
		                        outWriter.close();  
		                        writer.close();
		               
		                        JOptionPane.showMessageDialog(null,"Congratulations!"+ak1+"----"+ak3+"----"+ak2+"----"+"true");	
		                    	
		                    }
		                    reader.close();
		                    fileReader.close();
		                    myfile.exists();
		                } catch (IOException e1) {  
		                    e1.printStackTrace();  
		                }  
		                jta_text.setText("");  
		                jtb_text.setText("");  
		                jtc_text.setText(""); 
		                
		            }  
		        });  
		        
		       
		         
		        init();  
		           
		        panel = new MyPanel();  
		        //将所有的组件添加到panel面板中  
		        panel.add(lab_zhanghao);  
		        panel.add(lab_address);
		        panel.add(lat_password);  
		        panel.add(jta_text);  
		        panel.add(jtc_text);
		        panel.add(jtb_text);  
		        panel.add(btn_register); 
		        
		       
		        
		        panel.setLayout(null);  
		           
		        getContentPane().add(panel);  
		    }  
		    private void init() {  
		        lab_zhanghao.setSize(200,100);  
		        lab_zhanghao. setLocation(50,20);  
		        lab_zhanghao.setFont(lab);  
		        lab_address.setSize(200,100);
		        lab_address.setLocation(0,50);
		        lab_address.setFont(lab);
		        lat_password.setSize(200,100);  
		        lat_password.setLocation(0,80);  
		        lat_password.setFont(lat);  
		        jta_text.setSize(190,30);  
		        jta_text.setLocation(160,55); 
		        
		        jtc_text.setSize(190,30);
		        jtc_text.setLocation(160,85);
		      
		        jtb_text.setSize(190,30);  
		        jtb_text.setLocation(160,115); 
		        
		        btn_register.setSize(120, 40);  
		        btn_register.setLocation(230, 180);  
		       
		        btn_register.setFont(btn);  
		          
		    }  
		       
		    public static void main(String[] args)  
		    throws ClassNotFoundException,  
		        InstantiationException, IllegalAccessException,  
		        UnsupportedLookAndFeelException {  
		        UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");  
		        new Customerregister().setVisible(true);  
		    }  
		}  
		  

