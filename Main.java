package com.company;
import java.util.Objects;

public class Main {

    public static boolean isChar (char[] array, char element) {
        if (Objects.isNull(array)) return false;
        for (int i = 0; i < array.length; i++)
            if (array[i] == element) return true;
        return false;
    }

    public static String removeLastChar(String s) {
        return (s == null || s.length() == 0) ? null : (s.substring(0, s.length() - 1));
    }

    public static int number_of_words_deleted(String lhs, String rhs) {
        lhs = lhs.trim();
        rhs = rhs.trim();
        int k_lhs = 1;
        int k_rhs = 1;
        for (int i = 0; i < lhs.length(); i++) {
            if (lhs.charAt(i) == ' ') k_lhs++;
        }
        for (int i = 0; i < rhs.length(); i++) {
            if (rhs.charAt(i) == ' ') k_rhs++;
        }
        return k_lhs - k_rhs;
    }

    public static String deleteWords (String str, boolean flag) {
        char[] vowels = {'а', 'у', 'о', 'ы', 'э',
                'е', 'ё', 'и', 'ю', 'я', 'А', 'У',
                'О', 'Ы', 'Э', 'Е', 'Ё', 'И', 'Ю',
                'Я'}; //flag == true
        char[] consonants = {'б', 'в', 'г', 'д',
                'ж', 'з', 'й', 'к', 'л',
                'м', 'н', 'п', 'р', 'с',
                'т', 'ф', 'х', 'ц', 'ч',
                'ш', 'щ', 'Б', 'В', 'Г', 'Д',
                'Ж', 'З', 'Й', 'К', 'Л',
                'М', 'Н', 'П', 'Р', 'С',
                'Т', 'Ф', 'Х', 'Ц', 'Ч',
                'Ш', 'Щ'}; //flag == false
        str = str.trim();
        String result = "";

        if (flag) {
            boolean flag_isWord = false;
            for (int i = 0; i < str.length(); i++) {
                if (i == 0) {
                    if (isChar(vowels, str.charAt(i))) {
                        for (int j = i; j < str.length(); j++) {
                            if (str.charAt(j) == ' ') break;
                            result += str.charAt(j);
                            flag_isWord = true;
                        }
                    }
                }
                else {
                    if (str.charAt(i) == ' ') {
                        if (isChar(vowels, str.charAt(i + 1))) {
                            int j;
                            for (j = i; j < str.length() - 1; j++) {
                                if (str.charAt(j + 1) == ' ') break;
                                result += str.charAt(j + 1);
                                flag_isWord = true;
                            }
                        }
                    }
                }
                if (flag_isWord) {
                    result += ' ';
                    flag_isWord = false;
                }
            }
        }
        else {
            boolean flag_isWord = false;
            for (int i = 0; i < str.length(); i++) {
                if (i == 0) {
                    if (isChar(consonants, str.charAt(i))) {
                        for (int j = i; j < str.length(); j++) {
                            if (str.charAt(j) == ' ') break;
                            result += str.charAt(j);
                            flag_isWord = true;
                        }
                    }
                }
                else {
                    if (str.charAt(i) == ' ') {
                        if (isChar(consonants, str.charAt(i + 1))) {
                            int j;
                            for (j = i; j < str.length() - 1; j++) {
                                if (str.charAt(j + 1) == ' ') break;
                                result += str.charAt(j + 1);
                                flag_isWord = true;
                            }
                        }
                    }
                }
                if (flag_isWord) {
                    result += ' ';
                    flag_isWord = false;
                }
            }
        }
        result = removeLastChar(result);
        return result;
    }

    public static void main(String[] args) {
        String strl = "апельсин год алмаз человек яблоко время дело иголка ель яма шапка";
        boolean p = false;
        String strl2 = deleteWords(strl, p);
        System.out.print(strl + "\n");
        System.out.print(strl2+ "\n");
        double k = number_of_words_deleted(strl, strl2);
        double y = Math.sqrt((strl.length() * k)/(k * k));
        System.out.print("y = " + y);
    }
}
