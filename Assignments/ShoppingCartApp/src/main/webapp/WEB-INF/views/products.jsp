<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<body>

<h2>Product List</h2>

<c:forEach var="p" items="${products}">
    <form action="addToCart" method="post">
        ${p.name} - ${p.price}
        <input type="hidden" name="id" value="${p.id}" />
        Quantity:
        <input type="number" name="quantity" min="1" required />
        <button type="submit">Add to Cart</button>
    </form>
    <br>
</c:forEach>

<a href="cart">View Cart</a>

</body>
</html>