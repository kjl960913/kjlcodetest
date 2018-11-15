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
	
	public class Customerlogin extends JFrame{
		  
		    //设置一个含有背景图片的面板  
		    private MyPanel panel;  
		    private JLabel lab_zhanghao = new JLabel("name:");  
		    private JTextField jta_text = new JTextField();  
		    Font lab = new Font("楷体",1,30);  
		    private JLabel lat_password = new JLabel("dateofbirth:");  
		    Font lat  = new Font("楷体",1,30);  
		    private JPasswordField jtb_text = new JPasswordField();  
		     
		    private JButton btn_land = new JButton("LOG IN");  
		    Font btn = new Font("黑体",2,30);  
		    public static  int pd = 0;  
		    public static String ak1, ak2;  
		    private Container contentPane = this.getContentPane();  
		   
		    public Customerlogin () {  
		        this.setSize(400,267);  
		        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
		        this.setLocationRelativeTo(null);  
		        this.setTitle("LOG IN");  
		        this.setResizable(false);  
	
		        btn_land.addActionListener(new ActionListener() {  
		            @SuppressWarnings("deprecation")  
		            public void actionPerformed(ActionEvent e) {  
		                  
		                if(pd==1||pd==0) {  
		                    File fileName=new File("customer.txt");  
		                    try{  
		                    FileReader inOne=new FileReader(fileName);  
		                    BufferedReader inTwo=new BufferedReader(inOne);  
		                    String s=null;  
		                    int judge=1;  
		                    while((s=inTwo.readLine())!=null)  
		                    {  
		                      StringBuilder stringBuilder = new StringBuilder();  
		                        
		                        stringBuilder.append(jta_text.getText());  
		                        stringBuilder.append("&&");  
		                        
		                        stringBuilder.append(jtb_text.getText()); 
		                      String[]buf=s.split("----");  
		                      String ss=buf[0]+"&&"+buf[2];  
		                        
		                    String ak=stringBuilder.toString();  
		                     boolean b=ss.equals(ak); 
		                     System.out.println(b); 
		                     System.out.println(ak); 
		                      System.out.println(ss);  
		                      if(ak.equals(ss)) {  
		                        JOptionPane.showMessageDialog(null, "登录成功！");  
		                        //jta_text .setText("");  
		                        jtb_text .setText("");  
		                        judge=0;  
		                          
		                        break;  
		                      }  
		                    }   
		                    
		                    
		                    inTwo.close();  
		                    inOne.close();  
		                    
		         		   		                    
		                    
		                    
		                    
		                    
		                    
		                    
		                    
		                    
		                    
		                    
		                    
		                    
		                    if(judge==1) {  
		                         JOptionPane.showMessageDialog(null,"登陆失败！检查账号密码是否正确或请注册后登录",null,JOptionPane.ERROR_MESSAGE, null);  
		                         jta_text .setText("");  
		                         jtb_text .setText("");  
		                      }  
		                     if(judge==0){  
		                   
		                         dispose(); 
		                         Thesecondselect t=new Thesecondselect(jta_text.getText());
		                         t.frame.setTitle(jta_text.getText()+",Welcome to Bank System and now you can operate accounts!");
		                                 
		                         
		                         
		                         
		                         
		                         
		                         
		                         
		                         return;   
		                     }  
		                    }catch(IOException event){  
		                        JOptionPane.showMessageDialog(null,"系统错误"+event,null,JOptionPane.ERROR_MESSAGE, null);  
		                    }  
		                }  
		            } 
		            
		           
		        });  
		         
		        init();  
		           
		        panel = new MyPanel();  
		        //将所有的组件添加到panel面板中  
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
		       
		    public static void main(String[] args)  
		    throws ClassNotFoundException,  
		        InstantiationException, IllegalAccessException,  
		        UnsupportedLookAndFeelException {  
		        UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");  
		        new Customerlogin().setVisible(true);  
		    }  
		}  
		  

