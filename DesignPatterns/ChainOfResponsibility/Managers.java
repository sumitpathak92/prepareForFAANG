package DesignPatterns.ChainOfResponsibility;

public abstract class Managers {
    private Managers manager;
    private int approvalLimit;
    protected String managerName;

    public Managers(int approvalLimit, String name) {
        this.approvalLimit = approvalLimit;
        this.managerName = name;
    }

    public void setManager(Managers manager) {
        this.manager = manager;
    }

    public void approveSalary(int salaryAmount) {
        if(this.approvalLimit>salaryAmount)
            processSalary(salaryAmount);
        else if(this.manager!=null) {
            this.manager.approveSalary(salaryAmount);
        } else System.out.println("Cannot make offer!");
    }

    public abstract void processSalary(int salaryAmount);
}
