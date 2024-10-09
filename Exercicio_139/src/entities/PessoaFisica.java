package entities;

public class PessoaFisica extends Pessoa {
	private Double gastosSaude;
	
	public PessoaFisica() {
		super();
	}
	
	public PessoaFisica(String nome, Double rendaAnual, Double gastosSaude) {
		super(nome, rendaAnual);
		this.gastosSaude = gastosSaude;
	}

	public Double getGastosSaude() {
		return gastosSaude;
	}

	public void setGastosSaude(Double gastosSaude) {
		this.gastosSaude = gastosSaude;
	}

	@Override
	public Double imposto() {
		double sum = 0.0;
		if (getRendaAnual() < 20000.0) {
			sum += getRendaAnual() * 15 / 100;
		} else {
			sum += getRendaAnual() * 25 / 100;
		}

		sum -= getGastosSaude() * 50 / 100;

		return sum;
	}
}
