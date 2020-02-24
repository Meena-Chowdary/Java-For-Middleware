<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<jsp:include page="/header" />
<section style="padding:10px; min-height:400px;">
	<h3>Visitor Registration Form</h3>
	<form method="post">
		<label>Name:
			<input type="text" value="firstName" placeholder="firstName" required/>
			<input type="text" value="lastName" placeholder="lastName" required/>
		</label>
		<br/>
		<label>Date Of Birth
			<input type="date" name="dateOfBirth" required/>
		</label>
		<br/>
		<button>REGISTER</button>
	</form>
</section>
<jsp:include page="/footer" />


