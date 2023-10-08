package pojoClassForSerializationAndDeserialization;

public class SpousePojoClass {

	String sName;
	String email;
	int phNo;

	public SpousePojoClass() {

	}
	public SpousePojoClass(String sName, String eMail, int phNo) {
		super();
		this.sName = sName;
		this.email = eMail;
		this.phNo = phNo;
	}
	/**
	 * @return the sName
	 */
	public String getsName() {
		return sName;
	}
	/**
	 * @return the eMail
	 */
	public String geteMail() {
		return email;
	}
	/**
	 * @return the phNo
	 */
	public int getPhNo() {
		return phNo;
	}
	/**
	 * @param sName the sName to set
	 */
	public void setsName(String sName) {
		this.sName = sName;
	}
	/**
	 * @param eMail the eMail to set
	 */
	public void seteMail(String eMail) {
		this.email = eMail;
	}
	/**
	 * @param phNo the phNo to set
	 */
	public void setPhNo(int phNo) {
		this.phNo = phNo;
	}



}
