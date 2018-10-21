/******************************************************************
 * FlippinganImage.java
 * Copyright 2018 by GNNT Company. All Rights Reserved.
 * CreateDate��2018��9��14��
 * Author��Liupeng
 * Version��F1.0.0.0
 ******************************************************************/

package flippinganimage;


/*����һ�������ƾ��� A����������ˮƽ��תͼ��Ȼ��תͼ�񲢷��ؽ����

ˮƽ��תͼƬ���ǽ�ͼƬ��ÿһ�ж����з�ת�����������磬ˮƽ��ת [1, 1, 0] �Ľ���� [0, 1, 1]��

��תͼƬ����˼��ͼƬ�е� 0 ȫ���� 1 �滻�� 1 ȫ���� 0 �滻�����磬��ת [0, 1, 1] �Ľ���� [1, 0, 0]��

ʾ�� 1:

����: [[1,1,0],[1,0,1],[0,0,0]]
���: [[1,0,0],[0,1,0],[1,1,1]]
����: ���ȷ�תÿһ��: [[0,1,1],[1,0,1],[0,0,0]]��
     Ȼ��תͼƬ: [[1,0,0],[0,1,0],[1,1,1]]
ʾ�� 2:

����: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
���: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
����: ���ȷ�תÿһ��: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]��
     Ȼ��תͼƬ: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
˵��:

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
