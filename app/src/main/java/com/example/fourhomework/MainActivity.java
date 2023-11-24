package com.example.fourhomework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private String pi="3.141592653589793238462643383279502884197169399375105820974944592307816406286208998628034825342117067982148086513282306647093844609550582231725359408128481117450284102701938521105559644622948954930381964428810975665933446128475648233786783165271201909145648566923460348610454326648213393607260249141273724587006606315588174881520920962829254091715364367892590360";
    private int[] arrayInt;//массив для цифр заданого числа
    private int three;//количество цифр 3
    private int five;//количество цифр 5

    private int popularDigit;//самая частая цифра
    private int sumDigit;//сумма всех цифр
    private int[] reverseArrayInt;//массив задом на перед
    private String reverseStringInt;//массив задом на перед в виде сстроки
    private int[] sortArrayInt;//отсортированый массив

    private TextView infoApp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayInt = arrayInt(pi);
        three = three(arrayInt);
        five = five(arrayInt);

        popularDigit=popularDigit(arrayInt);
        sumDigit = sumDigit(arrayInt);
        reverseArrayInt = reverseArrayInt(arrayInt);
        reverseStringInt = Arrays.toString(reverseArrayInt);

        sortArrayInt = Arrays.copyOf(arrayInt, arrayInt.length);
        Arrays.sort(sortArrayInt);

        infoApp = findViewById(R.id.infoApp);

        infoApp.setText("Массив из строки: "+ Arrays.toString(arrayInt)+"\n"+"Количество цифр 3: "+three+"\n"+"Количество цифр 5: "+five+"\n"+"Самая популярная цифра: "+ popularDigit+"\n"+"Сумма всех цифр в массиве "+sumDigit+"\n"+"Отсортированый массив "+Arrays.toString(sortArrayInt));
    }

    private int[] reverseArrayInt(int[] arrayDigit){
        int[] reverse = new int[arrayDigit.length];
        for (int i = arrayDigit.length-1;i>=0;i--){
            reverse[arrayDigit.length - (i+1)] = arrayDigit[i];
        }
        return reverse;
    }
    private int sumDigit(int[] arrayDigit){
        int sum = 0;
        for (int i : arrayDigit){
            sum+=i;
        }
        return sum;
    }
    private int[] arrayInt(String string){
        String stringNew = string.replace(".","");
        String[] arrayString = stringNew.split("");
        int[] arrayInteger = new int[arrayString.length];
        for(int i = 0;i<arrayString.length;i++){
            arrayInteger[i] = Integer.parseInt(arrayString[i]);
        }
        return arrayInteger;
    }
    private int popularDigit(int[] arrayDigit){
        int[] count = new int[10];
        for (int i:arrayDigit){
            switch (i){
                case 0:count[0]++;break;
                case 1:count[1]++;break;
                case 2:count[2]++;break;
                case 3:count[3]++;break;
                case 4:count[4]++;break;
                case 5:count[5]++;break;
                case 6:count[6]++;break;
                case 7:count[7]++;break;
                case 8:count[8]++;break;
                case 9:count[9]++;break;

            }
        }
        int popular = 0;
        for (int i = 0;i<count.length;i++){
            if (count[i] > count[popular] ) popular=i;
        }
        return popular;
    }
    private int three(int[] arrayDigit){
        int count=0;
        for(int i : arrayDigit){
            if (i==3){
                count++;
            }
        }
        return count;
    }
    private int five(int[] arrayDigit){
        int count=0;
        for(int i : arrayDigit){
            if (i==5){
                count++;
            }
        }
        return count;
    }

}