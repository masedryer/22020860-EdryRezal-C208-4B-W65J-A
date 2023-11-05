/*
 * I declare that this code was written by me. 

 * I do not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Edry Rezal
 * Student ID: {22020860}
 * Class: {W65J}
 * Date/Time created: Wednesday 21-12-2022 12:02
 */

/**
 * @author 22020860
 *
 */
public class Patient {
	
	
	private String nric4;
	private String name;
	private String ward;
	private int bed;
	private String dateWarded;
	private String dateDischarged;
	private int visitorCount;
	
	public Patient(String nric4,String name,String ward, int bed,String dateWarded,String dateDischarged,int visitorCount) {
		this.nric4 = nric4;
		this.name = name;
		this.ward = ward;
		this.bed = bed;
		this.dateWarded = dateWarded;
		this.dateDischarged = dateDischarged;
		this.visitorCount = visitorCount;
		this.setDateDischarged(dateDischarged);
		this.setVisitorCount(visitorCount);
	}
	public Patient(String nric4,String name,String ward, int bed,String dateWarded) {
		this.nric4 = nric4;
		this.name = name;
		this.ward = ward;
		this.bed = bed;
		this.dateWarded = dateWarded;
		this.dateDischarged = "";
		this.visitorCount = 0;
	}
	public String getNric4() {
		return nric4;
	}
	public String getName() {
		return name;
	}
	public String getWard() {
		return ward;
	}
	public int getBed() {
		return bed;
	}
	public String getDateWarded() {
		return dateWarded;
	}
	public String getDateDischarged() {
		return dateDischarged;
	}
	public void setDateDischarged(String dateDischarged) {
		this.dateDischarged = dateDischarged;
	}
	public int getVisitorCount() {
		return visitorCount;
	}
	public void setVisitorCount(int visitorCount) {
		this.visitorCount = visitorCount;
	}
	public void display() {
		System.out.println("Patient Name    : " + name);
		System.out.println("Ward            : " + ward);
		System.out.println("Bed             : " + bed);
		System.out.println("Date warded     : " + dateWarded);
		System.out.println("Date Discharged : " + dateDischarged);
		System.out.println("No.of visitor(s): " + visitorCount);
		System.out.println("------------------------------");
	}
	
	}

