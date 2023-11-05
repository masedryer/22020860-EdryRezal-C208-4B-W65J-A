import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/*
 * I declare that this code was written by me. 
 * I do not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Edry Rezal
 * Student ID:22020860
 * Class:W65J
 * Date/Time created: Wednesday 21-12-2022 15:02
 */


public class WardManagement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//initialise Ward array with ward objects 
		Ward[] wardArr = new Ward[4];
		Ward wardA = new Ward("A","1 Bed, attached bath/toilet",10,535.00);
		Ward wardB1 = new Ward("B1","4 Bed, attached bath/toilet",20,266.43);
		Ward wardB2 = new Ward("B2","6 Bed, attached bath/toilet",20,83.00);
		Ward wardC = new Ward("C","8 Bed, attached bath/toilet",50,37.00);
		
		wardArr[0] = wardA;
		wardArr[1] = wardB1;
		wardArr[2] = wardB2;
		wardArr[3] = wardC;

		
		//initialise Patient arraylist with patient objects	
		
		Patient patient1 = new Patient("111A","John Lee", "A",2,"01/12/2022");
		Patient patient2 = new Patient("222B","Mary Jane", "B1",11,"02/12/2022");
		Patient patient3 = new Patient("333C","Abdul Musri", "B1",12,"03/12/2022");
		Patient patient4 = new Patient("444D","Jane Tan", "B2",2,"12/12/2022","",3);
		Patient patient5 = new Patient("555E","Paul Tan", "C",2,"02/11/2022","",4);
		Patient patient6 = new Patient("666F","Paul Ng", "C",3,"03/11/2022","09/11/2022",0);
		Patient patient7 = new Patient("777G","Wong Kuan", "C",4,"02/12/2022");
		
		ArrayList<Patient> patientList = new ArrayList<Patient>();
		
		patientList.add(patient1);
		patientList.add(patient2);
		patientList.add(patient3);
		patientList.add(patient4);
		patientList.add(patient5);
		patientList.add(patient6);
		patientList.add(patient7);
	
		



		//display standard menu and ask for option
		int option = -99;
		publicMenu();

		
		//indefinite while loop
		while(option != 10) {
			boolean patientfound = true;
			option = Helper.readInt("\nEnter option or 0 for main menu > ");

			//check for  options
			if(option == 0) {
				//display main menu
				publicMenu();
			} else if (option == 1) {
				//list ward info
				displayWardInfo(wardArr);		
			} else if (option == 2) {
				//display patient in ward
				displayPatientList(patientList);
			} else if (option == 3) {
				//admit patient
				admitPatient(patientList);
			} else if (option == 4) {
				//discharged patient
				patientfound = dischargePatient(patientList);
			} else if (option == 5) {
				//Remove patient visit
				patientfound = removePatient(patientList);
			} else if (option == 6) {
				//register visit
				patientfound = registerVisit(patientList);
			} else if (option == 7) {
				//End visit
				patientfound = endVisit(patientList);
			} else if (option == 8) {
				//End visit
				displayWardOverview(patientList, wardArr);
			} else if (option == 9) {
				displayRevenue(patientList,wardArr); 
			} else if (option == 10) {
				//log out
				System.out.println("\nGood bye!");
			} else {
				//invalid option chosen
				System.out.println("\n*** Invalid option selected ***\n");
			}

			//if patient does not exist based on return boolean
			if (!patientfound) {
				System.out.println("\n*** No such patient in ward ***\n");
			}

		}

	} // end of main



	

	//-------------------------------------------------------------------------------------------------------
	//static method to print the standard menu 
	//-------------------------------------------------------------------------------------------------------
	public static void publicMenu() {
		System.out.println();
		Helper.line(45, "*");
		System.out.println("*****     PATIENT  MANAGEMENT  MENU     *****");
		Helper.line(45, "*");
		System.out.println("1. View all Ward Info");
		System.out.println("2. Display Patient List");
		System.out.println("3. Admit Patient");
		System.out.println("4. Discharge Patient");
		System.out.println("5. Remove Patient");
		System.out.println("6. Register List");
		System.out.println("7. End Visit");
		System.out.println("8. Display Ward Overview");
		System.out.println("9. Display Revenue");
		System.out.println("10. Logout");

	}



	//-------------------------------------------------------------------------------------------------------
	//static method takes in a ward array and list out ward details in a tabular list
	//-------------------------------------------------------------------------------------------------------
	public static void displayWardInfo(Ward[] wardArr) {
		System.out.format("%-5s |  %-27s | %-10s  | %-10s\n","Ward","Description","Bed Count","Bed Charge");

		for (int i=0; i<wardArr.length; i++) {
			if (wardArr[i]!= null) {
				String w = wardArr[i].getWard();
				String d = wardArr[i].getDescription();
				int bCount = wardArr[i].getBedCount();
				double bCharge = wardArr[i].getBedCharge();
				System.out.println("---------------------------------------------------------------");
				String content = String.format("%-5s |  %-10s | %-10d  | %-10.2f",w,d,bCount,bCharge);
				System.out.println(content);
			}
		}

	}


	//-------------------------------------------------------------------------------------------------------
	//static method takes in a patient arraylist and display all the patient information in a tabular list
	//-------------------------------------------------------------------------------------------------------
	public static void displayPatientList(ArrayList<Patient> patientList) {
		Helper.line(215,"-");
		System.out.format("%-100s %-100s","","PATIENT LIST");
		Helper.line(215,"");
		Helper.line(215,"-");
		if (patientList.isEmpty()== true) {
			System.out.println("***** THERE IS NO PATIENTS ****");
		}else if (patientList.isEmpty()== false) {
			String output = "";
			output += String.format("%-30s | %-30s | %-30s | %-30s | %-30s | %-30s | %-30s  \n", "NRIC4","NAME","Ward","Bed","Date Warded", "Date discharged", "Visitor Count");
			for (int i = 0; i < patientList.size(); i++) {
				output += String.format ("%-30s | %-30s | %-30s | %-30s | %-30s | %-30s | %-30s  \n" , patientList.get(i).getNric4() ,patientList.get(i).getName(),patientList.get(i).getWard(),patientList.get(i).getBed(),patientList.get(i).getDateWarded(),patientList.get(i).getDateDischarged(),patientList.get(i).getVisitorCount());     
				
			}System.out.println(output);Helper.line(215,"-");
		}
	}
	


	//-------------------------------------------------------------------------------------------------------
	//static method takes in a patient arraylist and performs the admit patient functionality
	//-------------------------------------------------------------------------------------------------------
	public static void admitPatient(ArrayList<Patient> patientList) {
		Helper.line(215,"-");
		
		System.out.format("%-100s %-100s", "","ADMIT PATIENT");
		Helper.line(215,"-");
		Helper.line(215,"-");

		String nric4Patient = Helper.readString("Enter patient NRIC4>");
		String namePatient = Helper.readString("Enter NAME >");
		String wardPatient = Helper.readString("Enter WARD >");
		int bedPatient = Helper.readInt("Enter BED >")	;	
		String dateWardedPatient = Helper.readString("Enter DATE-WARDED >");		
		
		boolean isDuplicate = false;
		
		for (int i =0; i < patientList.size();i++) {
			if (nric4Patient.equalsIgnoreCase(patientList.get(i).getNric4())&& namePatient.equalsIgnoreCase(patientList.get(i).getName())&& wardPatient.equalsIgnoreCase(patientList.get(i).getWard())&& bedPatient == (patientList.get(i).getBed())&& dateWardedPatient.equalsIgnoreCase(patientList.get(i).getDateWarded())) {
				System.out.println(" This patiient had already exist!");
				isDuplicate = true;
				break;
			}
		} if (isDuplicate == false ) {
			patientList.add(new Patient(nric4Patient,namePatient,wardPatient,bedPatient,dateWardedPatient));
			System.out.println("Patient has beed added!");
		}
		
		
		

	}



	//-------------------------------------------------------------------------------------------------------
	//static method takes in a patient arraylist and performs the discharge patient functionality
	//It will return 'true' if the patient record exist
	//-------------------------------------------------------------------------------------------------------
	public static boolean dischargePatient(ArrayList<Patient> patientList) {
		Helper.line(215,"-");
		
		System.out.format("%-100s %-100s", "","DISCHARGE PATIENT");
		Helper.line(215,"");
		Helper.line(215,"-");
		boolean patientfound = false;
		String namePatient = Helper.readString("Enter patient name >");
		
		for (int i=0; i<patientList.size(); i++) {
			if (namePatient.equalsIgnoreCase(patientList.get(i).getName()) && patientList.get(i).getDateDischarged().equals("")) {
				patientList.get(i).display();
				String discharge= Helper.readString("Enter Date Discharged >");
				int countZero = 0;
				patientList.get(i).setDateDischarged(discharge);
				patientList.get(i).setVisitorCount( countZero);
				patientList.get(i).display();
				System.out.println("** Patient is discharged ***");
				patientfound = true;

			}
			else if (namePatient.equalsIgnoreCase(patientList.get(i).getName()) && patientList.get(i).getDateDischarged()!=("")) {
				System.out.println("The patient had already been discharged!");
			}
		}

		return patientfound;
	}





	//-------------------------------------------------------------------------------------------------------
	//static method takes in a patient arraylist and performs the remove patient functionality
	//It will return 'true' if the patient record exist
	//-------------------------------------------------------------------------------------------------------
	public static boolean removePatient(ArrayList<Patient> patientList) {
		Helper.line(215,"-");
		
		System.out.format("%-100s %-100s", "","REMOVE PATIENT");
		Helper.line(215,"");
		Helper.line(215,"-");
		boolean patientfound = false;
		String namePatient = Helper.readString("Enter patient name >");
		for (int i=0; i<patientList.size(); i++) {
			if (namePatient.equalsIgnoreCase(patientList.get(i).getName())){
				patientList.get(i).display();
				String delete= Helper.readString("Are you sure you want to delete this patient? (y/n) >");
				if (delete.equalsIgnoreCase("y")) {
					patientList.remove(i);
					patientfound = true;
					System.out.println("Patient name " + namePatient + " has been deleted.");

				}
				else if (delete.equalsIgnoreCase("n")) {
					patientfound = true;
					System.out.println("***Removing patient has been canceled.***");
				}
				else {
					System.out.println("Please type (y/n)");
					removePatient(patientList);
				}
			}
			
		}
		return patientfound;
	}


	//-------------------------------------------------------------------------------------------------------
	//static method takes in a patient arraylist and performs the register visit functionality
	//It will return 'true' if the patient record exist
	//-------------------------------------------------------------------------------------------------------
	public static boolean registerVisit(ArrayList<Patient> patientList) {
		Helper.line(215,"-");
		
		System.out.format("%-100s %-100s", "","REGISTER LIST");
		Helper.line(215,"");
		Helper.line(215,"-");
		boolean patientfound = false;
		String namePatient = Helper.readString("Enter patient name >");
		for (int i=0; i<patientList.size(); i++) {
			if (namePatient.equalsIgnoreCase(patientList.get(i).getName())) {
				patientfound = true;
				patientList.get(i).display();
				if (patientList.get(i).getVisitorCount() >= (4)) {
					System.out.println("***No visitors are allowed***");
				}
				else if (patientList.get(i).getDateDischarged() != "") {
					System.out.println("***Patient has been discharged***");
				}
				else if (patientList.get(i).getVisitorCount() >= 0 && patientList.get(i).getVisitorCount() < 4 ) {
					System.out.println("**** Only " + (4 - patientList.get(i).getVisitorCount()) + "patient(s) is allowed!");
					int visitorCount = Helper.readInt("Enter number of new visitor entered >");
					if ((visitorCount + patientList.get(i).getVisitorCount())> 4) {
						System.out.println("***Visitors exceeded***");
					}
					else if ((visitorCount + patientList.get(i).getVisitorCount())< 0) {
						System.out.println("***Invalid number***");
					}
					else if ((visitorCount + patientList.get(i).getVisitorCount()) <= 4 && (visitorCount + patientList.get(i).getVisitorCount()) >= 0 ) {
						patientList.get(i).setVisitorCount(visitorCount + patientList.get(i).getVisitorCount());
						System.out.println("***Please proceed  to the ward***");
					}
				}
			}
		}

		return patientfound;
	}

	//-------------------------------------------------------------------------------------------------------
	//static method takes in a patient arraylist and performs the end visit functionality
	//It will return 'true' if the patient record exist
	//-------------------------------------------------------------------------------------------------------
	public static boolean endVisit(ArrayList<Patient> patientList) {
		Helper.line(215,"-");
		
		System.out.format("%-100s %-100s", "","END VISIT");
		Helper.line(215,"");
		Helper.line(215,"-");
		boolean patientfound = false;
		String namePatient = Helper.readString("Enter patient name >");
		for (int i=0; i<patientList.size(); i++) {
			if (namePatient.equalsIgnoreCase(patientList.get(i).getName())){
				patientfound = true;
				patientList.get(i).display();
				int visitorCount = Helper.readInt("Number of guest leaving >");
				if ((patientList.get(i).getVisitorCount() - visitorCount)< 0){
					System.out.println("***Visitors leaving is more than expected***");
				}
				else if (patientList.get(i).getDateDischarged() != ""){
					System.out.println("***Patient has been discharged***");
				}
				else if (( patientList.get(i).getVisitorCount() - visitorCount)>= 0 && ( patientList.get(i).getVisitorCount()- visitorCount)<= 4) {
					System.out.println("*** Number of visitors still at ward : " + (patientList.get(i).getVisitorCount() - visitorCount) + " ***" );
					patientList.get(i).setVisitorCount(patientList.get(i).getVisitorCount() - visitorCount);
				}
			}
		}
		

		return patientfound;
	}

	
	
	//------------------------------------------------------------------------------------------------------------
	//static method that takes in a patient arraylist, a ward array and display an overview of the ward information
	//------------------------------------------------------------------------------------------------------------
	public static void displayWardOverview (ArrayList<Patient> patientList, Ward[] WardArr) {
		Helper.line(215,"-");
		
		System.out.format("%-100s %-100s", "","WARD OVERVIEW");
		Helper.line(215,"");
		Helper.line(215,"-");
		
		System.out.format("%-30s | %-30s | %-30s | %-30s | %-30s | \n", "Ward","Description","Bed count","Total Patient","Total visitors");
		Helper.line(200,"-");
		int wardPatientCount = 0;
		int wardVisitorCount = 0;
		int patientTotal = 0;
		int visitorTotal = 0;
		int bedCountTotal = 0;
		int [] patientCount = new int[WardArr.length];
		int [] visitorCount = new int [WardArr.length];
		
		
		
		
		
		
		
		
		for (int i=0; i<WardArr.length; i++) {
			wardPatientCount = 0;
			wardVisitorCount = 0;
			bedCountTotal += WardArr[i].getBedCount();

			for(int m = 0; m < patientList.size();m++ ) {
				if (patientList.get(m).getWard().equals(WardArr[i].getWard())) {
					if (patientList.get(m).getDateDischarged().equals("")) {
					wardPatientCount ++;
					wardVisitorCount += patientList.get(m).getVisitorCount();
					patientTotal ++;
					visitorTotal += patientList.get(m).getVisitorCount();
					
					
					patientCount[i] = wardPatientCount;
					visitorCount[i] = wardVisitorCount;
					
					}
			}
					
		/*System.out.println("Hospital Overview");
		System.out.format("%-30s | %-30s | %-30s | ", "Bed count","Total Patients","Total visitors");*/
		

	}
			System.out.format("%-30s | %-30s | %s/%-30s | %-30s | %-30s | \n", WardArr[i].getWard(),WardArr[i].getDescription(),patientCount[i],WardArr[i].getBedCount(),patientCount[i],visitorCount[i]);
	}
		Helper.line(200, "-");
		
		System.out.println("\n ");
		Helper.line(100, "-");
		System.out.format(" %-30s | %-30s | %-30s |\n","Total Bed Count","Total Patient Count","Total Visitor Count");
		Helper.line(100, "-");

		System.out.format("%-30s | %-30s | %-30s |\n", bedCountTotal,patientTotal,visitorTotal);

	}	
	public static void displayRevenue (ArrayList<Patient> patientList, Ward[] WardArr) {
		Helper.line(215, "-");
		System.out.format("%-100s %-100s", "","TOTAL REVENUE");
		Helper.line(215, "");
		Helper.line(215, "-");
		System.out.format("%-30s | %-30s |", "Ward","Revenue");
		System.out.println("");
		Helper.line(215,"-");
		double wardPatientCount = 0;
		double [] patientCount = new double[WardArr.length];
		double totalRevenue = 0;
		for (int i=0; i<WardArr.length; i++) {
			wardPatientCount = 0;
			
			
			for(int m = 0; m < patientList.size();m++ ) {
				if (patientList.get(m).getWard().equals(WardArr[i].getWard())) {
					wardPatientCount ++;
					
					patientCount[i] = wardPatientCount;
					if(patientList.get(m).getWard().equals("A")) {
						patientCount[i] = wardPatientCount*535.00;
					}
					if(patientList.get(m).getWard().equals("B1")) {
						patientCount[i] = wardPatientCount*266.43;
					}
					if(patientList.get(m).getWard().equals("B2")) {
						patientCount[i] = wardPatientCount*83.00;
					}
					if(patientList.get(m).getWard().equals("C")) {
						patientCount[i] = wardPatientCount*37.00;
					}
					totalRevenue += patientCount[i];
				}
				
			}
			
			
			System.out.format("%-30s | %-30s |\n",WardArr[i].getWard(),patientCount[i]);
			
		}
		Helper.line(200, "-");
		
		System.out.println("\n ");
		Helper.line(33, "-");
		System.out.format(" %-30s |","Total Revenue");
		System.out.println("");
		Helper.line(33, "-");
		System.out.format(" %-30s |", totalRevenue);
		System.out.println("");
		Helper.line(33, "-");
		
			
	}
}





