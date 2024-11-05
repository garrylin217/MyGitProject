<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="zh-TW">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>點餐系統登入</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            font-family: "微軟正黑體", sans-serif;
            background-color: #f8f9fa; /* 輕微灰色背景 */
        }
        .container {
            background: white;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
            max-width: 400px; /* 限制最大寬度 */
            margin-top: 100px; /* 上方間距 */
        }
        .error-message {
            color: red;
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1 class="text-center mb-4">點餐系統登入</h1>
        <form action="login" method="post">
            <div class="form-group">
                <label for="username">使用者名稱:</label>
                <input type="text" class="form-control" id="username" name="username" required>
            </div>
            <div class="form-group">
                <label for="password">密碼:</label>
                <input type="password" class="form-control" id="password" name="password" required>
            </div>
            <div class="form-group form-check">
                <input type="checkbox" class="form-check-input" id="memberCheck" onclick="toggleRegisterLink()">
                <label class="form-check-label" for="memberCheck">還不是會員, 我要註冊</label>
            </div>
            <div class="form-group text-center">
                <button type="submit" class="btn btn-primary btn-block">確定</button>
                <button type="button" class="btn btn-secondary btn-block" onclick="window.close();">取消</button>
            </div>
            <div class="error-message">
                <c:if test="${not empty error}">
                    <p>${error}</p>
                </c:if>
            </div>
        </form>
    </div>

    <script>
        function toggleRegisterLink() {
            const checkBox = document.getElementById("memberCheck");
            if (checkBox.checked) {
                window.location.href = "${pageContext.request.contextPath}/register";
            }
        }
    </script>
</body>
</html>
