#language: pt

Funcionalidade: Cadastrar Clientes
	como um usuário do sistema
	eu quero realizar o cadastro de um cliente
	para que eu possa gerenciar clientes
	
	Cenário: Cadastro de cliente com sucesso
		Dado Acessar a página de cadastro de cliente
		E Informar o nome do cliente
		E Informar o telefone
		E Informar a data de nascimento
		E Selecionar o tipo de plano
		E Informar as observações
		Quando Solicitar a realização do cadastro
		Então Sistema informa que o cliente foi cadastrado com sucesso