package com.Utility;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Utilities {

    public static void tapByElement (AndroidDriver driver, WebElement element) {
       try{
           new TouchAction(driver).tap(TapOptions.tapOptions().withElement(new ElementOption().withElement(element)))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(250))).perform();
         //  action.tap(new TapOptions().withElement(new ElementOption().withElement(ele))).perform();
       }
       catch(Exception e){
           e.printStackTrace();
       }
    }

    public static void sendKeysToElement(WebElement element, String inputText) {
        element.sendKeys();
    }

    public static String reverseWords(String inputString){
        String reverseWord = "";
        String words[] = inputString.split(" ");
        for(String word:words){
            StringBuilder sb = new StringBuilder(word);
            sb.reverse();
            System.out.println(reverseWord);
            reverseWord+= sb.toString() +" ";
        }
        System.out.println(reverseWord);
        return reverseWord;
    }

    public static void findDuplicateCharacters(String inputText){

        char[] inputString= inputText.replace(" ","").toCharArray();
        HashMap<Character, Integer> inputMap = new HashMap<>();

        for(Character character:inputString){
            if(inputMap.containsKey(character)){
                inputMap.put(character, inputMap.get(character)+1);
            }else{
                inputMap.put(character, 1);
            }
        }

        Set<Character> inputSet = inputMap.keySet();
        for(Character character : inputSet){
            if(inputMap.get(character)>1){
                System.out.println("Duplicate Value Found; Repetition [Occurrence] of "+character+" is "+inputMap.get(character));
            }
        }

    }

    public static void findDuplicateWords(String inputText){
        String[] inputWords = inputText.split(" ");
        HashMap<String, Integer> inputMap = new HashMap();
        for(String word:inputWords){
            if(inputMap.containsKey(word)){
                System.out.println("if statement : before adding ---- "+inputMap);
                inputMap.put(word, inputMap.get(word)+1);
                System.out.println("if statement : after adding ---- "+inputMap);
            }else {
                System.out.println("else statement : before adding ---- "+inputMap);
                inputMap.put(word, 1);
                System.out.println("else statement : after adding ---- "+inputMap);
            }
        }
        Set<String> inputSet = inputMap.keySet();
        for(String word : inputSet){
            if(inputMap.get(word)>1){
                System.out.println("SET Value "+inputSet);
                System.out.println("Duplicate Value Found; Repetition [Occurrence] of "+word+" is "+inputMap.get(word));
            }
        }




    }


    public static void main(String args[]){
        //findDuplicateWords("My Name is Kuldeep Kuldeep my name is");


        String s ="My name is Dharma";
        String[] a  =s.split(" ");


        for(int i=0;i<a.length;i++){
            StringBuffer sb=new StringBuffer(a[i]);
            sb.reverse();

            System.out.print(sb+"  ");
        }


    }

}
