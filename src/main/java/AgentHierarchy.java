package main.java;

/**
 * Represents hierarchy of agents
 * Hierarchy is represented as a single dimensional array
 * with the array index corresponding to the level of hierarchy
 * The array starts with(0th index) selling agent and super agents fills the rest of the array in the hierarchical order
 */
public class AgentHierarchy {
    private Agent[] agents;

    public AgentHierarchy(Agent[] agents) {
        this.agents = agents;
    }

    public Agent getAgentAt(int level) {
        if(level < 0 || level >= agents.length) {
            throw new IllegalArgumentException("Invalid hierarchy level");
        }
        return agents[level];
    }

    public int height() {
        return agents.length;
    }
}
