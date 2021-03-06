package com.buildhappy.swordoffer;
/**
 * 矩阵特点：每一行从左到右递增，每一列从上到下递增。
 * 在二维数组中查找某个元素是否存在
 * 思路：
 *  1、从右上角开始查找
 *  2、如果值大于num，列数减1；小于num，则行数加1。
 * @author buildhappy
 *
 */
public class _003_FindInPartiallySortedMatirx {
	//private static int rows = 4 , colums = 4;
	private static final int[][] matrix = {{1,2,8,9}, {2,4,9,12}, {4,7,10,13}, {6,8,11,15}};
	/**
	 * 
	 * @param matrix
	 * @param number 待查找的数字
	 * @return
	 */
	public static boolean find(int[][] matrix , int number){
		int rows = 0 , columns = 0;
		//判断是否有元素
		if(matrix.length > 0 ){
			columns = matrix[0].length;
			rows = matrix.length;
		}
		boolean found = false;
		if(matrix != null && rows > 0 && columns > 0){
			int row = 0;
			int colum = columns - 1;
			while(colum >= 0 && row < rows){
				if(matrix[row][colum] == number){
					found = true;
					break;
				}else if(matrix[row][colum] > number){
					colum--;
				}else{
					row++;
				}
			}
		}
		return found;
	}
	
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		System.out.println(find(matrix , 5));
		System.out.println("用时：" + (System.nanoTime() - startTime));//181089  198305
	}
}
