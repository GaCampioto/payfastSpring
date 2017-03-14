<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<td>Forma de pagamento</td>
			<td>Descrição</td>
			<!--  <td>Data</td>-->
			<td>Valor</td>
			<td>Moeda</td>
			<td>Status</td>
		<c:forEach items="${pagamentos}" var="pagamento">
			<tr>
				<td>${pagamento.formaPagamento}</td>
				<td>${pagamento.descricao}</td>
				<!-- <td>${pagamento.data}</td> -->
				<td>${pagamento.valor}</td>
				<td>${pagamento.moeda}</td>
				<td>${pagamento.status}</td>
			<tr>
		</c:forEach>
	</table>
</body>
</html>