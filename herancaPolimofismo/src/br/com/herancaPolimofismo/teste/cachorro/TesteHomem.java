package br.com.herancaPolimofismo.teste.cachorro;

import java.util.List;

import br.com.herancaPolimofismo.basicas.Homem;
import br.com.herancaPolimofismo.basicas.Mamifero;
import br.com.herancaPolimofismo.controladores.HomemController;
import br.com.herancaPolimofismo.helper.Conversor;

public class TesteHomem {

	public static void main(String[] args) {

		HomemController controller = HomemController.get();
		Mamifero homem = new Homem(2, 5000);
		homem.nome("Marcilio");
		Mamifero homem1 = new Homem(2, 500);
		homem1.nome("Ricardo");
		Mamifero homem2 = new Homem(2, 50);
		homem2.nome("Mauricio");
		Mamifero homem3 = new Homem(2, 5000);
		homem3.nome("Junior");

		System.out.println("@@@@@@@@@@@@@@@@@ SALVANDO HOMEM @@@@@@@@@@@@@@@@@@@@@@");

		try {
			if (controller.salvarAlterar(homem)) {
				System.out.println("Salvou!!!! " + homem.recuperarNome());
			} else {
				System.out.println("Deu Merd@@!! " + homem.recuperarNome());
			}

			if (controller.salvarAlterar(homem1)) {
				System.out.println("Salvou!!!! " + homem1.recuperarNome());
			} else {
				System.out.println("Deu Merd@@!! " + homem1.recuperarNome());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("@@@@@@@@@@@@@@@@@ XXXXXXXXXXXXXXXXXXXXX @@@@@@@@@@@@@@@@@@@@@@");
		System.out.println();
		System.out.println("@@@@@@@@@@@@@@@@@ REMOVENDO HOMENS @@@@@@@@@@@@@@@@@@@@@@");
		
		try {
			if (controller.remover(homem2)) {
				System.out.println("Homem removido!!! " + homem2.recuperarNome());
			} else {
				System.out.println("erro ao remover o Homem!!! " + homem2.recuperarNome());
			}

			if (controller.remover(homem1)) {
				System.out.println("Homem removido!!! " + homem1.recuperarNome());
			} else {
				System.out.println("erro ao remover o Homem!!! " + homem1.recuperarNome());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("@@@@@@@@@@@@@@@@@ XXXXXXXXXXXXXXXXXXXXX @@@@@@@@@@@@@@@@@@@@@@");
		System.out.println();
		System.out.println("@@@@@@@@@@@@@@@@@ CONSULTANDO HOMENS @@@@@@@@@@@@@@@@@@@@@@");
		
		try {
			if (controller.getHomem(homem3) != null) {
				System.out.println("Homem Encontrado!!! "+ homem3.recuperarNome());
			} else {
				System.out.println("erro ao consultar o Homem!!! "+ homem3.recuperarNome());
			}

			if (controller.remover(homem)) {
				System.out.println("Homem Encontrado!!! "+ homem.recuperarNome());
			} else {
				System.out.println("erro ao consultar o Homem!!! "+ homem.recuperarNome());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("@@@@@@@@@@@@@@@@@ XXXXXXXXXXXXXXXXXXXXX @@@@@@@@@@@@@@@@@@@@@@");
		System.out.println();
		System.out.println("@@@@@@@@@@@@@@@@@ SALVANDO HOMENS @@@@@@@@@@@@@@@@@@@@@@");

		try {
			if (controller.salvarAlterar(homem3)) {
				System.out.println("Salvou!!!! "+ homem3.recuperarNome());
			} else {
				System.out.println("Deu Merd@@!! "+ homem3.recuperarNome());
			}

			if (controller.salvarAlterar(homem2)) {
				System.out.println("Salvou!!!! "+ homem2.recuperarNome());
			} else {
				System.out.println("Deu Merd@@!! "+ homem2.recuperarNome());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("@@@@@@@@@@@@@@@@@ XXXXXXXXXXXXXXXXXXXXX @@@@@@@@@@@@@@@@@@@@@@");
		System.out.println();
		System.out.println("@@@@@@@@@@@@@@@@@ LISTANDO HOMENS @@@@@@@@@@@@@@@@@@@@@@");
		
		try {
			List<Homem> homens = controller.getHomens();
			StringBuilder builder = new StringBuilder();
			int contador = 0;
			for (Homem h : homens) {
				++contador;
				builder.append("[ ").append(contador).append("] ").append("Nome: " + h.recuperarNome())
						.append(" Caminha: " + Conversor.simNao(h.isCaminha()))
						.append("\n");
				System.out.print(builder.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
