package pojoClassForSerializationAndDeserialization;

public class EmpPojoClass {

	String eName;
	String[] email;
	int[] phNo;
	SpousePojoClass spouse;

	public EmpPojoClass() {

	}

	public EmpPojoClass(String eName, String[] email, int[] phNo, SpousePojoClass spouse) {
		super();
		this.eName = eName;
		this.email = email;
		this.phNo = phNo;
		this.spouse = spouse;
	}

	public EmpPojoClass(String[] email, int[] phNo) {
		super();
		this.email = email;
		this.phNo = phNo;
	}

	/**
	 * @return the eName
	 */
	public String geteName() {
		return eName;
	}

	/**
	 * @return the email
	 */
	public String[] getEmail() {
		return email;
	}

	/**
	 * @return the phNo
	 */
	public int[] getPhNo() {
		return phNo;
	}

	/**
	 * @return the spouse
	 */
	public SpousePojoClass getSpouse() {
		return spouse;
	}

	/**
	 * @param eName the eName to set
	 */
	public void seteName(String eName) {
		this.eName = eName;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String[] email) {
		this.email = email;
	}

	/**
	 * @param phNo the phNo to set
	 */
	public void setPhNo(int[] phNo) {
		this.phNo = phNo;
	}

	/**
	 * @param spouse the spouse to set
	 */
	public void setSpouse(SpousePojoClass spouse) {
		this.spouse = spouse;
	}
}
