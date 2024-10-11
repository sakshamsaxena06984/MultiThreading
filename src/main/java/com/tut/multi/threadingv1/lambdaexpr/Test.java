package com.tut.multi.threadingv1.lambdaexpr;

public class Test {
    public static void main(String[] args) {
//        EngStudent engStudent=new EngStudent();
//        System.out.println(engStudent.getBio("Rohan"));

        Student engStudent=new Student() {
            @Override
            public String getBio(String name) {
                return name +" is engineering student";
            }
        };

        System.out.println(engStudent.getBio("Rkk"));


        // via using lambda expression
        Student lawStu=(String name) -> {return name + " is law student";};
        Student docStu=(name) -> {return name + " is law student";};

        Student madStu = name -> name+" is the madical student";

        Student1 pharStu = name -> System.out.println(name +" is the pharmacist student");

        System.out.println(lawStu.getBio("Rocky"));
        System.out.println(docStu.getBio("Mohan"));
        pharStu.getBio1("Ronak");
        System.out.println(madStu.getBio("Jocky"));
    }

}
