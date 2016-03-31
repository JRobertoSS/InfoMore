<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<!-- Por alguma razão que só Satã sabe, não está chamando scripts em arquivos externos, então... -->
<script>
function atualizaDados(valor, destino){
	destino.value = valor;
}
</script>

<title>Configuração das Prioridades</title>
</head>
<body>
	<form action="Mapa?acao=classificacao" method="post">
		<table>
	    	<tr>	
	       	  <td>	<h3>Saude</h3></td>
	          <td><p1>Neste espaço vai a descrição da categoria </p1></td>
	  		</tr>
	        <tr>
	        	<td><input type="range" min="1" max="10" value="5" step="1" 
	                  name="rngSaude" id="rngSaude" oninput="atualizaDados(this.value, valorRngSaude);">
	                  <output for="rngSaude" name="valorRngSaude" id="valorRngSaude">5</output>
	            </td>
	        </tr>             
		</table>
		<table>
	    	<tr>	
	       	  <td>	<h3>Segurança</h3></td>
	          <td><p1>Neste espaço vai a descrição da categoria </p1></td>
	  		</tr>
	        <tr>
	        	<td><input type="range" min="1" max="10" value="5" step="1" 
	                  name="rngSeguranca" id="rngSeguranca" oninput="atualizaDados(this.value, valorRngSeguranca);">
	                  <output for="rngSeguranca" name="valorRngSeguranca">5</output>
	            </td>
	        </tr>             
		</table>
		<table>
	    	<tr>	
	       	  <td>	<h3>Educação</h3></td>
	          <td><p1>Neste espaço vai a descrição da categoria </p1></td>
	  		</tr>
	        <tr>
	        	<td><input type="range" min="1" max="10" value="5" step="1" 
	                  name="rngEducacao" id="rngEducacao" oninput="atualizaDados(this.value, valorRngEducacao);">
	                  <output for="rngEducacao" name="valorRngEducacao">5</output>
	            </td>
	        </tr>             
		</table>
		<table>
	    	<tr>	
	       	  <td>	<h3>Lazer e Cultura</h3></td>
	          <td><p1>Neste espaço vai a descrição da categoria </p1></td>
	  		</tr>
	        <tr>
	        	<td><input type="range" min="1" max="10" value="5" step="1" 
	                  name="rngLazerCultura" id="rngLazerCultura" oninput="atualizaDados(this.value, valorRngLazerCultura);">
	                  <output for="rngLazerCultura" name="valorRngLazerCultura">5</output>
	            </td>
	        </tr>             
		</table>
		<table>
	    	<tr>	
	       	  <td>	<h3>Comodidades</h3></td>
	          <td><p1>Neste espaço vai a descrição da categoria </p1></td>
	  		</tr>
	        <tr>
	        	<td><input type="range" min="1" max="10" value="5" step="1" 
	                  name="rngComodidades" id="rngComodidades" oninput="atualizaDados(this.value, valorRngComodidades);">
	                  <output for="rngComodidades" name="valorRngComodidades">5</output>
	            </td>
	        </tr>             
		</table>
		<input type="submit" name="btnProsseguir" value="Prosseguir"/>
	</form>
</body>
</html>