package com.Project.Modules;

import java.util.Scanner;

public class InputValidator {

    public static int getInt(Scanner sc, String message) {

        while(true) {

            try {

                System.out.print(message);

                int value = sc.nextInt();

                return value;

            }
            catch(Exception e) {

                System.out.println("Invalid input. Enter numbers only.");

                sc.nextLine();
            }
        }
    }



    public static double getDouble(Scanner sc, String message) {


        while(true) {

            try {

                System.out.print(message);

                double value = sc.nextDouble();

                if(value < 0) {
                    System.out.println("Salary cannot be negative");
                    continue;
                }

                return value;

            }
            catch(Exception e) {

                System.out.println("Enter valid salary");

                sc.nextLine();
            }

        }

    }
    
    public static String getString(Scanner sc, String message)
    {
    	  while(true){
    		  
    		  try {

              System.out.print(message);

             String name = sc.nextLine();


              if(name.trim().isEmpty()){

                  System.out.println("cannot be empty");

              }
              else if(!name.matches("[a-zA-Z ]+")) {

                  System.out.println("should contain only alphabets");

              }
              else
              {
              return name;
              }
    		  }
    		  catch(Exception e){
    			  System.out.println("Enter Correctly");
    		  }
       }

    }


}

