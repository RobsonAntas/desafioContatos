<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/estilo.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<meta charset="ISO-8859-1">
<script>
$(document).ready(function(){
	$("#login").click(function(){
		$.post("checkin",{
			email:$("#user").val(),
			pass:$("#pass").val()
	},function(data,status){
			if(data==1)
			$("#div").load("agenda");
			 if(data==0)
					$("#erro").text("Usuário ou senha inválida");
					$("#erro").css("color","red");
				});
		sessionStorage.setItem("EMAIL",$("#user").val());
			});
	    
		$("#user").val("");
		$("#pass").val("");
});
</script>
<title>Contatos</title>
</head>
<body>
<section class="container">
<div id="div">
<h1>Agenda de Contatos</h1>

<form>
<table>
<tr>
<td>e-mail:<input type="email" name="usuario" id="user"/></td>
</tr>
<tr>
<td>Senha:<input type="password" name="senha" id="pass"/></td>
</tr>
</table>
</form>
<a id="login" href="#">login</a>
<a id="btncadastro" href="cadastro">cadastre-se</a>
<p id="erro"></p>
</div>
</section>
</body>
</html>