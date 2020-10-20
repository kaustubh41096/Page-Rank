/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pagerank;

import java.util.Scanner;

/**
 *
 * @author kaustubhrajpathak
 */
public class PageRank {

    public static int path[][] = new int[10][10];
    public static double pagerank[] = new double[10];
    
    public static void calc(int nodes){
        double init = 0.2;
        int steps=0;
       // double c=0;
        //print adjacency
        System.out.print("Adjacency Matrix :-\n");
        for(int i=1;i<=nodes;i++){
            for(int j=1;j<=nodes;j++){
                System.out.print(path[i][j]);
            }
            System.out.print("\n");
        }
        System.out.print("No of webpages : " + nodes + " Starting value : " + init + "\n");
        //initialize pagerank for each webpage
        for(int i=1;i<=nodes;i++){
            pagerank[i] = init;
        }
        
        //ranking algo
        while(steps<=2){
            double temp[] = new double[10];
            System.out.print("Step "+steps+" for each webpage is :- \n");
            for(int i=1;i<=nodes;i++){
                System.out.println("Page Rank of webpage "+i+" is "+pagerank[i]);
            }
            
            //initiate temp with earlier ranks
            for(int i=1;i<=nodes;i++){
                temp[i]=pagerank[i];
            }
            for(int i=1;i<=nodes;i++){
                double value = 0;
                //check incoming connections
                for(int j=1;j<=nodes;j++){
                    if(path[j][i]==1){
                        double c=0;
                        //calculate outgoing nodes from node
                        for(int k=1;k<=nodes;k++){
                            if(path[j][k]==1){
                                c=c+1;
                            }
                        }
                       // System.out.print("No of edges from node "+j+" are : "+c+"\n");
                       System.out.print(value+"+"+temp[j]+"*"+(1/c)+", ");
                        value = value+temp[j]*(1/c);
                    }
                }
                System.out.print("\n");
                pagerank[i] = value;
            }
            steps++;
        }
        
        //find most successfull webpage
        int max = 1;
        double temp = pagerank[1];
        for(int i=2;i<nodes;i++){
            if(temp<pagerank[i]){
                temp = pagerank[i];
                max = i;
            }
        }
        System.out.print("The most successfull webpage is "+max+"\n");
       
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner c = new Scanner(System.in);
        System.out.print("Enter no.of webpages :-\n");
        int nodes = c.nextInt();
        if(nodes<10)
        {
            /*System.out.print("Enter adjacency matrix :-\n");
            System.out.println("Enter 1 for connected pages and 0 for non connected pages!");
            for(int i=1;i<=nodes;i++){
                for(int j=1;j<=nodes;j++){
                    if(i==j)
                    {
                        path[i][j]=0;
                        System.out.print("path["+i+"]["+j+"] = 0\n");
                    }
                    else
                    {
                        System.out.print("path["+i+"]["+j+"] = ");
                        path[i][j]=c.nextInt();
                        System.out.print("\n");
                    }
                }
                System.out.print("\n");
            }*/
            path[1][1] = 0; path[1][2] = 1;path[1][3] = 1;path[1][4] = 0;path[1][5] = 0;
            path[2][1] = 0; path[2][2] = 0;path[2][3] = 0;path[2][4] = 1;path[2][5] = 1;
            path[3][1] = 0; path[3][2] = 0;path[3][3] = 0;path[3][4] = 0;path[3][5] = 0;
            path[4][1] = 1; path[4][2] = 0;path[4][3] = 0;path[4][4] = 0;path[4][5] = 1;
            path[5][1] = 1; path[5][2] = 0;path[5][3] = 0;path[5][4] = 0;path[5][5] = 0;
            calc(nodes);
        }
        else
            System.out.print("Enter less than 10 webpages!");
        // TODO code application logic here
    }
    
}
