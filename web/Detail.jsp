<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${p.name}</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <style>
            .gallery-wrap .img-big-wrap img {
                height: 450px;
                width: auto;
                display: inline-block;
                cursor: zoom-in;
            }


            .gallery-wrap .img-small-wrap .item-gallery {
                width: 60px;
                height: 60px;
                border: 1px solid #ddd;
                margin: 7px 2px;
                display: inline-block;
                overflow: hidden;
            }

            .gallery-wrap .img-small-wrap {
                text-align: center;
            }
            .gallery-wrap .img-small-wrap img {
                max-width: 100%;
                max-height: 100%;
                object-fit: cover;
                border-radius: 4px;
                cursor: zoom-in;
            }
            .img-big-wrap img{
                width: 100% !important;
                height: auto !important;
            }
        </style>
    </head>
    <body>
        <jsp:include page="Menu.jsp"></jsp:include>
            <div class="container">
                <div class="row">
                <jsp:include page ="Category.jsp"></jsp:include>
                    <div class="col-sm-9">
                        <div class="container">
                            <div class="card">
                                <div class="row">
                                    <aside class="col-sm-5 border-right">
                                        <article class="gallery-wrap"> 
                                            <div class="img-big-wrap">
                                                <div> <a href="#"><img src="${p.image}"></a></div>
                                        </div> 
                                        <div>
                                            <h3 class="list-group-item text-white"><a href="seller?sellID=${seller.id}">${seller.user}</a></h3>
                                        </div> 
                                    </article> 
                                </aside>
                                <aside class="col-sm-7">
                                    <article class="card-body p-5">
                                        <h3 class="title mb-3">${p.name}</h3>

                                        <p class="price-detail-wrap"> 
                                            <span class="price h3 text-warning"> 
                                                <span class="currency"></span><span class="num">${p.price} VNĐ</span>
                                            </span> 
                                        </p>
                                        <dl class="item-property">
                                            <dt>Description</dt>
                                            <dd><p>${p.description} </p></dd>
                                        </dl>

                                        <hr>
                                        <form action="addtocart?pid=${p.id}" method="post">
                                            <dt>Số lượng: </dt>
                                            <div class="row">
                                                <div class="col-sm-5">
                                                    <input name="quantity" style="width:70px;" value="1" type="text">
                                                </div>
                                            </div>
                                            <hr>
                                            <a class="btn btn-lg btn-primary text-uppercase" href="buynow?pID=${p.id}">Mua ngay</a>
                                            <button class="btn btn-lg btn-outline-primary text-uppercase" type="submit"><i class="fas fa-shopping-cart"></i>Thêm vào giỏ</button>
                                        </form>
                                    </article> <!-- card-body.// -->
                                </aside> <!-- col.// -->
                            </div> <!-- row.// -->
                        </div> <!-- card.// -->
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page ="Footer.jsp"></jsp:include>
    </body>
</html>
