
public class EmployeeController {
	public EmployeeView view;
	public EmployeeModel model;
	
	public EmployeeController(EmployeeView view,EmployeeModel model) {
		this.model=model;
		this.view=view;	
	}
	
		public void setEmp_id(int emp_id) {
			model.setEmp_id(emp_id);
		}		
		public int getEmp_id(){
			return model.getEmp_id();
		}
		public String getEmp_name() {
			return model.getEmp_name();
		}
		public void setEmp_name(String emp_name) {
			model.setEmp_name(emp_name);
		}
		public double getEmp_salary() {
			return model.getEmp_salary();
		}
		public void setEmp_salary(double emp_salary) {
			model.setEmp_salary(emp_salary);
		}
		public int getDept_id() {
			return model.getDept_id();
		}
		public void setDept_id(int dept_id) {
			model.setDept_id(dept_id);
		}
		public long getEmp_phone() {
			return model.getEmp_phone();
		}
		public void setEmp_phone(long emp_phone) {
			model.setEmp_phone(emp_phone);
		}
		
		public void updateView() {
			view.emp_details(model.getEmp_id(), model.getEmp_name(), model.getEmp_salary(), model.getDept_id(), model.getEmp_phone());
		}
}
