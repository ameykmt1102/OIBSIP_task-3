package atm;
import java.util.*;

/*This program consists of the following Operations:
 * Also includes registration which will include Full account holder name , Account Number , userid creation, userpin creation

 *Balance will be displayed after every Operation
 *1)Transaction History
 *2)Withdraw
 *3)Deposit
 *4)Transfer
 *5)Quit 
 *default userid : admin
 *default pin    : 1234
 */

public class ATMinterface {
	
	String a_name = "Admin";
	String r_name;
	String userid = "admin";//default userId and Password 
	int pin = 1234;
	double bal;
	int trans = 0;
	String hist = "";
	Scanner s = new Scanner(System.in);
	public static void main(String[] args) 
	{
		ATMinterface a = new ATMinterface();
		
		Scanner s = new Scanner(System.in);
			System.out.println("\t>>>>>>>>>>>>>>>>>>>WELCOME TO THE ATM<<<<<<<<<<<<<<<<<<<<\t");
			System.out.println();
			System.out.print("\n\tSelect the options you want to proceed with(1 Or 2):\n\n\t1)Registration\n\t2)Login\n\nEnter Your Choice :");
			int choice;
			    choice = s.nextInt();
			       while(true) {
			             switch(choice) 
			             {
			               
			                    case 1: a.getReg();
			                        break;
			        
			                    case 2: a.getLogin();
			                         break;
			        
			                    default:
				                      System.out.println("Invalid Selection :(....");
			                          break;
			              }
			                            break;
			
	                              }a.getOp();
	}
	
	      public void getOp()  
	      {
		   	                 while(true) {
				                      System.out.print("\n\t*************************************************");
				                      System.out.println("\n\t\tWelcome To The Dashboard  "+a_name+" !! ");
				                      System.out.println("\t*************************************************");
				
				                            System.out.println();
				                      System.out.println("\t--------------Select a Choice ---------------------");
				                      System.out.println("\n\t-----------1)Transaction History ------------------");
				                      System.out.println("\t-----------2)Withdraw Funds -----------------------");
				                      System.out.println("\t-----------3)Deposit Funds ------------------------");
				                      System.out.println("\t-----------4)Transfer Funds -----------------------");
				                      System.out.println("\t-----------5)Check Balance-------------------------");
			                          System.out.println("\t-----------6)EXIT----------------------------------");
			                  
			                     System.out.print("\nEnter Your Choice : ");
			    
			                                   int choice2;
			                                                  
			                                   choice2 = s.nextInt();
			                                        
			                                       switch(choice2) {
			      
			                                         case 1: getHist();
			                                                 break;
			            
			                                         case 2: withFund();
			                                                 break;
			           
			                                         case 3: depFund();
			                                                  break;
			            
			                                         case 4: transFund();
			                                                  break;
			      
			                                         case 5: checkBal();
			                                                  break;
			     
			                                         case 6: System.out.print("Thank You for Banking With Us!!!!!!!!!!");
			                                                  System.exit(0);
			            
			                                         default: System.out.println("Invalid Choice!!!!!...Enter Again :");
			     
			                                                          }
			                               }
	       }
	      
	

		public void getReg() 
		{
		
			System.out.println("\n\tProceeding Towards Registration Page...\n\t");
			
			   System.out.println("\t-----------------------------------------------------\t");
			   System.out.println("\t\t\tWelcome to Registration");
			   System.out.println("\t-----------------------------------------------------\t");
			
			
			    System.out.println("\nPlease Enter Account Holder's Full Name :");
			         a_name = s.nextLine();
			         
			    System.out.println("\nEnter Your Account Number");
			         int accnum = s.nextInt();
			
			    System.out.println("\nSet Your Userid Accordingly");
			         userid = s.next();
			
			    System.out.println("\nSet Your Pin Accordingly");
			         pin = s.nextInt();
			
			      getLogin();
			
		  }
		
		public void getLogin() {
			 
			System.out.println("\n\tProceeding Towards Login Page...\n\t");
			 String entered_user;
			 int entered_pin;
			 
			    System.out.println("\nEnter The Userid:");
			 
			       while(true) {
			  
			    	        entered_user = s.next();
			 
			                   if (userid.equals(entered_user)) {
				 
			                	         System.out.println("\nEnter the Pin:");
				                   
			                	          while(true) {
				 
			                	        	    entered_pin=s.nextInt();
				 
			                	        	     if (pin == entered_pin) {
					 
			                	        	    	  System.out.println("\nSuccessfully Logged in......");
					                                      break;
					
					                                                      }
			                	        	     else {
					                                      System.out.println("Invalid Pin..Enter correct Pin");
				                                       }
				                                        
			                	                         } break;
			                                                      }  
			                    else{
				    
			                      System.out.println("Invalid Username...Please Enter Correct Username");
			                          
			                        }
			               }
			 
		 }
		
		
	
		public void getHist() {
		
			               if (trans == 0) {
			 
			            	          System.out.println("No Transactions Yet.");
		                           
			                                }else {System.out.println(hist);}
	                           }
	    
		public void withFund() {
		
		                   System.out.println("Enter the amount you want to withdraw : ");
		
		                          double amt = s.nextDouble();
			         
		                         if(bal >= amt) {
				 
		                        	    bal-=amt;
				                            trans++;
				
				                              String str = amt + " Withdrawn\n";
				                                 System.out.println("Processing................");
				                                  System.out.println("You have Successfully Withdrawn Rs "+amt+" /-");
				                                   System.out.println("Your Balance is :"+bal);
				                                     hist=hist.concat(str);
		                                          }	
			
			                      else {
				            
			                    	       System.out.println("Not Enough Funds!");
			                           }
	}
 
	public void depFund() {
		
		    System.out.println("Enter The Amount to be Deposited :");
		
		      double amt = s.nextDouble();
		
		      if (amt <= 50000) {
			
		    	    bal+=amt;
			            trans++;
			
			            String str = amt + " Deposited\n";
			
			             System.out.println("Processing................");
			
			                 System.out.println("You have Successfully Deposited Rs "+amt+" /-");
			                     System.out.println("Your Balance is :"+bal);
			   hist = hist.concat(str);
		                           }
		
		       else  {
			
		    	       System.out.println("\nMaximum Limit is Rs 50000 at a time only");
		             
		             }
	 }
	
	 public void transFund(){
		
		      Scanner b = new Scanner(System.in);
		
		       System.out.println("Please Enter the Recipent's Name: ");
		         r_name = b.nextLine();
		
		       System.out.println("\nEnter the amount to Transfer : (Max 1 lakh)");
		          double amt = s.nextDouble();
		
		          if (bal>=amt) {
			
		        	        bal-=amt;
			
		        	          System.out.println("Transfer Successful to "+r_name+"\nAmount Transferred: "+amt );
			
		        	          System.out.println("Your Balance is :"+bal);
			                  String str = amt + " Transferred to " +r_name;
			
			                    hist = hist.concat(str);
		                        
		                        }else if (amt>100000) {
			
		                        	  System.out.println("The Maximum Limit is 1 Lakh for Transfer");
		                                              }
		else {
			System.out.println("Insufficient Funds...Please Keep Your Account Funded!!");
		}
		
	}
	public void checkBal() {
		System.out.println("Your Current Balance in  Account :"+bal);
	}
	
}
