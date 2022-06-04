package DesignPatterns.ChainOfResponsibility;

public class SeniorManager extends Managers{

    public SeniorManager(int approvalLimit, String name) {
        super(approvalLimit, name);
    }

    @Override
    public void processSalary(int salaryAmount) {
        System.out.println(this.managerName+ " has approved the salary at level 2 for amount ::: "+salaryAmount);
    }
}
