/*
 * I declare that this code was written by me. 
 * I do not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Edry Rezal
 * Student ID: {22020860}
 * Class: {W65J}
 * Date/Time created: Wednesday 21-12-2022 11:37
 */

/**
 * @author 22020860
 *
 */
public class Ward {
	
	private String ward;
	private String description;
	private int bedCount;
	private double bedCharge;

	
	public Ward(String ward, String description, int bedCount, double bedChange) {
		this.ward =ward;
		this.description = description;
		this.bedCount = bedCount;
		this.bedCharge = bedChange;
		
	}
	public String getWard() {
		return ward;
	}
	public String getDescription() {
		return description;
	}
	public int getBedCount() {
	  return bedCount;
	}
	public double getBedCharge() {
		return bedCharge;
	}

}
