<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<meta charset="ISO-8859-1">
<script>
$(document).ready(function(){
   $("#cadastrar").click(function(){ 
	  $.post("rota",{classe:"CadastrarPessoa",
		             nome:$("#nome").val(),
		             email:$("#email").val(),
		             senha:$("#pass").val()},function(responseTxt){
		            	 if(responseTxt=="success")
		            		 alert("Cadastro efetuado com sucesso!");
		            	 if(responseTxt=="fail")
		            		 alert("Algum erro ocorreu, cadastro não efetuado !");
		             });
	    $("#nome").val("");
		$("#email").val("");
		$("#pass").val("");
	  });

});
</script>
<title>Cadastro</title>
</head>
<body>
<form>
<table>
<tr>
<td>Nome:<input id="nome" type="text"></td>
<tr>
<tr>
<td>e-mail:<input id="email" type="email"></td>
<tr>
<tr>
<td>Senha:<input id="pass" type="password"></td>
<tr>
</table>
<a id="cadastrar" href="#">cadastrar</a><a href="login.jsp">retornar a tela de login</a>
</form>
</body>
</html>