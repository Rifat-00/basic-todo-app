<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="webjars\bootstrap\5.3.0\css\bootstrap.min.css">
    <title>Todos</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #ffffff;
            margin: 0;
            padding: 20px;
        }

        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #ffffff;
        }

        hr{
            margin-bottom: 2rem;
        }
    </style>
</head>

<body>



<div class="container">

        <h2>Available Todos for ${userName}</h2>
        <hr>
        <table class="table">
            <tr>
<%--                <th scope="col">ID</th>--%>
                <th scope="col">User</th>
                <th scope="col">Description</th>
                <th scope="col">Target</th>
                <th scope="col">Done</th>
                <th scope="col"></th>
                <th scope="col"></th>
            </tr>


            <c:forEach items="${todo}" var="todo">
                <tr>
<%--                    <td>${todo.id}</td>--%>
                    <td>${todo.userName}</td>
                    <td>${todo.description}</td>
                    <td>${todo.target}</td>
                    <td>${todo.done}</td>
                    <td><a href="${pageContext.request.contextPath}/delete-todo?id=${todo.id}" class="btn btn-warning rounded-1 btn-sm">Delete</a></td>
                    <td><a href="${pageContext.request.contextPath}/update-todo?id=${todo.id}" class="btn btn-primary rounded-1 btn-sm">Update</a></td>
                </tr>
            </c:forEach>


            <!-- Add more rows as needed -->
        </table>

        <a class="btn btn-success" href="/newTodo">Create New Todo</a>

</div>

<script src="webjars\bootstrap\5.3.0\js\bootstrap.min.js"></script>
<script src="webjars\jquery\3.6.4\jquery.min.js"></script>
</body>

</html>