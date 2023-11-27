<html>
<body>
<h2>Hello World!</h2>

<h1>Comunicación entre JSP y Servlet</h1>

<form action="ServletTeatro" method="get">
    <input type="hidden" name="ACTION" value="Obra.TOP10VENTAS">
    <input type="submit" value="Llamar al Servlet">
</form>


<p>Mensaje desde el Servlet: <%= request.getAttribute("message") %></p>
</body>
</html>
