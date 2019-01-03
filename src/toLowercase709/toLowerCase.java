package toLowercase709;

/*
 实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串
示例 1：
输入: "Hello"
输出: "hello"
*/
public class toLowerCase {
	
	public static void main(String[] args) {
		String str="Hello";
		System.out.println(toLowerCase(str)); ;
	}
	/**
	 * 
	 * <b>方法说明：</b>
	 * <ul>
	 * 小写字母比大写字母大32 unicode
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
