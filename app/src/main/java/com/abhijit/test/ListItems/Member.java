package com.abhijit.test.ListItems;

/**
 * Created by abhijit on 3/5/17.
 */

public class Member {

    String name;
    String time;
    String desc;
    int photoID;

    public Member(String name, String time, String desc, int photoID) {
        this.name = name;
        this.time = time;
        this.desc = desc;
        this.photoID = photoID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPhotoID() {
        return photoID;
    }

    public void setPhotoID(int photoID) {
        this.photoID = photoID;
    }
}