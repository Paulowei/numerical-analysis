package com.moderneinstein.logical.numerical ;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.Map;
import java.util.Vector;
import java.util.LinkedList;
import java.lang.Thread;
import java.util.Random;
import java.lang.NullPointerException;
import java.util.ArrayList;

import java.util.Set;
import java.util.TreeSet;
import java.lang.Object;
import java.lang.CloneNotSupportedException;
import java.lang.Cloneable;
import java.util.List;
import java.lang.Integer;
import java.sql.Date;
import java.util.TreeSet;
import java.util.HashMap ;


import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.Serializable;
//import java.   ;

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.PrintStream;
import java.io.OutputStream;
import java.io.FileOutputStream;

public  class Functional {
    public static Manipulate manipulate = new Manipulate();
    public static String variable = new String("s");

    public static List<Pair<Double, Integer>> differentiate(List<Pair<Double, Integer>> value) {
        LinkedList<Pair<Double, Integer>> function = new LinkedList<Pair<Double, Integer>>();
        int length = value.size();
        for (int n = 0; n < length; n++) {
            Pair<Double,Integer> oldPair = value.get(n);
            Pair<Double,Integer> newPair = new Pair<Double, Integer>();
            if (oldPair.second == 0) {
                continue;    }
            newPair.first = oldPair.first * oldPair.second;
            newPair.second = oldPair.second - 1;
            function.addLast(newPair)  ;    }
        return function  ;    }

    public static List<Pair<Double, Integer>> integrate(List<Pair<Double, Integer>> function) {
        LinkedList<Pair<Double, Integer>> integral = new LinkedList<Pair<Double, Integer>>();
        int length = function.size();
        for (int m = 0; m < length; m++) {
            Pair<Double,Integer> oldPair = function.get(m);
            Pair<Double,Integer> newPair = new Pair<Double, Integer>();
            if (oldPair.second == -1) {
                continue;   }
            newPair.second = oldPair.second + 1;
            newPair.first = oldPair.first / (oldPair.second + 1);
            integral.addLast(newPair);
        }
        return integral   ;    }
  /* Pair<Double, Integer> oldPair = new Pair<Double, Integer>();
        Pair<Double, Integer> newPair = new Pair<Double, Integer>();
   */  
   //         Pair<Double, Integer> tempPair = new Pair<Double, Integer>();  
   /*  TreeSet<Integer> setValue = new TreeSet<Integer>(digitMap.keySet());
        Vector<Integer> vector = new Vector<Integer>(setValue); */   //         TreeSet<Integer> setValue = new TreeSet<Integer>(digitMap.keySet());
    public static void flatten(Map<Integer, Double> digitMap, List<Pair<Double, Integer>> function) {
        function.clear() ; 
        int length = digitMap.size();
        Vector<Integer> vector = new Vector<Integer>(digitMap.keySet());
        for (int v = 0; v < length; v++) {
            Integer iterand = vector.elementAt(v);
            Double opposite = digitMap.getOrDefault(iterand, 0.0);
            Pair<Double,Integer> tempPair = new Pair<Double, Integer>(opposite, iterand);
            function.add(tempPair);
        }    }  
        /*        Integer iterand = 0;
        Double opposite = 0.0; */
   //   Pair<Double, Integer> newPair = new Pair<Double, Integer>();  
   //   // newPair = new Pair<Double,Integer>(paired.first,paired.second) ;  
   /*if (funct2 == null || funct2.size() == 0) { return funct1  ;   }
        if (funct1 == null || funct1.size() == 0) {  return funct2 ;    } */
    public static List<Pair<Double, Integer>> subtraction(List<Pair<Double, Integer>> funct1,List<Pair<Double, Integer>> funct2) {
        Map<Integer, Double> mappy = new HashMap<Integer, Double>();
        insertMap(mappy, funct1);
        Manipulate.sort(funct2);
        for (int v = 0; v < funct2.size(); v++) {
            Pair<Double, Integer> paired = funct2.get(v);
            if (!mappy.containsKey(paired.second)) {
                mappy.putIfAbsent(paired.second, (paired.first) * (-1.0));
            } else {
                Double other = mappy.get(paired.second);
                mappy.replace(paired.second, other - paired.first);   }   }
        List<Pair<Double, Integer>> listed = new ArrayList<Pair<Double, Integer>>();
        flatten(mappy, listed);
        return listed;
    }

    /*
     * newPair.first = newPair.first-other ;
     * listed.add(newPair) ;
     * sort(listed) ;
     */  
     /*   double value1 = pairVal.first;
            int value2 = pairVal.second; */
    public static void insertMap(Map<Integer, Double> mapper, List<Pair<Double, Integer>> function) {
        mapper.clear();
        int length = function.size();
        for (int v = 0; v < length; v++) {
            Pair<Double,Integer> pairVal = function.get(v) ; 
            if (mapper.containsKey(pairVal.second)) {
                double other = mapper.getOrDefault(pairVal.second, 0.0);
                mapper.replace(pairVal.second, other + pairVal.first);
            } else {
                mapper.putIfAbsent(pairVal.second,pairVal.first);
            }
        }
    }
    /*// TreeMap<Integer,Double> mapper = new TreeMap<Integer,Double>();
        Pair<Double, Integer> pairVal = new Pair<Double, Integer>(); */  
        //          if (pairVal == null) { continue;  }  //       // insertMap(mappy, funct1 ) ;
    public static List<Pair<Double, Integer>> summation(List<Pair<Double, Integer>> funct1,
            List<Pair<Double, Integer>> funct2) {
        Map<Integer, Double> mappy = new TreeMap<Integer, Double>();
        insertMap(mappy, funct2);
        Manipulate.sort(funct1);
        for (int a = 0; a < funct1.size(); a++) {
            Pair<Double, Integer> serial = funct1.get(a);
            if (mappy.containsKey(serial.second)) {
                Double other = mappy.get(serial.second);
                mappy.replace(serial.second, serial.first + other);
            } else {
                mappy.putIfAbsent(serial.second,serial.first);
            }
        }  
        List<Pair<Double,Integer>> function =  new ArrayList<Pair<Double,Integer>>( ) ; 
        flatten(mappy,  function);
        return function;
    }   
    //  List<Pair<Double, Integer>> function = new LinkedList<Pair<Double, Integer>>();
    //     Pair<Double, Integer> parity = new Pair<Double, Integer>();  
    // Pair<Double, Integer> interim = new Pair<Double, Integer>(0.0, 0);  
    public static List<Pair<Double, Integer>> multiply(List<Pair<Double, Integer>> funct1,
        List<Pair<Double, Integer>> funct2) {
        Vector<Pair<Double, Integer>> product = new Vector<Pair<Double, Integer>>();
        for (int c = 0; c < funct2.size(); c++) {
            Pair<Double, Integer> paired1 = funct2.get(c);
            for (int v = 0; v < funct1.size(); v++) {
                Pair<Double, Integer> paired2 = funct1.get(v);
                Pair<Double,Integer> interim = new Pair<Double, Integer>(paired1.first * paired2.first, paired2.second + paired1.second)  ;
                product.addElement(interim);
            }   }
        TreeMap<Integer, Double> treeMap = new TreeMap<Integer, Double>();
        insertMap(treeMap, product);
        flatten(treeMap, product);
        return product;
    }   
    /* if (funct1 == null || funct2 == null) {
            return product;  } */
    public static List<String>  segment(String mains,char delims){
        List<String> serial = new ArrayList<String>( ) ; 
        int upper =   0   ; // mains.length ()-1 ; 
        int lower = 0 ;  
        while(mains.charAt(upper)==delims){upper++  ; lower ++ ;  }
        while(upper<mains.length()){
            while( upper<mains.length( )&&mains.charAt(upper)!=delims){upper++ ;  } 
            String pounds = mains.substring( lower,upper ) ; 
            serial.add(pounds ) ; 
            while(upper<mains.length()&&mains.charAt(upper)==delims){upper++ ; } 
            lower = upper ;  
        }
        return serial  ; 
    }
}   


  /**
     *      if (funct1.size() == 0) {
            return funct2;   }
        if (funct2.size() == 0) {
            return funct1 ;    }
                interim.second = paired2.second + paired1.second;
                interim.first = paired1.first * paired2.first;
     */