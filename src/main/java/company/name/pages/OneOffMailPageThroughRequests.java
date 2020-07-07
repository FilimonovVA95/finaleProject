package company.name.pages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Класс для работы с временной почтой. Все методы статические. Используются GET запросы. Доступно не более 5 ящиков
 * для одного пользователя одновременно. Время жизни одного ящика - 10 минут. Чтобы создавать еще ящики
 * удаляйте предыдущий с помощью метода deleteEmail() перед созданием нового
 * @author Филимонов Виктор
 */
public class OneOffMailPageThroughRequests {

    /**
     * Используемые переменные, адрес основного URL, время ожидания письма в секундах, адрес текущего почтового ящика,
     * ключ доступа к текущему почтовому ящику и пароль
     */
    private static String stringUrl = "https://post-shift.ru/api.php?";
    private static int timeWaitEmail = 60;
    private static String email;
    private static String keyEmail;
    private static String password;

    /**
     * Приватный конструктор. Запрещает создание экземпляров класса т.к. все методы статичные
     */
    private OneOffMailPageThroughRequests() {}

    /**
     * Возвращет строку адреса текущей почты или null если сейчас нет активной почты
     * @return строку адреса почты
     */
    public static String getEmail() { return email; }

    /**
     * Создает новую временную почту и возвращет строку адреса новой почты
     * @return строку адреса новой почты
     * @throws IOException используется класс URL
     */
    public static String getNewEmail() {
        URL urlToNewEmail;
        String[] stringWithEmail;

        try {
            urlToNewEmail = new URL(stringUrl + "action=new");
            stringWithEmail = getStringReturn(urlToNewEmail).split(" ");

            email = stringWithEmail[1].replace("Key:", "");
            keyEmail = stringWithEmail[2];
            password = null;
    }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("Getting mail exception");
    }
        System.out.println(email);
        System.out.println(keyEmail);

        return email;
    }

    /**
     * Возвращает пароль текущего ящика
     * @return возвращает строку с паролем для текущего почтового ящика
     */
    public static String getPassword() {
        if (password != null)
            return password;

        URL urlWaitPassword;
        try {
            urlWaitPassword = new URL(stringUrl + "action=getlist&key=" + keyEmail);

            for (int i = 0; i < timeWaitEmail; i ++) {
                String stringWithEmail = getStringReturn(urlWaitPassword);

                if(!stringWithEmail.equals("Error: The list is empty.")) { break; }

                System.out.println("Ожидание письма с паролем");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            URL UrlToPasswordByKey = new URL(stringUrl + "action=getmail&key=" + keyEmail + "&id=1&forced=1");

            String mailString = getStringReturn(UrlToPasswordByKey);
            String[] stringWithPassword = mailString.split("<p>");

            password = stringWithPassword[5].replace("</p>", "").split(" ")[1];
        }
        catch (IOException e) {
        e.printStackTrace();
        System.out.println("Getting password exception");
    }
        return password;
    }

    /**
     * Удаляет текущую используемую почту
     */
    public static void deleteEmail() {
        try{
            URL UrlToDeleteEmail = new URL(stringUrl + "action=delete&key=" + keyEmail);
            HttpURLConnection connection = (HttpURLConnection) UrlToDeleteEmail.openConnection();
            connection.setRequestMethod("GET");
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("Delete email exception");
        }
        email = null;
        keyEmail = null;
        password = null;
    }

    /**
     * Принимает URL GET запроса и возвращает строку ответа
     * @param url URL запроса для получения ответа
     * @return строку ответа на GET запрос
     */
    private static String getStringReturn (URL url) {
        String line;
        String result = "";
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(30000);
            connection.setDoOutput(true);

            BufferedReader bufferedReader = new BufferedReader((new InputStreamReader(connection.getInputStream())));

            while ((line = bufferedReader.readLine()) != null) {
                result += line;
            }
            bufferedReader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("Response from GET request exception");
        }
        return result;
    }
}
