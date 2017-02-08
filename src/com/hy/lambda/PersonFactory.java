package com.hy.lambda;

/**
 * Created by Hy on 2017/2/8.
 */
interface  PersonFactory<P extends Person> {
    P create(String name);
}
