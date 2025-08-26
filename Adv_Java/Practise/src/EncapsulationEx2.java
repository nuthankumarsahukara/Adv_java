class StudentEx1{
	private int std_id;
	private String std_name;
	private String std_class;
	
	public void setStd_id(int std_id) {
		this.std_id = std_id;
	}
	public void setStd_name(String std_name) {
		this.std_name = std_name;
	}
	public void setStd_class(String std_class) {
		this.std_class = std_class;
	}
	public void details() {
		System.out.println("Student ID :"+std_id);
		System.out.println("Student Name :"+std_name);
		System.out.println("Student Class :"+std_class);
	}
	
}

public class EncapsulationEx2 {

	public static void main(String[] args) {
		StudentEx1 obj=new StudentEx1();
		obj.setStd_id(109);
		obj.setStd_name("Vinod Kumar");
		obj.setStd_class("Inter 2nd year");
		
		obj.details();
	}

}

