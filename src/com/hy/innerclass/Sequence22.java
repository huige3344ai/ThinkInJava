package com.hy.innerclass;

/**
 * Created by Hy on 2017/2/22.
 */
public class Sequence22  {
    private Object[] items;
    private int next = 0;
    public Sequence22(int size) { items = new Object[size]; }
    public void add(Object x) {
        if(next < items.length)
            items[next++] = x;
    }

    public Selector reverseSelector(){
       return new Selector() {
           int i = items.length-1;

           @Override
           public boolean end() {
               if (i==-1)
                return false;
               else
                return true;
           }

           @Override
           public Object current() {
               return items[i];
           }

           @Override
           public void next() {
            i--;
           }
       };
   }

    public static void main(String[] args) {
        Sequence22 sequence22 = new Sequence22(5);
        Selector selector = sequence22.reverseSelector();
        sequence22.add("1");
        sequence22.add("2");
        sequence22.add("b");
        sequence22.add("n");
        sequence22.add("8");
        for (;selector.end();selector.next()){
            System.out.println("selector:"+selector.current());
        }
    }

}
