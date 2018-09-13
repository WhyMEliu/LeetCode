/******************************************************************
 * HammingDistance.java
 * Copyright 2018 by GNNT Company. All Rights Reserved.
 * CreateDate��2018��9��13��
 * Author��Liupeng
 * Version��F1.0.0.0
 ******************************************************************/

package hammingdistance;

/**
 * <b>�޸ļ�¼��</b> 
 * <p>
 * <li>
 * 
 *                        ---- LP 2018��9��13��
 * </li>
 * </p>
 * 
 * <b>��˵����</b>
 * 
 * <p> 
 * 
 * </p>
 */

/*��������֮��ĺ�������ָ�������������ֶ�Ӧ������λ��ͬ��λ�õ���Ŀ��
������������ x �� y����������֮��ĺ������롣
ע�⣺
0 �� x, y < 2^32
����: x = 1, y = 4
���: 2
����:
1   (0 0 0 1)
4   (0 1 0 0)
       ��   ��
����ļ�ͷָ���˶�Ӧ������λ��ͬ��λ�á�

*/
public class HammingDistance {
	
	public static void main(String[] args) {
		System.out.println("hammingDistance=="+hammingDistance(1,4));

/*		int a= 1^4;
		int b= 4&5;
		System.out.println("1^4=="+a);
		System.out.println("4&5=="+b);
		System.out.println(Integer.toBinaryString(5));*/
		
	}
	
	public static int hammingDistance(int x, int y) {
		int hamming = x ^ y;
		 int cnt = 0;
		 while(hamming > 0){
		 hamming = hamming & (hamming - 1);
		 System.out.println("hamming==="+hamming);
		 cnt++;
		 }
		 return cnt;
    }
}
