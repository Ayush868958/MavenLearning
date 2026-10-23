package com.ayush;

import org.apache.commons.lang3.StringUtils;

public class Main {
    public static void main(String[] args) {
        String name = "ayush";

        System.out.println(StringUtils.capitalize(name));
      calculator cal=new calculator();
      int result=cal.divide(10,2);
      if(result==5)
         System.out.println("Test case is passed");
    else
        System.out.println("Test case is failed");
    }
}