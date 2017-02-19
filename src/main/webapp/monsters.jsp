<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <body>
        <h2>Monsters</h2>

        <table>
            <tr>Monster Name</tr>
            <tr>Monster HP</tr>
        </table>
        <c:forEach var="monster" items="${monsters}">
            <tr>
                <td>${monster.name}</td>
                <td>${monster.hp}</td>
            </tr>
        </c:forEach>
    </body>
</html>
