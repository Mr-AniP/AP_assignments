package futurebuilder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Company {
	float cgpa;
	float ctc;
	String name;
	String role;
	Date regtime=null;
	List<Student> ss;
	List<Student> rs;
	public Company(String _name ,String _role,float _ctc,float _cgpa,List<Student> _ss,List<Student> _rs) {
		this.cgpa=_cgpa;
		this.ctc=_ctc;
		this.name=_name;
		this.role=_role;
		this.ss=_ss;
		this.rs=_rs;
	}
	private void updatecg(float x) {
		this.cgpa=x;
	}
	private void updatect(float x) {
		this.ctc=x;
	}
	private void updaterole(String x) {
		this.role=x;
	}
	public void printme() {
		System.out.println("Company name "+this.name);
		System.out.println("\t   Company role "+this.role);
		System.out.println("\t   Company package "+this.ctc);
		System.out.println("\t   Required CGPA "+this.cgpa);
	}
	public void getselectedstudents() {
		System.out.println("Selected Students are as follows :");
		int co=1;
		for(Student a:ss) {
			System.out.print("\t" +co+ ") ");
			System.out.println("Name: "+a.name);
			System.out.println("\t   RollNo: "+a.rollno);
			System.out.println("\t   CGPA: "+a.cgpa);
			System.out.println("\t   Branch: "+a.branch);
			co+=1;
		}
		if(co==1) {
			System.out.println("NONE");
		}
	}
	private void selectstu(int x) {
		int i=0,k;
		Student kp;
		Random rand = new Random();
		while(rs.size()>0 && i!=x) {
			k=rand.nextInt(rs.size());
	        kp=rs.get(k);
	        rs.remove(k);
	        kp.ofr.add(this);
	        if(kp.onu==0 || (kp.offby.ctc<ctc)) {
	        	if(kp.onu==1) {
	        		kp.offby.ss.remove(kp);
	        	}
	        	ss.add(kp);
	        	makeoffer(kp,this);
	        	i++;
	        }
	    }
	}
	private void makeoffer(Student s,Company c) {
		s.offby=c;
		s.onu=1;
	}
	public void comportal(Scanner sr,PlacementCell pc,SimpleDateFormat simpleDateFormat) {
		System.out.println("__________________________________________________________________________________________");
		System.out.println();
		System.out.println("Welcome "+this.name+" !!");
		System.out.println("1) Update Role");
		System.out.println("2) Update Package");
		System.out.println("3) Update CGPA criteria");
		System.out.println("4) Register To Institute Drive");
		System.out.println("5) Get Selected Students");
		System.out.println("6) Select Students");
		System.out.println("7) Back");
		System.out.println();
		System.out.print("Enter your choice (1 or 2 or 3 or 4 or 5 or 6 or 7) : ");
		int x =sr.nextInt();
		while(!(x==1 || x==2 || x==3 || x==4 || x==5 || x==6 || x==7)) {
			System.out.print("Enter a correct choice (1 or 2 or 3 or 4 or 5 or 6 or 7) : ");
			x =sr.nextInt();
        }
		if (x==1){
			System.out.print("Please enter the new role : ");
			sr.nextLine();
			String gu =sr.nextLine();
			updaterole(gu);
			System.out.println("Updated succesfully!!");
			comportal(sr,pc,simpleDateFormat);
		}
		else if (x==2){
			System.out.print("Please enter the new package (in LPA) : ");
			sr.nextLine();
			float gu =sr.nextFloat();
			updatect(gu);
			System.out.println("Updated succesfully!!");
			comportal(sr,pc,simpleDateFormat);
		}
		else if (x==4){
			if(regtime!=null) {
				System.out.println("Already registered");
			}
			else {
				System.out.print("Please enter current time of registration (dd/MM/yyyy HH:mm:ss) : ");
				sr.nextLine();
				String d1=sr.nextLine();
				do {
					try {
						regtime = simpleDateFormat.parse(d1);
						break;
					} catch (ParseException e) {
						e.printStackTrace();
					}
					System.out.print("Enter date in only correct format (dd/MM/yyyy HH:mm:ss) : ");
					d1=sr.nextLine();
				}while(true);
				if(pc.crc.compareTo(regtime) >= 0 && pc.cro.compareTo(regtime) < 0) {
					pc.loc.add(this);
					System.out.println("Succesfully registered for placement drive!!");
				}
				else {
					System.out.println("Registration for company has closed");
				}
			}
			comportal(sr,pc,simpleDateFormat);
		}
		else if (x==3){
			System.out.print("Please enter the new required CGPA : ");
			float gu =sr.nextFloat();
			updatecg(gu);
			System.out.println("Updated succesfully!!");
			comportal(sr,pc,simpleDateFormat);
		}
		else if (x==5){
			getselectedstudents();
			comportal(sr,pc,simpleDateFormat);
		}
		else if(x==6) {
			if(pc.mainflag) {
				int xdv =1+(this.name.length());
				selectstu(xdv);
				
			}
			else {
				System.out.println("Please wait for registration cycle to get completed!!");
			}
			comportal(sr,pc,simpleDateFormat);
		}
	}
}
