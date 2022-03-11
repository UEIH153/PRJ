/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import Entity.*;
import java.util.ArrayList;

/**
 *
 * @author tinht
 */
public class main {
    public static void main(String[] args) {
        AccountDAO db = new AccountDAO();
        StoryDAO storydb = new StoryDAO();
        ChapterDAO chapterdb = new ChapterDAO();
        Account acc = new Account(0, "tinhtinh", "1111", "ke", "sa", "normal");
        Chapter chap = new Chapter(null, 0, 0);
        //Story story = new Story("Naruto", 1, "abc", "Resource/Story/Naruto", "Resource/Thumbnail/naruto.jpg");
        //for(Account a : acc) 
            //System.out.println(acc.getUsername());
       //storydb.DeleteStoryByName("Narutoo");
       //storydb.UpdateStory("Na", story);
       //chapterdb.CreateChapter(chap);
       
//        Chapter getchapter = chapterdb.GetChapter("Bleach", 3);
//        if(getchapter == null)
            //chapterdb.CreateChapter(chap);
//        else
//            chapterdb.UpdateChapter("Bleach", chap);
       chapterdb.DeleteChapter(chap);
        //System.out.println(chapterdb.GetChapter("Bleach").getName()+ chapterdb.GetChapter("Bleach").getChapter()+ chapterdb.GetChapter("Bleach").getPageAmount());
    }
}
