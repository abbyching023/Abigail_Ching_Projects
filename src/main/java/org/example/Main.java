package org.example;

import java.util.ArrayList;
import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

         int[] arr = {8, 1, 8};


        int total =  0;
        int deskCount = arr[0];
        int nextSeat = 0; int nextSeat2 = 0;
        ArrayList<Integer> occupied = new ArrayList<>();
        for (int i : arr){
            occupied.add(i);
        }
        occupied.remove(0); //only contains occupied seats

        for (int k=0; k < deskCount; k++){
            if (k % 2 == 0){
                nextSeat = k + 2;
            } else {
                nextSeat = k + 1;
                nextSeat2 = k + 2;
            }
            Arrays.asList(occupied);
            if (!(occupied.contains(nextSeat) || occupied.contains(nextSeat2))) {
                total++;
            }
        }

        System.out.println(total);
    }
}