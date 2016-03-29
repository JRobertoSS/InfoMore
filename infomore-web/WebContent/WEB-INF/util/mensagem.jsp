<%@page import="br.com.infomore.core.aplicacao.Resultado"%>
<%
	if(request.getAttribute("resultado")!= null){
		Resultado resultado = (Resultado) request.getAttribute("resultado");
		if (!resultado.getMsg().isEmpty()){
	%>
			<script>alert('<%=resultado.getMsg()%>');</script>
	<%		request.setAttribute("resultado", null); // evita de chamar novamente a mensagem 
		}
	}
%>