package chapter7.task8;
//Удалить из текста его часть, заключенную между двумя символами, которые вво-
//дятся (например, между скобками «(» и «)» или между звездочками «*» и т. п.).

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

public class Text {
    public String deleteTextBetweenCharset(String[] text) {
        String letter = String.join("", text);
        String s = letter.replaceAll("[/{/</(/*].*?[/}/(/>/*]", "");
        String deleteSpace = s.replaceAll("\\s\\,+",",");
        return deleteSpace.trim();
    }

    public static void main(String[] args) {
        String[] s = {"some text {12j},,{1 2  j}, faf121_ asaasmk *q1 ffa3* a2324<3234>, <12 s>o{mete}xt2"};
        Text text = new Text();
        System.out.println(text.deleteTextBetweenCharset(s));
    }
}
