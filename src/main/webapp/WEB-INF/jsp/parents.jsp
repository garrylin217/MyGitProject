<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-Hant">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet">
    <title>父類別管理</title>
    <style>
        body {
            background-color: #f8f9fa;
        }
        .navbar {
            background-color: #007a33;
        }
        .navbar-brand, .nav-link {
            color: #ffffff !important;
        }
        .footer {
            background-color: #005b25;
            color: white;
            padding: 20px 0;
        }
        .form-actions {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-top: 20px;
        }
    </style>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>

<nav class="navbar navbar-expand-lg">
    <a class="navbar-brand" href="#">巨匠早餐店產品管理</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon fas fa-bars"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="#">首頁</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">聯絡我們</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container mt-5">

    <h1 class="text-center mb-4">父類別管理</h1>

    <div class="mb-4">
        <h3>新增父類別</h3>
        <form action="${pageContext.request.contextPath}/myDrink/parent/add" method="post" class="needs-validation" novalidate>
            <div class="form-group">
                <label for="parentName">父類別名稱</label>
                <input type="text" class="form-control" id="parentName" name="myDrinkParenNtame" placeholder="輸入父類別名稱" required>
                <div class="invalid-feedback">請輸入父類別名稱。</div>
            </div>
            <div class="form-group">
                <label for="parentDescription">父類別說明</label>
                <input type="text" class="form-control" id="parentDescription" name="myDrinkParentDescription" placeholder="輸入父類別說明" required>
                <div class="invalid-feedback">請輸入父類別說明。</div>
            </div>
            <div class="form-group">
                <label for="parentCategory">父類別類別</label>
                <input type="text" class="form-control" id="parentCategory" name="myDrinkParentCategory" placeholder="輸入父類別類別" required>
                <div class="invalid-feedback">請輸入父類別類別。</div>
            </div>

            <!-- 返回與新增按鈕 -->
            <div class="form-actions">
                <button class="btn btn-secondary" onclick="history.back()" type="button">返回</button>
                <button type="submit" class="btn btn-primary">新增父類別</button>
            </div>
        </form>
    </div>

    <h3>現有父類別</h3>
    <table class="table table-striped">
        <thead>
            <tr>
                <th>父類別名稱</th>
                <th>父類別說明</th>
                <th>父類別類別</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="parent" items="${parents}">
                <tr>
                    <td>
                        <a href="#" class="parent-link" data-name="${parent.myDrinkParenNtame}" data-id="${parent.myDrinkParenid}">
                            ${parent.myDrinkParenNtame}
                        </a>
                    </td>
                    <td>${parent.myDrinkParentDescription}</td>
                    <td>${parent.myDrinkParentCategory}</td>
                </tr>
            </c:forEach>
            <c:if test="${empty parents}">
                <tr>
                    <td colspan="3" class="text-center">目前無父類別</td>
                </tr>
            </c:if>
        </tbody>
    </table>
</div>

<div class="footer text-center mt-5">
    <div class="container">
        <p>&copy; 2024 巨匠早餐店</p>
    </div>
</div>

<script>
    $(document).ready(function() {
        $('.parent-link').click(function(e) {
            e.preventDefault();
            var parentName = $(this).data('name');
            var parentId = $(this).data('id');
            var contextPath = '<c:out value="${pageContext.request.contextPath}" />';
            
            window.location.href = contextPath + '/myDrink/drinks?parentName=' 
                                  + encodeURIComponent(parentName) 
                                  + '&parentid=' + encodeURIComponent(parentId);
        });

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
    });
</script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
