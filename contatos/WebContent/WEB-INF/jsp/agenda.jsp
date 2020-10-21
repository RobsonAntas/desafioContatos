<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<meta charset="ISO-8859-1">
<script>
$(document).ready(function(){
	$("#listar").click(function(){
		$.post("rota",{classe:"ListarContatos"},function(responseTxt){
			$("#div2").text(responseTxt);
		});		
	});
	$("#adicionar").click(function(){
		$("#div2").html("<form><table><tr><td>Nome do contato:<input id=\"nomeContato\" type=\"text\"></td></tr>"+
		"<tr><td>E-mail do contato:<input id=\"emailContato\" type=\"text\"></td></tr><tr><td>Telefone:<input id=\"telContato\" type=\"text\">"+
		"</td></tr><tr><td>Ddd:<input id=\"dddContato\" type=\"text\"></td></tr><tr><td>Tipo:<input id=\"tipo\" type=\"text\"></td></tr><tr><td><button id=\"send\">submeter</button></td></tr></table></form>");	
});
	$("#send").click(function(){
		$.post("rota",{classe:"AdicionarContatos",
            nomeContato:$("#nomeContato").val(),
            emailContato:$("#emailContato").val(),
            dddContato:$("#dddContato").val(),
            tipo:$("#tipo").val()},function(){            	
            	alert("tudo bem!");
            });	
		$("#nomeContato").val("");
		$("#mailContato").val("");
		$("#dddContato").val("");
		$("#tipo").val("");
	});
	
})
</script>
<title>Agenda</title>
</head>
<body>
<h1 id="h1agenda">Olá!!!!</h1>
<div id="div1">
<a id="listar" href="#">Listar Contatos</a>
<a id="adicionar" href="#">Adicionar Contatos</a>
</div>

<div id="div2"></div>
</body>
</html>