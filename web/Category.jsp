<%-- 
    Document   : Category
    Created on : Oct 25, 2022, 4:47:19 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-sm-3">
    <div class="card bg-light mb-3">
        <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Danh mục</div>
        <ul class="list-group category_block">
            <c:forEach items="${listOfC}" var="o">
                <li class="list-group-item text-white ${o.cid == tagOfC ? "active":""}"><a href="category?cid=${o.cid}">${o.cname}</a></li>
            </c:forEach>

        </ul>
    </div>
</div>
