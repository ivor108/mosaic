package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    private static int[][] mosaic;

    static void print2d(int[][] arr)
    {
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }


    static void part(int i, int j)
    {
        mosaic[i][j] = 2;
        if (mosaic[i - 1][j] == 1){
            part(i - 1, j);
        }
        else if(mosaic[i][j + 1] == 1){
            part(i, j + 1);
        }
        else if(mosaic[i + 1][j] == 1){
            part(i + 1, j);
        }
        else if(mosaic[i][j - 1] == 1){
            part(i, j - 1);
        }
    }


    static int solve(){
        int count = 0;

        for(int i = 1; i < mosaic.length - 1; i++) {
            for (int j = 1; j < mosaic[0].length - 1; j++) {

                if(mosaic[i][j] == 1){
                    count ++;
                    part(i, j);
                }

            }
        }


        return count;
    }

    public static void main(String[] args) throws IOException {

        int K;
        int L;
        //int[][] mosaic = new int[0][0];
        try {
            FileReader fr  = new FileReader("INPUT.TXT");
            BufferedReader reader = new BufferedReader(fr);
            String first =  reader.readLine();

            K = Integer.parseInt(first.split(" ")[0]);
            L = Integer.parseInt(first.split(" ")[1]);
            mosaic = new int[K + 2][L + 2];
            for(int i = 0; i < K + 2; i++)
            {
                String[] line = new String[L + 2];
                if(i == 0 || i == K + 1)
                {
                    for(int j = 0; j < L + 2; j++)
                        line[j] = "0";
                }
                else
                {
                    line = ("0" + reader.readLine() + "0").split("");
                }
                for(int j = 0; j < line.length; j++)
                    mosaic[i][j] = Integer.parseInt(line[j]);
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        print2d(mosaic);
        System.out.println("------------");
        System.out.println(solve());
        System.out.println("------------");
        print2d(mosaic);
    }
}
