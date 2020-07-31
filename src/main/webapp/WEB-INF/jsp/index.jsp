<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../../resources/css/style.css">
    <title>Spring1</title>
</head>
<body>
<div id="page-container">
    <div id="content-container">
        <div class="modules-container">
            <div class="module" style="text-align:center">
                <h2>spring1</h2>
            </div>
            <div class="module">
                <table id="users-table">

                </table>
            </div>

            <div class="module">
                <form action="#">
                    <input id="user_name" placeholder="User name">
                    <input id="user_login" placeholder="User login">
                    <input id="user_email" placeholder="User email">
                    <button onclick="createUser()">Create user</button>
                </form>
            </div>
        </div>
    </div>
</div>
<script src="../../resources/js/main.js" type="text/javascript"></script>
</body>
</html>