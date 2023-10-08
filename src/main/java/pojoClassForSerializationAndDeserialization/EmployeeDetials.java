package pojoClassForSerializationAndDeserialization;

public class EmployeeDetials {

	String eName;
	String eID;
	int phNo;
	String email;
	String address;
	
	public EmployeeDetials() {
		
	}
	
	public EmployeeDetials(String eName, String eID, int phNo, String email, String address) {
		super();
		this.eName = eName;
		this.eID = eID;
		this.phNo = phNo;
		this.email = email;
		this.address = address;
	}
	/**
	 * @return the eName
	 */
	public String geteName() {
		return eName;
	}
	/**
	 * @return the eID
	 */
	public String geteID() {
		return eID;
	}
	/**
	 * @return the phNo
	 */
	public int getPhNo() {
		return phNo;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param eName the eName to set
	 */
	public void seteName(String eName) {
		this.eName = eName;
	}
	/**
	 * @param eID the eID to set
	 */
	public void seteID(String eID) {
		this.eID = eID;
	}
	/**
	 * @param phNo the phNo to set
	 */
	public void setPhNo(int phNo) {
		this.phNo = phNo;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
}
