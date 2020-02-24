<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<jsp:include page="/header" />
<section style="padding:10px; min-height:400px;">
	<h2>${pageTitle }</h2>
	<h3>Developers</h3>
	<ol>
		<c:forEach var="d" items="${developers }">
			<li>${d }</li>
			</c:forEach>
	</ol>
</section>
<jsp:include page="/footer" />


