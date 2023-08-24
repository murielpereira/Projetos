<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="formulario.css" />
    <title>Formulário</title>
</head>

<body>
    <div>
        <h1 id="titulo">Cadastro de Usuário</h1>
        <p id="subtitulo">Complete suas Informações</p>
        <br/>
    </div>

    <form method="POST" action="meus_dados.php">
        
            <div class="campo">
                <label for="nome">Nome Completo</label>
                <input type="text" name="nome" id="nome" required>
            </div>
        
        <div class="campo">
            <label for="email">Email</label>
            <input type="email" name="email" id="email" required>
        </div>

        <div class="campo">
            <label for="cep">CEP</label>
            <input type="text" name="cep" id="cep" required>
        </div>

        <div class="campo">
            <label for="sexo">Sexo</label>
            <label>
                <input type="radio" name="sexo" value="Masculino"> Masculino
            </label>
            <label>
                <input type="radio" name="sexo" value="Feminino"> Feminino
            </label>
            <label>
                <input type="radio" name="sexo" value="Outro"> Outro
            </label>
        </div>
        
        <button class="button" type="submit">Enviar</button>
    </form>

    
</body>
</html>