<link href="css/navigator.css" rel="stylesheet" />
<script type="text/javascript" src="js/navigator.js"></script>


<ul id="dropdownOpcoes" class="dropdown-content collection">
	<li class="collection-item">
		<form action="perfil" method="post">
			<input type="hidden" name="acao" value="consultar" /> <input
				type="submit" value="Meu Perfil"
				class="waves-effect waves-teal btn-flat btn-small " />
		</form>
	</li>
	<li class="collection-item">
		<form action="navegar" method="post">
			<input type="hidden" name="acao" value="senha" /> <input
				type="submit" value="Alterar Senha"
				class="waves-effect waves-teal btn-flat btn-small" />
		</form>
	</li>


	<li class="divider"></li>


	<li class="collection-item">
		<form action="meuLocal" method="post">
			<input type="hidden" name="acao" value="salvar" /> <input
				type="submit" value="Salvar este local"
				class="waves-effect waves-teal btn-flat btn-small" />
		</form>
	</li>

	<li class="collection-item">
		<form action="meuLocal" method="post">
			<input type="hidden" name="acao" value="listar" /> <input
				type="submit" value="Meus locais"
				class="waves-effect waves-teal btn-flat btn-small" />
		</form>
	</li>

	<li class="divider"></li>

	<li class="collection-item">
		<form action="login" method="post">
			<input type="hidden" name="acao" value="sair" /> <input
				type="submit" value="Sair"
				class="waves-effect waves-teal btn-flat btn-small" />
		</form>
	</li>

</ul>

<nav>

	<div class="nav-wrapper teal menuNav">

		<ul id="nav-mobile" class="left">
			<li><a href="#!" id="dropdownButtonOpcoes"
				class="dropdown-button" data-beloworigin="true"
				data-activates="dropdownOpcoes"><i class="material-icons">settings</i></a></li>
		</ul>
		<a href="navegar?acao=mapa" class="right"><img
			src="images/icon_mapa.png" /></a>
	</div>
</nav>