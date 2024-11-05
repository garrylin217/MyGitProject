<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-Hant">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <title>子分類管理 - ${selectedParent}</title>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>

<div class="container mt-5">
    <h1 class="text-center mb-4">父類別: ${selectedParent}</h1>

    <!-- 返回按鈕 -->
    <div class="mb-4 text-right">
        <a href="${pageContext.request.contextPath}/myDrink/parents" class="btn btn-secondary">返回父類別列表</a>
    </div>

    <!-- 新增子分類 -->
    <div class="mb-4">
        <h3>新增子分類</h3>
        <form action="${pageContext.request.contextPath}/myDrink/drink/add" method="post" class="needs-validation" novalidate>
            <div class="form-group">
                <label for="drinkname">子分類名稱</label>
                <input type="text" class="form-control" id="drinkname" name="drinkname" placeholder="輸入名稱" required>
                <div class="invalid-feedback">請輸入子分類名稱。</div>
            </div>
            <div class="form-group">
                <label for="drinkprice">子分類單價</label>
                <input type="number" class="form-control" id="drinkPrice" name="drinkprice" placeholder="輸入單價" required>
                <div class="invalid-feedback">請輸入子分類單價。</div>
            </div>
            <div class="form-group">
                <label for="drinkdescription">子分類描述</label>
                <textarea class="form-control" id="drinkdescription" name="drinkdescription" placeholder="輸入描述" required></textarea>
                <div class="invalid-feedback">請輸入子分類描述。</div>
            </div>
            <div class="form-group">
                <label for="drinkCategory">子分類種類</label>
                <input type="text" class="form-control" id="drinkcategory" name="drinkCategory" placeholder="輸入飲料種類" required>
                <div class="invalid-feedback">請輸入子分類種類。</div>
            </div>
            <input type="hidden" id="mydrinkparentid" name="mydrinkparentid" value="${selectedParentId}"> <!-- 用於關聯子分類 -->
            
            <button type="submit" class="btn btn-primary">新增子分類</button>
        </form>
    </div>

    <c:if test="${not empty drinks}">
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>子分類名稱</th>
                    <th>子分類描述</th>
                    <th>子分類單價</th>
                    <th>子分類種類</th>
                    <th>操作</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="drink" items="${drinks}">
                    <tr>
                        <td>${drink.drinkName != null ? drink.drinkName : '無名稱'}</td>
                        <td>${drink.drinkDescription != null ? drink.drinkDescription : '無描述'}</td>
                        <td>${drink.drinkPrice != null ? drink.drinkPrice : '無價格'}</td>
                        <td>${drink.drinkCategory != null ? drink.drinkCategory : '無種類'}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/myDrink/drink/edit/${drink.drinkId}" 
                               class="btn btn-warning btn-sm">編輯</a>
                          
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>

    <c:if test="${empty drinks}">
        <div class="alert alert-info text-center">
            目前沒有子分類資料。
        </div>
    </c:if>
</div>

<script>
    // 表單驗證
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
