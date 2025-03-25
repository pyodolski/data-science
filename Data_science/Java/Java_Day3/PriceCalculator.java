package ch03;

public class PriceCalculator {
    public static void main(String[] args) {
        final int VAT = 10;

        int cost = 1000;
        int totalCost = cost + (VAT*cost)/100;

        System.out.println(totalCost);
    }
}
