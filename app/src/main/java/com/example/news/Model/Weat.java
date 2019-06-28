package com.example.news.Model;

public class Weat  {
public  String todayHeat;
public String highHeat;
public String lowHeat;
public String preesHeat;
private String description;
public String speed;
public String cloud;
    public Weat(String todayHeat ,String highHeat ,String lowHeat ,String preesHeat ,String speed,String cloud,String description) {
        this.todayHeat = todayHeat;
        this.highHeat=highHeat;
        this.lowHeat=lowHeat;
        this.preesHeat=preesHeat;
        this.speed=speed;
        this.cloud=cloud;
        this.description=description;
    }

    public String getTodayHeat() {
        return todayHeat;
    }

    public void setTodayHeat(String todayHeat) {
        this.todayHeat = todayHeat;
    }

    public String getHighHeat() {
        return highHeat;
    }

    public void setHighHeat(String highHeat) {
        this.highHeat = highHeat;
    }

    public String getLowHeat() {
        return lowHeat;
    }

    public void setLowHeat(String lowHeat) {
        this.lowHeat = lowHeat;
    }

    public String getPreesHeat() {
        return preesHeat;
    }

    public void setPreesHeat(String preesHeat) {
        this.preesHeat = preesHeat;
    }


    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getCloud() {
        return cloud;
    }

    public void setCloud(String cloud) {
        this.cloud = cloud;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
