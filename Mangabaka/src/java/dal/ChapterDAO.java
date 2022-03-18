/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import Entity.Chapter;
import Entity.Story;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author tinht
 */
public class ChapterDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public Chapter GetChapter(String name, int chapter) {
        String sql = "select * from Chapter\n"
                + "where [name] = ? and chapter = ? \n";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, chapter);
            rs = ps.executeQuery();
            while (rs.next()) {                
                return new Chapter(rs.getString("name"), 
                        rs.getInt("chapter"), 
                        rs.getInt("pageAmount"));
            }
        } catch (Exception e) {
        }
        
        return null;
    }
    
    public void DeleteChapter(Chapter chapter) {
        String sql = "delete from Chapter where( name = '"+ chapter.getName() + "' and chapter =" + chapter.getChapter()+ ")";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
        } catch (Exception e) {
        }
    }
    
    public void UpdateChapter(String currentName ,Chapter chapter) {
        //Chapter currentAccount = GetChapter(currentName, chapter.getChapter());
        String sql = "update Chapter\n" +
                "set\n" +
                "	name ='" + chapter.getName() + "',\n" +
                "	chapter = " + chapter.getChapter()+ ",\n" +
                "	pageAmount = '" + chapter.getPageAmount()+ "'\n" +
                "where\n" +
                "	name = '" + currentName + "'";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
        } catch (Exception e) {
        }
    }
    
    public void CreateChapter(Chapter chapter) {
        Chapter chap = GetChapter(chapter.getName(), chapter.getChapter());
        if(chap == null && chapter.getName() != null) {
            StoryDAO storyDB = new StoryDAO();
            Story story = storyDB.GetStory(chapter.getName());
            
            Story newStory = new Story(story.getName(), story.getChapterAmount() + 1, 
                    story.getStatus(), story.getLink(), story.getThumbnail(), story.getAuthor());
            
            storyDB.UpdateStory(story.getName(), newStory);
            
            String sql = "insert into Chapter\n" 
                        + "values ('" + chapter.getName()
                    + "', " + chapter.getChapter()
                    + ", " + chapter.getPageAmount()
                    + ")\n";
            try {
                conn = new DBContext().getConnection();
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
            } catch (Exception e) {

            }
        }
        else
        {
            UpdateChapter(chapter.getName(), chapter);
        }
    }
    
    public static void main(String[] args) {
        ChapterDAO db = new ChapterDAO();
//        db.CreateChapter(new Chapter("Naruto", 1, 1));
        
        StoryDAO storyDB = new StoryDAO();
        Story story = storyDB.GetStory("Naruto");
        System.out.println(story.getName());
    }
    
}
