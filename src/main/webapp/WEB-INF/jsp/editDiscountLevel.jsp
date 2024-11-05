<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-Hant">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>編輯折扣等級</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <style>
        body {
            font-family: "微軟正黑體", Arial, sans-serif;
            background: linear-gradient(to bottom right, #e0eafc, #cfdef3);
            padding: 20px;
        }
        .container {
            max-width: 600px;
            padding: 40px;
            background: rgba(255, 255, 255, 0.9);
            border-radius: 16px;
            box-shadow: 0 8px 24px rgba(0, 0, 0, 0.1);
        }
        h2 {
            margin-bottom: 30px;
            color: #495057;
            font-weight: bold;
        }
        .btn-primary {
            background: linear-gradient(45deg, #007bff, #5a9df4);
            border: none;
            color: white;
        }
        .btn-primary:hover {
            background: linear-gradient(45deg, #0056b3, #4a8de2);
        }
    </style>
</head>
<body>

<div class="container mt-5">
    <h2>編輯折扣等級</h2>
    <form action="${pageContext.request.contextPath}/discountLevels/update/${discountLevel.id}" method="post">
        <div class="mb-3">
            <label for="discount" class="form-label">折扣 (%)</label>
            <input type="number" step="0.01" class="form-control" id="discount" name="discount" value="${discountLevel.discount}" required>
        </div>
        <div class="mb-3">
            <label for="levelname" class="form-label">等級名稱</label>
            <input type="text" class="form-control" id="levelname" name="levelname" value="${discountLevel.levelname}" required>
        </div>
        <button type="submit" class="btn btn-primary">更新</button>
        <a href="${pageContext.request.contextPath}/discountLevels" class="btn btn-secondary">返回</a>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
