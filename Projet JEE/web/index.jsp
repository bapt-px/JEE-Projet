<%@page import="com.bapt.package1.DB"%>
<!DOCTYPE HTML>
<html>

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="./css/style.css" type="text/css" rel="stylesheet" />
</head>

<body>
    
        <p class="error_message">Error message ${loginError}</p>
    <form method="post" action="">
        <h2>
            <p>Login</p>
        </h2>
        <input type="text" name="login" placeholder=" Login" /><br />
        <input type="password" name="password" placeholder=" Password" /><br />
        <input type="submit" value="Login" />
    </form>
</body>

</html>
