package com.company;

public class OddEvanPrinter {

    boolean isOddTurn;
    int[]buffer;
    int size;
    int index = 0;

    public OddEvanPrinter(int size) {
        this.size = size;
        buffer = new int[size];
        isOddTurn = false;
    }

    public synchronized void fillBuffer(int val){
        while((isOddTurn && val % 2 == 0) || (!isOddTurn && val % 2 == 1)){
            try {
                System.out.println(Thread.currentThread().getName() + " going to sleep with val : " + val );
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " inputs : " + val );
        buffer[index++] = val;
        isOddTurn = !isOddTurn;
        notifyAll();
    }

    public void printBuffer(){
        System.out.println(Thread.currentThread().getName() + " called printBuffer");
        for(int i=0;i<size;i++){
            System.out.println("Buffer[" + i + "]=" + buffer[i]);
        }
    }
}
