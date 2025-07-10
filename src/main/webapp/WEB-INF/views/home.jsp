<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<!-- 모델에 있는 데이터를 가져오는 방법 1순위가 ${표현식}  -->
<!-- request.getAttribute 해서 사용하던걸 이렇게 쓰는 거임  -->
</body>
</html>
