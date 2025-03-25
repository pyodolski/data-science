package My_project.Web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.*;

public class PageDownLoadTask implements Runnable {
    private String url;
    private BlockingQueue<String> queue;

    public PageDownLoadTask(String url, BlockingQueue<String> queue) {
        this.url = url;
        this.queue =queue;

    }

    @Override
    public void run() {
        try {
            URLConnection connection = new URL(url).openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder content =new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
            queue.put(content.toString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
class PageAnalysisTask implements Runnable{
    private BlockingQueue<String> queue;

    public PageAnalysisTask(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            String content = queue.take();
            System.out.println("analysis web page: " + content);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

class AppUI {
    public static void main(String[] args) {
        int num_thread = 4;
        String[] urls = {"https://www.daegu.ac.kr/main"};
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();

        ExecutorService service = Executors.newFixedThreadPool(num_thread);

        for (var url : urls) {
            service.execute(new PageDownLoadTask(url, queue));
        }
        for (int i = 0; i < num_thread; i++) {
            service.execute(new PageAnalysisTask(queue));
        }
        service.shutdown();
        System.out.println("Main thread end..............");
    }
}

