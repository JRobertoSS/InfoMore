<c:set value="${mensagem}" var="mensagem" scope="request" />

<c:if test="${ mensagem != null }">
	<div id="modalMsg" class="modal">
		<div class="modal-content">
			<b><c:out value="${mensagem}" /></b>
		</div>
	</div>

	<script type="text/javascript">
		$(document).ready(function() {
			$('.modal').modal().modal('open');
		});
	</script>
</c:if>

