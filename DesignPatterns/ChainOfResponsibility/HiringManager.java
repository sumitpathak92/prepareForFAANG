package DesignPatterns.ChainOfResponsibility;

public class HiringManager extends Managers{

    public HiringManager(int approvalLimit, String name) {
        super(approvalLimit, name);
    }

    @Override
    public void processSalary(int salaryAmount) {
        System.out.println(this.managerName+ " has approved the salary at level 1 for amount ::: "+salaryAmount);
    }
}
