package com.moderneinstein.logical.numerical;

import  java.util.List ;
import java.util.Arrays ;
import java.util.Vector  ;
import java.util.Map ;
import java.util.ArrayList ;
import java.util.HashMap ;
import java.util.TreeMap ;
import java.util.Set ; 

public class EquationSystem {
    public static String[] DELIMS = new String[]{";",":"," "} ;
    public static double starters[] = new double[]{ 0.0,1.0,2.0 ,3.0,4.0} ;   
    public static int  TRIES =  20 ;    
    // public static List<Map<Integer,Double>>  parse(String input){  
   // List<Map<Integer,Double>> portions = new ArrayList<Map<Integer,Double>>() ;     
    public static Map<Integer,Map<Integer,Double>>  parse(String input){
        Map<Integer,Map<Integer,Double>> portions = new HashMap<Integer,Map<Integer,Double>>() ;     
        List<String> options =  Functional.segment(input,DELIMS[0].charAt( 0)) ;
        int range = input.length( ) ;
        for(int rc=0;rc<options.size();rc++){
            Map<Integer,Double> trials = convert(options.get(rc)) ; 
            portions.put(rc+1,trials) ; 
        }
        return portions ; 
    }

    public static Map<Integer,Double> convert(String parts){
            Map<Integer,Double>  mapper = new TreeMap<Integer,Double>( ) ;
            int length = parts.length( ) ;
            List<String>  vertical =  Functional.segment(parts,DELIMS[2].charAt(0)) ;  
            for(int ce=0;ce<vertical.size( );ce++){
                String  internal = vertical.get(ce)  ;
                List<String> content =  Functional.segment(internal,DELIMS[1].charAt(0)) ; 
                mapper.put( Integer.parseInt(content.get(0)),Double.parseDouble(content.get(1))) ;
             }
            return  mapper ;
    }
     // List<List<Pair<Integer,Double>>>  // List<Map<Integer,Double>> workers
     // List<Map<Double,Integer>>  frames = deriveEquation(workers) ;   
    // int value = reach =  digits.get(de) ; 
     public static void serialise(double converge ,Map<Integer,Map<Integer,Double>> carrier,Map<Integer,Double> braces,List<String> events){
        double upper = converge+converge+1 ; 
        List<Integer> digits = new Vector<Integer>(carrier.keySet()) ;  
        events.add(braces.toString ( )) ; 
        while  (upper>converge)   {  
            Map<Integer,Double> holder = new HashMap<Integer,Double>() ; 
            for( int  de=digits.size()-1;de>=0;de-- ){
                int value =  digits.get(de) ; 
                Map<Integer,Double> voltage = carrier.get(value) ;     
                double trial = Double.valueOf(0) ;  
                for(Map.Entry<Integer,Double> names:voltage.entrySet( )){
                  double temps =  braces.get(names.getKey())*names.getValue( ) ; 
                   trial = trial+ temps ;   
                } 
                upper = Math.max(trial-braces.get(value),upper)  ; 
                 holder.put(value,trial) ;    } 
            braces = new TreeMap<Integer,Double>(holder) ;  
            events.add(braces.toString()) ;     }
     }  
     // List<Double> JacobisIteration  // List<Double> iterands = new ArrayList<Double>() ;  
     ///     List<Integer> values = new  Vector<Integer>( frames.keySet()) ;   
     // iterands.add(Double.valueOf(starters[0])) ; 
    public static Map<Integer,Double> JacobisIteration(double converge,Map<Integer,Map<Integer,Double>> workers,List<String> output){
            int width = workers.size( ) ; 
             Map<Integer,Map<Integer,Double>>  frames = deriveEquations(workers) ; 
            Map<Integer,Double> iterands = new HashMap<Integer,Double>() ;  
            List<Integer> yields =  new ArrayList<Integer>(workers.keySet( )) ;
            for(int de=width;de>=1;de--){iterands.put(yields.get(de),Double.valueOf(starters[0])) ; } 
             serialise( converge,frames,iterands,output ) ;  
            return iterands ;  
    }    
    // List<Map<Integer,Double>> source // List<Map<Integer,Double>> deriveEquations
    // List<Map<Integer,Double>> created = new Vector<Map<Integer,Double>>() ; 
    public static Map<Integer,Map<Integer,Double>> deriveEquations(Map<Integer,Map<Integer,Double>> source){
         Map<Integer,Map<Integer,Double>> created = new TreeMap<Integer,Map<Integer,Double>>() ; 
         List<Integer> points = new  ArrayList<Integer> (source.keySet()) ; 
         int spans = points.size() ;   
         for(int rd=0;rd<spans;rd++ ){   int fc = points.get(rd) ; 
            Map<Integer,Double> crest = new HashMap<Integer,Double>( ) ;   
            Map<Integer,Double> quest = source.get(fc) ; 
             double  notes =   quest.get(fc) ; 
            crest.put(Integer.valueOf(0),quest.get(0)/notes)  ; 
            for(int cd=0;cd<spans;cd++){ int tc  = points.get(cd) ; 
                if(!quest.containsKey(tc)){continue ; } 
                if(tc==fc){continue ;  } 
                crest.put(tc,(quest.get(tc)/notes)*-1) ;
            }  
        created.put(fc,crest) ; 
         }  
         return created ;  
    }
}
