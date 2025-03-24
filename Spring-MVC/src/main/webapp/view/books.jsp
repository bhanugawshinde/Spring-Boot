<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="in.ashokit.bean.Book" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ashok IT</title>
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
	
	<table border="1">
		<thead>
			<tr>
				<th>Book Id</th>
				<th>Book Name</th>
				<th>Book Price</th>
			</tr>
		</thead>
		<tbody>
			<%
				List<Book> books = (List<Book>) request.getAttribute("books");
				if (books != null) {
					for (Book book : books) {
			%>
				<tr>
					<td><%= book.getBookId() %></td>
					<td><%= book.getBookName() %></td>
					<td><%= book.getBookPrice() %></td>
				</tr>
			<%
					}
				}
			%>
		</tbody>
	</table>
</body>
</html>
