package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {
	// write your code here
        OddEvanPrinter printer = new OddEvanPrinter(10);
        Thread oddPrintThread = new Thread(()->{
            for(int i=0;i<10;i+=2)printer.fillBuffer(i);
        });
        Thread evenPrintThread = new Thread(()->{
            for(int i=1;i<10;i+=2)printer.fillBuffer(i);
        });

        oddPrintThread.start();
        evenPrintThread.start();

        oddPrintThread.join();
        evenPrintThread.join();

        printer.printBuffer();

    }
}
