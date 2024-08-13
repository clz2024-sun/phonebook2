<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.javaex.vo.PersonVo" %>

<%
	List<PersonVo> personList = (List<PersonVo>)request.getAttribute("personList");
	System.out.println("여기는 jsp");
	System.out.println(personList);
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>전화번호부</h1>
	
	<h2>전화번호-리스트</h2>
	
	<p>등록된 전화번호 리스트 입니다.</p>

	
	<table border="1">
		<tbody>
			<tr>
				<th>이름(name)</th>
				<td>이효리</td>
			</tr>
			<tr>
				<th>핸드폰(hp)</th>
				<td>010-1111-1111</td>
			</tr>
			<tr>
				<th>회사(company)</th>
				<td>02-2222-2222</td>
			</tr>
		</tbody>
	</table>
	<br>



</body>
</html>