package futurebuilder;

import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class futurebuilerportal {
	static Scanner scan_main= new Scanner(System.in);
	static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	static Date date1=null;
	static Date date2=null;
	static Date date3=null;
	static List<Company> loc=new ArrayList<Company>();
	static List<Student> los=new ArrayList<Student>();
	static List<Company> allloc=new ArrayList<Company>();
	static List<Student> alllos=new ArrayList<Student>();
	static PlacementCell pc= new PlacementCell(loc,los);
	public static void main(String[] args) {
		String manu="";
		manu =scan_main.nextLine();
		while(!(manu.equals("Enter Future Builder"))) {
			manu =scan_main.nextLine();
        }
		enteri();
		mody();
	}
	private static void enteri() {
		System.out.println("__________________________________________________________________________________________");
		System.out.println();
		System.out.println("Welcome to Future Builder");
		System.out.println("1) Enter the application");
		System.out.println("2) Exit the application");
		System.out.println();
		System.out.print("Enter your choice (1 or 2) : ");
		int x =scan_main.nextInt();
		while(!(x==1 || x==2)) {
			System.out.print("Enter a correct choice (1 or 2) : ");
			x =scan_main.nextInt();
        }
		if (x==2){
			System.out.print("Thanks For Using FutureBuilder!!!!!!");
			System.exit(0);
		}
	}
	private static void mody() {
		System.out.println("__________________________________________________________________________________________");
		System.out.println();
		System.out.println("Choose The mode you want to Enter in : ");
		System.out.println("1) Enter as Student Mode");
		System.out.println("2) Enter as Company Mode");
		System.out.println("3) Enter as Placement Cell Mode");
		System.out.println("4) Return To Main Application");
		System.out.println();
		System.out.print("Enter your choice (1 or 2 or 3 or 4) : ");
		int x =scan_main.nextInt();
		while(!(x==1 || x==2 || x==3 || x==4)) {
			System.out.print("Enter a correct choice (1 or 2 or 3 or 4) : ");
			x =scan_main.nextInt();
        }
		if (x==1){
			stau();
		}
		else if (x==2){
			compy();
		}
		else if (x==3){
			plac();
		}
		else{
			enteri();
		}
	}
	private static void plac() {
		System.out.println("__________________________________________________________________________________________");
		System.out.println();
		System.out.println("Welcome to IIITD Placement Cell");
		System.out.println("1) Open Student Registrations");
		System.out.println("2) Open Company Registrations");
		System.out.println("3) Get Number of Student Registrations");
		System.out.println("4) Get Number of Company Registrations");
		System.out.println("5) Get Number of Offered/Unoffered/Blocked Students");
		System.out.println("6) Get Student Details");
		System.out.println("7) Get Company Details");
		System.out.println("8) Get Average Package");
		System.out.println("9) Get Company Process Results");
		System.out.println("10) Begin Placement Drive");
		System.out.println("11) Back");
		System.out.println();
		System.out.print("Enter your choice (1 or 2 or 3 or 4 or 5 or 6 or 7 or 8 or 9 or 10 or 11) : ");
		int x =scan_main.nextInt();
		while(!(x==1 || x==2 || x==3 || x==4 || x==5 || x==6 || x==7 || x==8 || x==9 || x==10 || x==11)) {
			System.out.print("Enter a correct choice (1 or 2 or 3 or 4 or 5 or 6 or 7 or 8 or 9 or 1or 11) : ");
			x =scan_main.nextInt();
        }
		if (x==11){
			mody();
		}
		else if(x==7) {
			System.out.print("Enter the name of company : ");
			scan_main.nextLine();
			String manu=scan_main.nextLine();
			boolean g=false;
			for(Company ci:allloc) {
				if(ci.name.equals(manu)) {
					pc.getcompdet(ci);
					g=true;
					break;
				}
			}
			if(!g) {
				System.out.println("No such company exixts");
			}
			plac();
		}
		else if(x==9){
			System.out.print("Enter the name of company : ");
			scan_main.nextLine();
			String manu=scan_main.nextLine();
			boolean g=false;
			for(Company ci:allloc) {
				if(ci.name.equals(manu)) {
					pc.getcompro(ci);
					g=true;
					break;
				}
			}
			if(!g) {
				System.out.println("No such company exixts");
			}
			plac();
		}
		else if(x==6){
			System.out.print("Enter the name of the student : ");
			scan_main.nextLine();
			String manu=scan_main.nextLine();
			System.out.print("Enter the roll no. of the student : ");
			int ghy=scan_main.nextInt();
			boolean g=false;
			for(Student ci:alllos) {
				if(ci.name.equals(manu) && ghy==ci.rollno) {
					pc.getstudentdetail(ci,scan_main);
					g=true;
					break;
				}
			}
			if(!g) {
				System.out.println("No such student exixts");
			}
			plac();
		}
		else if(x==8){
			pc.averagepack();
			plac();
		}
		else if(x==5){
			pc.getplres();
			plac();
		}
		else if(x==4){
			pc.getcomno();
			plac();
		}
		else if(x==3){
			pc.getstuno();
			plac();
		}
		else if(x==2){
			if(pc.flagc) {
				System.out.print("Please enter sart time for registration (dd/MM/yyyy HH:mm:ss) : ");
				scan_main.nextLine();
				String d1=scan_main.nextLine();
				do {
					try {
						date1 = simpleDateFormat.parse(d1);
						break;
					} catch (ParseException e) {
						e.printStackTrace();
					}
					System.out.print("Enter date in only correct format (dd/MM/yyyy HH:mm:ss) : ");
					d1=scan_main.nextLine();
				}while(true);
				System.out.print("Please enter end time for registration (dd/MM/yyyy HH:mm:ss) : ");
				String d2=scan_main.nextLine();
				do {
					try {
						date2 = simpleDateFormat.parse(d2);
						break;
					} catch (ParseException e) {
						e.printStackTrace();
					}
					System.out.print("Enter date in only correct format (dd/MM/yyyy HH:mm:ss) : ");
					d2=scan_main.nextLine();
				}while(true);
				if(date1.compareTo(date2) < 0){
					pc.setcopreg(date1,date2);
					pc.flagc=false;
				}
			}
			else {
				System.out.println("Company registration timings have already been set!!");
			}
			plac();
		}
		else if(x==10) {
			if(!pc.flagc && !pc.flags) {
				System.out.print("Please enter current time (dd/MM/yyyy HH:mm:ss) : ");
				scan_main.nextLine();
				String d2=scan_main.nextLine();
				do {
					try {
						date3 = simpleDateFormat.parse(d2);
						break;
					} catch (ParseException e) {
						e.printStackTrace();
					}
					System.out.print("Enter date in only correct format (dd/MM/yyyy HH:mm:ss) : ");
					d2=scan_main.nextLine();
				}while(true);
				if(pc.src.compareTo(date2) <= 0) {
					pc.mainflag=true;
				}
				else {
					System.out.println("Registration for students have not yet completed!!");
				}
			}
			else {
				System.out.println("Registration for students or Company have not yet started!!");
			}
			plac();
		}
		else {
			if(pc.flags) {
				if(!pc.flagc) {
					System.out.print("Please enter sart time for registration (dd/MM/yyyy HH:mm:ss) : ");
					scan_main.nextLine();
					String d1=scan_main.nextLine();
					do {
						try {
							date1 = simpleDateFormat.parse(d1);
							break;
						} catch (ParseException e) {
							e.printStackTrace();
						}
						System.out.print("Enter date in only correct format (dd/MM/yyyy HH:mm:ss) : ");
						d1=scan_main.nextLine();
					}while(true);
					System.out.print("Please enter end time for registration (dd/MM/yyyy HH:mm:ss) : ");
					String d2=scan_main.nextLine();
					do {
						try {
							date2 = simpleDateFormat.parse(d2);
							break;
						} catch (ParseException e) {
							e.printStackTrace();
						}
						System.out.print("Enter date in only correct format (dd/MM/yyyy HH:mm:ss) : ");
						d2=scan_main.nextLine();
					}while(true);
					if(pc.crc.compareTo(date1) <= 0 && date1.compareTo(date2) < 0) {
						pc.setstureg(date1,date2);
						pc.flags=false;
					}
					else{
						System.out.print("Dates entered are either not in increasing order or are before Company registration end date");
					}
					
				}
				else {
					System.out.println("Please wait for company registrations to get over!!");
				}
			}
			else {
				System.out.println("Student registration timings have already been set!!");
			}
			plac();
		}
	}
	public static void stau() {
		System.out.println("__________________________________________________________________________________________");
		System.out.println();
		System.out.println("Choose the Student Query to perform-");
		System.out.println("1) Enter as a Student");
		System.out.println("2) Add students");
		System.out.println("3) Back");
		System.out.println();
		System.out.print("Enter your choice (1 or 2 or 3 ) : ");
		int x =scan_main.nextInt();
		while(!(x==1 || x==2 || x==3)) {
			System.out.print("Enter a correct choice (1 or 2 or 3) : ");
			scan_main.nextLine();
			x =scan_main.nextInt();
        }
		if (x==1){
			System.out.print("Enter the name of the student : ");
			scan_main.nextLine();
			String manu=scan_main.nextLine();
			System.out.print("Enter the roll no. of the student : ");
			int ghy=scan_main.nextInt();
			boolean g=false;
			for(Student ci:alllos) {
				if(ci.name.equals(manu) && ghy==ci.rollno) {
					ci.stuportal(scan_main,pc,simpleDateFormat);
					g=true;
					break;
				}
			}
			if(!g) {
				System.out.println("No such student exixts");
			}
			stau();
		}
		else if(x==2) {
			System.out.print("Enter no. of students to add : ");
			x =scan_main.nextInt();
			String d,y;
			int b;
			float c;
			for(int i=0;i<x;i++) {
				System.out.println("Please enter student "+ (i+1) +"'s Name, Roll No, CGPA, Branch(in line by line order) : ");
				scan_main.nextLine();
				d=scan_main.nextLine();
				b=scan_main.nextInt();
				c=scan_main.nextFloat();
				scan_main.nextLine();
				y=scan_main.next();
				alllos.add(new Student(d,b,c,y,new ArrayList<Company>(),new ArrayList<Company>(),new ArrayList<Company>()));
			}
			stau();
		}
		else{
			mody();
		}
	}
	public static void compy() {
		System.out.println("__________________________________________________________________________________________");
		System.out.println();
		System.out.println("Choose the Company Query to perform");
		System.out.println("1) Add Company and Details");
		System.out.println("2) Choose Company");
		System.out.println("3) Get Available Companies");
		System.out.println("4) Back");
		System.out.println();
		System.out.print("Enter your choice (1 or 2 or 3 or 4) : ");
		int x =scan_main.nextInt();
		while(!(x==1 || x==2 || x==3 || x==4)) {
			System.out.print("Enter a correct choice (1 or 2 or 3 or 4) : ");
			x =scan_main.nextInt();
        }
		if (x==1){
			System.out.println("Please enter Company's Name, Role, CTC (in LPA) and required CGPA (in line by line order) : ");
			scan_main.nextLine();
			String d=scan_main.nextLine();
			String b=scan_main.nextLine();
			float c=scan_main.nextFloat();
			float y=scan_main.nextFloat();
			allloc.add(new Company(d,b,c,y,new ArrayList<Student>(),new ArrayList<Student>()));
			compy();
		}
		else if(x==2){
			int co=1;
			for(Company a:allloc) {
				System.out.print("\t"+co+ ") ");
				System.out.println("Name: "+a.name);
				co+=1;
			}
			if(co==1) {
				System.out.println("No company has been yet added");
				compy();
			}
			else {
				System.out.print("Choose To enter into mode of Available Companies : ");
				x=scan_main.nextInt();
				while(!(x>0 && x<=allloc.size())) {
					System.out.println("No such choice is there !! Please enter a valid choice from above list");
					System.out.print("Re-enter your choice : ");
					x=scan_main.nextInt();
				}
				allloc.get(x-1).comportal(scan_main,pc,simpleDateFormat);
				compy();
			}
		}
		else if(x==3) {
			int co=1;
			for(Company a:allloc) {
				System.out.print("\t"+co+ ") ");
				System.out.println("Name: "+a.name);
				co+=1;
			}
			if(co==1) {
				System.out.println("No company has been yet added");
				compy();
			}
		}
		else{
			mody();
		}
		
	}
}