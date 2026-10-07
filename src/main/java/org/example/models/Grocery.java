package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {

    public static ArrayList<String> groceryList = new ArrayList<>();

    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);

        // Kullanıcı 0 girene kadar programın açık kalması için sonsuz döngü
        while (true) {
            System.out.println("\n0: Çıkış | 1: Eleman Ekle | 2: Eleman Çıkar");
            System.out.print("Seçiminiz: ");

            // nextInt() yerine nextLine() kullanarak \n kaynaklı atlama hatasını engelliyoruz
            String secim = scanner.nextLine().trim();

            if (secim.equals("0")) {
                System.out.println("Uygulama kapatılıyor...");
                break;
            } else if (secim.equals("1")) {
                System.out.println("Eklenmesini istediğiniz elemanları giriniz (örn: tomato veya tomato, orange, peach):");
                String input = scanner.nextLine();
                addItems(input);
            } else if (secim.equals("2")) {
                System.out.println("Çıkarılmasını istediğiniz elemanları giriniz (örn: tomato veya tomato, orange, peach):");
                String input = scanner.nextLine();
                removeItems(input);
            } else {
                System.out.println("Geçersiz seçim! Lütfen 0, 1 veya 2 giriniz.");
            }
        }

        scanner.close();
    }

    public static void addItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String trimmed = item.trim();
            if (!trimmed.isEmpty()) {
                // Listede yoksa ekle, varsa uyar
                if (!checkItemIsInList(trimmed)) {
                    groceryList.add(trimmed);
                } else {
                    System.out.println("'" + trimmed + "' zaten listede var.");
                }
            }
        }
        printSorted();
    }

    public static void removeItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String trimmed = item.trim();
            if (!trimmed.isEmpty()) {
                // Listede varsa sil, yoksa uyar
                if (checkItemIsInList(trimmed)) {
                    groceryList.remove(trimmed);
                } else {
                    System.out.println("'" + trimmed + "' listede bulunamadı.");
                }
            }
        }
        printSorted();
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    public static void printSorted() {
        Collections.sort(groceryList);
        System.out.println("Mevcut Liste: " + groceryList);
    }
}