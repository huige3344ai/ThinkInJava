package com.hy.interface9;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Hy on 2017/2/1.
 */
class RandomChars {
	private static Random rand = new Random();
	public char next() {
		return (char)rand.nextInt(128);
	}
/*	public static void main(String[] args) {
		RandomChars rc = new RandomChars();
		for(int i = 0; i < 10; i++)
			System.out.print(rc.next() + " ");
	}*/
 }

public class Ex16 extends RandomChars
        implements Readable {
    private int count;
    public Ex16(int count) {
        this.count = count;
    }
    @Override
    public int read(@NotNull CharBuffer cb) throws IOException {
        if(count-- == 0) return -1;
        String result = Character.toString(next()) + " ";
        cb.append(result);
        return result.length();
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(new Ex16(10));
        while(s.hasNext())
            System.out.print(s.next() + " ");
    }

}
