<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-Hant">
<head>
    <meta charset="UTF-8">
    <title>會員管理</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .container {
            margin-top: 30px;
            padding: 20px;
            background-color: white;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
    </style>
</head>
<body>
<div class="container">
    <h1 class="mt-4">會員管理</h1>
    <table class="table table-striped">
        <thead class="thead-dark">
            <tr>
                <th>會員名稱</th>
                <th>登入名稱</th>
                <th>電話號碼</th>
                <th>會員等級</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="member" items="${members}">
                <tr>
                    <td>${member.membername}</td>
                    <td>${member.username}</td>
                    <td>${member.phone}</td>
                    <td>${member.level}</td>
                    <td>
                        <a href="/mylesson20241014/edit/${member.memberid}" class="btn btn-warning btn-sm">編輯</a>
                        <a href="/mylesson20241014/delete/${member.memberid}" class="btn btn-danger btn-sm">刪除</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="/mylesson20241014/manage" class="btn btn-success">返回</a>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
