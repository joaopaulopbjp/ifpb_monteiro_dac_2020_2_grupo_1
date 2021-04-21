package dto;

public class CorreioDTO {
	
	private long indentificador;
	private String cep_origem;
	private String cep_destino;
	private int formato;
	private String peso;
	private int comprimento;
	private int altura;
	private int largura;
	private String mao_propria;
	private String aviso_recebimento;
	private String valor_declarado;
	private String servicos [];

	public long getIndentificador() {
		return indentificador;
	}

	public void setIndentificador(long indentificador) {
		this.indentificador = indentificador;
	}

	public String getCep_origem() {
		return cep_origem;
	}

	public void setCep_origem(String cep_origem) {
		this.cep_origem = cep_origem;
	}

	public String getCep_destino() {
		return cep_destino;
	}

	public void setCep_destino(String cep_destino) {
		this.cep_destino = cep_destino;
	}

	public int getFormato() {
		return formato;
	}

	public void setFormato(int formato) {
		this.formato = formato;
	}

	public int getComprimento() {
		return comprimento;
	}

	public void setComprimento(int comprimento) {
		this.comprimento = comprimento;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getLargura() {
		return largura;
	}

	public void setLargura(int largura) {
		this.largura = largura;
	}

	public String getMao_propria() {
		return mao_propria;
	}

	public void setMao_propria(String mao_propria) {
		this.mao_propria = mao_propria;
	}

	public String getAviso_recebimento() {
		return aviso_recebimento;
	}

	public void setAviso_recebimento(String aviso_recebimento) {
		this.aviso_recebimento = aviso_recebimento;
	}

	public String[] getServicos() {
		return servicos;
	}

	public void setServicos(String[] servicos) {
		this.servicos = servicos;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getValor_declarado() {
		return valor_declarado;
	}

	public void setValor_declarado(String valor_declarado) {
		this.valor_declarado = valor_declarado;
	}
}
