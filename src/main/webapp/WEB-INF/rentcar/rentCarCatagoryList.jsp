<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%-- 카테고리 분류 값 받아옴(int 타입) --%>
    <c:set var="category" value="${param.category}" />
    <c:set var="temp" value="" />
    <c:choose>
        <c:when test="${category eq 1}">
            <c:set var="temp" value="소형" />
        </c:when>
        <c:when test="${category eq 2}">
            <c:set var="temp" value="중형" />
        </c:when>
        <c:when test="${category eq 3}">
            <c:set var="temp" value="대형" />
        </c:when>
    </c:choose>
    
    <div align="center">
        <table>
            <tr height="60">
                <td align="center" colspan="3">
                    <font size="6" color="gray">${temp} 자동차</font>
                </td>
            </tr>
            <c:set var="cars" value="${cars}" />
            <c:forEach items="${cars}" var="car" varStatus="status">
                <c:if test="${status.index % 3 == 0}">
					<tr height="220"></tr>
                </c:if>
                <td width="333" align="center">
                    <a href="01_carMain.jsp?center=10_carReserveInfo.jsp?no=${car.no}">
                        <img alt="" src="img/${car.img}" width="300" height="200">
                    </a>
                    <p>
                    <font size="3" color="gray"><b>차량명 | ${car.name}</b></font>
                </td>
            </c:forEach>
        </table>
    </div>
</body>
</html>