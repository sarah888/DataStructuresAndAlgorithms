package LE3Q2;

public class Student implements Comparable<Student>{
    //define fields
    private Double score;
    private String firstName;
    private String lastName;

    //define constructor
    public Student(String first, String last,Double mark){
        firstName = first;
        lastName = last;
        score = mark;
    }

    public Student(){
        firstName = "Sarah";
        lastName = "Huang";
        score = 100.00;
    }

    //define method
    public Double getScore() {
        return score;
    }
    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public String toString() {
            return firstName + ' ' + lastName +':' + String.format("%.2f",score);
    }

    //override from Comparable<T>
    @Override
    public int compareTo(Student sm){
        int rv = 0;
        if (this.score>sm.score){
            rv = 1;
        }else if(this.score<sm.score){
            rv = -1;
        }else{
            rv = 0;
        }
        return rv;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
