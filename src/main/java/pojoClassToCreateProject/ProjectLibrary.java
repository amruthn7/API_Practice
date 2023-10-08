package pojoClassToCreateProject;

public class ProjectLibrary {
	
	//Declaring key variables globlly
	String createdBy;
	String projectName;
	String status;
	int teamSize;
	
	//creating constructor to initialize the variables
	public ProjectLibrary(String createdBy, String projectName, String status, int teamSize) {
		super();
		this.createdBy = createdBy;
		this.projectName = projectName;
		this.status = status;
		this.teamSize = teamSize;
	}

	//getter methods
	public String getCreatedBy() {
		return createdBy;
	}

	public String getProjectName() {
		return projectName;
	}

	public String getStatus() {
		return status;
	}

	public int getTeamSize() {
		return teamSize;
	}

	//setter methods
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
}
