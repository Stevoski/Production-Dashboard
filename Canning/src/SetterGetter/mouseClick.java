/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SetterGetter;

/**
 *
 * @author Stevoski
 */
public  class mouseClick {
     private static Integer id;
//     private static String id="";
//     public static mouseClick(Integer id){
//        this.id=id; 
//     } 
     public static void setId(Integer myid){
         myid=id; 
     }
     public static Integer getId(){
         return id;
     }
}
