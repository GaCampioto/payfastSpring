<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Interface web para o payfast</title>
</head>
<body>
	<h1>Comprovantes - Payfast</h1>
	<a href="${s:mvcUrl('PC#listarPagamento').build()}" rel="nofollow">Meus pagamentos</a>
	<table>
		<tr>
			<td>Forma de pagamento</td>
			<td>Descrição</td>
			<td>Data</td>
			<td>Valor</td>
			<td>Moeda</td>
			<td>Status</td>
		<c:forEach items="${comprovante.itens}" var="item">
			<tr>
				<td>${item.pagamento.formaPagamento}</td>
				<td>${item.pagamento.descricao}</td>
				<td><fmt:formatDate pattern="dd/MM/yyyy" value="${item.pagamento.data.time }"/></td>
				<td>${item.pagamento.valor}</td>
				<td>${item.pagamento.moeda}</td>
				<td>${item.pagamento.status}</td>
			<tr>
		</c:forEach>
	</table>
	<div>Total dos comprovantes: ${comprovante.total}</div>
</body>
</html>