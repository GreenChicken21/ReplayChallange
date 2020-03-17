package com.challange.reply;

import java.util.ArrayList;

public class Developer {
    private String company;
    private int bonus;
    private ArrayList<String> skills = new ArrayList<>();

    public Developer(String company, int bonus, ArrayList<String> skills) {
        this.company = company;
        this.bonus = bonus;
        this.skills = skills;
    }

    public Developer(String company, int bonus) {
        this.company = company;
        this.bonus = bonus;
    }

    public void addSkill(String skill){
        skills.add(skill);
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

    public ArrayList<String> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<String> skills) {
        this.skills = skills;
    }
    public int WP(Developer d){
        int same = 0, diff = 0;
        for(int i = 0;i<skills.size();i++){
            if(d.getSkills().contains(skills.get(i)))same++;
            else diff++;
        }
        diff = diff + d.skills.size() - same;
        return same*diff;
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
        return "Company: "+ company + ". Bonus: " +bonus+". Skills: "+ skills;
    }

}
