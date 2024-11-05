<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-Hant">
<head>
    <meta charset="UTF-8">
    <title>刪除會員資料</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<div class="container">
    <h1 class="mt-4">刪除會員資料</h1>

    <form id="memberForm">
        <input type="hidden" id="memberid" name="memberid" value="${member.memberid}" readonly />
        <div class="form-group">
            <label for="memberName">會員名稱</label>
            <input type="text" class="form-control" id="membername" name="membername" 
                   value="${member.membername}" readonly />
        </div>
        <div class="form-group">
            <label for="username">登入名稱</label>
            <input type="text" class="form-control" id="username" name="username" 
                   value="${member.username}" readonly />
        </div>
        <div class="form-group">
            <label for="phone">電話號碼</label>
            <input type="text" class="form-control" id="phone" name="phone" value="${member.phone}" readonly />
        </div>
        <div class="form-group">
            <label for="levelId">會員等級</label>
            <select class="form-control" id="levelid" name="levelId" disabled>
                <option value="1" data-name="系統管理員" <c:if test="${member.levelid == 1}">selected</c:if>>系統管理員</option>
                <option value="2" data-name="金質會員" <c:if test="${member.levelid == 2}">selected</c:if>>金質會員</option>
                <option value="3" data-name="銀質會員" <c:if test="${member.levelid == 3}">selected</c:if>>銀質會員</option>
                <option value="4" data-name="一般會員" <c:if test="${member.levelid == 4}">selected</c:if>>一般會員</option>
                <option value="5" data-name="銅質會員" <c:if test="${member.levelid == 5}">selected</c:if>>銅質會員</option>
                <option value="7" data-name="鐵質會員" <c:if test="${member.levelid == 7}">selected</c:if>>鐵質會員</option>
            </select>
        </div>

        <button type="submit" class="btn btn-danger">刪除會員資料</button>
        <a href="/mylesson20241014/memberManage" class="btn btn-secondary">取消</a>
    </form>
</div>

<script>
$(document).ready(function () {
    // 綁定表單提交事件
    $('#memberForm').submit(function (e) {
        e.preventDefault(); // 阻止預設提交行為

        const memberId = $('#memberid').val(); // 取得會員 ID

        if (confirm('確定要刪除此會員資料嗎？')) {
            $.ajax({
                method: 'DELETE', // 使用 DELETE 方法
                url: '/mylesson20241014/deleteMember/' + encodeURIComponent(memberId),
                dataType: 'json',
                success: function (response) {
                    alert(response.message || '會員資料已刪除');
                    window.location.href = '/mylesson20241014/memberManage'; // 重導頁面
                },
                error: function (xhr) {
                    alert('刪除失敗');
                    console.error('錯誤狀態碼:', xhr.status);
                    console.error('錯誤回應:', xhr.responseText);
                    window.location.href = '/mylesson20241014/memberManage'; // 重導頁面
                }
            });
        }
    });
});
</script>
</body>
</html>
