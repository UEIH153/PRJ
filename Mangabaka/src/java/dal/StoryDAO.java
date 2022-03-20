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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            while (rs.next()) {
                Story story = new Story();
                story.setId(rs.getInt("id"));
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

    public ArrayList<Story> getAll(int pageIndex, int pageSize) {
        ArrayList<Story> storyList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM (SELECT [Story].[id], [Story].name,\n"
                    + " [Story].chapterAmount,[Story].status,[Story].link ,[Story].thumbnail \n"
                    + " ,ROW_NUMBER() OVER (ORDER BY [Story].[id] DESC) as row_index\n"
                    + " FROM [Story])  [story]\n"
                    + " WHERE row_index >= (? - 1) * ? + 1 AND row_index <= ? * ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, pageIndex);
            ps.setInt(2, pageSize);
            ps.setInt(3, pageIndex);
            ps.setInt(4, pageSize);
            rs = ps.executeQuery();
            while (rs.next()) {
                Story story = new Story();
                story.setId(rs.getInt("id"));
                story.setName(rs.getString("name"));
                story.setChapterAmount(rs.getInt("chapterAmount"));
                story.setStatus(rs.getString("status"));
                story.setLink(rs.getString("link"));
                story.setThumbnail(rs.getString("thumbnail"));
                storyList.add(story);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(StoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return storyList;
    }

    public int getSize() {
        String sql = "SELECT COUNT([Story].[id]) as 'size'  FROM [Story]";
        PreparedStatement statement = null;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int size = rs.getInt("size");
                return size;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(StoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public Story get(int id) {
        try {
            ArrayList<Story> storyList = new ArrayList<>();
            String sql = "SELECT * FROM [Story]"
                    + " where id = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Story story = new Story();
                story.setId(rs.getInt("id"));
                story.setName(rs.getString("name"));
                story.setChapterAmount(rs.getInt("chapterAmount"));
                story.setStatus(rs.getString("status"));
                story.setLink(rs.getString("link"));
                story.setThumbnail(rs.getString("thumbnail"));
                return story;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(StoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Story> getStorys(String search) {
        ArrayList<Story> storyList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM [Story]\n"
                    + " WHERE LOWER(name) LIKE LOWER(?)";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + search + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
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
        ArrayList<Story> list = getAll();
        for (Story s : list) {
            if (s.getName().equalsIgnoreCase(name)) {
                return s;
            }
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
                + "')\n";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
        } catch (Exception e) {

        }
    }

    public void UpdateStory(Story story) {
        String sql = "update Story\n"
                + "set\n"
                + "	name ='" + story.getName() + "',\n"
                + "	chapterAmount = " + story.getChapterAmount() + ",\n"
                + "	[status] = '" + story.getStatus() + "',\n"
                + "	link = '" + story.getLink() + "',\n"
                + "	thumbnail = '" + story.getThumbnail() + "'\n"
                + "where\n"
                + "	id = '" + story.getId() + "'";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
        } catch (Exception e) {
        }
    }

    public void UpdateStory(String currentName, Story story) {
        Story currentAccount = GetStory(currentName);
        String sql = "update Story\n"
                + "set\n"
                + "	name ='" + story.getName() + "',\n"
                + "	chapterAmount = " + story.getChapterAmount() + ",\n"
                + "	[status] = '" + story.getStatus() + "',\n"
                + "	link = '" + story.getLink() + "',\n"
                + "	thumbnail = '" + story.getThumbnail() + "'\n"
                + "where\n"
                + "	name = '" + currentName + "'";
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

    public static void main(String[] args) {
        StoryDAO db = new StoryDAO();

        ArrayList<Story> list = db.getAll();
        for (Story s : list) {
            System.out.println(s.getName());
        }
        System.out.println(db.GetStory("Naruto"));
    }
}
