<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="pl">
<head>
    <title>Strona logowania</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <%--    <link rel="stylesheet" href="csslogin.css">--%>
    <style>
        body {
            font-family: "Lato", sans-serif;
        }



        .main-head{
            height: 150px;
            background: #FFF;

        }

        .sidenav {
            height: 100%;
            background-color: #000;
            overflow-x: hidden;
            padding-top: 20px;
        }


        .main {
            padding: 0px 10px;
        }

        @media screen and (max-height: 450px) {
            .sidenav {padding-top: 15px;}
        }

        @media screen and (max-width: 450px) {
            .login-form{
                margin-top: 10%;
            }

            .register-form{
                margin-top: 10%;
            }
        }

        @media screen and (min-width: 768px){
            .main{
                margin-left: 40%;
            }

            .sidenav{
                width: 40%;
                position: fixed;
                z-index: 1;
                top: 0;
                left: 0;
            }

            .login-form{
                margin-top: 80%;
            }

            .register-form{
                margin-top: 20%;
            }
        }


        .login-main-text{
            margin-top: 20%;
            padding: 60px;
            color: #fff;
        }

        .login-main-text h2{
            font-weight: 300;
        }

        .btn-black{
            background-color: #000 !important;
            color: #fff;
        }
    </style>
</head>
<body>
<div class="sidenav">
    <div class="login-main-text">
        <h2>Strona logowania</h2>
    </div>
</div>
<div class="main">
    <div class="col-md-6 col-sm-12">
        <div class="login-form">
            <form method="post" action="/login">
                <div class="form-group">
                    <label>Email</label>
                    <input type="email" name="email" id="email" class="form-control" placeholder="email">
                </div>
                <div class="form-group">baba
                    <label>Hasło</label>
                    <input type="password" class="form-control" placeholder="hasło" name="password" id="password" required="true">
                    <div align="start">
                        <input type="checkbox" onclick="showPassword()">Pokaż hasło
                    </div>
                </div>
                <div>
                    <c:if test="${param.error != null}">
                        <p class="alert alert-danger" role="alert">Błędne dane logowania</p>
                    </c:if>
                </div>
                <input type="submit" class="btn btn-black" value="Zaloguj">
            </form>
        </div>
    </div>
</div>
<script>
    function showPassword(){
        var x = document.getElementById("password");
        if(x.type ==="password"){
            x.type = "text";
        }else {
            x.type = "password"
        }
    }
</script>
</body>

</html>