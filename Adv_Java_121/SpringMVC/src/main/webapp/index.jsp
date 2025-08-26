<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee</title>
</head>
<body>
	<h1>Add Employee Details</h1>
	
	<form action="/list" method="post" enctype="multipart/form-data">
		Employee Name :
		<input type="text" name="emp_name"/> <br/><br/> 
		Employee Gender :
		<input type="radio" name="emp_gender" value="male" />Male
		<input type="radio" name="emp_gender" value="female" />Female <br/><br/> 
		Employee Email :
		<input type="email" name="emp_email" /> <br/><br/> 
		Employee Department :
		<select name="emp_dept">
			<option>HR</option>
			<option>Salesman</option>
			<option>Team Leader</option>
			<option>Manager</option>
			<option>Accounts</option>
		</select><br/><br/> 
		Employee Salary :
		<input type="tel" name="emp_sal" step="0.01" /> <br/><br/> 
		Employee Phone Number :
		<input type="tel" name="emp_phone" pattern="[0-9]{10}" /> <br/><br/> 
		Employee Photo :
		<input type="file" name="emp_photo" /> <br/><br/> 
		
		<input type="submit" />
		
	</form> 
</body>
</html>