
public class MVCEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmployeeModel model=new EmployeeModel();
		model.setEmp_id(101);
		model.setEmp_name("Datapro");
		model.setEmp_dept("Trainer");
		model.setEmp_sal(154544.65);
		
		EmployeeView view =new EmployeeView();
		
		EmployeeController controller=new EmployeeController(model, view);		
		controller.updateView();
		
		controller.setEmp_name("Vinod Kumar");
		System.out.println("After updating the data");
		controller.updateView();
	}

}
