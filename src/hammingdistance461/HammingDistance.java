package hammingdistance461;

/*两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
给出两个整数 x 和 y，计算它们之间的汉明距离。
注意：
0 ≤ x, y < 2^32
输入: x = 1, y = 4
输出: 2
解释:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑
上面的箭头指出了对应二进制位不同的位置。

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
