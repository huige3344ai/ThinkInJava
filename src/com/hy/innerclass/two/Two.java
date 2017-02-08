package com.hy.innerclass.two;

import com.hy.innerclass.one.One;

/**
 * Created by Hy on 2017/2/6.
 */
public class Two {
    protected class TwoInner implements One{
        public TwoInner(){}//need public constructor to create one in One child:
        @Override
        public void say() {
            System.out.println("TwoInner say.");
        }
    }
}
