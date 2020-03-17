package com.challange.reply;

import java.util.ArrayList;

public class Office {
    private int x,y;
    private ArrayList<Desk> desks = new ArrayList<>();
    private ArrayList<ArrayList<Double>> deskMap = new ArrayList<>();
    private ArrayList<ArrayList<Double>> desksCoeficient = new ArrayList<>();

    public Office(int height, int width) {
        x = height;
        y = width;
    }

    public void Office(){}



    public void setDesksCoeficient(){
        desksCoeficient.addAll(deskMap);
        /*for(int i = 0;i<desks.size();i++){
            ArrayList<Double> row = new ArrayList<>();
            for(int j = 0; j<desks.size();j++){
                if(deskMap.get(i).get(j).equals(1))
                    row.add(desks.get(i).getDeskScore() * desks.get(j).getDeskScore());
                else row.add(0.0);
            }
            desksCoeficient.add(row);
        }*/

        for(int i = 0;i<desks.size();i++){
            double sum = 0;
            for(int j = 0;j<desks.size();j++){
                sum+=desksCoeficient.get(i).get(j);
            }
            desks.get(i).setDeskScore(sum/4);
        }
        for(int k = 0; k<2;k++){
            for(int i = 0;i<desksCoeficient.size();i++){
                ArrayList<Double> row = new ArrayList<>();
                for(int j = 0; j<desksCoeficient.size();j++){
                    double coef = desksCoeficient.get(i).get(j) * desks.get(i).getDeskScore() * desks.get(j).getDeskScore();
                    row.add(coef);
                    // desks.get(i).setDeskScore(coef);
                    // desks.get(j).setDeskScore(coef);
                }
                desksCoeficient.set(i,row);
            }
        }
    }

    public void deskMapGenerate(){
        for(int i = 0;i<desks.size();i++){
            ArrayList<Double> row = new ArrayList<>();
            for(int j = 0;j<desks.size();j++){
                if(i!=j && desks.get(i).nextTo(desks.get(j))){
                    row.add(1.0);
                    desks.get(i).setDeskScore(1.0);
                } else {
                    row.add(0.0);
                    desks.get(i).setDeskScore(0.0);
                }
            }
            deskMap.add(row);
        }
    }
    public void addDesk(Desk d){
        desks.add(d);
    }

    public void addAllDesks(ArrayList<ArrayList<String>> map) {
        for(int i = 0;i<map.size();i++)
            for(int j = 0;j<map.get(i).size();j++)
                if(map.get(i).get(j).equals("_"))
                    desks.add(new Desk(i,j,0));
                else if(map.get(i).get(j).equals("M"))
                    desks.add(new Desk(i,j,1));
        deskMapGenerate();
        setDesksCoeficient();
    }
    public void showDeskCoeficients(){
        for(var row : desksCoeficient) {
            for (var coef : row)
                System.out.print(coef + " | ");
            System.out.println("");
        }
    }
    public void showAllDesks() {
        for (var desk : desks) System.out.println(desk);

        ArrayList<ArrayList<String>> mapa = new ArrayList<>();
        for(int i = 0;i < x; i++){
            ArrayList<String> row = new ArrayList<>();
            for(int j = 0; j<y; j++){
                Desk d1 = new Desk(i,j,0);
                Desk d2 = new Desk(i,j,1);
                if(desks.contains(d1))row.add("0");
                else if(desks.contains(d2))row.add("1");
                else row.add("*");
            }
            mapa.add(row);
        }
        for(var i : mapa){
            for(var j : i){
                System.out.print(j);
            }
            System.out.println("");
        }

    }


}
