package com.example.FlamesApp.service;

import org.springframework.stereotype.Service;

@Service
public class FlameDataService {
    public String flames(String a,String b){
        a=a.toLowerCase();
        b=b.toLowerCase();
        int c=a.length()+b.length();
        char[] chars = b.toCharArray();
        for(int i=0;i<a.length();i++){
            for(int j=0;j<b.length();j++){
                if(a.charAt(i)==chars[j]){
                    chars[j] = '*';
                    c=c-2;
                    break;
                }

            }
        }
        c=c%6;
        if(c==0)
            return "Siblings";
        if(c==1)
            return "Friends";
        if(c==2)
            return "Love";
        if(c==3)
            return "Affection";
        if(c==4)
            return "Marriage";
        if(c==5)
            return "Enemy";
        return "";
    }
}
