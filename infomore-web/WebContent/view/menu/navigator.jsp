<link href="css/navigator.css" rel="stylesheet" />
<script type="text/javascript" src="js/navigator.js"></script>

<nav>
	<ul id="dropdownOpcoes" class="dropdown-content collection">
		<li class="collection-item"><a href="perfil?acao=consultar"
			class="navigator-item">Meu Perfil</a></li>
		<li class="collection-item"><a href="navegar?acao=senha"
			class="navigator-item">Alterar Senha</a></li>

		<li class="divider"></li>

		<!-- <li class="collection-item"><a id="linkSalvarMeuLocal" href="navegar?acao=detalhesMeuLocal"
			class="navigator-item">Salvar este local</a></li> -->
		<li class="collection-item"><a href="meusLocais?acao=listar"
			class="navigator-item">Meus locais</a></li>


		<li class="collection-item"><a href="navegar?acao=classificacao"
			class="navigator-item">Prioridades</a></li>
		<li class="divider"></li>

		<li class="collection-item"><a href="login?acao=sair"
			class="navigator-item">Sair</a></li>

	</ul>

	<div class="nav-wrapper teal menuNav">

		<ul id="nav-mobile">
			<li class="left"><a href="#!" id="dropdownButtonOpcoes"
				class="dropdown-button" data-beloworigin="true"
				data-constrainwidth="false" data-activates="dropdownOpcoes"><i
					class="material-icons">settings</i></a></li>
					
			<li class="right"><a href="navegar?acao=mapa" ><img
					src="images/icon_mapa.png" /></a></li>

		</ul>
		
		<div id="divBotaoMeuLocal" style="visibility:hidden">
			<a class="center" href="navegar?acao=detalhesMeuLocal" id="linkSalvarMeuLocal"><i
				class="material-icons">my_location</i></a>

			<script type="text/javascript">
				window.onload = function() {
					var a = document
							.getElementById("linkSalvarMeuLocal");
					a.onclick = function() {
						salvarEsteLocal("Meu Local");
						return true;
					}
				}
			</script>
		</div>

	</div>
</nav>

<script type="text/javascript">
	window.onload = function() {
		var a = document.getElementById("linkSalvarMeuLocal");
		a.onclick = function() {
			salvarEsteLocal("Meu Local");
			return true;
		}
	}
</script>