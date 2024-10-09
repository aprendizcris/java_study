
public class funcionario {
	public int id;
	public String name;
	private double salary;

	public funcionario(int id) {
		this.id = id;
	}
	
	public funcionario(int id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.setSalary(salary);
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
}
