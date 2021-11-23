package pic.downloadpictures;

import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class Main {

    private static final String PATH_TO_PICTURE = "src\\pic\\downloadpictures\\picture.jpg";

    public static void main(String[] args) throws IOException {
        URL url = new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/2/29/FIM_Motocross_World_" +
                "Championship_2012.jpg/800px-FIM_Motocross_World_Championship_2012.jpg");
        ReadableByteChannel byteChannel = Channels.newChannel(url.openStream());
        FileOutputStream stream = new FileOutputStream(PATH_TO_PICTURE);
        stream.getChannel().transferFrom(byteChannel, 0, Long.MAX_VALUE);
        stream.close();
        byteChannel.close();
    }
}