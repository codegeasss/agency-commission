package main.java;

import java.util.LinkedHashMap;
import java.util.Map;


public class CommissionTest {

    AgentHierarchy h1;
    AgentHierarchy h2;

    CommissionPlan planA;
    CommissionPlan planB;

    private void setUp()  {
        System.out.println("Initializing tests");
        Agent bob = new Agent("Bob", 2);
        Agent a = new Agent("A", 3.25f);
        Agent c = new Agent("C", 2.25f);
        Agent d = new Agent("D", 2.75f);
        Agent x = new Agent("X", 2.5f);
        Agent z = new Agent("Z", 1.75f);
        h1 = new AgentHierarchy(
                new Agent[]{bob, x, a, c});
        h2 = new AgentHierarchy(
                new Agent[]{bob, a, x, d, z});

        planA = new CommissionPlan(
                new int[]{50, 5, 0}
        );

        planB = new CommissionPlan(
                new int[]{70, 8, 4, 0}
        );
    }

    public void runTests() {
        setUp();
        testCommissionPlanAWithH1();
        testCommissionPlanBWithH2();
        testCommissionPlanAWithH2();
        testCommissionPlanBWithH1();
    }

    public void testCommissionPlanAWithH1() {
        System.out.println("Testing Agent Hierarchy:H1; Commission Plan:A");
        Payment p = planA.calculateCommission(100000, h1);
        try {
            assertEquals(p, expectedPaymentAWithH1());
            System.out.println("Passed - " + p);
        } catch (Exception e) {
            System.err.println("testCommissionPlanAWithH1 failed");
        }

    }

    public void testCommissionPlanBWithH2() {
        System.out.println("Testing Agent Hierarchy:H2; Commission Plan:B");
        Payment p = planB.calculateCommission(100000, h2);
        try {
            assertEquals(p, expectedPaymentBWithH2());
            System.out.println("Passed - " + p);
        } catch (Exception e) {
            System.err.println("testCommissionPlanBWithH2 failed");
        }

    }

    public void testCommissionPlanAWithH2() {
        System.out.println("Testing Agent Hierarchy:H2; Commission Plan:A");
        Payment p = planA.calculateCommission(100000, h2);
        try {
            assertEquals(p, expectedPaymentAWithH2());
            System.out.println("Passed - " + p);
        } catch (Exception e) {
            System.err.println("testCommissionPlanAWithH2 failed");
        }

    }

    public void testCommissionPlanBWithH1() {
        System.out.println("Testing Agent Hierarchy:H1; Commission Plan:B");
        Payment p = planB.calculateCommission(100000, h1);
        try {
            assertEquals(p, expectedPaymentBWithH1());
            System.out.println("Passed - " + p);
        } catch (Exception e) {
            System.err.println("testCommissionPlanBWithH1 failed");
        }
    }

    private Payment expectedPaymentAWithH1() {
        Payment expectedPaymentAWithH1 = new Payment();
        Map<String, Double> agentPayments = new LinkedHashMap<>();
        agentPayments.put("Bob", 1000d);
        agentPayments.put("X", 125d);
        agentPayments.put("A", 0d);
        agentPayments.put("C", 0d);
        expectedPaymentAWithH1.setAgentPayments(agentPayments);
        expectedPaymentAWithH1.setTotal(1125);
        return expectedPaymentAWithH1;
    }

    private Payment expectedPaymentBWithH2() {
        Payment expectedPaymentAWithH1 = new Payment();
        Map<String, Double> agentPayments = new LinkedHashMap<>();
        agentPayments.put("Bob", 1400d);
        agentPayments.put("A", 260d);
        agentPayments.put("X", 100d);
        agentPayments.put("D", 0d);
        agentPayments.put("Z", 0d);
        expectedPaymentAWithH1.setAgentPayments(agentPayments);
        expectedPaymentAWithH1.setTotal(1760);
        return expectedPaymentAWithH1;
    }

    private Payment expectedPaymentAWithH2() {
        Payment expectedPaymentAWithH1 = new Payment();
        Map<String, Double> agentPayments = new LinkedHashMap<>();
        agentPayments.put("Bob", 1000d);
        agentPayments.put("A", 162.5);
        agentPayments.put("X", 0d);
        agentPayments.put("D", 0d);
        agentPayments.put("Z", 0d);
        expectedPaymentAWithH1.setAgentPayments(agentPayments);
        expectedPaymentAWithH1.setTotal(1162.5);
        return expectedPaymentAWithH1;
    }

    private Payment expectedPaymentBWithH1() {
        Payment expectedPaymentAWithH1 = new Payment();
        Map<String, Double> agentPayments = new LinkedHashMap<>();
        agentPayments.put("Bob", 1400d);
        agentPayments.put("X", 200d);
        agentPayments.put("A", 130d);
        agentPayments.put("C", 0d);
        expectedPaymentAWithH1.setAgentPayments(agentPayments);
        expectedPaymentAWithH1.setTotal(1730);
        return expectedPaymentAWithH1;
    }

    private void assertEquals(Payment actual, Payment expected) throws Exception {
        if(!actual.equals(expected)) {
            System.err.println("Actual: " + actual);
            System.err.println("Expected: " + expected);
            throw new RuntimeException("Test failed");
        }
    }

}
