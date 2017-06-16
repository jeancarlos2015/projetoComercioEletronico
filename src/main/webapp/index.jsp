<%-- 
    Document   : index
    Created on : 15/06/2017, 19:14:21
    Author     : jean
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="utf-8">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="js/funcoes.js"></script>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/bootstrap-theme.css" rel="stylesheet">
        <link href="css/estilo.css" rel="stylesheet">

        <title>Cadastro De Pedidos</title>


    </head>
    <body>
        <nav class="navbar navbar-inverse">
            <ul class="nav nav-pills">
                <li role="presentation" class="active"><a href="index.jsp">Pedidos</a></li>
                <li role="presentation"><a href="cadastroProdutos.jsp">Produtos</a></li>
                <li role="presentation"><a href="cadastroFornecedor.jsp">Fornecedor</a></li>
            </ul>
        </nav>

        <div class="jumbotron">
            <h1>
                Solicitação De Pedidos
            </h1>
        </div>
        <main class="imagem servicos container">

            <h1 class="bg-titulo">PRODUTOS</h1>
            <form method="post" action="Controlador">
            
                <div class="figuras">
                    <figure class="figure" >
                        <a href="acesso.jsp"><img class="prato" src="img/prato.png" alt="..." class="img-thumbnail"></a> 
                        <label><input name="tipo1" type="checkbox" value="2"></label>
                        <figcaption class="figure-caption">Prato Personalizado</figcaption>
                    </figure>

                    <figure class="figure" >
                        <a href="acesso.jsp"><img class="prato" src="img/tropeiro.png" alt="..." class="img-thumbnail"></a> 
                        <label><input type="checkbox" name="tipo1" value="1"></label>
                        <figcaption class="figure-caption">Feijão Tropeiro</figcaption>
                    </figure>

                    <figure class="figure" >
                        <a href="acesso.jsp"><img class="prato" src="img/espaguete.png" alt="..." class="img-thumbnail"></a> 
                        <label><input type="checkbox" name="tipo1" value="3"></label>
                        <figcaption class="figure-caption">Espaguete</figcaption>
                    </figure>

                    <figure class="figure" >
                        <a href="acesso.jsp"><img class="prato" src="img/salada.png" alt="..." class="img-thumbnail"></a> 
                        <label><input type="checkbox" name="tipo1" value="4"></label>
                        <figcaption class="figure-caption">Salada</figcaption>
                    </figure>

                    <figure class="figure" >
                        <a href="acesso.jsp"><img class="prato" src="img/refrigerante.png" alt="..." class="img-thumbnail"></a> 
                        <label><input type="checkbox" name="tipo1" value="5"></label>
                        <figcaption class="figure-caption">Coca Cola</figcaption>
                    </figure> 

                    <input  type="text" class="oculto" name="tipo" value="pedido">
                    <input  type="text" class="oculto" name="operacao" value="cotacao">
                    <button type="submit" class="btn btn-default campo1">Solicitar Pedido</button>
                </div>
                <div class="alert">
                    <h3 class="mensagem">${mensagem}</h3>
                </div>
            </form>

    </body>
</html>