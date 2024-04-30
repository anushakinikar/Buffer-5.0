package project;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;
import java.time.LocalDate;
import java.text.ParseException;  
import java.text.SimpleDateFormat;  


class Member{
    String name;
    String dept_class;
    String position;
 	String email;
    String phone;
    public Member next;
    String club;

 public Member(){
    	next = null;
    }

public Member(String name, String email, String phone, String position, String dept_class, String club) {
	this.name = name;
	this.email = email;
	next = null;
	this.phone= phone;
	this.position = position;
	this.dept_class= dept_class;
	this.club = club;
	}
}


class Club_members{
	
		Member curr, ptr ;
			
		Scanner sc = new Scanner(System.in).useDelimiter("\n");
		Member user = new Member();

		  Member head;
		  public Club_members() {
		        head = null;
		    }

		    public boolean isValidEmail(String email) {
		        return email.contains("@");
		    }

		    public boolean isValidPhoneNumber(String phone) {
		        if (phone.length() != 10) {
		            return false; // Phone number must be exactly 10 characters long
		        }

		        char firstDigit = phone.charAt(0);

		        if (firstDigit != '7' && firstDigit != '8' && firstDigit != '9') {
		            return false; // First digit is not 7, 8, or 9
		        }

		        for (char digit : phone.toCharArray()) {
		            if (!Character.isDigit(digit)) {
		                return false; // Phone number contains a non-digit character
		            }
		        }

		        return true;
		    }

    
   public void addNewMember(String club) {
		
			Member current;
			
			System.out.println("ADD NEW MEMBERS");
            System.out.print("Enter name: ");
            String name = sc.next();
            sc.nextLine(); 
            
            System.out.print("Enter Dept and Class: ");
            String dept_class = sc.next();
            sc.nextLine(); 
            
            System.out.print("Enter email: ");
            String email = sc.next();
            sc.nextLine();
            
            System.out.print("Enter position: ");
            String position = sc.next();
            sc.nextLine(); 
            
            System.out.print("Enter phone number: ");
            String phone = sc.next();
            
            if (isValidEmail(email) && isValidPhoneNumber(phone)) {
                System.out.println("Enter 1 if details are correct, or any other key to restart:");
                int n = sc.nextInt();
                if (n == 1) {
                	Member newMember = new Member(name, email, phone, position, dept_class, club);
                    if (head == null) {
                        head = newMember;
                    } 
                    else {
                        current = head;
                        while (current.next != null) {
                            current = current.next;
                        }
                        current.next = newMember;
                    }
                    System.out.println("New Member added successfully!!");
                } 
                else {
                    addNewMember(club);
                }
            } 
            else {
                System.out.println("Invalid email or phone number format. Please try again.\n");
                addNewMember(club);
            }
}
   public void delete() {
	   System.out.println("Enter the phone number of the member you want to remove: ");
	   String delete= sc.next();
	   sc.nextLine(); 

	   if(head == null) {
		   System.out.println("empty");
	   }

	   else {
	   ptr= head;
	   Member prev = head;
	   while(ptr.next!=null && !(ptr.phone.equals(delete))) {
		   prev = ptr;
		   ptr= ptr.next;
	   }

	   if(ptr.phone.equals(delete)) {
		   prev.next = ptr.next;
		   ptr.next = null;
		   System.out.println("Member details deleted!!");
	   }

	   else {
	   System.out.println("Member not present!");
	   }
	   }
   }
   void display() {

	   if(head== null) {

	   System.out.println("List is empty");

	   }

	   ptr= head;

	   System.out.printf("--------------------------------------------------------------------------------------------------%n");

	   System.out.printf("%-10s 	| %-10s | %-10s | %-10s  			 | %-10s 	   %n", "Name", "Dept & Class", "Position", "Email", "Phone No.");

	   System.out.printf("--------------------------------------------------------------------------------------------------%n");

	   while(ptr.next!= null) {

	   System.out.printf("%-10s   | %-10s    | %-10s  | %-10s    | %-10s    %n", ptr.name, ptr.dept_class, ptr.position, ptr.email, ptr.phone);

	   ptr= ptr.next;

	   }



	   System.out.printf("%-10s  | %-10s   | %-10s | %-10s  | %-10s 	   %n", ptr.name, ptr.dept_class, ptr.position, ptr.email, ptr.phone);
	   //System.out.printf("----------------------------------------------------------------------------------------%n");
	   System.out.printf("--------------------------------------------------------------------------------------------------%n");
	   System.out.println("\n");

	   }
   
   void update() {
	   System.out.println("Enter the phone number of the memeber: ");
	   String update = sc.next();
	   sc.nextLine();
	   if(head == null) {
		   System.out.println("empty");
	   }
	   else {
		   ptr= head;
		   while(ptr.next!=null && !(ptr.phone.equals(update))) {
			   ptr= ptr.next;
		   }

		   if(ptr.phone.equals(update)) {
			   System.out.println("Enter a to update name\nb to update dept & class\nc to update position\nd to update email\ne to update phone number");
			   System.out.println("Enter your option:");
			   String opt = sc.next();
			   sc.nextLine();
			   String a = "a"; 
			   String b= "b";
			   String c="c"; 
			   String d= "d"; 
			   String e= "e";
			   
			   if(opt.equals(a)) {
				   System.out.println("Enter the new name: ");
				   String name = sc.next();
				   sc.nextLine();
				   ptr.name = name;
				   System.out.println("Updated");
				   
			   }
			   else if(opt.equals(b)) {
				   System.out.println("Enter the new class: ");
				   String dept = sc.next();
				   sc.nextLine();
				   ptr.dept_class= dept;
				   System.out.println("Updated");
				   
			   }
			   else if(opt.equals(c)) {
				   System.out.println("Enter the new position: ");
				   String pos = sc.next();
				   sc.nextLine();
				   ptr.position= pos;
				   System.out.println("Updated");
				   
			   }
			   else if(opt.equals(d)) {
				   System.out.println("Enter the new email: ");
				   String email = sc.next();
				   sc.nextLine();
				   ptr.email= email;
				   System.out.println("Updated");
				   
			   }
			   else if(opt.equals(e)) {
				   System.out.println("Enter the new phone number: ");
				   String no = sc.next();
				   sc.nextLine();
				   ptr.phone= no;
				   System.out.println("Updated");
				   
			   } 
			   }

		   else {
		   System.out.println("Member not present!");
		   }
	   
	   }
}
}

class BST{
	
	BST left;
	BST right;
	public String name, type;
	public BST next;
	String desc;
	String password;
	
	BST( String name, String type,String desc, String password){
		this.left=null;
		this.right=null;
		this.name=name;
		this.type=type;
		this.desc = desc;
		this.password= password;
	}
}

class BST_Club{
	BST root,ptr;
	Scanner sc = new Scanner(System.in);
	BST_Club()
	{
		this.root=null;
	}
	
	void create(String name,String type, String desc, String password) {

	     BST temp=new BST(name,type,desc, password);
	    
	    if(root==null) {
	    	root=temp;
	    }
	    
	    else {
	    	ptr=root;
	    	while(ptr!=null) {
		    	if(temp.name.compareTo(ptr.name)<0)
			    	{if(ptr.left==null) {
			    		ptr.left=temp;
			    		break;
			    	}
			    	else
			    		ptr=ptr.left;
			    }
		    	else if(temp.name.compareTo(ptr.name)>0) {
			    		if(ptr.right==null) {
			    			ptr.right=temp;
			    			break;
				    	}
			    		else
			    			ptr=ptr.right;
			    	}
		    	else if(temp.name.compareTo(ptr.name)==0){
		    		return;}
		    	}}
	}
	
	void search() {
	    if (root == null) {
	        System.out.println("BST is empty");
	        return;
	    }

	    System.out.println("Enter the club name: ");
	    String key = sc.nextLine().toLowerCase(); // Convert input to lowercase directly
	    BST ptr = root; 

	    while (ptr != null) {
	        int comparison = key.compareTo(ptr.name.toLowerCase()); // Convert node name to lowercase for comparison
	        if (comparison == 0) {
	            System.out.println(ptr.name);
	            System.out.println("Type: " + ptr.type);
	            System.out.println("About this club: " + ptr.desc);
	            return; // Exit function after finding the node
	        } else if (comparison < 0) {
	            ptr = ptr.left;
	        } else {
	            ptr = ptr.right;
	        }
	    }

	    // If loop completes without finding the node
	    System.out.println("Sorry, this club is not available");
	}
	
	/*boolean clubHead(String club, String password) {
		int flag = 0;
	    String key1= club.toLowerCase();
	    ptr = root;
	    while (ptr != null) {
	        int comparison = key1.compareTo(ptr.name);
	        if (comparison == 0) {
	        	int comparison1 = password.compareTo(ptr.password);
		        	if(comparison1==0) {
		            flag = 1;
		            break;
	        }
	        } else if (comparison < 0) {
	            ptr = ptr.left;
	        } else {
	            ptr = ptr.right;
	        }
	    }
	    if (flag == 1) {
	        return true;
	    } else {
	        return false;
	    } 
		

	} */
	boolean clubHead(String club, String password) {
	    String key1 = club.toLowerCase();
	    BST ptr = root; // Ensure ptr is initialized locally
	    
	    while (ptr != null) {
	        int comparison = key1.compareTo(ptr.name.toLowerCase()); // Convert node name to lowercase for comparison
	        if (comparison == 0) {
	            int comparison1 = password.compareTo(ptr.password);
	            if (comparison1 == 0) {
	                return true; // Return true if both club name and password match
	            }
	            break; // Exit loop if club name matches but password doesn't
	        } else if (comparison < 0) {
	            ptr = ptr.left;
	        } else {
	            ptr = ptr.right;
	        }
	    }
	    
	    return false; // Return false if club name or password doesn't match or if the club name isn't found
	}
	
	void display() {
		Stack<BST> st = new Stack<>();
		if(root==null) {
			System.out.println("EMPTY");
			return;
		}
		 ptr = root;
		 System.out.printf("----------------------------------------------------------------------------------------------------------------------------------%n");

		   System.out.printf("%-10s 	| %-10s | %-10s  	   %n", "Name", "Type", "Description");

		   System.out.printf("----------------------------------------------------------------------------------------------------------------------------------%n");
		while(ptr != null || st.size() > 0) {
			while(ptr !=null) {
				st.push(ptr);
				ptr = ptr.left;}
			ptr = st.pop();
			 
			   System.out.printf("%-10s 	| %-10s | %-10s   	   %n", ptr.name, ptr.type, ptr.desc);
			ptr = ptr.right;
		}
	}
}


class Event{
	String name_of_event;
	String type;
	String loc;
	String date;
	String criteria;
	String club;
	
	Event(String name_of_event, String type,String loc,String date,String criteria, String club){
		this.name_of_event=name_of_event;
		this.type=type;
		this.loc=loc;
		this.date=date;
		this.criteria=criteria;
		this.club = club;

}

}
 class Events {
    PriorityQueue<Event> events;

    public Events() {
        events = new PriorityQueue<>(Comparator.comparing(event -> event.date));
    }

    public void enqueue(String name_of_event, String type,String loc,String date,String criteria, String club) {
        events.offer(new Event(name_of_event, type,loc,date,criteria, club));   //.offer used to add in priority queue    
    }

    public void delete() {
        Event deletedEvent = events.poll();
        if (deletedEvent != null) {
            System.out.println("Deleted Event: " + deletedEvent.name_of_event);
        } else {
            System.out.println("No events to delete.");
        }
    }
    
    //events sorted by dates
    public void accessEvents() {
        if (events.isEmpty()) {
            System.out.println("No events.");
        } else {
        	System.out.printf("---------------------------------------------------------------------%n");

 		   System.out.printf("%-10s 	| %-10s | %-10s | %-10s | %-10s 	   %n", "Name", "Club", "Date", "Criteria", "Location");

 		   System.out.printf("----------------------------------------------------------------------%n");
            for (Event event : events) {
                

     		   System.out.printf("%-10s 	| %-10s | %-10s | %-10s  | %-10s	   %n", event.name_of_event, event.club, event.date, event.criteria, event.loc);

            }
        }
    } 
    
    //events in queue
    public void displayEvents() {
        if (events.isEmpty()) {
            System.out.println("No events.");
        } else {
            System.out.println("Events in the queue:");
            for (Event event : events) {
                System.out.println("Event: " + event.name_of_event + ", Date: " + event.date);
            }
        }}
 }
 
 class Student{
		String stud_name;
		String stud_dept;
		String stud_year;
		String stud_phone;
		Student next;
		Student(String stud_name, String stud_dept, String stud_year,String stud_phone){
			this.stud_name = stud_name;
			this.stud_dept = stud_dept;
			this.stud_year = stud_year;
			this.stud_phone = stud_phone;
		}
	}
	class StudentLL{
		Scanner sc = new Scanner(System.in);
		Student head = null;
		Student tail = null;
		
		public boolean addStudent() {
			System.out.println("Enter Name: ");
			String stud_name = sc.next();
			sc.nextLine();
			
			System.out.println("Enter Year (FY/ SY/ TY/ Btech):");
			String stud_year = sc.next();
			sc.nextLine();
			
			System.out.println("Enter Branch:");
			String stud_dept = sc.next();
			sc.nextLine();
			
			System.out.println("Enter phone number:");
			String stud_phone = sc.next();
			sc.nextLine();			
			Student stud = new Student(stud_name,stud_dept,stud_year,stud_phone);
			
			if(head == null) {
				head = stud;
				tail = stud;
				return true;
			}
			else {
				tail.next = stud;
				tail = stud;
				return true;
			}
			
		}
		
		public void display() {
				Student curr = head;
				while(curr!=null) {
					System.out.println("Name: " + curr.stud_name);
					System.out.println("Year: " + curr.stud_year);
					System.out.println("Branch " + curr.stud_dept);
					System.out.println("Contact: " + curr.stud_phone);
				}
			}
	}


public class main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in).useDelimiter("\n");
		Club_members cm = new Club_members();
		
		BST_Club bs = new BST_Club();
		bs.create("Code club", "Technical", "Code club is a club that helps in preparation of opportunities like scholarships, hackathons, etc.", "codeclubhead");
		bs.create("Loop", "Technical", "Team Loop is a Coding Club with that creates awareness about the various Data Structures and Algorithms.", "loopclubhead");	
		bs.create("Mozilla Club", "Technical", "Mozilla Campus Club is a club dedicated to Open source development and community building", "mozillaclubhead");
		bs.create("Kalawant", "Cultural", "A platform that encourages, educates and guides enthusiasts to participate in fine arts performing arts.", "kalawantclubhead");
		
		Events ob=new Events();
		 ob.enqueue("Buffer","Technical","Instru Audi","25-05-2024","SY", "Loop"); 
         ob.enqueue("DSA Craft","Technical","Mech Audi","12-06-2024","SY, TY", "Code Club"); 
		 
		 StudentLL recruit = new StudentLL();
		
		 int n;
		 int choice;
		 int choice1;
		 int choice2;
		 System.out.println("WELCOME TO THE CLUB PORTAL");
		 do {
	            System.out.println("1. Student");
	            System.out.println("2. Club Head");
	            System.out.println("3. Add New Club");
	            System.out.println("Enter your choice: ");
	            n =s.nextInt();
	            
	            switch(n) {
	            
	            case 1:
	            int ch;
	            do {
	            
	            	 System.out.println("1. Display all the Clubs");
	            	 System.out.println("2. Search for a Club");
	                 System.out.println("3. Upcoming Events on Campus");
	                 System.out.println("4. Apply for a Club");
	                 System.out.println("Enter Your Option: ");
	                 ch=s.nextInt();
	                 
	                 switch(ch) {
	                 case 1:
	                	bs.display();
	                	System.out.println("\n");
	                break;
	                 
	                 case 2:
	                     bs.search();
	                     break;
	                     
	                 case 3:
	                	 ob.accessEvents();
	                	 break;
	                 case 4:
	                	  recruit.addStudent();
	                	  System.out.println("Thank you for applying! Please await for further process.\nWe will contact you soon!");
	                	  break;
	                 }
	                 System.out.println("\nDo you want to continue? If yes press 1 else 0");
	                 choice = s.nextInt();
	            }while(choice!=0);
	            break;
	            
	            case 2:
	            	System.out.println("Enter the club name: ");  
	        	    String club = s.next(); 
	        	    s.nextLine();
	        	    
	        	    System.out.println("Enter the password: ");  
	        	    String password = s.next(); 
	        	    s.nextLine();
	        	    
	            	if(bs.clubHead(club, password)) {
	            	System.out.println("Welcome!!");
	            	do {
	            	  System.out.println("\n");
	            	  System.out.println("1. Add New Member");
	                  System.out.println("2. Delete a Member's Details");
	                  System.out.println("3. Update Member Details");
	                  System.out.println("4. Display Members");
	                  System.out.println("5. Add New Events");
	                  System.out.println("6. Display Events");
	                  System.out.println("7. Delete an Event");
	                  System.out.println("8. Club Recruitment");
	                  System.out.println("Enter your option:");
	                  int opt = s.nextInt();
	                  
	                  switch(opt) {
	                  	
	                  case 1:
	              		cm.addNewMember(club);
	              		cm.display();
	              		break;
	                  
	                  case 2:
	                	  cm.delete();
	                	  break;
	                	  
	                  case 3:
	                	  cm.update();
	                	  break;
	                	  
	                  case 4:
	                	  cm.display();
	                	  break;
	                	  
	                  case 5:
	                	  	System.out.println("1. Enter event name: ");
	                	  	String name_of_event2=s.next();
	                	  	s.nextLine();
	                        System.out.println("2. Enter type (technical, cultural, etc):");
	                        String type2=s.next();
	                        s.nextLine();
	                        System.out.println("3. Enter loaction: ");
	                        String loc2=s.next();
	                        s.nextLine();
	                        System.out.println("4. Enter Date of event (dd-mm-yyyy): ");
	                        String date2=s.next();
	                        s.nextLine();
	                        System.out.println("Enter the Criteria for participation:");
	                        String criteria2=s.next();
	                        s.nextLine();
	                        ob.enqueue(name_of_event2,type2,loc2,date2,criteria2, club);
	                        System.out.println("Event added!!");
	                        ob.accessEvents();
	                        break;
	                        
	                  case 6:
	                	  ob.accessEvents();
	                	  break;
	                	  
	                  case 7:
	                	  ob.delete();
	                	  System.out.println("Event deleted!!");
	                	  break;
	                	  
	                  case 8:
	                	  recruit.display();
	                	  break;
	                  }
	                	  
	                  System.out.println();
	                  System.out.println("Do you want to continue? If yes press 1 else 0");
		                 choice2 = s.nextInt();
	            	}while(choice2!=0);
	            	}
	            	else {
	            		System.out.println("Please enter correct password!!");
	            	}
	            	break;
	            	
	            case 3:
	            	System.out.println("PLEASE LOG- IN FIRST");
	            	System.out.println("Please enter the password: ");
	            	String login = s.next();
	            	String login_passowrd = "StudentClubLogin";
	            	s.nextLine();
	            	if(login_passowrd.equals(login)) {
	            		System.out.println("Welcome!!");
	            		System.out.println();
		            	System.out.println("Enter name:");
		            	String club_name = s.next();
		            	s.nextLine(); 
		            	System.out.println("Enter type (technical/cultural/sports) :");
		            	String club_type = s.next();
		            	s.nextLine(); 
		            	System.out.println("Enter description (Write a few lines describing the club):");
		            	String desc = s.next();
		            	s.nextLine(); 
		            	System.out.println("Please enter the Password:");
		            	String club_password = s.next();
		            	s.nextLine(); 
		            	bs.create(club_name, club_type, desc, club_password);
		        		System.out.println("New Club added");
		        		bs.display();
	            	}
	            	else {
	            		System.out.println("Please enter the correct passowrd!!");
	            	}
	            	break;
	            	
	        }
	            System.out.println();	 
	            System.out.println("Do you want to continue? If yes press 1 else 0");
                 choice1 = s.nextInt();
           }while(choice1!=0);
	                 
	                
	                	 
	
	                 }
	            }


	            
