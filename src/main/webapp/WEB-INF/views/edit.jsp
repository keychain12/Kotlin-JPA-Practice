<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>새 게시글 작성</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        .container {
            width: 80%;
            margin: auto;
        }
        input[type="text"], textarea {
            width: 100%;
            padding: 8px;
            margin: 10px 0;
            box-sizing: border-box;
        }
        button {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }
        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>게시물 수정</h1>
    <form action="/edit" method="post">
        <div>
            <label for="title">제목:</label>
            <input type="text" id="title" name="title" required value="${board.title}">
        </div>
        <div>
            <label for="content">내용:</label>
            <textarea id="content" name="content" rows="10" required>${board.content}</textarea>
        </div>
        <input type="hidden" value="${board.id}" name="id">
        <button type="submit">수정</button>

    </form>
    <a href="/">목록으로 돌아가기</a>
</div>
</body>
</html>
