package br.com.herancaPolimofismo.teste.cachorro;

import br.com.herancaPolimofismo.basicas.Cachorro;
import br.com.herancaPolimofismo.basicas.Mamifero;
import br.com.herancaPolimofismo.controladores.CachorroController;

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
			
			if (controller.remover(cachorro)) {
				System.out.println("Cachorro removido!!!");
			} else {
				System.out.println("erro ao remover o cachorro!!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("@@@@@@@@@@@@@@@@@ XXXXXXXXXXXXXXXXXXXXX @@@@@@@@@@@@@@@@@@@@@@");
		System.out.println();
	}
}
