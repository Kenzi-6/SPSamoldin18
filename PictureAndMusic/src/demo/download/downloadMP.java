package demo.download;

import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class downloadMP {

    private static final String IN_FILE_TXT = "src\\demo\\download\\inFile.txt";

    public static void main(String[] args) {
        try (BufferedReader textFile = new BufferedReader(new FileReader(IN_FILE_TXT))) {
            String str;
            int count = 1;
            try {
                while ((str = textFile.readLine()) != null) {
                    String[] mas = str.split(" "); // разделение строки на Url и путь
                    for (int i = 1; i < 2; i++){
                        String Url = mas[0]; // ссылка на скачивание
                        String Path = mas[1]; // путь к файлу
                        downloadUsingNIO(Url, Path); // загрузка
                        System.out.println("Скачивание " + count +" файла завершено");
                        count++;
                    }

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileInputStream inputStream = new FileInputStream("src\\demo\\download\\music.mp3")) {
            try {
                Player player = new Player(inputStream);
                player.play();
            } catch (JavaLayerException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void downloadUsingNIO(String strUrl, String file) throws IOException {
        URL url = new URL(strUrl);
        ReadableByteChannel byteChannel = Channels.newChannel(url.openStream());
        FileOutputStream stream = new FileOutputStream(file);
        stream.getChannel().transferFrom(byteChannel, 0, Long.MAX_VALUE);
        stream.close();
        byteChannel.close();
    }
}