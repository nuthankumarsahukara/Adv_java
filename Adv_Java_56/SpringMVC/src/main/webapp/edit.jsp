<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Base64"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Edit Student Details</h1>
	<form action="/update" method="post" enctype="multipart/form-data">
		<input type="hidden" name="std_id" value="${data.std_id}"/>
		Student Name :<input type="text" name="std_name" value="${data.std_name}"/><br/><br/>
		Student DOB :<input type="date" name="std_date" value="${data.std_date}"/><br/><br/>
		Student Gender :
		<input type="radio" name="std_gender" value="male" ${data.std_gender == 'male' ? 'checked' : ''}/>Male
		<input type="radio" name="std_gender" value="female" ${data.std_gender == 'female' ?'checked' : ''}/>Female<br/><br/>
		Student Phone Number:
		<input type="tel" pattern="[0-9]{10}" name="std_phone" value="${data.std_phone}"/><br/><br/>
		Student Course :
		<select name="std_course">
			<option ${data.std_course == 'Java Full Stack' ? 'selected' : ''}>Java Full Stack</option>
			<option ${data.std_course == 'Python Full Stack' ? 'selected' : ''}>Python Full Stack</option>
			<option ${data.std_course == 'Power BI' ? 'selected' : ''}>Power BI</option>
			<option ${data.std_course == '.Net Full Stack' ? 'selected' : ''}>.Net Full Stack</option>
			<option ${data.std_course == 'Data Science' ? 'selected' : ''}>Data Science</option>
		</select><br/><br/>
		Student Email :<input type="email" name="std_email" value="${data.std_email}"/><br/><br/>
		Student Photo :<input type="file" name="std_photo"/><br/><br/>
		Current Photo :<img src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(data.std_photo)}" width="100"/><br/><br/>		
		<input type="submit" />
	</form>
</body>
</html>