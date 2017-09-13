package br.com.herancaPolimofismo.basicas;

public abstract class Mamifero {

	private int mamas;
	private int pelos;
	public String nome;
	
	public Mamifero(int qtdMamas, int qtdPelos) {
		nome = null;
		setMamas(qtdMamas);
		setPelos(qtdPelos);
	}
	
	public Mamifero(String nome) {
		nome(nome);
	}
	
	public int getMamas() {
		return mamas;
	}
	public void setMamas(int mamas) {
		this.mamas = mamas;
	}
	public int getPelos() {
		return pelos;
	}
	public void setPelos(int pelos) {
		this.pelos = pelos;
	}
	
	public abstract String nome(String nome);
	
	public abstract String recuperarNome();
}
