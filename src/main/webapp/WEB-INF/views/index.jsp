<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>게시판</title>
    <link rel="stylesheet" href="<c:url value='/resources/css/style.css' />">
    <style>
        /* 간단한 CSS 스타일 */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 80%;
            margin: 0 auto;
        }
        header {
            background-color: #4CAF50;
            color: white;
            text-align: center;
            padding: 1em 0;
        }
        .login {
            float: right;
            margin-top: -3em;
            margin-right: 1em;
        }
        .board-table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 2em;
        }
        .board-table th, .board-table td {
            border: 1px solid #ddd;
            padding: 8px;
        }
        .board-table th {
            background-color: #f2f2f2;
        }
        .board-table tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        .board-table tr:hover {
            background-color: #ddd;
        }
        .board-table th, .board-table td {
            text-align: left;
        }
        .new-post {
            text-align: right;
            margin: 1em 0;
        }
    </style>
</head>
<body>
<header>
    <h1>게시판</h1>
    <div class="login">
        <a href="/login">로그인</a>
    </div>
</header>
<div class="container">
    <div class="new-post">
        <a href="/create">새 글 쓰기</a>
    </div>
    <table class="board-table">
        <thead>
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성일</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="board" items="${board}">
            <tr>
                <td><c:out value="${board.id}" /></td>
                <td><a href="<c:url value='/view/${board.id}' />"><c:out value="${board.title}" /></a></td>
                <td><c:out value="${board.user.name}" /></td>
                <td><c:out value="${board.regdate}" /></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
