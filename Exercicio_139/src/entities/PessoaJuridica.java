package entities;

public class PessoaJuridica extends Pessoa {
	private Integer numeroFuncionarios;

	public PessoaJuridica() {
		super();
	}

	public PessoaJuridica(String nome, Double rendaAnual, Integer numeroFuncionarios) {
		super(nome, rendaAnual);
		this.numeroFuncionarios = numeroFuncionarios;
	}

	public Integer getNumeroFuncionarios() {
		return numeroFuncionarios;
	}

	public void setNumeroFuncionarios(Integer numeroFuncionarios) {
		this.numeroFuncionarios = numeroFuncionarios;
	}

	@Override
	public Double imposto() {
		double sum = 0.0;
		
		if (getNumeroFuncionarios() > 10) {
			sum += getRendaAnual() * 14 / 100;
		} else {
			sum += getRendaAnual() * 16 / 100;
		}

		return sum;
	}

}
