<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Interface web para o payfast</title>
</head>
<body>
	<form:form action="${s:mvcUrl('PC#salvar').build() }" method="post" commandName="pagamento">
		<div>
			<label>Forma de Pagamento</label>
			<form:input path="formaPagamento"/>
			<form:errors path="formaPagamento"/>
		</div>
		<div>
			<label>Valor</label>
			<form:errors path="valor"/>
			<form:input path="valor"/>
		</div>
		<div>
			<label>Moeda</label>		
			<form:input path="moeda"/>
			<form:errors path="moeda"/>
		</div>
		<div>
			<label>Status</label>
			<form:input path="status"/>
			<form:errors path="status"/>
		</div>
		<div>
			<label>Descrição</label>
			<form:textarea rows="2" cols="20" path="descricao"/>
			<form:errors path="descricao"/>
		</div>
		<div>
			<label>Data</label>
			<form:input path="data"/>
			<form:errors path="data"/>
		</div>
		<button type="submit">Cadastrar</button>
	</form:form>
</body>
</html>