/******************************************************************
 * NumJewelsInStones.java
 * Copyright 2018 by GNNT Company. All Rights Reserved.
 * CreateDate��2018��9��12��
 * Author��Liupeng
 * Version��F1.0.0.0
 ******************************************************************/

package jewelsandstones;

import java.util.Scanner;

/**
 * <b>�޸ļ�¼��</b> 
 * <p>
 * <li>
 * 
 *                        ---- LP 2018��9��12��
 * </li>
 * </p>
 * 
 * <b>��˵����</b>
 * <p> 
 * 
 * </p>
 */
/*
 �����ַ���J ����ʯͷ�б�ʯ�����ͣ����ַ��� S������ӵ�е�ʯͷ�� S ��ÿ���ַ�������һ����ӵ�е�ʯͷ�����ͣ�����֪����ӵ�е�ʯͷ���ж����Ǳ�ʯ��
J �е���ĸ���ظ���J �� S�е������ַ�������ĸ����ĸ���ִ�Сд�����"a"��"A"�ǲ�ͬ���͵�ʯͷ��

ʾ�� 1:

����: J = "aA", S = "aAAbbbb"
���: 3
ʾ�� 2:

����: J = "z", S = "ZZ"
���: 0
*/

public class NumJewelsInStones {
	public static void main(String[] args) {
	/*	Scanner sc = new Scanner(System.in);
		System.out.println("�������ݣ�");
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
