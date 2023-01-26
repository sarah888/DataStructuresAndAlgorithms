package LE3Q1;

public class MyStudent {
    private String firstName;
    private Double score;

    //define constructor
    public MyStudent(){
        firstName = "Sarah";
        score = 100.00;
    }

    public MyStudent(String name, Double mark){
        firstName = name;
        score = mark;
    }

    //define methods
    @Override
    public String toString() {
        return firstName + ':' + String.format("%.2f",score);
    }
}
