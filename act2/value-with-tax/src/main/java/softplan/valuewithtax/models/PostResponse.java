package softplan.valuewithtax.models;

public class PostResponse {

    private double tax;
    private double amount;
    private double valueWithTax;

    /*public double getTax() {
        return tax;
    }

    public double getAmount() {
        return amount;
    }*/

    public double getValueWithTax() {
        return valueWithTax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


    public void setValueWithTax(double valueWithTax) {
        this.valueWithTax = valueWithTax;
    }

}
