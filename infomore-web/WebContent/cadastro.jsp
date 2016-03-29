<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>

<title>Cadastro</title>
</head>
<body>
	<div class="container">
		<form action="Usuario?acao=salvar" method="post">
			<div class="form-group">
				<label for="txtNome">Nome: </label>
				<input type="text" name="txtNome" class="form-control">
			</div>
				<br>
			<div class="form-group">
				<label for="txtEmail">E-mail: </label>
				<input type="email" name="txtEmail" class="form-control">
			</div>
				<br>
			<div class="form-group">
				<label for="txtSenha">Senha: </label>
				<input type="password" name="txtSenha" class="form-control">
			</div>
				<br>
			<div class="form-group">
				<div class="row">
					<div class="col-md-10">
						<input type="submit" id="btnOperacao" name= "btnOperacao" value="Salvar" class="btn btn-primary">
						<input type="reset" id="btnOperacao" name= "btnOperacao" value="Limpar Dados" class="btn btn-default">
						<a href="login.jsp" class="btn btn-default">Cancelar</a>
					</div>
				</div>
			</div>
		</form>
	</div>
	<%@include file="WEB-INF/util/mensagem.jsp" %>
</body>
</html>