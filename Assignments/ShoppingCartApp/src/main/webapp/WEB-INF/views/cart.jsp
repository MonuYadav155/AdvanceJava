<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<body>

<h2>Your Cart</h2>

<c:forEach var="item" items="${cartItems}">
    ${item.product.name} -
    Quantity: ${item.quantity} -
    Total: ${item.total}
    <br>
</c:forEach>

<h3>Total Amount: ${total}</h3>

<a href="products">Back to Products</a>

</body>
</html>