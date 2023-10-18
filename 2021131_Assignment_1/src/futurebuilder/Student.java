package futurebuilder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Student {
	Date regtime=null;
	String name;
	int rollno,onu=0;
	float cgpa;
	String branch;
	String status="not-applied";
	Company myofe,offby;
	List<Company> rs;
	List<Company> rns;
	List<Company> ofr;
	float updateto =-1;
	public Student(String _name,int _rol,float _cg, String _branch,List<Company> _rs,List<Company> _rns,List<Company> _ofr){
		this.name=_name;
		this.rollno=_rol;
		this.branch=_branch;
		this.cgpa=_cg;
		this.rs=_rs;
		this.rns=_rns;
		this.ofr=_ofr;
	}
	private boolean iseligible(Company c) {
		if((this.status.equals("offered")) && (this.cgpa>=c.cgpa) && (c.ctc>=(3*myofe.ctc))){
			return true;
		}
		else if((this.status.equals("applied") || this.status.equals("not-applied")) && (this.cgpa>=c.cgpa)) {
			return true;
		}
		else{
			return false;
		}
	}
	private void registermyself(Company c) {
		if(iseligible(c)==true){
			c.rs.add(this);
			this.rs.add(c);
			this.status=(this.status.equals("offered"))?"offered":"applied";
			System.out.println("Succesfully registered!!");
		}
		else {
			this.rns.add(c);
		}
	}
	private void getStatus(){
		if(this.onu==1)
			System.out.println("You have been offerd by "+offby.name+" !! Please accept the offer.");
		else if(this.status.equals("applied"))
			System.out.println("Your application is been considered !! Please wait for results.");
		else if(this.status.equals("offered"))
			System.out.println("You have accepted offer by "+myofe.name+" !!");
		else
			System.out.println("You haven't applied for any company !!");
	}
	private void selectOffer(int i){
		this.onu=0;
		if(i==1) {
			if(this.status.equals("offered")) {
				myofe.ss.remove(this);
			}
			this.status="offered";
			myofe=offby;
		}
		else if(i==0 && (!this.status.equals("offered"))){
			offby.ss.remove(this);
			this.status="blocked";
		}
		else
			offby.ss.remove(this);
	}
	private void updateCg(float a){
		this.updateto=a;
	}
	private void fetchcompnies(PlacementCell pc) {
		if(this.status.equals("blocked")) {
			System.out.println("Unavailable");
		}
		else{
			boolean xc=false;
			for(int i=0;i<pc.loc.size();i++) {
				if(iseligible(pc.loc.get(i))==true){
					System.out.print("\t"+(i+1)+") ");
					pc.loc.get(i).printme();
					xc=true;
				}
			}
			if(xc==false) {
				System.out.println("Unavailable");
			}
		}
	}
	public void stuportal(Scanner sr,PlacementCell pc,SimpleDateFormat simpleDateFormat) {
		System.out.println("__________________________________________________________________________________________");
		System.out.println();
		System.out.println("Welcome "+this.name+" !!");
		System.out.println("1) Register For Placement Drive");
		System.out.println("2) Register For Company");
		System.out.println("3) Get All available companies");
		System.out.println("4) Get Current Status");
		System.out.println("5) Update CGPA");
		System.out.println("6) Accept offer");
		System.out.println("7) Reject offer");
		System.out.println("8) Back");
		System.out.println();
		System.out.print("Enter your choice (1 or 2 or 3 or 4 or 5 or 6 or 7 or 8) : ");
		int x =sr.nextInt();
		while(!(x==1 || x==2 || x==3 || x==4 || x==5 || x==6 || x==7 || x==8)) {
			System.out.print("Enter a correct choice (1 or 2 or 3 or 4 or 5 or 6 or 7 or 8) : ");
			x =sr.nextInt();
        }
		if (x==1){
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
				if(pc.src.compareTo(regtime) >= 0 ) {
					if(pc.sro.compareTo(regtime) < 0) {
						pc.los.add(this);
						System.out.println("Succesfully registered for placement drive!!");
					}
					else {
						System.out.println("Registration for students has not yet open!! Please Wait");
					}
				}
				else {
					System.out.println("Registration for students has closed");
				}
			}
			stuportal(sr,pc,simpleDateFormat);
		}
		else if (x==2){
			System.out.print("Please enter the Company name : ");
			sr.nextLine();
			String gu =sr.nextLine();
			boolean g=false;
			for(Company ci:pc.loc) {
				if(ci.name.equals(gu)) {
					registermyself(ci);
					g=true;
					break;
				}
			}
			if(!g) {
				System.out.println("No such company has registered for placement drive");
			}
			stuportal(sr,pc,simpleDateFormat);
		}
		else if (x==3){
			fetchcompnies(pc);
			stuportal(sr,pc,simpleDateFormat);
		}
		else if (x==4){
			getStatus();
			stuportal(sr,pc,simpleDateFormat);
		}
		else if (x==5){
			System.out.print("Please enter the new CGPA : ");
			float gu =sr.nextFloat();
			updateCg(gu);
			System.out.println("Request for update has been succesfully made!!");
			stuportal(sr,pc,simpleDateFormat);
		}
		else if (x==6){
			selectOffer(1);
			stuportal(sr,pc,simpleDateFormat);
		}
		else if (x==7){
			selectOffer(0);
			stuportal(sr,pc,simpleDateFormat);
		}
	}
}