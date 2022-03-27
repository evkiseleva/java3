package com.java.laba3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
// через интерфейс лист

public class Program extends JFrame {

    /**
     * Функция, тестирующая методы
     * @param list - тестируемый лист
     * @param count - количество повторений (элементов)
     * @param method - название метода
     * */
    public static String testMethod(List list, int count, String method)
    {
        long start, finish;
        switch (method)
        {
            case "add":
            {
                start = System.nanoTime();
                for(int i=0; i<1000;i++)
                {
                    list.add(5);
                }
                finish = System.nanoTime();
                break;
            }
            case "get":
            {
                start = System.nanoTime();
                for(int i=0; i<1000;i++)
                {
                    list.get(i);
                }
                finish = System.nanoTime();
                break;
            }
            case "set":
            {
                start = System.nanoTime();
                for(int i=0; i<1000;i++)
                {
                    list.set(i, 0);
                }
                finish = System.nanoTime();
                break;
            }
            case "remove":
            {
                start = System.nanoTime();
                for(int i=0; i<1000;i++)
                {
                    list.remove(0);
                }
                finish = System.nanoTime();
                break;
            }
            default:
                return "Ошибка";
        }
        return Long.toString(finish - start);
    }


    /**
     * Стартовая точка
     * @param args
     * */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Сравнение методов");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Название колонок в таблице
        String[] columnNames = {
                "Method",
                "ArrayList",
                "LinkedList",
                "Number of elements"
        };
        //Данные таблицы
        String[][] data = {
                {"Add", "", "", "1000"},
                {"Get", "", "", "1000"},
                {"Set", "", "", "1000"},
                {"Delete", "", "", "1000"},
        };

        //Переменные, с помощью которых засекается время
        long start, finish;

        //Тестируемые листы
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        /*
        //Метод add для ArrayList
        start = System.nanoTime();
        for(int i=0; i<1000;i++)
        {
            arrayList.add(5);
        }
        finish = System.nanoTime();
        data[0][1] = Long.toString(finish - start);


        //Метод add для LinkedList
        start = System.nanoTime();
        for(int i=0; i<1000;i++)
        {
            linkedList.add(5);
        }
        finish = System.nanoTime();
        data[0][2] = Long.toString(finish - start);

        //Метод get для ArrayList
        start = System.nanoTime();
        for(int i=0; i<1000;i++)
        {
            arrayList.get(i);
        }
        finish = System.nanoTime();
        data[1][1] = Long.toString(finish - start);
        //Метод get для LinkedList
        start = System.nanoTime();
        for(int i=0; i<1000;i++)
        {
            linkedList.get(i);
        }
        finish = System.nanoTime();
        data[1][2] = Long.toString(finish - start);

        //Метод set для ArrayList
        start = System.nanoTime();
        for(int i=0; i<1000;i++)
        {
            arrayList.set(i, 0);
        }
        finish = System.nanoTime();
        data[2][1] = Long.toString(finish - start);
        //Метод set для LinkedList
        start = System.nanoTime();
        for(int i=0; i<1000;i++)
        {
            linkedList.set(i, 0);
        }
        finish = System.nanoTime();
        data[2][2] = Long.toString(finish - start);

        //Метод remove для ArrayList
        start = System.nanoTime();
        for(int i=0; i<1000;i++)
        {
            arrayList.remove(0);
        }
        finish = System.nanoTime();
        data[3][1] = Long.toString(finish - start);
        //Метод remove для LinkedList
        start = System.nanoTime();
        for(int i=0; i<1000;i++)
        {
            linkedList.remove(0);
        }
        finish = System.nanoTime();
        data[3][2] = Long.toString(finish - start);
        */
        data[0][1] = testMethod(arrayList, 1000, "add");
        data[1][1] = testMethod(arrayList, 1000, "get");
        data[2][1] = testMethod(arrayList, 1000, "set");
        data[3][1] = testMethod(arrayList, 1000, "remove");
        data[0][2] = testMethod(linkedList, 1000, "add");
        data[1][2] = testMethod(linkedList, 1000, "get");
        data[2][2] = testMethod(linkedList, 1000, "set");
        data[3][2] = testMethod(linkedList, 1000, "remove");
        //Создание таблицы для предоставления результатов тестирования
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.getContentPane().add(scrollPane);
        frame.setPreferredSize(new Dimension(550, 300));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
