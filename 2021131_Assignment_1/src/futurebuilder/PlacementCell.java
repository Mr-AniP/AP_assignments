package futurebuilder;

import java.util.*;

public class PlacementCell {
	List<Company> loc;
	List<Student> los;
	Date cro;
	Date crc;
	boolean flagc=true;
	boolean flags=true;
	Date sro;
	Date src;
	boolean mainflag=false;
	public PlacementCell(List<Company> _loc,List<Student> _los) {
		this.loc=_loc;
		this.los=_los;
	}
	public void getcomno(){
		System.out.println("No. of company registered : "+ loc.size());
	}
	public void getstuno(){
		System.out.println("No. of Student registered : "+ los.size());
	}
	public void getplres() {
		int p=0,u=0,b=0;
		for(Student a: los) {
			if(a.status.equals("offered")) {
				p++;
			}
			else if(a.status.equals("blocked")){
				b++;
			}
			else {
				u++;
			}
		}
		System.out.println("No. of Student Placed : "+ p);
		System.out.println("No. of Student Unplaced : "+ u);
		System.out.println("No. of Student Blocked : "+ b);
	}
	public void averagepack(){
		int s=0;
		for(Student a: los) {
			if(a.status.equals("offered")) {
				s+=(a.myofe.ctc >= a.offby.ctc)?a.myofe.ctc:a.offby.ctc;
			}
			else if(a.onu==1) {
				s+=a.offby.ctc;
			}
			else {
				s+=0;
			}
		}
		System.out.println("Averge Package offered to Students of the institute (in LPA) : "+ (s/los.size()));
	}
	public void getcompro(Company c) {
		c.getselectedstudents();
	}
	public void getcompdet(Company c) {
		c.printme();
		if (c.ss.size()>0) {
			System.out.println("Selected Students are as follows :");
			int co=1;
			for(Student a:c.ss) {
				System.out.print("\t" +co+ ") ");
				System.out.println("Name: "+a.name);
				System.out.println("\t   RollNo: "+a.rollno);
				co+=1;
			}
			if(co==1) {
				System.out.println("NONE");
			}
		}
		else if(c.regtime==null){
			System.out.println("Company has not registered for placement drive");
		}
		else {
			System.out.println("No Students have been yet selected");
		}
	}
	public void getstudentdetail(Student a,Scanner x) {
		int co=1;
		System.out.println("Companies which have been applied by the student are as follows :");
		for(Company c: a.rs) {
			System.out.println(co+") "+c.name);
			co++;
		}
		co=1;
		System.out.println("Companies which haven\'t been applied by the student are as follows :");
		for(Company c: a.rns) {
			System.out.println(co+") "+c.name);
			co++;
		}
		co=1;
		System.out.println("Companies which have rolled out offer to the student are as follows :");
		for(Company c: a.ofr) {
			System.out.println(co+") "+c.name);
			co++;
		}
		System.out.println();
		System.out.print("Update CGPA ? (YES or NO) : ");
		String manu =x.nextLine();
		while(!(manu.equals("YES") || manu.equals("NO"))) {
			System.out.print("Enter a valid choice (YES or NO) : ");
			manu =x.nextLine();
		}
		if(manu.equals("YES")) {
			if(a.updateto==-1) {
				System.out.print("No update request by Student");
			}
			else {
				System.out.print("Older CGPA : "+a.cgpa);
				a.cgpa=a.updateto;
				a.updateto=-1;
				System.out.print("New CGPA : "+a.cgpa);
				System.out.print("Succesfully updated !!");
			}
		}
	}
	public void setcopreg(Date d1,Date d2){
		cro=d1;
		crc=d2;
	}
	public void setstureg(Date d1,Date d2){
		sro=d1;
		src=d2;
	}
}