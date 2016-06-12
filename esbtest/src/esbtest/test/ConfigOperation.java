package esbtest.test;

public enum ConfigOperation {
	Add("Add"), Update("Update"), Delete("Delete"), Select("Select");

	private String desc;

	private ConfigOperation(String op) { this.desc = op; }

	public String toString(){
	    return this.desc;
	}
}
