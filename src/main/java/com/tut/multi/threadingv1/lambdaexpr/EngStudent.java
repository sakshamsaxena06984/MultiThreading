package com.tut.multi.threadingv1.lambdaexpr;

public class EngStudent implements Student{
    @Override
    public String getBio(String name) {
        return name + " eng student!";
    }
}
