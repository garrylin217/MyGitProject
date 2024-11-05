<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-Hant">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>修改子分類</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="card shadow">
                    <div class="card-header bg-primary text-white text-center">
                        <h4>修改子分類</h4>
                    </div>
                    <div class="card-body">
                        <form:form method="post" modelAttribute="drink" 
                                   action="${pageContext.request.contextPath}/myDrink/drink/update">

                            <!-- 隱藏欄位：飲料ID -->
                            <form:hidden path="drinkId" />

                            <!-- 飲料名稱 -->
                            <div class="form-group">
                                <label for="name">飲料名稱</label>
                                <form:input path="drinkName" id="name" 
                                            class="form-control" required="true" />
                            </div>

                            <!-- 飲料價格 -->
                            <div class="form-group">
                                <label for="price">價格</label>
                                <form:input path="drinkPrice" id="price" 
                                            class="form-control" required="true" 
                                            type="number" min="0" />
                            </div>

                            <!-- 飲料描述 -->
                            <div class="form-group">
                                <label for="description">描述</label>
                                <form:textarea path="drinkDescription" id="description" 
                                               class="form-control" rows="3"></form:textarea>
                            </div>

                            <!-- 飲料種類 -->
                            <div class="form-group">
                                <label for="category">種類</label>
                                <form:input path="drinkCategory" id="category" 
                                            class="form-control" />
                            </div>

                            <!-- 父分類選擇 -->
                            <div class="form-group">
                                <label for="parent">父分類</label>
                                <form:select path="myDrinkParentid" id="parent" 
                                             class="form-control">
                                    <c:forEach var="parent" items="${parents}">
                                        <option value="${parent.myDrinkParenid}"
                                            <c:if test="${parent.myDrinkParenid == drink.myDrinkParentid}">
                                                selected="selected"
                                            </c:if>>
                                            ${parent.myDrinkParenNtame}
                                        </option>
                                    </c:forEach>
                                </form:select>
                            </div>

                            <!-- 按鈕組 -->
                          <div class="text-center">
    <button type="submit" class="btn btn-success">更新</button>
    <a href="javascript:history.back()" class="btn btn-secondary ml-2">取消</a>
</div>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS 和依賴 -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
