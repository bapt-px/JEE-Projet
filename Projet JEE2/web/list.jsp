<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE HTML>
<html>

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="./css/style.css" type="text/css" rel="stylesheet" />
</head>

<body>
    <div class="warpper">
        <h2>List of Employee</h2>
        <form method="post" action="">
            <table>
                <tr>
                    <td>Sél</td>
                    <td>Name</td>
                    <td>First name</td>
                    <td>Home phone</td>
                    <td>Mobile phone</td>
                    <td>Work phone</td>
                    <td>Address</td>
                    <td>Postal Code</td>
                    <td>City</td>
                    <td>Email</td>
                </tr>
                <c:forEach items="${employee}" var="e">

                <tr>
                    <td><input type="radio" name="selector" value="${e['id']}" id="${e['id']}"/></td>
                    <td><label for="${e['id']}"><c:out value="${e['name']}" /></label></td>
                    <td><label for="${e['id']}"><c:out value="${e['firstName']}" /></label></td>
                    <td><label for="${e['id']}"><c:out value="${e['telehome']}" /></label></td>
                    <td><label for="${e['id']}"><c:out value="${e['telMob']}" /></label></td>
                    <td><label for="${e['id']}"><c:out value="${e['telPro']}" /></label></td>
                    <td><label for="${e['id']}"><c:out value="${e['adress']}" /></label></td>
                    <td><label for="${e['id']}"><c:out value="${e['postalCode']}" /></label></td>
                    <td><label for="${e['id']}"><c:out value="${e['city']}" /></label></td>
                    <td><label for="${e['id']}"><c:out value="${e['email']}" /></label></td>




                </tr>
                </c:forEach>

            </table>

            <input type="submit" value="Delete" name="action" />
            <input type="submit" value="Details" name="action" />
            <input type="submit" value="Add" name="action" />
            <input type="submit" value="Logout" name="action" />
        </form>
    </div>
</body>

</html>