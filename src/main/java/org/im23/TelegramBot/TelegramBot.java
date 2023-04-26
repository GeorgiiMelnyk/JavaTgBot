package org.im23.TelegramBot;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;
import java.util.Scanner;

public class TelegramBot {
    static String botToken = "6062859401:AAG74nVt9vJLJYxm44P52NelVNJqbGNKDWA";
    static String chatId = "508340152";
    public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int choice = sc.nextInt();
    //sc.close();
        System.out.println(choice);
    if (choice == 1) {
        System.out.println(choice);

        String message = "yo";
        String urlString = String.format("https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s", botToken, chatId, message);
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        int responseCode = conn.getResponseCode();
        if (responseCode != 200) {
            System.out.println("Error sending message to Telegram chat: " + responseCode);
        }
        Scanner scanner = new Scanner(conn.getInputStream());
        while (scanner.hasNext()) {
            System.out.println(scanner.nextLine());
        }
        scanner.close();
    } else if (choice == 2){
        System.out.println(choice);
        String urlString = String.format("https://api.telegram.org/bot%s/getUpdates", botToken);
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        InputStream stream = conn.getInputStream();
        Scanner scanner = new Scanner(stream);
        String responseBody = scanner.useDelimiter("\\A").next();
        scanner.close();
        conn.disconnect();
        System.out.println(responseBody);

    }
    }
}
/*import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class TelegramBot {
    public static void main(String[] args) throws IOException {
        String botToken = "6062859401:AAG74nVt9vJLJYxm44P52NelVNJqbGNKDWA";
        String urlString = String.format("https://api.telegram.org/bot%s/getUpdates", botToken);
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        InputStream stream = conn.getInputStream();
        Scanner scanner = new Scanner(stream);
        String responseBody = scanner.useDelimiter("\\A").next();
        scanner.close();
        conn.disconnect();
        System.out.println(responseBody);


    }
}*/