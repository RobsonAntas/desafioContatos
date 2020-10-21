<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
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
			$("#div").load("agenda",function(){
				$.post("agenda",{email:$("#user").val()})
			});				
			else if(data==0)
				$("#erro").text("Usuário ou senha inválida");
				$("#erro").css("color","red");								    
	    });
		
		$("#user").val("");
		$("#pass").val("");
	});	
});
</script>
<title>Contatos</title>
</head>
<body>
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
</body>
</html>