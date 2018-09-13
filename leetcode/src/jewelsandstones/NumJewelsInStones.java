/******************************************************************
 * NumJewelsInStones.java
 * Copyright 2018 by GNNT Company. All Rights Reserved.
 * CreateDate：2018年9月12日
 * Author：Liupeng
 * Version：F1.0.0.0
 ******************************************************************/

package jewelsandstones;

import java.util.Scanner;

/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- LP 2018年9月12日
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * 
 * </p>
 */
/*
 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。

示例 1:

输入: J = "aA", S = "aAAbbbb"
输出: 3
示例 2:

输入: J = "z", S = "ZZ"
输出: 0
*/

public class NumJewelsInStones {
	public static void main(String[] args) {
	/*	Scanner sc = new Scanner(System.in);
		System.out.println("接收数据：");
		if(sc.hasNext()){
			String ss= sc.next();
			System.out.println(ss);
		}
		sc.close();*/
		String j="aA";
		String s="aAAbbbb";
		System.out.println(numJewelsInStones(j, s));
	}
	
	public static int numJewelsInStones(String j,String s){
		int njs=0;
		char[] a= j.toCharArray();
		char[] b= s.toCharArray();
		for (char c : a) {
			for (char f : b) {
				if(c==f){
					njs++;
				}
			}
		}
		return njs;
	}
}
