package 多线程.leetcode1242;

import java.util.*;
import java.util.concurrent.*;

interface HtmlParser {
    List<String> getUrls(String url);
}

public class WebCrawler {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        String host = getHostName(startUrl);
        Set<String> visited = ConcurrentHashMap.newKeySet();
        Queue<String> queue = new ConcurrentLinkedQueue<>();
        visited.add(startUrl);
        queue.offer(startUrl);
        ExecutorService executor = Executors.newFixedThreadPool(8);
        List<Future<?>> futures = new ArrayList<>();
        while (!queue.isEmpty()) {
            String url = queue.poll();
            futures.add(executor.submit(() -> {
                for (String next : htmlParser.getUrls(url)) {
                    if (getHostName(next).equals(host) && visited.add(next)) {
                        queue.offer(next);
                    }
                }
            }));
        }
        for (Future<?> f : futures) {
            try { f.get(); } catch (Exception ignored) {}
        }
        executor.shutdown();
        return new ArrayList<>(visited);
    }
    private String getHostName(String url) {
        String[] parts = url.split("/");
        return parts[2];
    }

    public static void main(String[] args) {
        HtmlParser parser = new HtmlParser() {
            @Override
            public List<String> getUrls(String url) {
                if (url.equals("http://a.com")) return Arrays.asList("http://a.com/b", "http://a.com/c");
                if (url.equals("http://a.com/b")) return Arrays.asList("http://a.com");
                return Collections.emptyList();
            }
        };
        WebCrawler crawler = new WebCrawler();
        List<String> result = crawler.crawl("http://a.com", parser);
        System.out.println(result);
    }
} 