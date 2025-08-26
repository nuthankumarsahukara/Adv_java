
public class StudentMVC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StudentView view=new StudentView();
		StudentModel model=new StudentModel();
		model.setStd_id(101);
		model.setStd_name("Nuthan");
		model.setStd_course("Java Full Stack");
		model.setStd_fee(25000);
		
		StudentController controller=new StudentController(view, model);
		controller.updateView();
		
		model.setStd_fee(35000);
		System.out.println("\nAfter Updating the Data \n");
		controller.updateView();
		
	}

}
