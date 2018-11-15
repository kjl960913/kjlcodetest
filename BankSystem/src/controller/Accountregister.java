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

import javax.swing.ButtonGroup;
import javax.swing.JButton;  
import javax.swing.JFrame;  
import javax.swing.JLabel;  
import javax.swing.JOptionPane;  
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;  
import javax.swing.UIManager;  
import javax.swing.UnsupportedLookAndFeelException;  
import boundary.MyPanel;
import entities.User;
	
	public class Accountregister extends JFrame{
		    public String name;
		    //设置一个含有背景图片的面板  
		    private MyPanel panel;  
		    private JLabel lab_zhanghao = new JLabel("ID:");  
		    private JTextField jta_text = new JTextField();  
		    Font lab = new Font("楷体",1,30);  
		    private JLabel lab_address  = new JLabel("address:");
		    private JTextField jtc_text = new JTextField();  
 		    private JLabel lat_password = new JLabel("PIN:"); 
		    
		    Font lat  = new Font("楷体",1,30);  
		    private JPasswordField jtb_text = new JPasswordField();  
		    private JButton btn_register = new JButton("REGIS");  
		   
		    Font btn = new Font("黑体",2,30);  
		    public static  int pd = 0;  
		    public static String ak1, ak2,ak3;
		    private Container contentPane = this.getContentPane();  
		   
		    public Accountregister (String Name) {  
		    	
		    	 JRadioButton SButton = new JRadioButton("SaverAccount");  
			        SButton.setBounds(70, 290, 100, 20);  
			        SButton.setSelected(true);  
			        
			        JRadioButton JuButton = new JRadioButton("JuniorAccount");  
			        JuButton.setBounds(70, 290, 100, 20);  
			       
			        
			        JRadioButton CButton = new JRadioButton("CurrentAccount");  
			        CButton.setBounds(70, 290, 100, 20);  
			       
			        ButtonGroup figureGroup = new ButtonGroup();  
			        figureGroup.add(SButton);  
			        figureGroup.add(JuButton); 
			        figureGroup.add(CButton); 
			        
		    	
		    	
		    	
		    	
		    	this.name=Name;
		        this.setSize(800,600);  
		        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
		        this.setLocationRelativeTo(null);  
		        this.setTitle("New Account Register for "+this.name);  
		        this.setResizable(false);  
		        btn_register.addActionListener(new ActionListener() {  
		            @SuppressWarnings("deprecation")  
		            public void actionPerformed(ActionEvent e) {  
		            	try{
		            	int age=0;
		            	String year=null;
		            	String customername=null;
		            	boolean status=false;
		            	 File fileName=new File("customer.txt");  
		            	 String buff[];
		            	 String buff2[];
		            	 
		                      
		                    FileReader inOne=new FileReader(fileName);  
		                    BufferedReader inTwo=new BufferedReader(inOne);       	
		            	String st=inTwo.readLine();
		            	
		            	while(st!=null) {
 System.out.println(st);
		            	buff=st.split("----");
		            	customername=buff[0];
System.out.println(customername);
System.out.println(Name);
		       if(customername.equals(Name)) {
System.out.println(Name);
		    	   buff2=buff[2].split("&&");
System.out.println(buff[2]);		    	   
		    	   year=buff2[0];
System.out.println(buff2[0]);		    	   
		    	   status= Boolean.parseBoolean(buff[3]);
		    	  age=2018-Integer.parseInt(year);
		    	   break;		    	   		    	   		    	   
		    			       }
	
		       
		       st=inTwo.readLine();     	
		      		            	
		            		
		            	}
System.out.println(year);	
System.out.println(status);
System.out.println(age);
		                    
		                    
		            	if(!status) {
		            		JOptionPane.showMessageDialog(null, "Sorry,you have been prohibited to create a new account! "); 
		            	}
		            	
		            	
		            	else {	 if(SButton.isSelected()) {
System.out.print("bbbbb");		            		
		            		
		            		
			            	  registeroperation(name,"saveraccount.txt",0);            	  
			              }    
			          if(JuButton.isSelected()) {
			        	  if(age<=16) {
			        	  			        	  
			        	      registeroperation(name,"junioraccount.txt",0);
			        	      }
			        	  
			        	  else {
			        		  JOptionPane.showMessageDialog(null,"Sorry, you're over 16 years old,creation failure!");
			        	  }
			          }     
			            
			          else 
			        	  registeroperation(name,"currentaccount.txt",500);
		                    }  
		            	inOne.close();
	                    inTwo.close();
		            	}catch(Exception ex) {}
		                    
		                    
		            	
		            }  
		        });  
		        
		       
		         
		        init();  
		        
		        SButton.setLocation(100,300);
		        JuButton.setLocation(300,300);
		        CButton.setLocation(500,300);
		        panel = new MyPanel(); 
		        panel.add(SButton);
			    panel.add(JuButton);
			    panel.add(CButton);  
		         
		        //将所有的组件添加到panel面板中  
		        panel.add(lab_zhanghao);  
		       // panel.add(lab_address);
		        panel.add(lat_password);  
		        panel.add(jta_text);  
		       // panel.add(jtc_text);
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
		        lat_password.setLocation(50,80);  
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
		       
		    
		    public void registeroperation(String name,String Afile,int overdraft) {
		    	
		    	 pd = 1;  
	                ak1 = jta_text .getText();  
	                ak2 = jtb_text .getText();  
	                ak3 = jtc_text .getText();
	                String fileName =Afile; 
	                String draft=Integer.toString(overdraft);
	                
	                try {  
	                	File myfile=new File(fileName);
	                	
	    		        if(!myfile.exists()){
	    		        	myfile.createNewFile();}
	                	FileReader fileReader=new FileReader(myfile);
	                	
						BufferedReader reader=new BufferedReader(fileReader);
	                	
	                	
	                	
	                	
	                     
	                    String line=reader.readLine();
	                    int flag=1;
	                    if(line == null){                 
	                        FileWriter writer = new FileWriter(fileName,true);  
	                        BufferedWriter outWriter=new BufferedWriter(writer);
	                        System.out.println(name+"----"+ak1+"----"+ak2+"----"+0+"----"+draft+"----"+0);                        
	                        outWriter.write(name+"----"+ak1+"----"+ak2+"----"+0+"----"+draft+"----"+0);                         
	                         outWriter.close();  
	                         writer.close();  
	                          flag=0;
	                         JOptionPane.showMessageDialog(null,"congratulations!"+name+","+"注册成功"+"Customer:"+  name+"----"+"ID:"+ak1+"----"+"PIN:"+ak2);		
	                    }
	                                        
	                    else {  while(line!=null){
	                    	
	           
	                    	String[]buff=line.split("----");
	                    	if(buff[1].equals(ak1)){
	                       JOptionPane.showMessageDialog(null,"Sorry,the ID has been registered! ");	
	                       flag=0;	
System.out.println("aaaaaaa");
	                       break;
	          
	                      
	                    	
	                    	}
	                    	
	                    	line=reader.readLine();
	                    }
	                    if(flag == 1){
	                    	FileWriter writer = new FileWriter(fileName,true);  
	                        BufferedWriter outWriter=new BufferedWriter(writer);
	                        outWriter.newLine();
	                       
	                        outWriter.write(name+"----"+ak1+"----"+ak2+"----"+0+"----"+draft+"----"+0);  
	                          
	                        outWriter.close();  
	                        writer.close();
	               
	                        JOptionPane.showMessageDialog(null,"恭喜"+name+","+"注册成功"+"Customer:"+  name+"----"+"ID:"+ak1+"----"+"PIN:"+ak2);		
	                    	
	                    }
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
System.out.println("ccc");	
                     
		    }
		    
		    
		    
		    public static void main(String[] args)  
		    throws ClassNotFoundException,  
		        InstantiationException, IllegalAccessException,  
		        UnsupportedLookAndFeelException {  
		        UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");  
		        new Accountregister("kjl").setVisible(true);  
		    }  
		}  
		  

