package ch11_sorting_searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ch11_7_LongestIncreasingSubSequence3 {

   /*
    * A circus is designing a tower routine consisting of people standing atop of one 
    * another's shoulder. Each person should be both lighter and shorter than the person below him or her.
    * Given the heights and weights of each person, write a method to compute the largest possible number
    * of people in such a tower
    */
   public static void main(String[] args) {
      
      Person[] persons = new Person[]{new Person(65,100), new Person(70,150), new Person(56,90), new Person(75,190), new Person(60, 95), new Person(68, 110)};
      System.out.println(Arrays.toString(persons));
      System.out.println(buildTower(persons).toString());
   }
   // dynamic programming, O(n*n)
   public static ArrayList<Person> buildTower(Person[] persons){
      ArrayList<Person> tower = new ArrayList<Person>();
      if (persons == null || persons.length == 0)
         return tower;
      Arrays.sort(persons);
      Map<Integer, ArrayList<Person>> mem = new HashMap<Integer, ArrayList<Person>>();
      initMem(mem, persons.length);
      mem.get(0).add(persons[0]);
      for (int i = 1; i < persons.length; i++){
         mem.get(i).add(persons[i]);
         for (int j = 0; j < i; j++){
            if (persons[i].getWeight() > persons[j].getWeight() && mem.get(i).size() < mem.get(j).size()+1){
               mem.put(i, new ArrayList<Person>(mem.get(j)));
               mem.get(i).add(persons[i]);
            }
         }
      }
      for (ArrayList<Person> list : mem.values()){
         tower = list.size() > tower.size() ? list : tower;
      }
      return tower;
   }
   
   public static void initMem(Map<Integer, ArrayList<Person>> mem, int length){
      for (int i = 0 ; i< length; i++){
         mem.put(i, new ArrayList<Person>());
      }
   }
   
   public static class Person implements Comparable<Person>{
      private int height;
      private int weight;
      public Person(int height, int weight){
         this.height = height;
         this.weight = weight;
      }
      
      public int getHeight(){
         return this.height;
      }
      public int getWeight(){
         return this.weight;
      }
      
      public String toString(){
         return "("+ height + "," + weight + ")";
      }
      // compare height first, then weight
      public int compareTo(Person p) {
         if (this.getHeight() == p.getHeight())
            return this.getWeight() - p.getWeight();
         return this.getHeight() - p.getHeight();
      } 
   }
}

