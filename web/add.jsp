<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>formulier</title>
</head>
<body>
<article>
    <c:if test="${not empty errors}">
        <div class="error">
            <ul>
                <c:forEach items="${errors}" var="error">
                    <li><p>${error}</p></li>
                </c:forEach>
            </ul>
        </div>
    </c:if>
</article>
<article>
    <h2>formulier</h2>
    <form method="POST" action="servlet?task=add"  novalidate>
        <fieldset>
            <legend>formulier</legend>
            <label for="naam">naam :</label>
            <input type="text" name="naam" id="naam"
                   value="${voornaamIsSafe}">
            <label for="achternaam">achternaam :</label>
            <input type="text" name="achternaam" id="achternaam"
                   value="${naamIsSafe}">
            <label for="leeftijd">leeftijd :</label>
            <input type="text" name="leeftijd" id="leeftijd"
                   value="${leeftijdIsSafe}">
            <label for="richting">richting :</label>
            <input type="text" name="richting" id="richting"
                   value="${studieRichtingIsSafe}">
            <input type="submit" value="add">
        </fieldset>
    </form>
</article>
</body>
</html>