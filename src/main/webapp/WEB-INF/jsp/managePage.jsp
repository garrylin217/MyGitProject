<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    // 檢查 Session 中的用戶是否已登入，若無則導向登入頁面
    String username = (String) session.getAttribute("user");
    if (username == null) {
        response.sendRedirect(request.getContextPath() + "/login");
        return;
    }
%>
<html lang="zh-Hant">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>主管理系統</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">

    <style>
        body {
            font-family: "微軟正黑體", Arial, sans-serif;
            background: linear-gradient(rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)),
                        url('https://images.unsplash.com/photo-1520739308772-8c2bdbb3d967?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MXwyMDg5NzR8MHwxfGFsbHwxfHx8fHx8fHwxNjAwOTM0NjMz&ixlib=rb-1.2.1&q=80&w=1080') 
                        no-repeat center center fixed;
            background-size: cover;
            height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            color: white;
        }

        .container {
            max-width: 400px;
            padding: 40px;
            background: rgba(255, 255, 255, 0.9);
            border-radius: 16px;
            box-shadow: 0 8px 24px rgba(0, 0, 0, 0.2);
            backdrop-filter: blur(15px);
            transition: transform 0.3s, box-shadow 0.3s;
        }

        .container:hover {
            transform: scale(1.05);
            box-shadow: 0 12px 36px rgba(0, 0, 0, 0.3);
        }

        h1 {
            margin-bottom: 30px;
            font-weight: bold;
            text-shadow: 1px 1px 5px rgba(0, 0, 0, 0.5);
        }

        .btn {
            border-radius: 50px;
            font-size: 18px;
            padding: 12px 20px;
            margin: 12px 0;
            transition: background-color 0.3s, transform 0.3s, box-shadow 0.3s;
            width: 100%;
        }

        .btn-primary {
            background: linear-gradient(45deg, #007bff, #5a9df4);
            border: none;
            color: white;
        }

        .btn-primary:hover {
            background: linear-gradient(45deg, #0056b3, #4a8de2);
            transform: translateY(-3px);
            box-shadow: 0 8px 16px rgba(0, 123, 255, 0.4);
        }

        .btn-secondary {
            background: linear-gradient(45deg, #6c757d, #a1a5a8);
            border: none;
            color: white;
        }

        .btn-secondary:hover {
            background: linear-gradient(45deg, #5c636a, #8e9398);
            transform: translateY(-3px);
            box-shadow: 0 8px 16px rgba(108, 117, 125, 0.4);
        }

        .btn-danger {
            background: linear-gradient(45deg, #dc3545, #f57373);
            border: none;
            color: white;
        }

        .btn-danger:hover {
            background: linear-gradient(45deg, #b21f32, #e56363);
            transform: translateY(-3px);
            box-shadow: 0 8px 16px rgba(220, 53, 69, 0.4);
        }

        .btn.disabled {
            background: linear-gradient(45deg, #adb5bd, #ced4da);
            border: none;
        }
    </style>
</head>
<body>

    <div class="container text-center">
        <h1>主管理系統</h1>
        <p>歡迎, <strong><%= username %></strong>!</p>

        <button class="btn btn-primary" 
                onclick="window.location.href='${pageContext.request.contextPath}/memberManage'">
            會員管理
        </button>

        <button class="btn btn-secondary" 
                onclick="window.location.href='${pageContext.request.contextPath}/myDrink/parents'">
            產品管理
        </button>

        <button class="btn btn-secondary" 
                onclick="window.location.href='${pageContext.request.contextPath}/discountLevels/showall'">
            會員折扣資料維護
        </button>

        <button class="btn btn-secondary disabled" disabled title="此功能尚未啟用">
            銷貨管理
        </button>

        <button class="btn btn-danger" 
                onclick="window.location.href='${pageContext.request.contextPath}/logout'">
            登出
        </button>
        
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
