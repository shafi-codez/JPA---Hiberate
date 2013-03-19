<%-- 
    Document   : index
    Created on : Oct 2, 2012, 10:29:56 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
        <link href="css/style.css" rel="stylesheet" type="text/css">
	<head>U.S. Census Bureau, Population Division</head>
	<body>
		<p>Please upload file to generate data analytics Census </p>
		<form action="UploadServlet" enctype="multipart/form-data" method="POST">
			<input type="file" name="fileName" value="C:\Users\Admin\Desktop\sample.csv" reguired "><br>
			<input type="Submit" value="Upload File" class="button"><br>
		</form>
	</body>
</html>
