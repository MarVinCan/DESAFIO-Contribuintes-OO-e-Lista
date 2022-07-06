package entities;

public class TaxPayer {
	
	private Double salaryIncome;
	private Double servicesIncome;
	private Double capitalImcome;
	private Double healthSpending;
	private Double educationSpending;
	
	public TaxPayer(Double salaryIncome, Double servicesIncome, Double capitalImcome, Double healthSpending,
			Double educationSpending) {
		this.salaryIncome = salaryIncome;
		this.servicesIncome = servicesIncome;
		this.capitalImcome = capitalImcome;
		this.healthSpending = healthSpending;
		this.educationSpending = educationSpending;
	}

	public Double getSalaryIncome() {
		return salaryIncome;
	}

	public void setSalaryIncome(Double salaryIncome) {
		this.salaryIncome = salaryIncome;
	}

	public Double getServicesIncome() {
		return servicesIncome;
	}

	public void setServicesIncome(Double servicesIncome) {
		this.servicesIncome = servicesIncome;
	}

	public Double getCapitalImcome() {
		return capitalImcome;
	}

	public void setCapitalImcome(Double capitalImcome) {
		this.capitalImcome = capitalImcome;
	}

	public Double getHealthSpending() {
		return healthSpending;
	}

	public void setHealthSpending(Double healthSpending) {
		this.healthSpending = healthSpending;
	}

	public Double getEducationSpending() {
		return educationSpending;
	}

	public void setEducationSpending(Double educationSpending) {
		this.educationSpending = educationSpending;
	}
	//salary tax calculation
	public Double salaryTax() {
		double value;
		if ((salaryIncome / 12) < 3000.00) {
			value = 0.0;
		} else if ((salaryIncome / 12) < 5000.00) {
			value = 0.1 * salaryIncome;
		} else {
			value = 0.2 * salaryIncome;
		}		
		return value;
	}
	//calculation of tax on service provision
	public Double serviceTax() {
		double value; 
		if (servicesIncome > 0.0) {
			value = servicesIncome * 0.15;
		} else {
			value = 0.0;
		}
		return value;
	}
	//capital gain tax calculation
	public Double capitalTax() {
		double value; 
		if (capitalImcome > 0.0) {
			value = capitalImcome * 0.20;
		} else {
			value = 0.0;
		}
		return value;
	}
	//gross tax calculation
	public Double grossTax() {
		return salaryTax() + serviceTax() + capitalTax();
	}
	//tax abatement calculation
	public Double taxRebate() {
		double value = healthSpending + educationSpending;
		
		if (value > (grossTax() * 0.30)) {
			value = grossTax() * 0.30;
		}
		return value;
	}
	//calculation of tax due
	public Double netTax() {
		return grossTax() - taxRebate();
	}
	
}
