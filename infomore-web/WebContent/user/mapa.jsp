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
	*manter essas infos em uma opção
	<div id="map"></div>
	<div id="raio">raio</div>
	<div id="lat">lat</div>
	<div id="lng">lng</div>
	
<%-- 		<%
			// para ler os pontos da request, chamar a função em javascript correspondente
			List<Ponto> pontos = (List<Ponto>) request.getAttribute("pontos");
			for(Ponto ponto : pontos) {
				// Gerar um local para o ponto.
				// ...
			}
		%> --%>
		
	<!-- *Um botão (Filtrar) para as localidades, em que aparecem as 05 categorias: Saúde, Educação, Segurança, Lazer/Cultura e Comodidades.
	Ao clicar em uma categoria, todos os pontos dentro do raio e desta categoria são mostrados. É possível listar
	quais pontos específicos de cada categoria são desejados (Ex. Hospitais, farmácias e Postos, na categoria Saúde))
	Ao clicar em um ponto, é possível ver os detalhes e salvar este ponto nos "favoritos/pontos importantes" do usuário -->
	
	
	<!-- *Um botão (Filtrar) para as ocorrências, em que aparecem as categorias em que há ocorrências apenas (Se houver apenas
	uma categoria, não vai ter sentido manter isso, bota direto a lista dos pontos, sem categoria). 
	Ao clicar em uma categoria, todos os pontos dentro do raio e desta categoria são mostrados. É possível listar
	quais pontos específicos de cada categoria são desejados (Ex. Acidentes, Assaltos e Homicídios, na categoria Segurança)) -->
	
	<!-- *Um botão (Filtrar) para as áreas de abrangência, em que aparecem as categorias Energia, Água e Telecomunicações.
	Ao clicar nisso, aparece quais categorias possuem (ou não) cobertura do serviço. -->
	
	<!-- *Um botão de informações sobre a área demarcada. Ainda não definimos, mas pode ser algo como, além das infos de latitude, longitude e raio, quantidade de pontos de cada categoria no local e coisa do tipo. -->
	
	 <!--  window.variavel para salvar como 'global'-->
	
</body>
</html>