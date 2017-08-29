package br.com.herancaPolimofismo.basicas;

public class Macaco extends Mamifero {

	private boolean temCauda;
	private boolean corre;
	
	public Macaco(int qtdMamas, int qtdPelos) {
		super(qtdMamas, qtdPelos);
	}

	public boolean isTemCauda() {
		return temCauda;
	}

	public void setTemCauda(boolean temCauda) {
		this.temCauda = temCauda;
	}

	public boolean isCorre() {
		return corre;
	}

	public void setCorre(boolean corre) {
		this.corre = corre;
	}	
}
