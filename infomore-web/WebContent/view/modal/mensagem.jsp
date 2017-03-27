<link href="css/mensagem.css" rel="stylesheet">

<c:set value="${mensagem}" var="mensagem" scope="request" />
<c:set value="${tipoMensagem}" var="tipoMensagem" scope="request" />

<c:if test="${ mensagem != null && tipoMensagem != null}">
	<div id="modalMsg" class="modal ${tipoMensagem}">
		<div class="modal-content">
			<b><c:out value="${mensagem}"/></b>
		</div>
	</div>

	<script type="text/javascript">
		$(document).ready(function() {
			$('.modal').modal().modal('open');
		});
	</script>
</c:if>

