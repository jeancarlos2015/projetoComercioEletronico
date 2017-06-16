<%-- 
    Document   : cadastroProdutos
    Created on : 15/06/2017, 19:14:12
    Author     : jean
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="utf-8">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/bootstrap-theme.css" rel="stylesheet">
        <link href="css/estilo.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/funcoes.js"></script>
        <title>Cadastro De Pedidos</title>
    </head>
    <body>
        <nav class="navbar navbar-inverse">
            <ul class="nav nav-pills">
                <li role="presentation" ><a href="index.jsp">Pedidos</a></li>
                <li role="presentation" class="active"><a href="cadastroProdutos.jsp">Produtos</a></li>
                <li role="presentation" ><a href="cadastroFornecedor.jsp">Fornecedor</a></li>
            </ul>
        </nav>
        <div class="jumbotron">
            <h1>
                <th class="align-center">Cadastro De Produtos</th>
            </h1>
        </div>

        <form method="post" action="Controlador">
            <span class="campo" id="basic-addon1" >Nome</span>
            <input id="codigo" type="text" class="campo" name="nome"  placeholder="Fulano" required="required" aria-describedby="basic-addon1" value="Feijao">

            <span class="campo" id="basic-addon1" >Descrição</span>
            <input id="descricao" type="text" class="campo" name="descricao"  placeholder="Feijao" required="required" aria-describedby="basic-addon1" value="Feijao Tropeiro">

            <span class="campo" id="basic-addon1">Marca</span>
            <input id="marca" type="text" class="campo" name="marca"  placeholder="Rio doce" required="required" aria-describedby="basic-addon1" value="Rio doce">

            <span class="campo" id="basic-addon1">Quantidade Unitaria</span>
            <input id="quantidade" type="text" class="campo" name="quantidade_unitaria"  placeholder="0" required="required" aria-describedby="basic-addon1" value="20">

            <span class="campo" id="basic-addon1">Quantidade Estoque</span>
            <input id="quantidade" type="text" class="campo" name="quantidade_estoque"  placeholder="0" required="required" aria-describedby="basic-addon1" value="30">
            
            <span class="campo" id="basic-addon1">Preço</span>
            <input id="quantidade" type="text" class="campo" name="preco"  placeholder="0" required="required" aria-describedby="basic-addon1" value="20">

            <input  type="text" class="oculto" name="tipo" value="produto">

            <input  type="text" class="oculto" name="operacao" value="cadastro">

            <div class="opcoes  radio">
                <label><input type="radio" name="optradio" value="tropeiro" checked="">Tropeiro</label>
                <label><input type="radio" name="optradio" value="salada">Salada</label>
                <label><input type="radio" name="optradio" value="prato">Prato</label>
                <label><input type="radio" name="optradio" value="espaguete">Espaguete</label>
                <label><input type="radio" name="optradio" value="refrigerante">Refrigerante</label>
            </div>
            <button type="submit" class="btn btn-default campo" onclick="verifica()">Cadastrar</button>
            
            <div class="alert">
                <h3 class="mensagem">${mensagem}</h3>
            </div>
        </form>
        <br>
        <br>
    </body>
</html>