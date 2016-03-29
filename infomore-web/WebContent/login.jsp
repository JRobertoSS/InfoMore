<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>

<title>InfoMore</title>
</head>
<body>
	<div class="container">
		
			<form action="Usuario?acao=login" method="post">
				<div class="form-group">
					<label for="txtEmail">E-mail: </label>
					<input type="text" name="txtEmail" class="form-control">
					<br>
				</div>
				<div class="form-group">
					<label for="txtSenha">Senha: </label>
					<input type="password" name="txtSenha" class="form-control">
					<br>
				</div>
				<div class="form-group">
					<div class="row">
						<div class="col-md-10">
							<input type="submit" id="btnOperacao" name="btnOperacao" value="Entrar" class="btn btn-primary">
							<a href="cadastro.jsp" class="btn btn-default">Sou novo por aqui!</a>
						</div>
					</div> <!-- row -->
				</div>
			</form>
		</div>
		<%@include file="WEB-INF/util/mensagem.jsp" %>
	</div>
</body>
</html>