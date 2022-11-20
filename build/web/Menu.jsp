<%-- 
    Document   : Menu
    Created on : Oct 25, 2022, 4:47:45 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta charset="UFT-8">
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="home">Shoes</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
            <ul class="navbar-nav m-auto">

                <c:if test="${sessionScope.acc.isSeller == 1}">
                    <li class="nav-item">
                        <a class="nav-link" href="manager">Manager Product</a>
                    </li>
                </c:if>

                <c:if test="${sessionScope.acc.isSeller == 1}">
                    <li class="nav-item">
                        <a class="nav-link" href="ordermanager">Đơn hàng</a>
                    </li>
                </c:if>
                <c:if test="${sessionScope.acc != null}">
                    <li class="nav-item">
                        <a class="nav-link">Hello ${acc.user}</a>
                    </li> 
                </c:if>

                <c:if test="${sessionScope.acc != null}">
                    <li class="nav-item">
                        <a class="nav-link" href="logout">Logout</a>
                    </li>
                </c:if>

                <c:if test="${sessionScope.acc == null}">
                    <li class="nav-item">
                        <a class="nav-link" href="Login.jsp">Login</a>
                    </li>
                </c:if>

            </ul>

            <form action="search" method="post" class="form-inline my-2 my-lg-0">
                <div class="input-group input-group-sm">
                    <input value="${keyValue}"name="key" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search...">
                    <div class="input-group-append">
                        <button type="submit" class="btn btn-secondary btn-number">
                            <i class="fa fa-search"></i>
                        </button>
                    </div>
                </div>
                <a class="btn btn-success btn-sm ml-3" href="cart">
                    <i class="fa fa-shopping-cart"></i> Cart
                </a>
            </form>
        </div>
    </div>
</nav>
<section class="jumbotron text-center">
    <div class="container">
        <h1 class="jumbotron-heading">Siêu thị gia dụng</h1>
        <p class="lead text-muted mb-0">Thả ga mua sắm với</p>
    </div>
</section>
