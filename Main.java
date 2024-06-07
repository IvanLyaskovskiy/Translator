package com.lessons;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<String> spanishWords = new ArrayList<>();
    private static List<String> ukrainianWords = new ArrayList<>();

    public static void main(String[] args) {
        String filePath = "C:\\Users\\USER\\Desktop\\translator\\translation.txt";

        // Читаємо файл и заповнюємо списки
        readKeyValueFile(filePath, spanishWords, ukrainianWords);

        // Виводимо вміст списків для перевірки
        System.out.println("Spanish words: " + spanishWords);
        System.out.println("Ukrainian words: " + ukrainianWords);

        // Запускаємо тест
        Checker();
    }

    public static void readKeyValueFile(String filePath, List<String> spanishWords, List<String> ukrainianWords) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split("=", 2);
                if (parts.length == 2) {
                    spanishWords.add(parts[0]);
                    ukrainianWords.add(parts[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void Checker() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Тест на знання іспанської");

        for (int i = 0; i< spanishWords.size();i++) {
            System.out.println(spanishWords.get(i) + " - ");
            String rightAnswer = ukrainianWords.get(i);
            String userAnswer = scanner.nextLine();

            if (userAnswer.equals(rightAnswer)) {
                System.out.println("Ваша відповідь вірна!");
            } else {
                System.out.println("Ваша відповідь невірна. Правильна відповідь: " + rightAnswer);
            }
        }
    }
}
