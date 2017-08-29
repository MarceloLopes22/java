package br.com.herancaPolimofismo.teste.cachorro;

import java.util.List;

import br.com.herancaPolimofismo.basicas.Cachorro;
import br.com.herancaPolimofismo.basicas.Mamifero;
import br.com.herancaPolimofismo.controladores.CachorroController;
import br.com.herancaPolimofismo.helper.Conversor;

public class TesteCachorro {

	public static void main(String[] args) {

		CachorroController controller = CachorroController.get();
		Mamifero cachorro = new Cachorro(6, 5000);
		Mamifero cachorro1 = new Cachorro(4, 500);
		Mamifero cachorro2 = new Cachorro(8, 50);
		Mamifero cachorro3 = new Cachorro(2, 5000);

		System.out.println("@@@@@@@@@@@@@@@@@ SALVANDO CACHORROS @@@@@@@@@@@@@@@@@@@@@@");

		try {
			if (controller.salvarAlterar(cachorro)) {
				System.out.println("Salvou!!!!");
			} else {
				System.out.println("Deu Merd@@!!");
			}

			if (controller.salvarAlterar(cachorro1)) {
				System.out.println("Salvou!!!!");
			} else {
				System.out.println("Deu Merd@@!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("@@@@@@@@@@@@@@@@@ XXXXXXXXXXXXXXXXXXXXX @@@@@@@@@@@@@@@@@@@@@@");
		System.out.println();
		System.out.println("@@@@@@@@@@@@@@@@@ REMOVENDO CACHORROS @@@@@@@@@@@@@@@@@@@@@@");
		try {
			if (controller.remover(cachorro2)) {
				System.out.println("Cachorro removido!!!");
			} else {
				System.out.println("erro ao remover o cachorro!!!");
			}

			if (controller.remover(cachorro1)) {
				System.out.println("Cachorro removido!!!");
			} else {
				System.out.println("erro ao remover o cachorro!!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("@@@@@@@@@@@@@@@@@ XXXXXXXXXXXXXXXXXXXXX @@@@@@@@@@@@@@@@@@@@@@");
		System.out.println();
		System.out.println("@@@@@@@@@@@@@@@@@ CONSULTANDO CACHORROS @@@@@@@@@@@@@@@@@@@@@@");
		try {
			if (controller.getCachorro(cachorro3) != null) {
				System.out.println("Cachorro Encontrado!!!");
			} else {
				System.out.println("erro ao consultar o cachorro!!!");
			}

			if (controller.remover(cachorro)) {
				System.out.println("Cachorro Encontrado!!!");
			} else {
				System.out.println("erro ao consultar o cachorro!!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("@@@@@@@@@@@@@@@@@ XXXXXXXXXXXXXXXXXXXXX @@@@@@@@@@@@@@@@@@@@@@");
		System.out.println();
		System.out.println("@@@@@@@@@@@@@@@@@ SALVANDO CACHORROS @@@@@@@@@@@@@@@@@@@@@@");

		try {
			if (controller.salvarAlterar(cachorro3)) {
				System.out.println("Salvou!!!!");
			} else {
				System.out.println("Deu Merd@@!!");
			}

			if (controller.salvarAlterar(cachorro2)) {
				System.out.println("Salvou!!!!");
			} else {
				System.out.println("Deu Merd@@!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("@@@@@@@@@@@@@@@@@ XXXXXXXXXXXXXXXXXXXXX @@@@@@@@@@@@@@@@@@@@@@");
		System.out.println();
		System.out.println("@@@@@@@@@@@@@@@@@ LISTANDO CACHORROS @@@@@@@@@@@@@@@@@@@@@@");
		try {
			List<Cachorro> cachorros = controller.getCachorros();
			StringBuilder builder = new StringBuilder();
			int contador = 0;
			for (Cachorro c : cachorros) {
				++contador;
				builder.append("[ ").append(contador).append("] ").append("Mamas: " + c.getMamas())
						.append(" Pelos: " + c.getPelos())
						.append(" Corre: " + Conversor.simNao(c.isCorre()))
						.append(" Tem Cauda: " + Conversor.simNao(c.isTemCauda()))
						.append(" Trota: " + Conversor.simNao(c.isTrota()))
						.append("\n");
				System.out.print(builder.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
