

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet"  href="css/login.css" />
        <title>Login</title>
    </head>
    <body>
        <div class="login">
            <div class="Contentlogin">
                    <form  action="Validar" method="POST">
                        <div>
                            <img src="img/Logo Speed.png" alt="Logo SpeedOne" width="250px"/><br><br>
                            <p>¡Bievenido a Speed One!</p>
                        </div>
                        <div>
                            <h2>Usuario</h2>
                            <br>
                            <input class="In" type="text" name="txtUser" placeholder="Usuario...">
                        </div>
                        <div>
                            <h2>Contraseña</h2>
                            <br>
                            <input class="In" type="password" name="txtPass" placeholder="Contraseña...">
                        </div>
                        <input class="button" type="submit" name="accion" value="Ingresar" >
                    </form>
            </div>
        </div>
    </body>
</html>
