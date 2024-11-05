<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-Hant">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Discount Levels</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h1 class="mb-4">折扣等級</h1>
    <table class="table table-striped">
        <thead>
            <tr>
                <th>ID</th>
                <th>折扣數</th>
                <th>等級名稱</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="level" items="${discountLevels}">
                <tr>
                    <td>${level.id}</td>
                    <td>${level.discount}</td>
                    <td>${level.levelname}</td>
                    <td>
                        <a class="btn btn-warning btn-sm" href="${pageContext.request.contextPath}/discountLevels/edit/${level.id}">編輯</a>
                        <a class="btn btn-danger btn-sm" href="${pageContext.request.contextPath}/discountLevels/delete/${level.id}" onclick="確定刪除?');">刪除</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a class="btn btn-primary" href="${pageContext.request.contextPath}/discountLevels/create">產生新的等級資料</a>
            <button class="btn btn-secondary" onclick="history.back()" type="button">返回</button>
    
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.7/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
