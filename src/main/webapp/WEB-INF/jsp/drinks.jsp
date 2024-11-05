<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-Hant">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <title>飲料管理 - ${selectedParent}</title>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>

<div class="container mt-5">
    <h1 class="text-center mb-4">子類別: ${selectedParent}</h1>

    <table class="table table-striped">
        <thead>
            <tr>
                <th>飲料名稱</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="drink" items="${drinks}">
                <tr>
                    <td>${drink.drinkName}</td> <!-- 假設 drinkName 是飲料名稱 -->
                    <td>
                        <a href="${pageContext.request.contextPath}/myDrink/drink/edit/${drink.drinkId}" class="btn btn-warning btn-sm">編輯</a>
                        <form action="${pageContext.request.contextPath}/myDrink/drink/delete/${drink.drinkId}" method="post" style="display:inline;">
                            <button type="submit" class="btn btn-danger btn-sm" onclick="return confirm('確定刪除這個飲料嗎？');">刪除</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <div id="children-container">
        <!-- 這裡可以添加子類別的顯示 -->
    </div>
</div>

</body>
</html>
