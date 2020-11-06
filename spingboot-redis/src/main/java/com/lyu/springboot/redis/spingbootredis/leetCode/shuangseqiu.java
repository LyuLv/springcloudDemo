package com.lyu.springboot.redis.spingbootredis.leetCode;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * @Author: Lyu
 * @Description:
 * @Date: Created in 16:46 2020/10/30
 * @Modified By:
 */
public class shuangseqiu {
    /**
     * 冒泡排序
     * @param ball
     */
    public static void sort(int[] ball){
        for (int i = 0; i < ball.length-1; i++) {
            for (int j = 0; j < ball.length-1-i; j++) {
                if(ball[j]>ball[j+1]){
                    ball[j] = ball[j] + ball[j+1];
                    ball[j+1] = ball[j] - ball[j+1];
                    ball[j] = ball[j] - ball[j+1];
                }
            }
        }
    }

    /**
     * 用于在指定的数组中，随机生成多个不重复的数据（算法）
     * @param redBall
     * @param userRedBall
     * 在redBall数组里随机先选一个数，让选择的数的下标和最后一个下标交换位置，
     * 存给temp赋值给userRedBall，redBall的长度-1-i;
     */
    public static void computerSeletion(int[] redBall,int[] userRedBall){
        Random ran = new Random();
        int index = -1;
        for (int i = 0; i < userRedBall.length; i++) {
            index = ran.nextInt(redBall.length-i);
            userRedBall[i] = redBall[index];
            int temp = redBall[index];

            redBall[index] = redBall[redBall.length-1-i];
            redBall[redBall.length-1-i] = temp;
        }
    }

    public static int get() {
        //定义相关变量
        //用户选择的红色球号码
        int[] userRedBall = new int[6];
        //系统生成的红色球号码
        int[] sysRedBall = new int[6];
        //用户选择的蓝球
        int userBlueBall = 0;
        int sysBlueBall = 0;
        //记录用户选择正确的红色球的个数
        int redCount = 0;
        int blueCount = 0;
        //用于存储1-33的红色球的号码
        int[] redBall = new int[33];

        //填充红色数组
        for (int i = 0; i < redBall.length; i++) {
            //存储1-33
            redBall[i] = i+1;
        }

        //游戏开始
        System.out.println("双色球游戏开始，Good luck! ");

        //双色球买入号码
        Random ran = new Random();
        boolean flag = true;
        while(flag){
            //红球
            computerSeletion(redBall,userRedBall);
            //蓝球
            userBlueBall = ran.nextInt(16)+1;
            flag = false;
            break;
        }

        //系统随机生成号码，中奖号码
        //红球
        computerSeletion(redBall,sysRedBall);
        //蓝球
        sysBlueBall = ran.nextInt(16)+1;

        //统计结果
        //统计红球
        for (int i = 0; i < userRedBall.length-redCount; i++) {
            for (int j = 0; j < sysRedBall.length; j++) {
                if(userRedBall[i]==sysRedBall[j]){
                    int temp = sysRedBall[j];
                    sysRedBall[j] = sysRedBall[sysRedBall.length-1-redCount];
                    sysRedBall[sysRedBall.length-1-redCount] = temp;
                    redCount++;
                }
            }
        }
        //统计蓝球
        if(userBlueBall==sysBlueBall){
            blueCount = 1;
        }

        //公布结果
        System.out.println("本期中奖红球号码为：");
        sort(sysRedBall);
        System.out.println(Arrays.toString(sysRedBall));
        System.out.println("本期中奖蓝球号码为："+sysBlueBall);

        System.out.println("您选择的红球号码是：");
        sort(userRedBall);
        System.out.println(Arrays.toString(userRedBall));
        System.out.println("您选择的蓝球号码是："+userBlueBall);

        System.out.println("买双色球，造福你我他。谢谢!");

        //验证是否中奖
        if (blueCount == 0 && redCount <= 3) {
            System.out.println("抱歉，您没有中奖!");
            return 0;
        } else if (blueCount == 1 && redCount < 3) {
            System.out.println("恭喜你中了六等奖，5块钱！");
            return 5;
        } else if ((blueCount == 1 && redCount == 3) || (blueCount == 0 && redCount == 4)) {
            System.out.println("恭喜你中了五等奖，10块钱！");
            return 10;
        } else if ((blueCount == 1 && redCount == 4) || (blueCount == 0 && redCount == 5)) {
            System.out.println("恭喜你中了四等奖，300块钱！");
            return 300;
        } else if (blueCount == 1 && redCount == 5) {
            System.out.println("恭喜你中了三等奖，1000块钱！");
            return 1000;
        } else if (blueCount == 0 && redCount == 6) {
            System.out.println("恭喜你中了二等奖，15w！");
            return 15;
        } else if (blueCount == 1 && redCount == 6) {
            System.out.println("恭喜你中了一等奖，500w！");
            return 500;
        } else {
            System.out.println("系统有误，中奖无效！");
            return 1;
        }
    }

    public static void main(String[] args) {
        int count = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        int count5 = 0;
        int count6 = 0;
        for (int i = 0; i < 1000000000; i++) {
            count++;
            if (get() == 500) {
                System.out.println("循环的总次数：" + count);
                System.out.println("二等奖的总次数：" + count2);
                System.out.println("三等奖的总次数：" + count3);
                System.out.println("四等奖的总次数：" + count4);
                System.out.println("五等奖的总次数：" + count5);
                System.out.println("六等奖的总次数：" + count6);
                break;
            } else if (get() == 15) {
                count2++;
            } else if (get() == 1000) {
                count3++;
            } else if (get() == 300) {
                count4++;
            } else if (get() == 10) {
                count5++;
            } else if (get() == 5) {
                count6++;
            }
        }
    }



}
