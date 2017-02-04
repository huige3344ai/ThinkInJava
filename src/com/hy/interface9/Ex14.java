package com.hy.interface9;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by Hy on 2017/2/1.
 */
 interface Processor{
    String name();
    Object process(Object input);
}
class Apply{
     public static void process(Processor p,Object obj){
         System.out.println("Using Processor "+p.name());
         System.out.println(p.process(obj));
     }
}

class StringMixerAdapter implements Processor {
    public String name() { return "StringMixerAdapter"; }
    StringMixer stringMixer;
    public StringMixerAdapter(StringMixer stringMixer) {
        this.stringMixer = stringMixer;
    }
    public String process(Object input) {
        return stringMixer.process((String)input);
    }
}


class StringMixer{
    public String process(String s){
 		char[] ca = new char[s.length()];
 		if((s.length())%2 == 0) {
 			for(int i = 0; i < s.length(); i += 2) {
 				ca[i] = s.charAt(i + 1);
 				ca[i + 1] = s.charAt(i);
 			}
 			return new String(ca);
 		}
 		else {
 		for(int i = 0; i < s.length() - 1; i += 2) {
 				ca[i] = s.charAt(i + 1);
 				ca[i + 1] = s.charAt(i);
 			}
 			ca[s.length() - 1] = s.charAt(s.length() - 1);
 			return new String(ca);
 		}
    }
}
public class Ex14 {
    public static void main(String[] args) {
        String s = "We can fly";
        Apply.process(new StringMixerAdapter(new StringMixer()), s);
    }
}
