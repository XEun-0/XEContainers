package DAO;

import Model.Message;

import Util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MessageDAO implements MessageDaoInterface{

    public List<Message> getAllMessages() {
        List<Message> messages = new ArrayList<>();
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM message";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                //append to the array list all that found
                messages.add(new Message(
                    rs.getInt("message_id"),
                    rs.getInt("posted_by"),
                    rs.getString("message_text"),
                    rs.getLong("time_posted_epoch")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return messages;
    }

    @Override
    public List<Message> getUserMessages(int posted_by) {
        List<Message> messages = new ArrayList<>();
        try (Connection conn = ConnectionUtil.getConnection()) {
            // select the posted by a user querry
            String sql = ("SELECT * FROM message WHERE posted_by= ? ");
            PreparedStatement ps = conn.prepareStatement(sql);
            // get the posted by a user to look up 
            ps.setInt(1, posted_by);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                //append to the message array list all that found 
                messages.add(new Message(
                    rs.getInt("message_id"),
                    rs.getInt("posted_by"),
                    rs.getString("message_text"),
                    rs.getLong("time_posted_epoch")));
                }
            }
            catch(Exception e){
                e.printStackTrace();
        }
        //return empty message list 
        return messages;
    }

    @Override
    public Message searchSMSByID(int message_id) {  
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = (" SELECT * FROM message WHERE message_id= ? ");
            PreparedStatement ps = conn.prepareStatement(sql);
            // set up the parameter for user input 
            ps.setInt(1,message_id);
            ResultSet rs= ps.executeQuery();
            if (rs.next()){
                // set up the single found message by id 
                Message message = new Message(
                rs.getInt("message_id"),
                rs.getInt("posted_by"),
                rs.getString("message_text"),
                rs.getLong("time_posted_epoch")
                );
                return message;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        //return null if none found
        return null;
    }

    @Override
    public Message deleteSMSByID(int messageId) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            Message toDelete = searchSMSByID(messageId); // Get it before deleting
            if (toDelete == null) return null;

            String sql = "DELETE FROM message WHERE message_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, messageId);
            int deleted = ps.executeUpdate();

            if (deleted > 0) {
                return toDelete; // Return the deleted message
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Message updateSMSByID(int message_id, String message_updated) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            // update querry 
            String sql = "UPDATE message SET message_text = ? WHERE message_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            // set up the parameter for user input 
            ps.setInt(1, message_id);
            ps.setString(2, message_updated);
            int updated = ps.executeUpdate();
            if (updated > 0) {
                // Fetch and return updated message
                String fetchSql = "SELECT * FROM message WHERE message_id = ?";
                PreparedStatement fetchPs = conn.prepareStatement(fetchSql);
                fetchPs.setInt(1, message_id);
                ResultSet rs = fetchPs.executeQuery();
                if (rs.next()) {
                    return new Message(
                        rs.getInt("message_id"),
                        rs.getInt("posted_by"),
                        rs.getString("message_text"),
                        rs.getLong("time_posted_epoch")
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Message createMessage(Message message) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "INSERT INTO message (posted_by, message_text, time_posted_epoch) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            // If the client didn't provide a timestamp (or it is zero), default to current time
            long timestamp = message.getTime_posted_epoch();
            if (timestamp == 0) {
                timestamp = System.currentTimeMillis();
                message.setTime_posted_epoch(timestamp);
            }

            ps.setInt(1, message.getPosted_by());
            ps.setString(2, message.getMessage_text());
            // Instead of setting time_posted_epoch to current time:
            ps.setLong(3, message.getTime_posted_epoch());


            int newRow = ps.executeUpdate();
            if (newRow > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    message.setMessage_id(rs.getInt(1));
                    return message;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
