package com.education.ztu;

public class Task3 {
    public static void main(String[] args) {
        if(args.length == 0){
            System.out.println("No arguments given");
            return;
        }
        for(int i = 0; i < args.length; i++){
            System.out.println(args[i]);
            if(i<args.length-1){
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}
