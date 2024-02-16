<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 렌트카 보기</title>
</head>
<body>
<div align="center">
	<table>
		<tr height="60">
			<td align="center" colspan="3">
				<font size="6" color="gray">전체 렌트카 보기</font>
			</td>
		</tr>
		<tr height="220">
			<c:forEach var="car" items="${cars}" varStatus="status">
				<c:if test="${status.index % 3 == 0}">
					</tr><tr height="220">
				</c:if>
				<td width="333" align="center">
					<a href="01_carMain.jsp?center=10_carReserveInfo.jsp?no=${car.no}">
						<img alt="" src="img/${car.img}" width="300" height="200">
					</a>
					<p>
					<font size="3" color="gray"><b>차량명 | ${car.name}</b></font>
				</td>
			</c:forEach>
		</tr>
	</table>
</div>
</body>
</html>