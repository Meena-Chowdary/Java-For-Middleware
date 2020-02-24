<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<jsp:include page="/header" />
<section style="padding:10px; min-height:400px;">
	<h2>${msg }</h2>
	
	<form method="get">
		<label>Select Salutation</label>
			<select name="salut">
				<option value="">----select----</option>
				<option value="Mr.">Mister</option>
				<option value="Ms.">Miss</option>
				<option value="Mrs.">Mistress</option>
			</select>
		<label>Enter UserName:<input type="text" name="unm"/></label>
		<button>Done</button>
	</form>
</section>
<jsp:include page="/footer" />
