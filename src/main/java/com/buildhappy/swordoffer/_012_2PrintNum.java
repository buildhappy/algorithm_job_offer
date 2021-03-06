package com.buildhappy.swordoffer;

/**
 * 输入3，打印出0到999
 */
public class _012_2PrintNum {

    public static void main(String[] args) {
        new _012_2PrintNum().print1ToMaxOfNDigits1(3);
//        new _012_2PrintNum().print1ToMaxOfNDigits2(3);
    }

    //第一种实现
    public void print1ToMaxOfNDigits1(int n) {
        if (n <= 0) {
            System.out.println("输入出错，请重新输入！");
        }
        int[] number = new int[n];

        while (increment(number)) {
            printNumber(number);
        }
    }

    //第二种实现---全排序（P97）
    public void print1ToMaxOfNDigits_Recursive(int[] num, int length, int index) {
        if (index == length - 1) {
            printNumber(num);
            return;
        }
        for (int i = 0; i < 10; i++) {
            num[index + 1] = i;
            print1ToMaxOfNDigits_Recursive(num, length, index + 1);
        }
    }

    public void print1ToMaxOfNDigits2(int n) {
        if (n <= 0) {
            return;
        }
        int[] num = new int[n];
        for (int i = 0; i < 10; i++) {
            num[0] = i;
            print1ToMaxOfNDigits_Recursive(num, n, 0);
        }

    }

    // 这个方法是用来实现对数加1操作
    public boolean increment(int[] number) {
        // 进位
        int nTakeOver = 0;

        for (int i = number.length - 1; i >= 0; i--) {
            int nSum = number[i] + nTakeOver;
            if (i == number.length - 1) {
                nSum++;
            }
            if (nSum >= 10) {
                //最高位为10，说明已经溢出，此时循环结束并退出
                if (i == 0) {
                    return false;
                }
                nTakeOver = 1;
                number[i] = 0;
            } else {
                number[i] = nSum;
                break;
            }
        }
        return true;
    }

    // 该方法是负责打印一个数字，千万不要尝试将数组变成一个整数
    public void printNumber(int[] number) {

        boolean isZero = true;
        for (int i = 0; i < number.length; i++) {
            //找到第一个不是0的元素后，令isZero=false
            if (isZero && number[i] != 0) {
                isZero = false;
            }
            if (!isZero) {
                System.out.print(number[i]);
            }
        }

        System.out.println();
    }

}