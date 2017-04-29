<link href="css/navigator.css" rel="stylesheet" />
<script type="text/javascript" src="js/navigator.js"></script>

<nav>
	<ul id="dropdownOpcoes" class="dropdown-content collection">
		<li class="collection-item"><a href="perfil?acao=consultar"
			class="navigator-item">Meu Perfil</a></li>
		<li class="collection-item"><a href="navegar?acao=senha"
			class="navigator-item">Alterar Senha</a></li>

		<li class="divider"></li>

		<li class="collection-item"><a id="linkSalvarMeuLocal"
			class="navigator-item">Salvar este local</a></li>
		<li class="collection-item"><a href="meuLocal?acao=listar"
			class="navigator-item">Meus locais</a></li>


		<li class="collection-item"><a href="navegar?acao=classificacao"
			class="navigator-item">Prioridades</a></li>
		<li class="divider"></li>

		<li class="collection-item"><a href="login?acao=sair"
			class="navigator-item">Sair</a></li>

	</ul>

	<div class="nav-wrapper teal menuNav">

		<ul id="nav-mobile" class="left">
			<li><a href="#!" id="dropdownButtonOpcoes"
				class="dropdown-button" data-beloworigin="true"
				data-constrainwidth="false" data-activates="dropdownOpcoes"><i
					class="material-icons">settings</i></a></li>
		</ul>
		<a href="navegar?acao=mapa" class="right"><img
			src="images/icon_mapa.png" /></a>
	</div>
</nav>

<script type="text/javascript">
	window.onload = function() {
		var a = document.getElementById("linkSalvarMeuLocal");
		a.onclick = function() {
			salvarEsteLocal("Teste");
			return false;
		}
	}
</script>