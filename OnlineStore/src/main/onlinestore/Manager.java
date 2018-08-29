package onlinestore;

public class Manager extends Employee {

	public Manager(String firstName, String lastName, float fixedSalary) {
		super(firstName, lastName, fixedSalary);
	}

	public float salaryAfterBenefitsAndDeductions() {
		float benefits = benefits();
		float pensionFounds = this.fixedSalary * 10 / 100;
		float tax = 0;
		if (fixedSalary > 3500)
			tax = fixedSalary * 5 / 100;
		return fixedSalary + benefits - pensionFounds - tax;
	}

	private float benefits() {
		return this.subordinates.size() * 20;
	}
}
