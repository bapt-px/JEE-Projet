<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE HTML>
<html>

<head>
    <title>Login Page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="css/style.css" type="text/css" rel="stylesheet" />
</head>

<body>
    <div class="warpper">
        <form method="post" action="">
            <h2>
                <p>Login</p>
            </h2>
            <input hidden name="selector" value="${e.id}" />
            <label for="name">Nom</label>
            <input type="text" name="name" placeholder="Nom" value="${e.name}" id="name" /><br />

            <label for="firstName">Pr�nom</label>
            <input type="text" name="firstName" placeholder="Pr�nom" value="${e.firstName}" id="firstName" /><br />

            <label for="telehome">T�l Dom</label>
            <input type="text" name="telehome" placeholder="T�l Dom" value="${e.telehome}" id="telehome" /><br />

            <label for="telMob">T�l Mob</label>
            <input type="text" name="telMob" placeholder="T�l Mob" value="${e.telMob}" id="telMob" /><br />

            <label for="telPro">T�l Pro</label>
            <input type="text" name="telPro" placeholder="T�l Pro" value="${e.telPro}" id="telPro" /><br />

            <label for="adress">Adresse</label>
            <input type="text" name="adress" placeholder="Adresse" value="${e.adress}" id="adress" /><br />

            <div class="content">

                <label for="postalCode">Code postal</label>
                <input type="text" name="postalCode" placeholder="Code postal" value="${e.postalCode}" id="postalCode" /><br />
                
                 <label for="city">Ville</label>
                 <input type="text" name="city" placeholder="ville" value="${e.city}" id="city" /><br />

                <label for="email">Adresse e-mail</label>
                <input type="text" name="email" placeholder="Adresse e-mail" value="${e.email}" id="email" /><br />

            </div>
            <div class="content">
                 <c:if test="${e.id == 0}" var="e.id" scope="session" >
                    <input type="submit" value="Add User" name="action" />
                 </c:if>
                 <c:if test="${e.id != 0}" var="e.id" scope="session" >
                    <input type="submit" value="Save" name="action" />
                 </c:if>
                <a href="/list">Cancel</a>
            </div>
        </form>
    </div>
</body>

</html>