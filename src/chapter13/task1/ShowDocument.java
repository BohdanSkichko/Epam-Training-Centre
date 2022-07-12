package chapter13.task1;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import javax.swing.JApplet;

public class ShowDocument extends JApplet {
    private URL bsu = null;
    public String getBaseURL() {
        return "http://www.bsu.by";
    }
    public void paint(Graphics g) {
        int timer = 0;
        g.drawString("Загрузка страницы", 10, 10);
        try {
            for (; timer < 30; timer++) {
                g.drawString(".", 10 + timer * 5, 25);
                Thread.sleep(100);
            }
            bsu = new URL(getBaseURL());
            this.getAppletContext().showDocument(bsu, "_blank");
        } catch (InterruptedException | MalformedURLException e) {
            e.printStackTrace();
        }

    }
    public static class ReadDocument {
        public static void main(String[] args) {
            URL bsu = null;
            String urlName = "http://www.bsu.by";
            try {
                bsu = new URL(urlName);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            if (bsu == null) {
                throw new RuntimeException();
            }
            try (BufferedReader d = new BufferedReader(new InputStreamReader(
                    bsu.openStream()))) {
                String line = "";
                while ((line = d.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}