
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmployeeModel model=new EmployeeModel();
		model.setEmp_id(101);
		model.setEmp_name("Nuthan");
		model.setDept_id(10);
		model.setEmp_salary(15000);
		model.setEmp_phone(9966783739l);
		
		EmployeeView view=new EmployeeView();
		
		EmployeeController controller=new EmployeeController(view, model);
		
		controller.updateView();
		
		System.out.println("After updating Details");
		controller.setEmp_id(102);
		controller.updateView();

	}

}
