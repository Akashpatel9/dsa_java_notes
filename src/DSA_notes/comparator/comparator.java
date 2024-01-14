package DSA_notes.comparator;
import java.util.*;

class Student implements Comparable<Student>{
    int age;
    String name;
    Student(int age , String name){
        this.age = age;
        this.name = name;
    }

    public int compareTo(Student o){
        return this.age - o.age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

class compareByAge implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {
        return o1.age-o2.age;
    }
}

class compareByName implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {
        return o1.name.compareTo(o2.name);
    }
}

public class comparator<I extends Number> {
    public static void main(String[] args){
        Student[] s = {new Student(46,"akahsd"),new Student(54,"iudhwa"),new Student(40,"uhfuieb")};
//        Arrays.sort(s);
//        Arrays.sort(s,new compareByAge());
        Arrays.sort(s,new compareByName());
        System.out.println(Arrays.toString(s));
    }
}