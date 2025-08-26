<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Base64"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Employee</title>
</head>
<body>
	<h1>Edit Employee Details</h1>
	
	<form action="/update" method="post" enctype="multipart/form-data">
		<input type="hidden" name="emp_id" value="${data.emp_id}" />
		Employee Name :
		<input type="text" name="emp_name" value="${data.emp_name}"/> <br/><br/> 
		Employee Gender :
		<input type="radio" name="emp_gender" value="male" ${data.emp_gender == 'male' ? 'checked' : ''} />Male
		<input type="radio" name="emp_gender" value="female" ${data.emp_gender == 'female' ? 'checked' : ''}/>Female <br/><br/> 
		Employee Email :
		<input type="email" name="emp_email" value="${data.emp_email}" /> <br/><br/> 
		Employee Department :
		<select name="emp_dept">
			<option ${data.emp_dept == 'HR' ? 'selected' : ''}>HR</option>
			<option ${data.emp_dept == 'Salesman' ? 'selected' : ''}>Salesman</option>
			<option ${data.emp_dept == 'Team Leader' ? 'selected' : ''}>Team Leader</option>
			<option ${data.emp_dept == 'Manager' ? 'selected' : ''}>Manager</option>
			<option ${data.emp_dept == 'Accounts' ? 'selected' : ''}>Accounts</option>
		</select><br/><br/> 
		Employee Salary :
		<input type="tel" name="emp_sal" step="0.01" value="${data.emp_sal}" /> <br/><br/> 
		Employee Phone Number :
		<input type="tel" name="emp_phone" pattern="[0-9]{10}" value="${data.emp_phone}"/> <br/><br/> 
		Employee Photo :
		<input type="file" name="emp_photo"  value={}/> <br/><br/> 
		Current Photo :
		<img src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(data.emp_photo)}" width="100"/> <br/>
		<input type="submit" />
		
	</form>
</body>
</html>