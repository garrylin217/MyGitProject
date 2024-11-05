<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-TW">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>會員註冊</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            font-family: "微軟正黑體", sans-serif;
            background-color: #f0f0f0;
        }
        .container {
            background: white;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            margin-top: 100px; /* 上方間距 */
        }
        .message {
            color: red;
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1 class="text-center mb-4">會員註冊</h1>
        <form action="${pageContext.request.contextPath}/register" method="post">
            <div class="form-group">
                <label for="memberName">會員名稱</label>
                <input type="text" class="form-control" id="memberName" name="memberName" required>
            </div>

            <div class="form-group">
                <label for="username">登入名稱</label>
                <input type="text" class="form-control" id="username" name="username" required>
            </div>

            <div class="form-group">
                <label for="phone">電話號碼</label>
                <input type="text" class="form-control" id="phone" name="phone" required>
            </div>

            <div class="form-group">
                <label for="password">密碼</label>
                <input type="password" class="form-control" id="password" name="password" required>
            </div>

            <div class="form-group">
                <label for="confirmPassword">密碼再次確認</label>
                <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" required>
            </div>

            <button type="submit" class="btn btn-primary btn-block">確認</button>
            <button type="button" class="btn btn-secondary btn-block" onclick="window.location.href='${pageContext.request.contextPath}/login'">回登入頁</button>
        </form>
        
        <c:if test="${not empty error}">
            <div class="message">${error}</div>
        </c:if>
    </div>
</body>
</html>
