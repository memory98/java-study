package chapter03;

import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
//import java.util.*;
public class ArrayUtilTest {

	public static void main(String[] args) {
		List list = null;
		Stack s = null;
		Queue q = null;
		int[] a = { 10, 20, 30, 40 };
		
//		int[] a = new int[5];
//		a[0]=10;
		double[] d = ArrayUtil.intToDouble(new int[] { 10, 20, 30, 40 });
		
		System.out.println(Arrays.toString(d));
		
		int[] i1 = ArrayUtil.doubleToInt(new double[] {10.0,11.1,22.2,33.4});
		System.out.println(Arrays.toString(i1));
		
		int[] i2 = ArrayUtil.concat(new int[] {1,2,3},new int[]{4,5,6});
		System.out.println(Arrays.toString(i2));

//		Goods g = new Goods();
//		System.out.println(g);
//		System.out.println(g.toString());
	}
}
