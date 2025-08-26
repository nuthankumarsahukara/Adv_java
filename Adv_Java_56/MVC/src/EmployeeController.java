
public class EmployeeController {
	private EmployeeView view;
	private EmployeeModel model;

	public EmployeeController(EmployeeModel model,EmployeeView view) {
		this.model=model;
		this.view=view;
	}
	
	public int getEmp_id() {
		return model.getEmp_id();
	}
	public void setEmp_id(int emp_id) {
		model.setEmp_id(emp_id);
	}
	public String getEmp_name() {
		return model.getEmp_name();
	}
	public void setEmp_name(String emp_name) {
		model.setEmp_name(emp_name);
	}
	public String getEmp_dept() {
		return model.getEmp_dept();
	}
	public void setEmp_dept(String emp_dept) {
		model.setEmp_dept(emp_dept);
	}
	public double getEmp_sal() {
		return model.getEmp_sal();
	}
	public void setEmp_sal(double emp_sal) {
		model.setEmp_sal(emp_sal);
	}

	public void updateView() {
		view.emp_details(model.getEmp_id(), model.getEmp_name(), model.getEmp_dept(), model.getEmp_sal());
	}
}
