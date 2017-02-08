package com.hy.innerclass.free;

import com.hy.innerclass.one.One;
import com.hy.innerclass.two.Two;

/**
 * Created by Hy on 2017/2/6.
 */
public class Free extends Two {
    One getTwoInner(){
        Two two = new Two();
        return two.new TwoInner();
//        return this.new TwoInner();
    }

    public static void main(String[] args) {
        Free free = new Free();
        free.getTwoInner().say();
    }
}
