package br.com.herancaPolimofismo.teste.cachorro;

import java.util.List;

import br.com.herancaPolimofismo.basicas.Homem;
import br.com.herancaPolimofismo.basicas.Macaco;
import br.com.herancaPolimofismo.basicas.Mamifero;
import br.com.herancaPolimofismo.controladores.MacacoController;
import br.com.herancaPolimofismo.helper.Conversor;

public class TesteMacaco {

	public static void main(String[] args) {

		MacacoController controller = MacacoController.get();
		Mamifero macaco = new Macaco(2, 5000);
		macaco.nome("Ariosvaldo");
		Mamifero macaco1 = new Macaco(2, 500);
		macaco1.nome("Miguel");
		Mamifero macaco2 = new Macaco(2, 50);
		macaco2.nome("Anderson");
		Mamifero macaco3 = new Macaco(2, 5000);
		macaco3.nome("Zé");

		System.out.println("@@@@@@@@@@@@@@@@@ SALVANDO MACACO @@@@@@@@@@@@@@@@@@@@@@");

		try {
			if (controller.salvarAlterar(macaco)) {
				System.out.println("Salvou!!!! " + macaco.recuperarNome());
			} else {
				System.out.println("Deu Merd@@!! " + macaco.recuperarNome());
			}

			if (controller.salvarAlterar(macaco1)) {
				System.out.println("Salvou!!!! " + macaco1.recuperarNome());
			} else {
				System.out.println("Deu Merd@@!! " + macaco1.recuperarNome());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("@@@@@@@@@@@@@@@@@ XXXXXXXXXXXXXXXXXXXXX @@@@@@@@@@@@@@@@@@@@@@");
		System.out.println();
		System.out.println("@@@@@@@@@@@@@@@@@ REMOVENDO MACACO @@@@@@@@@@@@@@@@@@@@@@");
		
		try {
			if (controller.remover(macaco2)) {
				System.out.println("MACACO removido!!! " + macaco2.recuperarNome());
			} else {
				System.out.println("erro ao remover o MACACO!!! " + macaco2.recuperarNome());
			}

			if (controller.remover(macaco1)) {
				System.out.println("MACACO removido!!! " + macaco1.recuperarNome());
			} else {
				System.out.println("erro ao remover o MACACO!!! " + macaco1.recuperarNome());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("@@@@@@@@@@@@@@@@@ XXXXXXXXXXXXXXXXXXXXX @@@@@@@@@@@@@@@@@@@@@@");
		System.out.println();
		System.out.println("@@@@@@@@@@@@@@@@@ CONSULTANDO MACACOS @@@@@@@@@@@@@@@@@@@@@@");
		
		try {
			if (controller.getMacaco(macaco3) != null) {
				System.out.println("MACACO Encontrado!!! "+ macaco3.recuperarNome());
			} else {
				System.out.println("erro ao consultar o MACACO!!! "+ macaco3.recuperarNome());
			}

			if (controller.remover(macaco)) {
				System.out.println("MACACO Encontrado!!! "+ macaco.recuperarNome());
			} else {
				System.out.println("erro ao consultar o MACACO!!! "+ macaco.recuperarNome());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("@@@@@@@@@@@@@@@@@ XXXXXXXXXXXXXXXXXXXXX @@@@@@@@@@@@@@@@@@@@@@");
		System.out.println();
		System.out.println("@@@@@@@@@@@@@@@@@ SALVANDO MACACOS @@@@@@@@@@@@@@@@@@@@@@");

		try {
			if (controller.salvarAlterar(macaco3)) {
				System.out.println("Salvou!!!! "+ macaco3.recuperarNome());
			} else {
				System.out.println("Deu Merd@@!! "+ macaco3.recuperarNome());
			}

			if (controller.salvarAlterar(macaco2)) {
				System.out.println("Salvou!!!! "+ macaco2.recuperarNome());
			} else {
				System.out.println("Deu Merd@@!! "+ macaco2.recuperarNome());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("@@@@@@@@@@@@@@@@@ XXXXXXXXXXXXXXXXXXXXX @@@@@@@@@@@@@@@@@@@@@@");
		System.out.println();
		System.out.println("@@@@@@@@@@@@@@@@@ LISTANDO MACACOS @@@@@@@@@@@@@@@@@@@@@@");
		
		try {
			List<Macaco> macacos = controller.getMacacos();
			StringBuilder builder = new StringBuilder();
			int contador = 0;
			for (Macaco h : macacos) {
				++contador;
				builder.append("[ ").append(contador).append("] ").append("Nome: " + h.recuperarNome())
						.append(" Corre: " + Conversor.simNao(h.isCorre()))
						.append(" Tem Cauda: " + Conversor.simNao(h.isTemCauda()))
						.append("\n");
				System.out.print(builder.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
