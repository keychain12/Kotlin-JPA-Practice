<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>로그인 페이지</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .login-container {
            background-color: white;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
        }
        .login-container h2 {
            margin-top: 0;
            margin-bottom: 20px;
            text-align: center;
        }
        .login-container input[type="text"],
        .login-container input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }
        .login-container button {
            width: 100%;
            padding: 10px;
            background-color: #5cb85c;
            border: none;
            color: white;
            border-radius: 3px;
            font-size: 16px;
            cursor: pointer;
        }
        .login-container button:hover {
            background-color: #4cae4c;
        }
    </style>
</head>
<body>
<div class="login-container">
    <h2>로그인</h2>
    <form action="login" method="post">
        <label for="username">사용자 이름</label>
        <input type="text" id="username" name="name" required>

        <label for="password">비밀번호</label>
        <input type="password" id="password" name="password" required>

        <button type="submit">로그인</button>
    </form>
</div>
</body>
</html>
