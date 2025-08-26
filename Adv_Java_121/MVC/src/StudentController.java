
public class StudentController {
	private StudentView view;
	private StudentModel model;
	
	public StudentController(StudentView view,StudentModel model) {
		this.model=model;
		this.view=view;
	}
	
	public int getStd_id() {
		return model.getStd_id();
	}
	public void setStd_id(int std_id) {
		model.setStd_id(std_id);
	}
	public String getStd_name() {
		return model.getStd_name();
	}
	public void setStd_name(String std_name) {
		model.setStd_name(std_name);
	}
	public String getStd_course() {
		return model.getStd_course();
	}
	public void setStd_course(String std_course) {
		model.setStd_course(std_course);
	}
	public double getStd_fee() {
		return model.getStd_fee();
	}
	public void setStd_fee(double std_fee) {
		model.setStd_fee(std_fee);
	}
	
	public void updateView() {
		view.std_details(model.getStd_id(), model.getStd_name(), model.getStd_course(), model.getStd_fee());		
	}
}
