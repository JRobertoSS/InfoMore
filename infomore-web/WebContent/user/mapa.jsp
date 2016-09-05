<%@page import="br.com.infomore.dominio.Ponto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
#map {
	width: 500px;
	height: 400px;
}
</style>

<c:set var="latitude" value="${requestScope.latitude}"></c:set>
<c:set var="longitude" value="${requestScope.longitude}"></c:set>

<script src="${pageContext.request.contextPath}/user/js/scripts.js">
	window.onload = initialize(latitude, longitude);
</script>
<script src="https://maps.googleapis.com/maps/api/js"></script>
<script>
	
</script>
</head>
<body>
	*manter essas infos em uma op��o
	<div id="map"></div>
	<div id="raio">raio</div>
	<div id="lat">lat</div>
	<div id="lng">lng</div>
	
<%-- 		<%
			// para ler os pontos da request, chamar a fun��o em javascript correspondente
			List<Ponto> pontos = (List<Ponto>) request.getAttribute("pontos");
			for(Ponto ponto : pontos) {
				// Gerar um local para o ponto.
				// ...
			}
		%> --%>
		
	<!-- *Um bot�o (Filtrar) para as localidades, em que aparecem as 05 categorias: Sa�de, Educa��o, Seguran�a, Lazer/Cultura e Comodidades.
	Ao clicar em uma categoria, todos os pontos dentro do raio e desta categoria s�o mostrados. � poss�vel listar
	quais pontos espec�ficos de cada categoria s�o desejados (Ex. Hospitais, farm�cias e Postos, na categoria Sa�de))
	Ao clicar em um ponto, � poss�vel ver os detalhes e salvar este ponto nos "favoritos/pontos importantes" do usu�rio -->
	
	
	<!-- *Um bot�o (Filtrar) para as ocorr�ncias, em que aparecem as categorias em que h� ocorr�ncias apenas (Se houver apenas
	uma categoria, n�o vai ter sentido manter isso, bota direto a lista dos pontos, sem categoria). 
	Ao clicar em uma categoria, todos os pontos dentro do raio e desta categoria s�o mostrados. � poss�vel listar
	quais pontos espec�ficos de cada categoria s�o desejados (Ex. Acidentes, Assaltos e Homic�dios, na categoria Seguran�a)) -->
	
	<!-- *Um bot�o (Filtrar) para as �reas de abrang�ncia, em que aparecem as categorias Energia, �gua e Telecomunica��es.
	Ao clicar nisso, aparece quais categorias possuem (ou n�o) cobertura do servi�o. -->
	
	<!-- *Um bot�o de informa��es sobre a �rea demarcada. Ainda n�o definimos, mas pode ser algo como, al�m das infos de latitude, longitude e raio, quantidade de pontos de cada categoria no local e coisa do tipo. -->
	
	 <!--  window.variavel para salvar como 'global'-->
	
</body>
</html>