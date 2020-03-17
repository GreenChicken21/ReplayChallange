package com.challange.reply;

public class ProjectManager {
    private String company;
    private int bonus;

    public ProjectManager(String company, int bonus) {
        this.company = company;
        this.bonus = bonus;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int BP(Developer d){
        if(company.equals(d.getCompany()))
            return bonus*d.getBonus();
        return 0;
    }
    public int BP(ProjectManager pm){
        if(company.equals(pm.getCompany()))
            return bonus*pm.getBonus();
        return 0;
    }
    @Override
    public String toString() {
        return "Company: "+ company + ". Bonus: " +bonus+".";
    }
}
