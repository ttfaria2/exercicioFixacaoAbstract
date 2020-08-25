package entities;

public class Individual extends TaxPayer {

    private Double healthExpenditures;

    public Individual() {
    }

    public Individual(String name, Double anualIncome, Double healthExpenditures) {
        super(name, anualIncome);
        this.healthExpenditures = healthExpenditures;
    }

    public Double getHealthExpenditures() {
        return healthExpenditures;
    }

    public void setHealthExpenditures(Double healthExpenditures) {
        this.healthExpenditures = healthExpenditures;
    }

    public Double tax() {
        double tax = 0;
        if(getAnualIncome() < 20000.00 && healthExpenditures == 0) {
            tax = getAnualIncome() * 0.15;
        } else if(getAnualIncome() >= 20000.00 && healthExpenditures == 0) {
            tax = getAnualIncome() * 0.25;
        } else if(getAnualIncome() < 20000.00 && healthExpenditures > 0) {
            tax = (getAnualIncome() * 0.15) - (healthExpenditures * 0.5);
        } else if(getAnualIncome() >= 20000.00 && healthExpenditures > 0) {
            tax = (getAnualIncome() * 0.25) - (healthExpenditures * 0.5);
        } return tax;

    }
}
