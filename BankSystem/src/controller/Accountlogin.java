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
	
	public class Accountlogin extends JFrame{
		    public String name;  
		    
		    //����һ�����б���ͼƬ�����  
		    private MyPanel panel;  
		    private JLabel lab_zhanghao = new JLabel("ID:");  
		    private JTextField jta_text = new JTextField();  
		    Font lab = new Font("����",1,30);  
		    private JLabel lat_password = new JLabel("PIN:");  
		    Font lat  = new Font("����",1,30);  
		    private JPasswordField jtb_text = new JPasswordField();  
		     
		    private JButton btn_land = new JButton("LOG IN");  
		    Font btn = new Font("����",2,30);  
		    public static  int pd = 0;  
		    public static String ak1, ak2;  
		    private Container contentPane = this.getContentPane();  
		   
		    public Accountlogin (String Name) {  
		       this.name=Name;
		    	this.setSize(800,400);  
		        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
		        this.setLocationRelativeTo(null);  
		        this.setTitle("LOG IN for the account of"+Name);  
		        this.setResizable(false);  
		        
		        
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
		        
		        int number=0;
		        
		        
		        
	
		        btn_land.addActionListener(new ActionListener() {  
		            @SuppressWarnings("deprecation")  
		            public void actionPerformed(ActionEvent e) {  
		              if(SButton.isSelected()) {
		            	 
		            	  loginoperation(name,"saveraccount.txt",1);            	  
		              }    
		          if(JuButton.isSelected()) {
		        	  
		        	      loginoperation(name,"junioraccount.txt",2);
		          }     
		            
		          else 
		        	  
		        	  loginoperation(name,"currentaccount.txt",3);
		            } 
		            
		           
		        });  
		         
		        init();  
		           
		        panel = new MyPanel();  
		        //�����е������ӵ�panel�����  
		        SButton.setLocation(100,300);
		        JuButton.setLocation(300,300);
		        CButton.setLocation(500,300);
		       panel.add(SButton);
		       panel.add(JuButton);
		       panel.add(CButton);
		        panel.add(lab_zhanghao);  
		        panel.add(lat_password);  
		        panel.add(jta_text);  
		        panel.add(jtb_text);  
		       // panel.add(btn_register);  
		        panel.add(btn_land);  
		        panel.setLayout(null);  
		           
		        getContentPane().add(panel);  
		    }  
		    private void init() {  
		    	
		        lab_zhanghao.setSize(200,100);  
		        lab_zhanghao. setLocation(50,20);  
		        lab_zhanghao.setFont(lab);  
		        lat_password.setSize(200,100);  
		        lat_password.setLocation(50,80);  
		        lat_password.setFont(lat);  
		        jta_text.setSize(190,30);  
		        jta_text.setLocation(160,55);  
		        jtb_text.setSize(190,30);  
		        jtb_text.setLocation(160,115);  
		       
		        btn_land.setSize(120, 40);  
		        btn_land.setLocation(230, 180);  
		       
		        btn_land.setFont(btn);  
		    }  
		    
		    
		    
		    
		    
		    public void loginoperation(String myname,String AccountFile,int num) {
		    	 
		    	if(pd==1||pd==0) {  
		    		    myname=this.name;
	                    File fileName=new File(AccountFile);  
	                    try{  
	                    FileReader inOne=new FileReader(fileName);  
	                    BufferedReader inTwo=new BufferedReader(inOne);  
	                    String s=null;  
	                    int judge=1;  
	                    while((s=inTwo.readLine())!=null)  
	                    {  
	                      StringBuilder stringBuilder = new StringBuilder();  
	                      stringBuilder.append(myname);
	                      stringBuilder.append("&&"); 
	                        stringBuilder.append(jta_text.getText());  
	                        stringBuilder.append("&&"); 
	                        stringBuilder.append(jtb_text.getText()); 
	                     
	                        String[]buf=s.split("----");  
	                      String ss=myname+"&&"+buf[1]+"&&"+buf[2];  
	                        
	                    String ak=stringBuilder.toString();  
	                     boolean b=ss.equals(ak); 
	                     System.out.println(b); 
	                     System.out.println(ak); 
	                      System.out.println(ss);  
	                      if(ak.equals(ss)) {  
	                        JOptionPane.showMessageDialog(null, "��¼�ɹ���");  
	                        //jta_text .setText("");  
	                        jtb_text .setText("");  
	                        judge=0;  
	                          
	                        break;  
	                      }  
	                    }   
	                    
	                    
	                    inTwo.close();  
	                    inOne.close();  
	                    
	         		   		                    
	                    
	                    
	                    
	                    
	              		                    
	                    if(judge==1) {  
	                         JOptionPane.showMessageDialog(null,"��½ʧ�ܣ�����˺������Ƿ���ȷ����ע����¼",null,JOptionPane.ERROR_MESSAGE, null);  
	                         jta_text .setText("");  
	                         jtb_text .setText("");  
	                         
	                      }  
	                     if(judge==0){  
	                   
	                         dispose(); 
	                         
	                         new Operationplatform(s,num);
	                      
	                                 
	                         	                        
	                     }  
	                    }catch(IOException event){  
	                        JOptionPane.showMessageDialog(null,"ϵͳ����"+event,null,JOptionPane.ERROR_MESSAGE, null);  
	                    }  
	                }  	    	
		    	
		    	
		    	
		    }
		    
		    
		    
	   
		    
		    public static void main(String[] args)  
		    throws ClassNotFoundException,  
		        InstantiationException, IllegalAccessException,  
		        UnsupportedLookAndFeelException {  
		        UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");  
		        new Accountlogin("kjl").setVisible(true);  
		    }  
		}  
		  

