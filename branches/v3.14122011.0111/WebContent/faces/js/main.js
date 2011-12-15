
function ocultar(span) {
	span.style.display='none';
}

function exibir(span, input) {
	if(input.value==null || input.value=='') {
		span.style.display='';
	}
}