<%@ tag language="java" pageEncoding="ISO-8859-1"%>

<%@ attribute name="id" required="true" %>
<%@ attribute name="value" required="false" %>

<input id="${id}" name="${id}" value="${value}" type="text">

<script>
	$("#${id}").datepicker({
		dateFormat: "dd/mm/yy",
		dayNames: ['Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sábado'],
	    dayNamesMin: ['D','S','T','Q','Q','S','S','D'],
	    dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sáb','Dom'],
	    monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
	    monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set','Out','Nov','Dez'],
	    nextText: "Próximo",
	    prevText: "'Anterior",		
		showOtherMonths: true,
		selectOtherMonths: true
	});
</script>