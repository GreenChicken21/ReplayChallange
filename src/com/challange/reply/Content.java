package com.challange.reply;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Content {
    private int width,height;
    private int devNumber,pmNumber;
    private ArrayList<Developer> devs = new ArrayList<>();
    private ArrayList<ProjectManager> managers = new ArrayList<>();
    private ArrayList<ArrayList<String>> map = new ArrayList<>();
    private Office office;
    public Content(String file) {
        width = 0;
        height = 0;
        devNumber = 0;
        pmNumber = 0;
        try {
            File myObj = new File(file);
            Scanner myReader = new Scanner(myObj);
            int lineNumber = 0;
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                // map dimensions
                if(lineNumber == 0){
                    String[] data = line.split(" ");
                    this.width = Integer.parseInt(data[0]);
                    this.height = Integer.parseInt(data[1]);
                }
                // map
                else if(lineNumber <= height){
                    String[] data = line.split("");
                    ArrayList<String> row = new ArrayList<>();
                    for(int i = 0;i<data.length;i++)
                        row.add(data[i]);
                    map.add(row);
                }
                // dev number
                else if(lineNumber == height+1){
                    devNumber = Integer.parseInt(line);
                }
                // devs
                else if(lineNumber>=height+2 && lineNumber<height+2+devNumber){
                    String[] data = line.split(" ");
                    String company = data[0];
                    int bonus  = Integer.parseInt(data[1]);
                    Developer dev = new Developer(company,bonus);
                    for(int i = 0;i<Integer.parseInt(data[2]);i++)
                        dev.addSkill(data[3+i]);
                    devs.add(dev);
                }
                // manager number
                else if(lineNumber == height+2+devNumber){
                    pmNumber = Integer.parseInt(line);
                }
                // managers
                else if(lineNumber > height+2+devNumber ){
                    String[] data = line.split(" ");
                    String company = data[0];
                    int bonus  = Integer.parseInt(data[1]);
                    ProjectManager pm = new ProjectManager(company,bonus);
                    managers.add(pm);
                }
                lineNumber++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        office = new Office(height,width);
        office.addAllDesks(map);
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getDevNumber() {
        return devNumber;
    }

    public void setDevNumber(int devNumber) {
        this.devNumber = devNumber;
    }

    public int getPmNumber() {
        return pmNumber;
    }

    public void setPmNumber(int pmNumber) {
        this.pmNumber = pmNumber;
    }

    public ArrayList<Developer> getDevs() {
        return devs;
    }

    public void setDevs(ArrayList<Developer> devs) {
        this.devs = devs;
    }

    public ArrayList<ProjectManager> getManagers() {
        return managers;
    }

    public void setManagers(ArrayList<ProjectManager> managers) {
        this.managers = managers;
    }

    public ArrayList<ArrayList<String>> getMap() {
        return map;
    }

    public void setMap(ArrayList<ArrayList<String>> map) {
        this.map = map;
    }
    public void showMap(){
        for(var x : map){
            for(var y : x)
                System.out.print(y);
            System.out.println("");
        }
    }

    public void showAllDevs(){
        for(var x : devs) System.out.println(x);
    }

    public void showAllManagers() {
        for(var x : managers) System.out.println(x);
    }
}
