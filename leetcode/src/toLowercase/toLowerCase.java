/******************************************************************
 * Solution.java
 * Copyright 2018 by GNNT Company. All Rights Reserved.
 * CreateDate��2018��9��13��
 * Author��Liupeng
 * Version��F1.0.0.0
 ******************************************************************/

package toLowercase;

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
 * <p> 
 * 
 * </p>
 */
/*
 ʵ�ֺ��� ToLowerCase()���ú�������һ���ַ������� str���������ַ����еĴ�д��ĸת����Сд��ĸ��֮�󷵻��µ��ַ���
ʾ�� 1��
����: "Hello"
���: "hello"
*/
public class toLowerCase {
	
	public static void main(String[] args) {
		String str="Hello";
		System.out.println(toLowerCase(str)); ;
	}
	/**
	 * 
	 * <b>����˵����</b>
	 * <ul>
	 * Сд��ĸ�ȴ�д��ĸ��32 unicode
	 * </ul>
	 * @param str
	 * @return
	 */
    public static String toLowerCase(String str) {
        if(str==""){
        	return null;
        }
    	char[] a= str.toCharArray();
    	for (int i = 0; i < a.length; i++) {
    		if(a[i]>='A'&&a[i]<='Z'){
    			a[i]+=32;
			}
		}
    	return new String (a);
    }
}
