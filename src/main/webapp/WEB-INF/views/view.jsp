<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>게시글 상세 정보</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        .container {
            width: 80%;
            margin: 0 auto;
        }
        .back-link {
            margin-top: 20px;
        }
        .board-details {
            margin-top: 20px;
            border-collapse: collapse;
            width: 100%;
        }
        .board-details th, .board-details td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        .board-details th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>게시글 상세 보기</h1>
    <table class="board-details">
        <tr>
            <th>제목</th>
            <td>${board.title}</td>
        </tr>
        <tr>
            <th>내용</th>
            <td><pre>${board.content}</pre></td>
        </tr>
        <tr>
            <th>작성자</th>
            <td>${board.user.name}</td>
        </tr>
        <tr>
            <th>작성일</th>
            <td>${board.regdate}</td>
        </tr>
    </table>
    <a href="/" class="back-link">목록으로 돌아가기</a>
    <a href="/edit/${board.id}" class="back-link">수정</a>
    <form action="/delete" method="post">
        <input type="hidden" name="id" value="${board.id}" />
        <button type="submit">삭제</button>
    </form>
</div>
</body>
</html>
