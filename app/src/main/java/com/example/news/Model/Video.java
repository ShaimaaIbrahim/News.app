package com.example.news.Model;

public class Video {
    private String Video_title;
    private String Video_link;


    public Video(String Video_link ) {
        this.Video_link=Video_link;
     //   this.Video_title=Video_title;



    }

    public String getVideo_link() {
        return Video_link;
    }

    public Video setVideo_link(String video_link) {
        Video_link = video_link;
        return this;
    }

    public String getVideo_title() {
        return Video_title;
    }

    public Video setVideo_title(String video_title) {
        Video_title = video_title;
        return this;
    }
}
