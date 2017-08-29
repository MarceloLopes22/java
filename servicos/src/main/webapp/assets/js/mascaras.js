$(document).ready(function() {
	mascaraCPF(cpf);
	mascaraCEP(cep);
});

function mascaraCPF(cpf) {
	$(cpf).mask('000.000.000-00', {
		reverse : true
	});
}

function mascaraCEP(cep) {
	$(cep).mask('00000-000', {
		reverse : true
	});
}