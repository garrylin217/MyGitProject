<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<%
    // 檢查 Session 中的用戶是否已登入，若無則導向登入頁面
    String username = (String) session.getAttribute("user");
    if (username == null) {
        response.sendRedirect(request.getContextPath() + "/login");
        return;
    }
%>
<html>
<head>
    <title>會員管理</title>
</head>
<body>
    <h1>會員列表</h1>
    <table>
        <tr>
            <th>會員名稱</th>
            <th>登入名稱</th>
            <th>密碼</th>
            <th>電話號碼</th>
            <th>會員等級</th>
        </tr>
        <c:forEach var="member" items="${members}">
            <tr>
                <td>${member.memberName}</td>
                <td>${member.username}</td>
                <td>${member.password}</td>
                <td>${member.phone}</td>
                <td>${member.level}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>