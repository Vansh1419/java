package design_pattern.structural.proxy;

/*
// ========== RealVideoDownloader Class ==========
class RealVideoDownloader {
    public String downloadVideo(String videoUrl) {
        // caching logic missing
        // filtering logic missing
        // access logic missing
        System.out.println("Downloading video from URL: " + videoUrl);
        String content = "Video content from " + videoUrl;
        System.out.println("Downloaded Content: " + content);
        return content;
    }
}
 */

import java.util.HashMap;
import java.util.Map;

interface VideoDownloader{
    String downloadVideo(String videoUrl);
}


// ========== RealVideoDownloader Class ==========
class RealVideoDownloader implements VideoDownloader {

    @Override
    public String downloadVideo(String videoUrl) {
        System.out.println("Downloading video from URL: " + videoUrl);
        return "Video content from " + videoUrl;
    }
}

// =============== Proxy With Cache ====================
class CachedVideoDownloader implements VideoDownloader {

    private RealVideoDownloader realDownloader;
    private Map<String, String> cache;

    public CachedVideoDownloader() {
        this.realDownloader = new RealVideoDownloader();
        this.cache = new HashMap<>();
    }

    @Override
    public String downloadVideo(String videoUrl) {
        if (cache.containsKey(videoUrl)) {
            System.out.println("Returning cached video for: " + videoUrl);
            return cache.get(videoUrl);
        }

        System.out.println("Cache miss. Downloading...");
        String video = realDownloader.downloadVideo(videoUrl);
        cache.put(videoUrl, video);
        return video;
    }
}


public class Main {
    public static void main(String[] args) {
       /*
        RealVideoDownloader realVideoDownloader = new RealVideoDownloader();
        realVideoDownloader.downloadVideo("testUrl");

        RealVideoDownloader realVideoDownloader2 = new RealVideoDownloader();
        realVideoDownloader2.downloadVideo("testUrl");
        */

        VideoDownloader cachedVideoDownloader = new CachedVideoDownloader();
        cachedVideoDownloader.downloadVideo("proxy-pattern");

        VideoDownloader cachedVideoDownloader2 = new CachedVideoDownloader();
        cachedVideoDownloader2.downloadVideo("proxy-pattern");

    }
}
