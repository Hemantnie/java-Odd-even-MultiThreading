package com.company;

public class Printer extends Thread{

    int start;
    int end;

    public Printer(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        print();
    }

    public void print(){
        for(int i=start;i<end;i++) System.out.println(Thread.currentThread().getName() + " prints : " + i);
    }
}
