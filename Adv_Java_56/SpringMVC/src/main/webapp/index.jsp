<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Details</title>
<style>
	.flexbox{
		display:flex;
		justify-content: space-around;
		align-items: center;
	}
</style>
</head>
<body>
	<div class="flexbox">
		<h1>Add Student Details</h1>
		<button onclick="window.location='/list'">List All Student</button>
	</div>
	<form action="/list" method="post" enctype="multipart/form-data">
		Student Name :<input type="text" name="std_name"/><br/><br/>
		Student DOB :<input type="date" name="std_date"/><br/><br/>
		Student Gender :
		<input type="radio" name="std_gender" value="male"/>Male
		<input type="radio" name="std_gender" value="female"/>Female<br/><br/>
		Student Phone Number:
		<input type="tel" pattern="[0-9]{10}" name="std_phone"/><br/><br/>
		Student Course :
		<select name="std_course">
			<option>Java Full Stack</option>
			<option>Python Full Stack</option>
			<option>Power BI</option>
			<option>.Net Full Stack</option>
			<option>Data Science</option>
		</select><br/><br/>
		Student Email :<input type="email" name="std_email"/><br/><br/>
		Student Photo :<input type="file" name="std_photo"/><br/><br/>
		<input type="submit" />
	</form>
</body>
</html>