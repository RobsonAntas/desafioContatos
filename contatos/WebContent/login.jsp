<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<meta charset="ISO-8859-1">
<script>
$(document).ready(function(){
	$("#btnlogar").click(function(){
		$.post("checkin",{
			email:$("#user").val(),
			pass:$("#pass").val()
	},function(data,status){
			if(data==1){
				alert("funciona");
			}else if(data==0){
				alert("Usuário ou senha inválida");
				}
				    
	    });
		
		$("#user").val("");
		$("#pass").val("");
	});	
});
</script>
<title>Contatos</title>
</head>
<body>
<div>
<input type="email" name="usuario" id="user"/>
<input type="password" name="senha" id="pass"/>
<section>
<button id="btnlogar">logar</button>
<button>cadastre-se</button>
<p id="erro"></p>
</section>
</div>
</body>
</html>