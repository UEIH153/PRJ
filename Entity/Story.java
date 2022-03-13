/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author tinht
 */
public class Story {
    int chapterAmount;
    String name, status, link, thumbnail, author;

    public Story() {
    }

    public Story(String name, int chapterAmount, String status, String link, String thumbnail, String author) {
        this.chapterAmount = chapterAmount;
        this.name = name;
        this.status = status;
        this.link = link;
        this.thumbnail = thumbnail;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
    
    public int getChapterAmount() {
        return chapterAmount;
    }

    public String getLink() {
        return link;
    }

    public void setChapterAmount(int chapterAmount) {
        this.chapterAmount = chapterAmount;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
