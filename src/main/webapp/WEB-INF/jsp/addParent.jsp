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
    <title>新增父分類</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #e9ecef;
        }
        .container {
            margin-top: 120px;
            max-width: 500px;
            padding: 30px;
            background-color: white;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }
        .btn-primary {
            background-color: #007bff;
            border-color: #007bff;
        }
        .btn-primary:hover {
            background-color: #0056b3;
        }
        .btn-secondary {
            background-color: #6c757d;
        }
        .btn-secondary:hover {
            background-color: #5a6268;
        }
        .btn-danger {
            background-color: #dc3545;
            border-color: #dc3545;
        }
        .btn-danger:hover {
            background-color: #c82333;
        }
    </style>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/myDrink/parents">飲料管理系統</a>
</nav>

<div class="container">
    <h2 class="text-center mb-4">新增父分類</h2>
    <form action="${pageContext.request.contextPath}/myDrink/parent/add" method="post" class="needs-validation" novalidate>
        <div class="form-group">
            <label for="parentName">父分類名稱</label>
            <input type="text" class="form-control" id="parentName" name="parentName" placeholder="輸入父分類名稱" required>
            <div class="invalid-feedback">
                請輸入父分類名稱。
            </div>
        </div>
        <button type="submit" class="btn btn-primary btn-block" data-toggle="tooltip" title="點擊以新增新分類">新增分類</button>
        <a href="${pageContext.request.contextPath}/myDrink/parents" class="btn btn-secondary btn-block mt-2" data-toggle="tooltip" title="返回父分類列表">返回分類列表</a>
    </form>

    <!-- CRUD 按鈕 -->
    <div class="mt-4">
        <h5>操作選項</h5>
        <a href="${pageContext.request.contextPath}/myDrink/parents" class="btn btn-info btn-block">查看父分類列表</a>
        <a href="${pageContext.request.contextPath}/myDrink/parent/edit" class="btn btn-warning btn-block">編輯父分類</a>
        <a href="${pageContext.request.contextPath}/myDrink/parent/delete" class="btn btn-danger btn-block">刪除父分類</a>
    </div>
</div>

<footer class="footer bg-dark text-center text-white py-3 mt-5">
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

    // 啟用 Bootstrap 的 tooltip
    $(function () {
        $('[data-toggle="tooltip"]').tooltip();
    });
</script>

</body>
</html>
