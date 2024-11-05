<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-Hant">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <title>${parentName} - 子類別</title>
</head>
<body>

<div class="container mt-5">
    <h1 class="text-center mb-4">${parentName} - 子類別列表</h1>
    
    <table class="table table-bordered">
        <thead>
            <tr>
                <th>子類別名稱</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="child" items="${childCategories}">
                <tr>
                    <td>${child.myDrinkChildName}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/myDrink/child/edit/${child.myDrinkChildid}" 
                           class="btn btn-warning btn-sm">編輯</a>
                        <form action="${pageContext.request.contextPath}/myDrink/child/delete/${child.myDrinkChildid}" 
                              method="post" style="display:inline;">
                            <button type="submit" class="btn btn-danger btn-sm" 
                                    onclick="return confirm('確定刪除這個子類別嗎？');">刪除</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            <c:if test="${empty childCategories}">
                <tr>
                    <td colspan="2" class="text-center">目前無子類別資料</td>
                </tr>
            </c:if>
        </tbody>
    </table>
</div>

</body>
</html>
