package org.wordheap;

public class ReverseString {

	ReverseString(String str) {
		char[] inp = str.toCharArray();
		char[] out = new char[inp.length];
		
		for(int i=0;i<inp.length;i++) {
			out[inp.length-1-i] =inp[i];
		}
		
		System.out.println("Reversed: " + new String(out));
		
	}
	
	public static void main(String[] args) {
		new ReverseString("An apple remains an apple, in most of the cases");
	}
}
