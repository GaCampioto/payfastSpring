<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
    <c:url value="/" var="contextPath" />
      <meta charset="utf-8"/>
          <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
          <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"/>
        <link rel="icon"
            href="//cdn.shopify.com/s/files/1/0155/7645/t/177/assets/favicon.ico?11981592617154272979"
            type="image/ico" />
        <link href="https://plus.googlecom/108540024862647200608"
            rel="publisher"/>
        <title>Interface web para o payfast</title>
        <link href="${contextPath}resources/css/cssbase-min.css"
            rel="stylesheet" type="text/css" media="all" />
        <link href='http://fonts.googleapis.com/css?family=Droid+Sans:400,700'
            rel='stylesheet'/>
        <link href="${contextPath}resources/css/fonts.css"
            rel="stylesheet" type="text/css" media="all" />
        <link href="${contextPath}resources/css/fontello-ie7.css"
            rel="stylesheet" type="text/css" media="all" />
        <link href="${contextPath}resources/css/fontello-embedded.css"
            rel="stylesheet" type="text/css" media="all" />
        <link href="${contextPath}resources/css/fontello.css"
            rel="stylesheet" type="text/css" media="all" />
        <link href="${contextPath}resources/css/style.css"
            rel="stylesheet" type="text/css" media="all" />
        <link href="${contextPath}resources/css/layout-colors.css"
            rel="stylesheet" type="text/css" media="all" />
        <link href="${contextPath}resources/css/responsive-style.css"
            rel="stylesheet" type="text/css" media="all" />
        <link href="${contextPath}resources/css/guia-do-programador-style.css" 
            rel="stylesheet" type="text/css"  media="all"  />
        <link href="${contextPath}resources/css/produtos.css" 
            rel="stylesheet" type="text/css"  media="all"  />
        <link rel="canonical" href="http://www.casadocodigo.com.br/" />    
</head>
<body>
  <header id="layout-header">
        <div class="clearfix container">
            <a href="/" id="logo">
            </a>
            <div id="header-content">
                <nav id="main-nav">

                    <ul class="clearfix">
                        <li><a href="${s:mvcUrl('PC#listarPagamento').build()}" rel="nofollow">Meus pagamentos</a></li>
                    </ul>
                </nav>
            </div>
        </div>
    </header>

    <article id="livro-css-eficiente">
          <header id="product-highlight" class="clearfix">
            <div id="product-overview" class="container">
              <h1 class="product-title">${pagamento.formaPagamento }</h1>
              <p class="book-description">${pagamento.descricao }</p>
              <p class="book-description">${pagamento.moeda }</p>
              <p class="book-description">${pagamento.valor }</p>
              <p class="book-description">${pagamento.status }</p>
            </div>
          </header>
    </article>    

    <footer id="layout-footer">
        <div class="clearfix container">
        	<div id="collections-footer">
                <!-- cdc-footer -->
                <p class="footer-title">PAYFAST</p>
            </div>
        </div>
    </footer>
</body>
</html>
