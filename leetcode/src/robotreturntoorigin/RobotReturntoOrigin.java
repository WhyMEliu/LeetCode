/******************************************************************
 * RobotReturntoOrigin.java
 * Copyright 2018 by GNNT Company. All Rights Reserved.
 * CreateDate��2018��9��13��
 * Author��Liupeng
 * Version��F1.0.0.0
 ******************************************************************/

package robotreturntoorigin;


/*�ڶ�άƽ���ϣ���һ�������˴�ԭ�� (0, 0) ��ʼ�����������ƶ�˳���ж����������������ƶ����Ƿ��� (0, 0) ��������
�ƶ�˳�����ַ�����ʾ���ַ� move[i] ��ʾ��� i ���ƶ��������˵���Ч������ R���ң���L���󣩣�U���ϣ��� D���£��������������������ж����󷵻�ԭ�㣬�򷵻� true�����򣬷��� false��
ע�⣺�����ˡ��泯���ķ����޹ؽ�Ҫ�� ��R�� ��ʼ��ʹ�����������ƶ�һ�Σ���L�� ��ʼ�������ƶ��ȡ����⣬����ÿ���ƶ������˵��ƶ�������ͬ��

ʾ�� 1:
����: "UD"
���: true
���ͣ������������ƶ�һ�Σ�Ȼ�������ƶ�һ�Ρ����ж�����������ͬ�ķ��ȣ���������ջص�����ʼ��ԭ�㡣��ˣ����Ƿ��� true��

ʾ�� 2:
����: "LL"
���: false
���ͣ������������ƶ����Ρ�������λ��ԭ�����࣬��ԭ�������� ���ƶ��� �ľ��롣���Ƿ��� false����Ϊ�����ƶ�����ʱû�з���ԭ�㡣*/

public class RobotReturntoOrigin {
	public static void main(String[] args) {
		String moves="UL";
		 System.out.println(judgeCircle(moves));
	}
	
	public static boolean judgeCircle(String moves) {
        //����ַ��� UD��LL�ĶԱ���
		int a =0;int b =0;
		for (int i = 0; i < moves.length(); i++) {
			if(moves.charAt(i)=='U')a++;
			else if(moves.charAt(i)=='D')a--;
			else if(moves.charAt(i)=='L')b++;
			else if(moves.charAt(i)=='R')b--;
		}
		return (a==0)&&(b==0);
    }
}
