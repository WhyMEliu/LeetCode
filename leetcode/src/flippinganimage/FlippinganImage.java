/******************************************************************
 * FlippinganImage.java
 * Copyright 2018 by GNNT Company. All Rights Reserved.
 * CreateDate：2018年9月14日
 * Author：Liupeng
 * Version：F1.0.0.0
 ******************************************************************/

package flippinganimage;


/*给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。

水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。

反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。

示例 1:

输入: [[1,1,0],[1,0,1],[0,0,0]]
输出: [[1,0,0],[0,1,0],[1,1,1]]
解释: 首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
     然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
示例 2:

输入: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
输出: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
解释: 首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
     然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
说明:

1 <= A.length = A[0].length <= 20
0 <= A[i][j] <= 1*/

public class FlippinganImage {
	
	public static void main(String[] args) {
		int[][] A = {{1,1,0}};
		flipAndInvertImage(A);
	}
	
    public static int[][] flipAndInvertImage(int[][] A) {
    	int al= A.length;
    	int[][] reslut = new int[al][al];
    	for (int i = 0; i < al; i++) {
			for (int j = 0; j < al; j++) {
				reslut[i][al-1-j]=A[i][j]^=1;
			}
		}
    	return reslut;
    }
    
    public int[][] easyflipAndInvertImage(int[][] A) {
        int n = A.length;
        for (int[] row : A)
            for (int i = 0; i * 2 < n; i++)
                if (row[i] == row[n - i - 1])
                    row[i] = row[n - i - 1] ^= 1;
        return A;
    }
}
