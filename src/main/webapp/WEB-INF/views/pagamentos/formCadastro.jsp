<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Interface web para o payfast</title>
</head>
<body>
	<form action="/payfastSpring/pagamentos" method="post">
		<div>
			<label>Forma de pagamento</label> <input type="text"
				name="formaPagamento" />
		</div>
		<div>
			<label>Valor</label> <input type="text" name="valor" />
		</div>
		<div>
			<label>Moeda</label> <input type="text" name="moeda" maxlength="3" />
		</div>
		<div>
			<label>Status</label> <input type="text" name="status" />
		</div>
		<div>
			<label>Descrição</label>
			<textarea rows="10" cols="20" name="descricao"></textarea>
		</div>
		<button type="submit">Cadastrar</button>
	</form>
</body>
</html>