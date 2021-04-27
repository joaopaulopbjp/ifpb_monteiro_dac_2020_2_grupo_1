package dto;

import org.springframework.stereotype.Component;

@Component
public class ServicosDTO {
	private String codigo;
	private String valor;
	private int PrazoEntrega;
	private String ValorSemAdicionais;
	private String ValorMaoPropria;
	private String ValorAvisoRecebimento;
	private String ValorValorDeclarado;
	private String EntregaDomiciliar;
	private String EntregaSabado;
	private int Erro;
	private String MsgErro;
	private String PacoteDePostagem;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public int getPrazoEntrega() {
		return PrazoEntrega;
	}
	public void setPrazoEntrega(int prazoEntrega) {
		PrazoEntrega = prazoEntrega;
	}
	public String getValorSemAdicionais() {
		return ValorSemAdicionais;
	}
	public void setValorSemAdicionais(String valorSemAdicionais) {
		ValorSemAdicionais = valorSemAdicionais;
	}
	public String getValorMaoPropria() {
		return ValorMaoPropria;
	}
	public void setValorMaoPropria(String valorMaoPropria) {
		ValorMaoPropria = valorMaoPropria;
	}
	public String getValorAvisoRecebimento() {
		return ValorAvisoRecebimento;
	}
	public void setValorAvisoRecebimento(String valorAvisoRecebimento) {
		ValorAvisoRecebimento = valorAvisoRecebimento;
	}
	public String getValorValorDeclarado() {
		return ValorValorDeclarado;
	}
	public void setValorValorDeclarado(String valorValorDeclarado) {
		ValorValorDeclarado = valorValorDeclarado;
	}
	public String getEntregaDomiciliar() {
		return EntregaDomiciliar;
	}
	public void setEntregaDomiciliar(String entregaDomiciliar) {
		EntregaDomiciliar = entregaDomiciliar;
	}
	public String getEntregaSabado() {
		return EntregaSabado;
	}
	public void setEntregaSabado(String entregaSabado) {
		EntregaSabado = entregaSabado;
	}
	public int getErro() {
		return Erro;
	}
	public void setErro(int erro) {
		Erro = erro;
	}
	public String getMsgErro() {
		return MsgErro;
	}
	public void setMsgErro(String msgErro) {
		MsgErro = msgErro;
	}
	public String getPacoteDePostagem() {
		return PacoteDePostagem;
	}
	public void setPacoteDePostagem(String pacoteDePostagem) {
		PacoteDePostagem = pacoteDePostagem;
	}
}
