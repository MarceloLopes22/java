package br.com.herancaPolimofismo.basicas;

public abstract class Mamifero {

	private int mamas;
	private int pelos;
	
	public Mamifero(int qtdMamas, int qtdPelos) {
		setMamas(qtdMamas);
		setPelos(qtdPelos);
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
	
}
