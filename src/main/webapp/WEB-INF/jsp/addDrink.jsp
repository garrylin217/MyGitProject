<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<html lang="zh-Hant">
<head>
    <meta charset="UTF-8">
    <title>新增產品</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .container {
            margin-top: 100px;
            max-width: 600px;
            padding: 30px;
            background-color: white;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }
        .btn-primary {
            background-color: #007bff;
            border-color: #007bff;
        }
        .btn-primary:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/myDrink/parents">飲料管理系統</a>
</nav>

<div class="container">
    <h2 class="text-center mb-4">新增產品</h2>
    <form action="${pageContext.request.contextPath}/myDrink/drink/add" method="post" class="needs-validation" novalidate>
        <div class="form-group">
            <label for="drinkName">產品名稱</label>
            <input type="text" class="form-control" id="drinkName" name="drinkName" placeholder="輸入產品名稱" required>
            <div class="invalid-feedback">請輸入產品名稱。</div>
        </div>

        <div class="form-group">
            <label for="drinkPrice">價格</label>
            <input type="number" class="form-control" id="drinkPrice" name="drinkPrice" min="0" placeholder="輸入價格" required>
            <div class="invalid-feedback">請輸入有效的價格。</div>
        </div>

        <div class="form-group">
            <label for="parentId">選擇父分類</label>
            <select class="form-control" id="parentId" name="parentId" required>
                <c:forEach var="parent" items="${parents}">
                    <option value="${parent.myDrinkParenid}">${parent.myDrinkParenNtame}</option>
                </c:forEach>
            </select>
            <div class="invalid-feedback">請選擇父分類。</div>
        </div>

        <button type="submit" class="btn btn-primary btn-block">新增產品</button>
        <a href="${pageContext.request.contextPath}/myDrink/drinks" class="btn btn-secondary btn-block mt-2">返回產品列表</a>
    </form>
</div>

<footer class="footer bg-dark text-white text-center py-3 mt-5">
    <p>&copy; 2024 飲料管理系統</p>
</footer>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.7/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script>
    // Bootstrap 表單驗證
    (function() {
        'use strict';
        window.addEventListener('load', function() {
            var forms = document.getElementsByClassName('needs-validation');
            Array.prototype.filter.call(forms, function(form) {
                form.addEventListener('submit', function(event) {
                    if (form.checkValidity() === false) {
                        event.preventDefault();
                        event.stopPropagation();
                    }
                    form.classList.add('was-validated');
                }, false);
            });
        }, false);
    })();
</script>

</body>
</html>

