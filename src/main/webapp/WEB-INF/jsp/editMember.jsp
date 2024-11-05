<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-Hant">
<head>
    <meta charset="UTF-8">
    <title>編輯會員資料</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<div class="container">
    <h1 class="mt-4">編輯會員資料</h1>

    <form id="memberForm">
        <input type="hidden" id="memberid" name="memberid" value="${member.memberid}" />
        <div class="form-group">
            <label for="memberName">會員名稱</label>
            <input type="text" class="form-control" id="membername" name="membername" value="${member.membername}" required>
        </div>
        <div class="form-group">
            <label for="username">登入名稱</label>
            <input type="text" class="form-control" id="username" name="username" value="${member.username}" required>
        </div>
        <div class="form-group">
            <label for="phone">電話號碼</label>
            <input type="text" class="form-control" id="phone" name="phone" value="${member.phone}" required>
        </div>
        <div class="form-group">
            <label for="levelId">會員等級</label>
            <select class="form-control" id="levelid" name="levelId" required>
                <option value="1" data-name="系統管理員" <c:if test="${member.levelid == 1}">selected</c:if>>系統管理員</option>
                <option value="2" data-name="金質會員" <c:if test="${member.levelid == 2}">selected</c:if>>金質會員</option>
                <option value="3" data-name="銀質會員" <c:if test="${member.levelid == 3}">selected</c:if>>銀質會員</option>
                <option value="4" data-name="一般會員" <c:if test="${member.levelid == 4}">selected</c:if>>一般會員</option>
                <option value="5" data-name="銅質會員" <c:if test="${member.levelid == 5}">selected</c:if>>銅質會員</option>
                <option value="7" data-name="鐵質會員" <c:if test="${member.levelid == 7}">selected</c:if>>鐵質會員</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">更新會員資料</button>
        <a href="/mylesson20241014/memberManage" class="btn btn-secondary">取消</a>
    </form>

</div>

<script>

    $('#memberForm').submit(function (e) {
        e.preventDefault(); // 阻止預設提交

        var obj = {
            "memberid": "${member.memberid}",
            "membername": $('#membername').val(),
            "username": $('#username').val(),
            "phone": $('#phone').val(),
            "levelid": $('#levelid').val(),
            "level": $('#levelid option:selected').data('name'),
            "password": "${member.password}"
        };

        $.ajax({
            type: 'POST',
            url: '/mylesson20241014/members/update',
            contentType: 'application/json;charset=UTF-8',
            data: JSON.stringify(obj),
            success: function () {
                alert('會員資料已成功更新');
                window.location.href = '/mylesson20241014/memberManage';
            },
            error: function (error) {
                alert('更新失敗，請重試');
                console.error(error);
            }
        });
    });

</script>

</body>
</html>
