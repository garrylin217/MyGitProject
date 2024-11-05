<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-Hant">
<%
    // 檢查 Session 中的用戶是否已登入，若無則導向登入頁面
    String username = (String) session.getAttribute("user");
    if (username == null) {
        response.sendRedirect(request.getContextPath() + "/login");
        return;
    }
%>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>訂單頁面</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <style>
        /* 自定義樣式 */
    </style>
</head>
<body class="container-fluid">
    <c:if test="${not empty sessionScope.message}">
        <div class="alert alert-success text-center">
            <c:out value="${sessionScope.message}" />
        </div>
    </c:if>
    
    <h1 class="text-center">訂單頁面</h1>
    
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-5">
            <form action="submitOrder" method="post" id="orderForm">
                <input type="hidden" name="userid" value="${sessionScope.userid}">
                <c:forEach var="parent" items="${parentCategories}">
                    <div class="accordion" id="accordionPanelsStayOpenExample">
                        <div class="accordion-item">
                            <h2 class="accordion-header" id="panelsStayOpen-heading-${parent.parentId}">
                                <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                                        data-bs-target="#panelsStayOpen-collapse-${parent.parentId}" aria-expanded="false"
                                        aria-controls="panelsStayOpen-collapse-${parent.parentId}">
                                    ${parent.parentName}
                                </button>
                            </h2>
                            <div id="panelsStayOpen-collapse-${parent.parentId}" class="accordion-collapse collapse"
                                 aria-labelledby="panelsStayOpen-heading-${parent.parentId}">
                                <div class="accordion-body">
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th>飲品名稱</th>
                                                <th>價格</th>
                                                <th>數量</th>
                                                <th>加入購物車</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="drink" items="${parent.drinks}">
                                                <tr>
                                                    <td>${drink.drinkname}</td>
                                                    <td>${drink.drinkprice}</td>
                                                    <td>
                                                        <input type="number" class="form-control"
                                                               id="quantity-${drink.drinkid}"
                                                               name="${drink.drinkid}" min="0" value="0">
                                                    </td>
                                                    <td>
                                                        <span class="add-to-cart" onclick="addToCart('${drink.drinkname}', ${drink.drinkprice}, '${drink.drinkid}')">
                                                            <i class="fas fa-shopping-cart"></i> 加入
                                                        </span>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
                <div class="mb-4">
                    <label for="discountCode" class="form-label">折扣數：</label>
                    <input type="text" class="form-control" id="discountCode" name="discountCode"
                           value="${sessionScope.discountValue}" readonly
                           aria-label="Discount Code">
                </div>
             <div class="d-flex justify-content-between btn-group">
    <button type="submit" class="btn btn-primary">前往結帳</button>
    <button type="button" class="btn btn-danger" 
            onclick="window.location.href='${pageContext.request.contextPath}/logout'">
        登出
    </button>
</div>
            </form>
        </div>
        <div class="col-md-5 cart-section">
            <div class="cart-title">即時購物車</div>
            <table id="cartItems" class="table cart-table">
                <thead>
                    <tr>
                        <th>商品名稱</th>
                        <th>數量</th>
                        <th>單價</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- 購物車的商品將動態插入 -->
                </tbody>
            </table>
            <p>總計：<span id="totalPrice" class="total-price">0</span> NTD</p>
        </div>
        <div class="col-md-1"></div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <script>
        var cart = {};
        
        function addToCart(itemName, price, drinkId) {
            var quantityInput = document.getElementById('quantity-' + drinkId);
            var quantity = parseInt(quantityInput.value);
            if (quantity <= 0) {
                alert("請選擇正確的數量");
                return;
            }
            if (cart[drinkId]) {
                cart[drinkId].quantity += quantity;
            } else {
                cart[drinkId] = {
                    name: itemName,
                    price: price,
                    quantity: quantity
                };
            }
            updateCart();
        }

        function updateCart() {
            var cartItems = document.getElementById("cartItems").getElementsByTagName('tbody')[0];
            cartItems.innerHTML = '';
            var total = 0;

            if (Object.keys(cart).length === 0) {
                cartItems.innerHTML = '<tr><td colspan="4" class="text-center">購物車為空</td></tr>';
                document.getElementById("totalPrice").innerText = '0';
                return;
            }

            for (let drinkId in cart) {
                let item = cart[drinkId];
                let newRow = cartItems.insertRow();

                // 商品資訊
                let nameCell = newRow.insertCell(0);
                nameCell.textContent = item.name;
                let quantityCell = newRow.insertCell(1);
                quantityCell.textContent = item.quantity;
                let priceCell = newRow.insertCell(2);
                priceCell.textContent = (item.price * item.quantity).toFixed(2);

                // 刪除按鈕
                let actionCell = newRow.insertCell(3);
                let deleteButton = document.createElement('button');
                deleteButton.className = 'btn btn-danger btn-sm';
                deleteButton.textContent = '刪除';
                deleteButton.onclick = function () {
                    removeFromCart(drinkId);
                };
                actionCell.appendChild(deleteButton);

                // 累加總價
                total += item.price * item.quantity;
            }

            document.getElementById("totalPrice").innerText = total.toFixed(2);
        }

        // 移除購物車項目
        function removeFromCart(drinkId) {
            delete cart[drinkId];
            updateCart();
        }

        document.getElementById('orderForm').addEventListener('submit', function (e) {
            const inputs = document.querySelectorAll('input[type="number"]');
            inputs.forEach(input => {
                if (input.value <= 0) {
                    input.name = '';  // 移除不需要的欄位
                }
            });
        });
    </script>
</body>
</html>
