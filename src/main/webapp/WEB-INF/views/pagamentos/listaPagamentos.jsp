<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Interface web para o payfast</title>
</head>
<body>
	<h1>Pagamentos - Payfast</h1>
	<div>${sucesso}</div>
	<table>
		<tr>
			<td>Id</td>
			<td>Forma de pagamento</td>
			<td>Descrição</td>
			<!--  <td>Data</td>-->
			<td>Valor</td>
			<td>Moeda</td>
			<td>Status</td>
			<td>Comprovante</td>
		<c:forEach items="${pagamentos}" var="pagamento">
			<tr>
				<td><a href="${s:mvcUrl('PC#getDetails').arg(0,pagamento.id).build()}">${pagamento.id }</a></td>
				<td>${pagamento.formaPagamento}</td>
				<td>${pagamento.descricao}</td>
				<!-- <td>${pagamento.data}</td> -->
				<td>${pagamento.valor}</td>
				<td>${pagamento.moeda}</td>
				<td>${pagamento.status}</td>
				<td>${pagamento.comprovantePath}</td>
			<tr>
		</c:forEach>
	</table>
</body>
</html>