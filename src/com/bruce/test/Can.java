package com.bruce.test;
public class Can {

	/**
	 * 思路：<br>
	 * 根据题意，只要求a和b的最大公约数即可，然后判断c是否是最大公约数的整数倍即可。
	 */

	public static boolean can(int a, int b, int c) {
		int d = 1;
		for (;;) {
			if ((a = a % b) == 0) {
				d = b;
				break;
			}
			if ((b = b % a) == 0) {
				d = a;
				break;
			}
		}
		if (c % d == 0) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(can(1, 2, 3));
		System.out.println(can(2, 4, 3));
		System.out.println(can(1, 1, 1));
		System.out.println(can(24, 18, 12));
	}
}
