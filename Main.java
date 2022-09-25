import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        System.out.println("Type number: ");
        Scanner scan = new Scanner(System.in);
        int qs_num = scan.nextInt();        //决定输出题目个数
        String[] question = new String[qs_num];   //存放题目
        String[] answer = new String[qs_num];     //存放答案
        for(int qs_numD = 0 ; qs_numD<qs_num ; qs_numD++){
            int order = qs_numD+1;
            int sign_num = (int)(Math.random()*10%2);  //决定运算符个数，0为1个，1为2个
            if(sign_num == 0){
                while(true){
                    int num1 = (int)(Math.random()*100);
                    int num2 = (int)(Math.random()*100);
                    int sign = (int)(Math.random()*10%2);  //决定中间运算符，0为+，1为-
                    if(sign == 0){     //+
                        if(num1+num2<100){
                            String str1 = order + "." +num1 + "+" + num2 + "=";
                            question[qs_numD] = str1;
                            int answer1 = num1+num2;
                            String str2 = order + "." + answer1;
                            answer[qs_numD] = str2;
                            break;
                        }
                    }
                    else if(sign == 1){    //-
                        if(num1-num2>0){
                            String str1 = order + "." +num1 + "-" + num2 + "=";
                            question[qs_numD] = str1;
                            int answer1 = num1-num2;
                            String str2 = order + "." + answer1;
                            answer[qs_numD] = str2;
                            break;
                        }
                    }
                }
            }
            else if(sign_num == 1){
                while(true){
                    int sign1 = (int)(Math.random()*10%2);  //决定中间运算符，0为+，1为-
                    int sign2 = (int)(Math.random()*10%2);  //决定中间运算符，0为+，1为-
                    int num1 = (int)(Math.random()*100);
                    int num2 = (int)(Math.random()*100);
                    int num3 = (int)(Math.random()*100);
                    if(sign1 == 0&&sign2 == 0){    //+,+
                        if(num1+num2+num3<100){
                            String str1 = order + "." +num1 + "+" + num2 + "+" + num3 + "=";
                            question[qs_numD] = str1;
                            int answer1 = num1+num2+num3;
                            String str2 = order + "." + answer1;
                            answer[qs_numD] = str2;
                            break;
                        }
                    }
                    else if(sign1 == 0&&sign2 == 1){    //+,-
                        if(num1+num2-num3<100&&num1+num2-num3>0){
                            String str1 = order + "." +num1 + "+" + num2 + "-" + num3 + "=";
                            question[qs_numD] = str1;
                            int answer1 = num1+num2-num3;
                            String str2 = order + "." + answer1;
                            answer[qs_numD] = str2;
                            break;
                        }
                    }
                    else if(sign1 == 1&&sign2 == 0){    //-,+
                        if(num1-num2+num3<100&&num1-num2+num3>0){
                            String str1 = order + "." +num1 + "-" + num2 + "+" + num3 + "=";
                            question[qs_numD] = str1;
                            int answer1 = num1-num2+num3;
                            String str2 = order + "." + answer1;
                            answer[qs_numD] = str2;
                            break;
                        }
                    }
                    else if(sign1 == 1&&sign2 == 1){     //-,-
                        if(num1-num2-num3>0){
                            String str1 = order + "." +num1 + "-" + num2 + "-" + num3 + "=";
                            question[qs_numD] = str1;
                            int answer1 = num1-num2-num3;
                            String str2 = order + "." + answer1;
                            answer[qs_numD] = str2;
                            break;
                        }
                    }
                }
            }
        }
        FileWriter fw1 = new FileWriter("Exercises.txt");
        BufferedWriter bf1 = new BufferedWriter(fw1);
        for(int i = 0;i<qs_num;i++){
            bf1.write(question[i]);
            bf1.newLine();
            bf1.flush();
        }
        FileWriter fw2 = new FileWriter("Answers.txt");
        BufferedWriter bf2 = new BufferedWriter(fw2);
        for(int i = 0;i<qs_num;i++){
            bf2.write(answer[i]);
            bf2.newLine();
            bf2.flush();
        }
    }
}
