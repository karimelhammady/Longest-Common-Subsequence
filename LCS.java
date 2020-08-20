/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bioinformatics_project1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Karim
 */
public class LCS {

    public static String x;
    public static String y;
    int[][] table;
    char[][] arrows;
    Scanner sc;
    String result="";
    public static String[][] mat;
    public static int [][] isCritical;

    public LCS() {
        sc = new Scanner(System.in);
        System.out.println("Please enter 2 sequences: ");
        x = sc.nextLine();
        y = sc.nextLine();
        table = new int[x.length() + 1][y.length() + 1];
        arrows = new char[x.length() + 1][y.length() + 1];
        mat=new String[x.length()+2][y.length()+2];
        isCritical=new int[x.length()+2][y.length()+2];
    }

    public void getLCS() {
        for (int i = 0; i < x.length()+2; i++) {
            for (int j = 0; j < y.length()+2; j++) {
                mat[i][j]="  0";
            }
        }
        mat[0][0]="   ";
        mat[0][1]="   ";
        mat[1][0]="   ";
        for (int i = 2; i < x.length()+2; i++) {
            mat[i][0]="  "+x.charAt(i-2);
        }
        for (int j = 2; j < y.length()+2; j++) {
            mat[0][j]="  "+y.charAt(j-2);
        }
        
        for (int i = 1; i <= x.length(); i++) {
            for (int j = 1; j <= y.length(); j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    table[i][j] = table[i - 1][j - 1] + 1;
                    arrows[i][j] = '\\';
                    mat[i+1][j+1]=" "+arrows[i][j]+""+table[i][j]+"";
                } else if (table[i - 1][j] >= table[i][j - 1]) {
                    table[i][j] = table[i - 1][j];
                    arrows[i][j] = '^';
                    mat[i+1][j+1]=" "+arrows[i][j]+""+table[i][j]+"";
                } else {
                    table[i][j] = table[i][j - 1];
                    arrows[i][j] = '<';
                    mat[i+1][j+1]=" "+arrows[i][j]+""+table[i][j]+"";
                }
            }
        }
        traceBack();
    }

    public void traceBack() {
        int i = x.length();
        int j = y.length();
        while(i!=0 && j!=0){
            switch(arrows[i][j]){
                case '\\':
                    result = x.charAt(i-1)+"" + result;
                    isCritical[i+1][j+1]=1;
                    i--;
                    j--;
                    break;
                case '^':
                    isCritical[i+1][j+1]=1;
                    i--;
                    break;
                case '<':
                    isCritical[i+1][j+1]=1;
                    j--;
                    break;
            }
        }
        System.out.println(result);
    }
    
    public void printMat(){
        for (int i = 0; i < x.length()+2; i++) {
            for (int j = 0; j < y.length()+2; j++) {
                System.out.print(mat[i][j]+"        ");
            }
            System.out.println("");
            System.out.println("");
        }
    }

}
