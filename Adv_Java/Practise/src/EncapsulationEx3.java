class StudentEx2{
	private int std_id=102;
	private String std_name="Sai Kumar";
	private String std_class="Degree 3rd year";
	
	public int getStd_id() {
		return std_id;
	}
	public String getStd_name() {
		return std_name;
	}
	public String getStd_class() {
		return std_class;
	}
		
}

public class EncapsulationEx3 {

	public static void main(String[] args) {
		StudentEx2 obj=new StudentEx2();
		System.out.println("Student ID :"+obj.getStd_id());
		System.out.println("Student Name :"+obj.getStd_name());
		System.out.println("Student Class :"+obj.getStd_class());	
		
	}

}

