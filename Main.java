package com.company;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static ArrayList<Tag> Copmression(String str) {
        ArrayList<Tag> Tags = new ArrayList<Tag>();
        HashMap<String, Integer> dectionary = new HashMap<String, Integer>();
        dectionary.put(null, 0);
        int counter = 1, start = 0;
        String subI;
        boolean isRepeated;

        for (int i = 0; i < str.length(); i++) {

            for (int j = i + 1; j <= str.length(); j++) {
                subI = str.substring(i, j);
                isRepeated=false;

                if (dectionary.containsKey(subI)) {
                    start = dectionary.get(subI);
                    isRepeated=true;
                }

                if(!isRepeated) {
                    dectionary.put(subI, counter);
                    counter++;
                    Tags.add(new Tag(start, str.charAt(j-1)));
                    i = i + subI.length() - 1;
                    break;
                }
                else if(dectionary.containsKey(subI)&&j==str.length()){
                    Tags.add(new Tag(start,'0'));
                    i = i + subI.length() - 1;
                    break;

                }
            }
        }

        return Tags;
    }

    public static String deCompression(ArrayList<Tag> Tags){
        String str="";
        ArrayList<String> doc = new ArrayList<String>();

        for (int i=0 ;i<Tags.size();i++){
            if (Tags.get(i).getPosition()==0){

                str=str+Tags.get(i).nextChar;
                doc.add(""+Tags.get(i).nextChar);

            }
            else{
                    int pos=Tags.get(i).getPosition();
                    char nChar=Tags.get(i).getNextChar();
                    str+=doc.get(pos-1);

                    if (nChar !='0') {
                         str+=nChar;
                        doc.add(doc.get(pos-1)+nChar);
                    }

            }
        }

        return str;
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        ArrayList<Tag> tags = new ArrayList<Tag>();

        int pos;
        char nChar;
        int choice=0;

        while (choice != 2)
        {
            System.out.println(" (1) Create tag \n (2) Compress");
            choice = sc.nextInt();
            if (choice == 1)
            {
                Tag newTag = new Tag();
                System.out.println("Please enter tag");
                newTag.setPosition(pos=sc.nextInt());
                newTag.setNextChar(nChar=sc.next().charAt(0));
                tags.add(newTag);
            }
        }
        System.out.println(deCompression(tags));

        String str=sc.next();
        System.out.println(Copmression(str));

        //    String str="ABAABABAABABBBBBBBBBBAA";
        //    System.out.println(deCompression(Copmression(str));

    }
}

