package com;

import java.util.stream.IntStream;

public class LeftRotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={1,2,3,4,5};
		int[] arrLeftRotated=rotLeft(arr,1);
		for(int element:arrLeftRotated)
		System.out.println(element);
		

	}
	static int[] rotLeft(int[] a, int n) {
		//this is a left rotation of array where n is the number by which we are deciding how many indexes we have to shift.
        return IntStream.range(0, a.length).map(d->a[((n+d)%a.length)]).toArray();

    }

}
