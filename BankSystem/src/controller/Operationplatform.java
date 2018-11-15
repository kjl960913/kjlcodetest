package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Operationplatform {
    
	private JButton button1=new JButton("Deposit");
	private JButton button2=new JButton("Withdraw");
	private JButton susbutton=new JButton("SUSPEND ACCOUNT");
	private JButton closebutton=new JButton("CLOSE ACCOUNT");
	private JButton checkbutton=new JButton("Check Deposit");
	private JButton clearbutton=new JButton("CLEAR");
	private JTextField field1=new JTextField("Please enter the number you want to deposit");
	private JTextField field2=new JTextField("please enter the number you want to withdraw");
	private JTextField field3=new JTextField();
	private JTextField unclearfield=new JTextField();
	private JTextField clearfield=new JTextField();
	public int flag=1;
	public	String ID;
    public int num;
	
    public Operationplatform(String ID,int number) {
		String filename=null;
		this.ID=ID;
		this.num=number;
System.out.println(number);		
		String accountname=(ID.split("----"))[1];
		if(number==1) {
	filename="saveraccount.txt";
	
		}
		else if(number==2) {
	 filename="junioraccount.txt";		
		}
		else {
	filename="currentaccount.txt";
		}
System.out.println(accountname);		
System.out.println(filename);	
	guiform(accountname,filename);	
  //为button1加监听器,存钱功能。 
	button1.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String accountname=(ID.split("----"))[1];
			String FM=null;
			String deposit=field1.getText();
			int depositmoney=0;
			int money=0;
			if(number==1) {
		FM="saveraccount.txt";
		
			}
			else if(number==2) {
		 FM="junioraccount.txt";		
			}
			else {
		FM="currentaccount.txt";
			}		
			
			File fileName=new File(FM);  
		    try{  
		    FileReader inOne=new FileReader(fileName);  
		    BufferedReader inTwo=new BufferedReader(inOne);  
		    String s=null;  
		    String ss=null;
		    String balance=null;
		    String unclear=null;
		    
		    while((s=inTwo.readLine())!=null) {
		    	ss=(s.split("----"))[1];
		    	if(ss.equals(accountname)) {
		    		int a=Integer.parseInt(field1.getText());
		    		if(a>0) {
		    	balance=(s.split("----"))[3];	
		    	money=Integer.parseInt(balance);
		    	depositmoney=Integer.parseInt(deposit);
		    	money=money+depositmoney;
		    		}
		    		else {JOptionPane.showMessageDialog(null, "输入必须为正数！");
		    	balance=(s.split("----"))[3];	
			    money=Integer.parseInt(balance);
			    depositmoney=Integer.parseInt(deposit);
			    
		    		
		    		}	
		    		}
		    	
		    	else System.out.println("asc");
		    }
		    
		    field3.setText(Integer.toString(money));
		    field1.setText("");
		    inOne.close();
		    inTwo.close();
		    
		    
		    }catch(Exception ex) {
		    	JOptionPane.showMessageDialog(null, "输入必须为正数！");
		    	
		    }			
		    
		    
		    
		    
		    
	
		    
	//	删除复制文件来修改balance    
		    
		    
		    
		    
		    try {
				FileInputStream in;
				in = new FileInputStream(FM);
				File file=new File("accountcopy.txt");
		        if(!file.exists())
		            file.createNewFile();
		        FileOutputStream out=new FileOutputStream(file);
		        int c;
		        byte buffer[]=new byte[2048];
		        while((c=in.read(buffer))!=-1){
		            for(int i=0;i<c;i++)
		                out.write(buffer[i]);   
			} 
		        in.close();
		        out.close();
		        }catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//String s=field2.getText();
			System.out.println(accountname);
			try {
				FileOutputStream out = new FileOutputStream(FM,false);
				out.write(new String("").getBytes());
				out.close();
				System.out.println("删除account成功");
				} catch (Exception ex) {
					System.out.println("删除account失败");
				} 
			
			
			
			try {
				FileWriter writer = new FileWriter(FM,true);  
	            BufferedWriter outWriter=new BufferedWriter(writer);
	            
	            File myfile=new File("accountcopy.txt");
	        	FileReader fileReader=new FileReader(myfile);       	
				BufferedReader reader=new BufferedReader(fileReader);
				String line =reader.readLine();
				
		        while(line!=null){
			String[]Buff=line.split("----");
			if(!(Buff[1].equals(accountname))){
			outWriter.write(line);
			
			outWriter.newLine();		
			}	
			else {
				
				StringBuilder stringBuilder = new StringBuilder();  
				
                String bff[]=line.split("----");
                
                stringBuilder.append(bff[0]);  
                stringBuilder.append("----");  
                stringBuilder.append(bff[1]);
                stringBuilder.append("----");
                stringBuilder.append(bff[2]);
                stringBuilder.append("----");
                stringBuilder.append(Integer.toString(money));
                stringBuilder.append("----");
                stringBuilder.append(bff[4]);
                stringBuilder.append("----");
                stringBuilder.append(bff[5]);
                 
               
                
            String ak=stringBuilder.toString();	
				
				
				
				
				
				
				outWriter.write(ak);
			}	
		line=reader.readLine();	
			
		}
		 //field2.setText("Please enter the user you want to remove");
		fileReader.close();
		reader.close();
		outWriter.close();
		writer.close();
		
				
				
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}		
						
//			
						
		}
		
	});
	
	
	//为button2加监听器,取钱功能。 
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String accountname=(ID.split("----"))[1];
				String FM=null;
				String deposit=field2.getText();
				int overdraft=0;
				int depositmoney=0;
				int money=0;
				if(number==1) {
			FM="saveraccount.txt";
			overdraft=0;
				}
				else if(number==2) {
			 FM="junioraccount.txt";
			 overdraft=0;
				}
				else {
			FM="currentaccount.txt";
			overdraft=500;
				}		
				
				File fileName=new File(FM);  
			    try{  
			    FileReader inOne=new FileReader(fileName);  
			    BufferedReader inTwo=new BufferedReader(inOne);  
			    String s=null;  
			    String ss=null;
			    String balance=null;
			    
			    while((s=inTwo.readLine())!=null) {
			    	ss=(s.split("----"))[1];
			    	if(ss.equals(accountname)) {
			    		int a=Integer.parseInt(field2.getText());
			    		if(a>0) {
			    	balance=(s.split("----"))[3];	
			    	money=Integer.parseInt(balance);
			    	depositmoney=Integer.parseInt(deposit);
			    
			    	if((money+overdraft)>=depositmoney){money=money-depositmoney;}
			    	else {JOptionPane.showMessageDialog(null, "对不起，你的透支额度不够！");}
			    	
			    		}
			    		else {JOptionPane.showMessageDialog(null, "输入必须为正数！");
			    	balance=(s.split("----"))[3];	
				    money=Integer.parseInt(balance);
				    depositmoney=Integer.parseInt(deposit);
				    
			    		
			    		}	
			    		}
			    	
			    	else System.out.println("asc");
			    }
			    
			    field3.setText(Integer.toString(money));
			    field2.setText("");
			    inOne.close();
			    inTwo.close();
			    
			    
			    }catch(Exception ex) {
			    	JOptionPane.showMessageDialog(null, "输入必须为正数！");
			    	
			    }			
			    
			    
			    
			    
			    
		
			    
		//	删除复制文件来修改balance    
			    
			    
			    
			    
			    try {
					FileInputStream in;
					in = new FileInputStream(FM);
					File file=new File("accountcopy.txt");
			        if(!file.exists())
			            file.createNewFile();
			        FileOutputStream out=new FileOutputStream(file);
			        int c;
			        byte buffer[]=new byte[2048];
			        while((c=in.read(buffer))!=-1){
			            for(int i=0;i<c;i++)
			                out.write(buffer[i]);   
				} 
			        in.close();
			        out.close();
			        }catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//String s=field2.getText();
				System.out.println(accountname);
				try {
					FileOutputStream out = new FileOutputStream(FM,false);
					out.write(new String("").getBytes());
					out.close();
					System.out.println("删除account成功");
					} catch (Exception ex) {
						System.out.println("删除account失败");
					} 
				
				
				
				try {
					FileWriter writer = new FileWriter(FM,true);  
		            BufferedWriter outWriter=new BufferedWriter(writer);
		            
		            File myfile=new File("accountcopy.txt");
		        	FileReader fileReader=new FileReader(myfile);       	
					BufferedReader reader=new BufferedReader(fileReader);
					String line =reader.readLine();
					
			        while(line!=null){
				String[]Buff=line.split("----");
				if(!(Buff[1].equals(accountname))){
				outWriter.write(line);
				
				outWriter.newLine();		
				}	
				else {
					
					StringBuilder stringBuilder = new StringBuilder();  
	                String bff[]=line.split("----");
	                
	                stringBuilder.append(bff[0]);  
	                stringBuilder.append("----");  
	                stringBuilder.append(bff[1]);
	                stringBuilder.append("----");
	                stringBuilder.append(bff[2]);
	                stringBuilder.append("----");
	                stringBuilder.append(Integer.toString(money));
	                stringBuilder.append("----");
	                stringBuilder.append(bff[4]);
	                stringBuilder.append("----");
	                stringBuilder.append(bff[5]);
	                 
	               
	                
	            String ak=stringBuilder.toString();	
										
					outWriter.write(ak);
				}	
			line=reader.readLine();	
				
			}
			 //field2.setText("Please enter the user you want to remove");
			fileReader.close();
			reader.close();
			outWriter.close();
			writer.close();
			
					
					
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}		
								
				
			
								
				
			}
			
		});	
		
		//为sus加监听器,suspend功能。 
		
				susbutton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
					
					if((flag==1)) {
						field1.setEditable(false); 
						field2.setEditable(false);
						clearfield.setEditable(false);
					flag=0;						
					}
					else {
	            	 field1.setEditable(true); 
						field2.setEditable(true);
						clearfield.setEditable(true);
					flag=1;					 
	             }
					
					
					}
					
				});	
		//为支票功能加监听器		
				checkbutton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						String accountname=(ID.split("----"))[1];
						String FM=null;
						String deposit=field1.getText();
						int depositmoney=0;
						int money=0;
						if(number==1) {
					FM="saveraccount.txt";
					
						}
						else if(number==2) {
					 FM="junioraccount.txt";		
						}
						else {
					FM="currentaccount.txt";
						}		
						
						File fileName=new File(FM);  
					    try{  
					    FileReader inOne=new FileReader(fileName);  
					    BufferedReader inTwo=new BufferedReader(inOne);  
					    String s=null;  
					    String ss=null;
					    String balance=null;
					    
					    while((s=inTwo.readLine())!=null) {
					    	ss=(s.split("----"))[1];
					    	if(ss.equals(accountname)) {
					    		int a=Integer.parseInt(field1.getText());
					    		if(a>0) {
					    	balance=(s.split("----"))[5];	
					    	money=Integer.parseInt(balance);
					    	depositmoney=Integer.parseInt(deposit);
					    	money=money+depositmoney;
					    		}
					    		else {JOptionPane.showMessageDialog(null, "输入必须为正数！");
					    	balance=(s.split("----"))[5];	
						    money=Integer.parseInt(balance);
						    depositmoney=Integer.parseInt(deposit);
						    
					    		
					    		}	
					    		}
					    	
					    	else System.out.println("asc");
					    }
					    
					    unclearfield.setText(Integer.toString(money));
					    field1.setText("");
					    inOne.close();
					    inTwo.close();
					    
					    
					    }catch(Exception ex) {
					    	JOptionPane.showMessageDialog(null, "输入必须为正数！");
					    	System.out.println("error!");
					    }			
					    
					    
					    
					    
					    
				
					    
				//	删除复制文件来修改balance    
					    
					    
					    
					    
					    try {
							FileInputStream in;
							in = new FileInputStream(FM);
							File file=new File("accountcopy.txt");
					        if(!file.exists())
					            file.createNewFile();
					        FileOutputStream out=new FileOutputStream(file);
					        int c;
					        byte buffer[]=new byte[2048];
					        while((c=in.read(buffer))!=-1){
					            for(int i=0;i<c;i++)
					                out.write(buffer[i]);   
						} 
					        in.close();
					        out.close();
					        }catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						//String s=field2.getText();
						System.out.println(accountname);
						try {
							FileOutputStream out = new FileOutputStream(FM,false);
							out.write(new String("").getBytes());
							out.close();
							System.out.println("删除account成功");
							} catch (Exception ex) {
								System.out.println("删除account失败");
							} 
						
						
						
						try {
							FileWriter writer = new FileWriter(FM,true);  
				            BufferedWriter outWriter=new BufferedWriter(writer);
				            
				            File myfile=new File("accountcopy.txt");
				        	FileReader fileReader=new FileReader(myfile);       	
							BufferedReader reader=new BufferedReader(fileReader);
							String line =reader.readLine();
							
					        while(line!=null){
						String[]Buff=line.split("----");
						if(!(Buff[1].equals(accountname))){
						outWriter.write(line);
						
						outWriter.newLine();		
						}	
						else {
							
							StringBuilder stringBuilder = new StringBuilder();  
			                String bff[]=line.split("----");
			                
			                stringBuilder.append(bff[0]);  
			                stringBuilder.append("----");  
			                stringBuilder.append(bff[1]);
			                stringBuilder.append("----");
			                stringBuilder.append(bff[2]);
			                stringBuilder.append("----");
			                stringBuilder.append(bff[3]);
			                stringBuilder.append("----");
			                stringBuilder.append(bff[4]);
			                stringBuilder.append("----");
			                stringBuilder.append(Integer.toString(money));
			                 
			               
			                
			            String ak=stringBuilder.toString();	
							
							
							
							
							
							
							outWriter.write(ak);
						}	
					line=reader.readLine();	
						
					}
					 //field2.setText("Please enter the user you want to remove");
					fileReader.close();
					reader.close();
					outWriter.close();
					writer.close();
					
							
							
							
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}		
									
//						
									
					}
					
				});		
				
				//为clearbutton加监听器,clear相当于取钱功能。 
				clearbutton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						String accountname=(ID.split("----"))[1];
						String FM=null;
						String deposit=clearfield.getText();
						int overdraft=0;
						int depositmoney=0;
						int money=0;
						int unclearmoney=0;
						if(number==1) {
					FM="saveraccount.txt";
					
						}
						else if(number==2) {
					 FM="junioraccount.txt";
					 
						}
						else {
					FM="currentaccount.txt";
					
						}		
						
						File fileName=new File(FM);  
					    try{  
					    FileReader inOne=new FileReader(fileName);  
					    BufferedReader inTwo=new BufferedReader(inOne);  
					    String s=null;  
					    String ss=null;
					    String balance=null;
					    String unclear=null;
					    
					    while((s=inTwo.readLine())!=null) {
					    	ss=(s.split("----"))[1];
					    	if(ss.equals(accountname)) {
					    		int a=Integer.parseInt(deposit);
					    		if(a>0) {
					    	balance=(s.split("----"))[3];
					    	unclear=(s.split("----"))[5];
					    	money=Integer.parseInt(balance);
					    	
					    	unclearmoney=Integer.parseInt(unclear);
					    	depositmoney=Integer.parseInt(deposit);
					    	if(a<=unclearmoney) {
					    	money=money+depositmoney;
					    unclearmoney=unclearmoney-depositmoney;
		System.out.println(money);
		System.out.println(unclearmoney);
					    	}
					    	else {JOptionPane.showMessageDialog(null, "clear 的大小不能超过unclear的金额！");}
					    	
					    		}
					    		else {JOptionPane.showMessageDialog(null, "输入必须为正数！");
					    	balance=(s.split("----"))[3];	
					    	unclear=(s.split("----"))[5];
						    money=Integer.parseInt(balance);
						    unclearmoney=Integer.parseInt(unclear);
						    depositmoney=Integer.parseInt(deposit);
						    
					    		
					    		}	
					    		}
					    	
					    	else System.out.println("asc");
					    }
					    
					    field3.setText(Integer.toString(money));
					    unclearfield.setText(Integer.toString(unclearmoney));
					    clearfield.setText("");
					    inOne.close();
					    inTwo.close();
					    
					    
					    }catch(Exception ex) {
					    	JOptionPane.showMessageDialog(null, "输入必须为正数！");
					    	
					    }			
					    
					    
					    
					    
					    
				
					    
				//	删除复制文件来修改balance    
					    
					    
					    
					    
					    try {
							FileInputStream in;
							in = new FileInputStream(FM);
							File file=new File("accountcopy.txt");
					        if(!file.exists())
					            file.createNewFile();
					        FileOutputStream out=new FileOutputStream(file);
					        int c;
					        byte buffer[]=new byte[2048];
					        while((c=in.read(buffer))!=-1){
					            for(int i=0;i<c;i++)
					                out.write(buffer[i]);   
						} 
					        in.close();
					        out.close();
					        }catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						//String s=field2.getText();
						System.out.println(accountname);
						try {
							FileOutputStream out = new FileOutputStream(FM,false);
							out.write(new String("").getBytes());
							out.close();
							System.out.println("删除account成功");
							} catch (Exception ex) {
								System.out.println("删除account失败");
							} 
						
						
						
						try {
							FileWriter writer = new FileWriter(FM,true);  
				            BufferedWriter outWriter=new BufferedWriter(writer);
				            
				            File myfile=new File("accountcopy.txt");
				        	FileReader fileReader=new FileReader(myfile);       	
							BufferedReader reader=new BufferedReader(fileReader);
							String line =reader.readLine();
							
					        while(line!=null){
						String[]Buff=line.split("----");
						if(!(Buff[1].equals(accountname))){
						outWriter.write(line);
						
						outWriter.newLine();		
						}	
						else {
							
							StringBuilder stringBuilder = new StringBuilder();  
			                String bff[]=line.split("----");
			                
			                stringBuilder.append(bff[0]);  
			                stringBuilder.append("----");  
			                stringBuilder.append(bff[1]);
			                stringBuilder.append("----");
			                stringBuilder.append(bff[2]);
			                stringBuilder.append("----");
			                stringBuilder.append(Integer.toString(money));
			                stringBuilder.append("----");
			                stringBuilder.append(bff[4]);
			                stringBuilder.append("----");
			                stringBuilder.append(Integer.toString(unclearmoney));
			                 
			               
			                
			            String ak=stringBuilder.toString();	
												
							outWriter.write(ak);
						}	
					line=reader.readLine();	
						
					}
					 //field2.setText("Please enter the user you want to remove");
					fileReader.close();
					reader.close();
					outWriter.close();
					writer.close();
					
							
							
							
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}		
										
						
					
										
						
					}
					
				});	
			//	
				//为sus加监听器,suspend功能。 
				
						susbutton.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent arg0) {
System.out.print(flag);							
							if(flag==1) {
								field1.setEditable(false); 
								field2.setEditable(false);
								clearfield.setEditable(false);
							}
							else
								field1.setEditable(false); 
							field2.setEditable(false);
							clearfield.setEditable(false);
							
							}
							
						});	
				
				
				
				
				
				
				
	//			
	}
	
	public void guiform(String accountname,String filename) {
		JFrame frame=new JFrame("Welcome to operation your account named "+accountname);	
		JLabel depositlabel = new JLabel("Deposit money");
		JLabel withdrawlabel = new JLabel("Withdraw money");
		JLabel balancelabel= new JLabel("Balance");
		JLabel unclearlabel=new JLabel("Money Uncleared");
		JLabel clearlabel=new JLabel("Clear");
		JPanel panel=new JPanel();


		frame.setSize(1000,800);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
		frame.setLocationRelativeTo(null);  
		frame.setVisible(true);
		frame.getContentPane().add(panel); 
		depositlabel.setLocation(50,100);
		depositlabel.setSize(100,50);

		withdrawlabel.setLocation(50,200);
		withdrawlabel.setSize(100,50);

		balancelabel.setLocation(50,300);
		balancelabel.setSize(100,50);
		
		unclearlabel.setLocation(50,400);
		unclearlabel.setSize(100,50);
		
		clearlabel.setLocation(50,500);
		clearlabel.setSize(100,50);
		
		

		field1.setLocation(200,100);
		field1.setSize(250,50);

		field2.setLocation(200,200);
		field2.setSize(250,50);

		field3.setLocation(200,300);
		field3.setSize(250,50);
		field3.setEditable(false);
		
		unclearfield.setLocation(200,400);
		unclearfield.setSize(250,50);
		unclearfield.setEditable(false);
		
		clearfield.setLocation(200,500);
		clearfield.setSize(250,50);
		
				
		this.button1.setLocation(500,100);
		this.button1.setSize(100,50);
		
		this.checkbutton.setLocation(650,100);
		this.checkbutton.setSize(150,50);

		this.button2.setLocation(500,200);
		this.button2.setSize(100,50);

		this.susbutton.setLocation(200,600);
		this.susbutton.setSize(200,50);

		this.closebutton.setLocation(450,600);
		this.closebutton.setSize(200,50);
		
		this.clearbutton.setLocation(500,500);
		this.clearbutton.setSize(100,50);
		
		

		panel.add(depositlabel);
		panel.add(withdrawlabel);
		panel.add(balancelabel);
		panel.add(unclearlabel);
		panel.add(clearlabel);
		panel.add(field1);
		panel.add(field2);
		panel.add(field3);
		panel.add(unclearfield);
		panel.add(clearfield);
		panel.add(this.button1);
		panel.add(this.button2);
		panel.add(this.susbutton);
		panel.add(this.closebutton);
		panel.add(this.checkbutton);
		panel.add(this.clearbutton);
		panel.setLayout(null);
		balanceread(accountname,filename);		
				
	}
	
	
	
	
	 
public void balanceread(String accountname,String filename ) {
	
	File fileName=new File(filename);  
    try{  
    FileReader inOne=new FileReader(fileName);  
    BufferedReader inTwo=new BufferedReader(inOne);  
    String s=null;  
    String ss=null;
    String balance=null;
    String unclear=null;
    
    while((s=inTwo.readLine())!=null) {
    	ss=(s.split("----"))[1];
    	if(ss.equals(accountname)) {
    	balance=(s.split("----"))[3];
    	unclear=(s.split("----"))[5];
    	}
    	
    
    }
    
    field3.setText(balance);
    unclearfield.setText(unclear);
    inOne.close();
    inTwo.close();
    
    }catch(Exception ex) {
    	
    }
}	
	

		
	
	
	
public static void main(String[]args) {
	
	new Operationplatform("kjl----qwe----qwe----0----500----0",3);
}	
	
	
}
