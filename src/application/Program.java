package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<TaxPayer> taxList = new ArrayList<>();
		
		System.out.print("Quantos contribuintes você vai digitar? ");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.println();
			System.out.println("Digite os dados do "+ i +"o contribuinte:");
			System.out.print("Renda anual com salário: ");
			double salary = sc.nextDouble();
			System.out.print("Renda anual com prestação de serviço: ");
			double service = sc.nextDouble();
			System.out.print("Renda anual com ganho de capital: ");
			double cg = sc.nextDouble();
			System.out.print("Gastos médicos: ");
			double health = sc.nextDouble();
			System.out.print("Gastos educacionais: ");
			double education = sc.nextDouble();
			
			TaxPayer taxPayer = new TaxPayer(salary, service, cg, health, education);
			taxList.add(taxPayer);
		}
		
		int i = 1;
			for (TaxPayer t : taxList) {
				System.out.println();
				System.out.println("Resumo do "+ i +"o contribuinte: ");
				System.out.printf("Imposto bruto total: %.2f %n", t.grossTax());
				System.out.printf("Abatimento: %.2f %n", t.taxRebate());
				System.out.printf("Imposto devido: %.2f %n", t.netTax());
				i++;
			}	
		sc.close();
	}

}
