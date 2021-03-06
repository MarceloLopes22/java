package br.com.herancaPolimofismo.basicas;

public class Cachorro extends Mamifero {

	private boolean temCauda;
	private boolean corre;
	private boolean trota;
	
	public Cachorro(int qtdMamas, int qtdPelos) {
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

	public boolean isTrota() {
		return trota;
	}

	public void setTrota(boolean trota) {
		this.trota = trota;
	}

	@Override
	public String nome(String nome) {
		super.nome = nome;
		return nome;
	}

	@Override
	public String recuperarNome() {
		return super.nome;
	}
}
