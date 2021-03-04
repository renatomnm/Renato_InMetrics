Feature: Listagem de funcionarios

	Scenario: Adicionar novo usuario
		Given que eu preenchi os campos usuario, senha e confirmar senha
		When clico no botão cadastrar
		Then o usuario é cadastrado com sucesso
		
  Scenario: Adicionar  funcionario
		Given que eu preencho todos os dados do funcionario
		When clico no botão enviar
		Then o funcionario é cadastrado com sucesso

  Scenario: Editar funcionario
		Given que eu altero os dados do funcionario
		When eu aperto o botão enviar
		Then o funcionario é editado com sucesso

	Scenario: Excluir funcionario
		Given que eu acesso a tela de listagem de funcionários
		When clico no botão excluir
		Then o funcionario é excluido com sucesso
