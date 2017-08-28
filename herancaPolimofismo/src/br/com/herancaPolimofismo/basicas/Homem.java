package br.com.herancaPolimofismo.basicas;

public class Homem extends Mamiferos {

	private boolean caminha;
	
	public Homem(int qtdMamas, int qtdPelos) {
		super(qtdMamas, qtdPelos);
	}

	public boolean isCaminha() {
		return caminha;
	}

	public void setCaminha(boolean caminha) {
		this.caminha = caminha;
	}	
}
