package main.java;

/**
 * This class represents a commission plan using a single dimensional array
 * The array represents commission for each level in the hierarchy with the starting of the array(0th index)
 * representing selling agent's commission and rest of the array representing commissions of super agents
 * according to the plan
 */
public class CommissionPlan {

    int[] commissions;

    public CommissionPlan(int[] commissions) {
        this.commissions = commissions;
    }

    /**
     * Calculates commissions given a face amount and hierarchy
     */
    public Payment calculateCommission(int faceValue, AgentHierarchy hierarchy) {
        if(commissions.length == 0) {
            throw new IllegalArgumentException("Agent commissions not defined for the plan");
        }
        Payment p = new Payment();
        double total = 0f;
        int level;
        // iterate through the commission plan hierarchy and calculate commission for each agent
        for(level = 0; level < commissions.length; level++) {
            double commission = commissions[level];
            Agent agent = hierarchy.getAgentAt(level);
            double agentCommission = getAgentCommission(faceValue, commission, agent);
            p.putAgentPayment(agent.getName(), agentCommission);
            total += agentCommission;
        }
        p.setTotal(total);
        // default to zero payments for rest of the heirarchy
        while(level < hierarchy.height()) {
            p.putAgentPayment(hierarchy.getAgentAt(level).getName(), 0d);
            level++;
        }
        return p;
    }

    /**
     * Calculates agent commission by applying plan commission and agent's individual commission
     */
    private double getAgentCommission(Integer faceValue, double commission, Agent agent) {
        return (commission * agent.getCommission() * faceValue)/10000;
    }
}
