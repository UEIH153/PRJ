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
public class Chapter {
    String name;
    int chapter, pageAmount;

    public Chapter() {
    }

    public Chapter(String name, int chapter, int pageAmount) {
        this.name = name;
        this.chapter = chapter;
        this.pageAmount = pageAmount;
    }

    public String getName() {
        return name;
    }

    public int getChapter() {
        return chapter;
    }

    public int getPageAmount() {
        return pageAmount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setChapter(int chapter) {
        this.chapter = chapter;
    }

    public void setPageAmount(int pageAmount) {
        this.pageAmount = pageAmount;
    }
    
    
}
