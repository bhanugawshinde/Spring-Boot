<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ashok IT Add Book Form</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
	<a href="javascript:history.back()" aria-label="Go back"> 
        <svg class="back-button" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
            <!-- Left Arrow -->
            <path d="M12 6L6 12L12 18" stroke="black" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
            <!-- Horizontal Line -->
            <line x1="6" y1="12" x2="18" y2="12" stroke="black" stroke-width="2" stroke-linecap="round"/>
        </svg>
	</a>
	<h1>Books</h1>
	<form:form action = "add-book" modelAttribute="book" method ="post">
		<table>
			<tbody>
				<tr>
					<td>Book Id : </td>
					<td><form:input path="bookId"/></td>
				</tr>
				<tr>
					<td>Book Name : </td>
					<td><form:input path="bookName"/></td>
				</tr>
				<tr>
					<td>Book Price : </td>
					<td><form:input path="bookPrice"/></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="submit"/></td>
				</tr>
			</tbody>
		</table>
	</form:form>
	
</body>
</html>
