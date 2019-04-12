package com.nhn.demosortarrayjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        demoSortSideEffect();
    }

    private void demoSortSideEffect() {
        Integer[] numbers = {1, 2, 3, 4, 5};
        List<Integer> listNumber = Arrays.asList(numbers);
        sortDesc(listNumber);
        showResult(numbers, listNumber, "demoSortSideEffect1");
    }


    private void demoSortSideEffect2() {
        Integer[] numbers = {1, 2, 3, 4, 5};
        List<Integer> listNumber = new ArrayList<>(Arrays.asList(numbers));
        sortDesc(listNumber);
        showResult(numbers, listNumber, "demoSortSideEffect2");
    }

    private void sortDesc(List<Integer> listNumber) {
        Collections.sort(listNumber, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1.equals(o2)) {
                    return 0;
                }
                return o1 < o2 ? 1 : -1;
            }
        });
    }

    private void showResult(Integer[] numbers, List<Integer> listNumber, String title) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("     ").append(title).append("     ").append("\n\n\n\n");
        stringBuilder.append("numbers:     ");
        for (Integer number : numbers) {
            stringBuilder.append(number).append(" ");
        }
        stringBuilder.append("\n\n");


        stringBuilder.append("listNumber:  ");
        for (Integer number : listNumber) {
            stringBuilder.append(number).append(" ");
        }
        stringBuilder.append("\n\n");
        TextView tv = findViewById(R.id.tvContent);
        tv.setText(stringBuilder.toString());
    }
}
