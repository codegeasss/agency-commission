package main.java;

/**
 * Represents an agent with their name and commission
 */
public class Agent {

    private String name;
    private double commission;

    public Agent(String name, double commission) {
        this.name = name;
        this.commission = commission;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }
}
