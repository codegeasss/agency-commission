package main.java;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Represents payments for agents for a given plan
 * Although this class uses <code>Double</code> to store payment values, this is not safe in practice
 * Currencies should be represented using <code>Long</code> in their lowest denomination
 * It's not a big issue here since we are not doing any arithmetic computations on Double values
 * The only reason payment is represented as Double is so that we don't lose precision after percentage calculation
 */
public class Payment {

    private Map<String, Double> agentPayments = new LinkedHashMap<>();
    private double total;

    public void putAgentPayment(String name, double payment) {
        agentPayments.put(name, payment);
    }

    public void setAgentPayments(Map<String, Double> agentPayments) {
        this.agentPayments = agentPayments;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "agentPayments=" + agentPayments +
                ", total=" + total +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Payment payment = (Payment) o;

        if (Double.compare(payment.total, total) != 0) return false;
        return agentPayments.equals(payment.agentPayments);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = agentPayments.hashCode();
        temp = Double.doubleToLongBits(total);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
