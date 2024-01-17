<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Create a New Todo</title>
    <link rel="stylesheet" href="webjars\bootstrap\5.3.0\css\bootstrap.min.css">
</head>
<body>

<div class="container">
    <div class="d-flex align-items-center justify-content-center vh-100 ">
        <div class="col">
            <h3>Create a New Todo</h3>

            <form:form class="bg-light p-5" method="POST" modelAttribute="todo">
                <!-- Add a hidden input for the id -->
                <form:input type="hidden" path="id"/>
                <label for="description" >Description</label>
                <br>
                <form:errors path="description" cssClass="text-danger"/>
                <form:input  class="form-control mb-2" id="description" type="text"  name="description" required="required" path="description"/>

                <label for="target">Target</label>
                <form:input  class="form-control" id="target" type="date" placeholder="target" name="target" required="required" path="target"/>
                <button class="btn btn-success mt-2" type="submit">create</button>
            </form:form>
        </div>
    </div>
</div>


<script src="webjars\bootstrap\5.3.0\js\bootstrap.min.js"></script>
<script src="webjars\jquery\3.6.4\jquery.min.js"></script>
</body>
</html>