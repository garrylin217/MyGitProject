<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-Hant">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>訂單明細</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script>
        // Prevent navigating back using the browser's buttons
        window.history.pushState(null, document.title, window.location.href);
        window.addEventListener('popstate', function (event) {
        window.history.pushState(null, document.title, window.location.href);
        });

        // Function to confirm order and redirect
        function confirmOrder() {
            if (confirm("訂單已提交!")) {
                window.location.href = "${pageContext.request.contextPath}/order"; // Redirect to order confirmation page
            }
        }
    </script>
    <style>
        body {
            background-color: #f8f9fa; /* Light background for better contrast */
            font-family: 'Arial', sans-serif; /* Use a clean font */
        }
        .container {
            margin-top: 50px; /* Add some space at the top */
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Soft shadow for depth */
            padding: 20px;
            background-color: white; /* White background for the container */
            border-radius: 10px; /* Rounded corners */
        }
        h1 {
            margin-bottom: 30px; /* Space below the heading */
            font-size: 2rem; /* Increase heading size */
        }
        table {
            margin-bottom: 30px; /* Space below the table */
        }
        th, td {
            text-align: center; /* Center align table content */
        }
        th {
            background-color: #007bff; /* Primary color for header */
            color: white; /* White text for contrast */
        }
        .btn-success {
            padding: 10px 20px; /* Increase button padding */
            font-size: 1.2rem; /* Increase button font size */
        }
        .total-summary {
            border-top: 2px solid #007bff; /* Border for summary */
            padding-top: 20px; /* Space above the summary */
            margin-top: 20px; /* Margin above the summary */
        }
    </style>
</head>
<body>
<%
    // Check if the user is logged in
    String username = (String) session.getAttribute("user");
    if (username == null) {
        response.sendRedirect(request.getContextPath() + "/login");
        return;
    }
%>
    <div class="container">
        <h1 class="text-center">訂單明細</h1>
        
        <form id="checkoutForm">
            <table class="table table-striped table-bordered">
                <thead class="thead-light">
                    <tr>
                        <th>商品名稱</th>
                        <th>數量</th>
                        <th>商品單價</th>
                        <th>總金額</th>
                    </tr>
                </thead>
                <tbody>
                    <c:if test="${empty orders}">
                        <tr>
                            <td colspan="4" class="text-center">No items in your order.</td>
                        </tr>
                    </c:if>
                    <c:forEach var="order" items="${orders}">
                        <tr>
                            <td>${order.drinkname}</td>
                            <td>${order.orderqty}</td>
                            <td>${order.drinkprice}</td>
                            <td>${order.ordersum}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <div class="total-summary text-right">
                <h3>總金額: <span class="text-danger">${totalPrice}</span></h3>
                <h3>會員折扣: <span class="text-danger">${discount}</span></h3>
                <h3>折扣後價格: <span class="font-weight-bold text-success">${finalPrice}</span></h3>
            </div>

            <!-- Confirmation button -->
            <div class="text-center">
                <button type="button" class="btn btn-success" onclick="confirmOrder()">確認訂單</button>
            </div>
        </form>
    </div>
</body>
</html>
