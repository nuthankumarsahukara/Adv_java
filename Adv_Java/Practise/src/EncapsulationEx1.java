class StudentEx{
	private int std_id;
	private String std_name;
	private String std_class;
	public int getStd_id() {
		return std_id;
	}
	public void setStd_id(int std_id) {
		this.std_id = std_id;
	}
	public String getStd_name() {
		return std_name;
	}
	public void setStd_name(String std_name) {
		this.std_name = std_name;
	}
	public String getStd_class() {
		return std_class;
	}
	public void setStd_class(String std_class) {
		this.std_class = std_class;
	}
	
	
}

public class EncapsulationEx1 {

	public static void main(String[] args) {
		StudentEx obj=new StudentEx();
		obj.setStd_id(101);
		obj.setStd_name("Vinod");
		obj.setStd_class("Inter 1st year");
		
		System.out.println("Student ID :"+obj.getStd_id());
		System.out.println("Student Name :"+obj.getStd_name());
		System.out.println("Student Class :"+obj.getStd_class());
	}

}
