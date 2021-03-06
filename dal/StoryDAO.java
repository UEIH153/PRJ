/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import Entity.Account;
import Entity.Story;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author tinht
 */
public class StoryDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public ArrayList<Story> getAll() {
        ArrayList<Story> storyList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM [Story]";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next())
            {
                Story story = new Story();
                story.setName(rs.getString("name"));
                story.setChapterAmount(rs.getInt("chapterAmount"));
                story.setStatus(rs.getString("status"));
                story.setLink(rs.getString("link"));
                story.setThumbnail(rs.getString("thumbnail"));
                storyList.add(story);
            }
        } catch (Exception ex) {
            
        }
        return storyList;
    }
    
    public Story GetStory(String name) {
        String sql = "select * from Story\n"
                + "where [name] = ?\n";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();
            while (rs.next()) {                
                return new Story(rs.getString("name"), 
                        rs.getInt("chapterAmount"), 
                        rs.getString("status"), 
                        rs.getString("link"),
                        rs.getString("thumbnail"),
                        rs.getString("author"));
            }
        } catch (Exception e) {
        }
        
        return null;
    }
    
    public void CreateStory(Story story) {
        String sql = "insert into Story\n" 
                    + "values ('" + story.getName()
                + "', '" + story.getChapterAmount()
                + "', '" + story.getStatus()
                + "', '" + story.getLink()
                + "', '" + story.getThumbnail()
                + "', '" + story.getAuthor()
                + "')\n";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
        } catch (Exception e) {
            
        }
    }
    
    public void UpdateStory(String currentName ,Story story) {
        Story currentAccount = GetStory(currentName);
        String sql = "update Story\n" +
                "set\n" +
                "	name ='" + story.getName() + "',\n" +
                "	chapterAmount = " + story.getChapterAmount()+ ",\n" +
                "	[status] = '" + story.getStatus()+ "',\n" +
                "	link = '" + story.getLink()+ "',\n" +
                "	thumbnail = '" + story.getThumbnail()+ "'\n" +
                "where\n" +
                "	name = '" + currentName + "'";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
        } catch (Exception e) {
        }
    }
    
    public void DeleteStory(Story story) {
        String sql = "delete from Story where( name = '" + story.getName() + "')";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
        } catch (Exception e) {
        }
    }
    
    public void DeleteStoryByName(String name) {
        String sql = "delete from Story where( name = '" + name + "')";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
        } catch (Exception e) {
        }
    }
}
