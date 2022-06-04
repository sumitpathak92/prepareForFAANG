package DesignPatterns.ChainOfResponsibility;

public class Director extends Managers {

    public Director(int approvalLimit, String name) {
        super(approvalLimit, name);
    }

    @Override
    public void processSalary(int salaryAmount) {
        System.out.println(this.managerName+ " has approved the salary at level 3 for amount ::: "+salaryAmount);
    }
}
