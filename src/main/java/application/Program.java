package application;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<TaxPayer> list = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int n = sc.nextInt();
        for(int i = 1; i <= n; i++) {
            System.out.println("Tax payer #" + i + " data:");
            System.out.print("Individual or company (i/c)? ");
            char type = sc.next().charAt(0);
            System.out.print("Name: ");
            String name = sc.next();
            sc.nextLine();
            System.out.print("Anual Income: ");
            double anualIncome = sc.nextDouble();
            sc.nextLine();
            if(type == 'i') {
                System.out.println("Helth expenditures: ");
                double helthexpenditures = sc.nextDouble();
                TaxPayer individual = new Individual(name, anualIncome, helthexpenditures);
                list.add(individual);
            } else {
                System.out.println("Number of employees: ");
                int numberOfEmployees = sc.nextInt();
                TaxPayer company = new Company(name, anualIncome, numberOfEmployees);
                list.add(company);
            }
        }

        double total = 0.0;
        System.out.println("TAXES PAID: ");
        for (TaxPayer payer : list) {
            System.out.println(payer.getName()
                    + ": $ "
                    + String.format("%.2f",payer.tax()));
            total += payer.tax();
        }

        System.out.println();
        System.out.println("TOTAL TAXES: $ " + String.format("%.2f",total));

        sc.close();
    }
}
