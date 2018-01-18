<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link href="./css/estilo.css" rel="stylesheet">
	<title>Blackbird Livraria - Listar Livros</title>
</head>
<body>
	<header class="container"> <img src="./imagens/logo-livraria.png" alt="Blackbird Livraria" id="logo-livraria" /> <nav class="menu-opcoes">
	<ul>
		<li><img src="./imagens/icon-livravria.png"><a href="#">Home</a></li>
		<li><img src="./imagens/icon-livravria.png"><a href="#">Carrinho</a></li>
		<li><img src="./imagens/icon-livravria.png"><a href="#">Cadastro</a></li>
		<li><img src="./imagens/icon-livravria.png"><a href="#">Login</a></li>
	</ul>
	</nav> </header>

	<div class="container destaque">
		<section class="busca">
		<h2>Busca</h2>
		<form>
			<input type="search"> <input type="image" src="./imagens/busca.png">
		</form>
		</section>

		<section class="menu-departamentos">
		<h2>Departamentos</h2>
		<nav>
		<ul>
			<li><a href="#">Livros</a>
				<ul>
					<li><a href="#">Auto-ajuda</a></li>
					<li><a href="#">Bibliografias</a></li>
					<li><a href="#">Teen</a></li>
					<li><a href="#">Romance</a></li>
					<li><a href="#">Ficção</a></li>
					<li><a href="#">Gibis e HQs</a></li>
				</ul></li>
			<li><a href="#">Filmes</a></li>
			<li><a href="#">Games</a></li>
			<li><a href="#">Música</a></li>
			<li><a href="#">Acessórios</a></li>
		</ul>
		</nav> </section>
	</div>

	<div class="container destaque" align="center">
		<h:forEach var="livro" items="#{livros}">
			<h:out value="${livro.titulo}" />
		</h:forEach>
	</div>

	<footer>
	<div class="container">
		<img src="./imagens/rodape-livraria.png" alt="Logo Livraria" id="logo-rodape">
			<ul class="social">
				<li><a href="http://facebook.com/">Facebook</a></li>
				<li><a href="http://twitter.com/">Twitter</a></li>
				<li><a href="http://plus.google.com/">Google+</a></li>
			</ul>
	</div>
	</footer>
</body>
</html>