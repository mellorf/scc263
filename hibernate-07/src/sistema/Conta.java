package sistema;

public class Conta {
	// atributos
	private Long id;
	private Float money;

	public Conta() {}

	private void setId(Long id) { this.id = id; }
	public void setMoney(Float money) { this.money = money; }

	public Long getId() { return id; }
	public Float getMoney() { return money; }
}
