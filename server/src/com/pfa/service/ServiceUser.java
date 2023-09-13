package com.pfa.service;

import com.pfa.connection.DatabaseConnection;
import com.pfa.model.Model_Client;
import com.pfa.model.Model_Login;
import com.pfa.model.Model_Message;
import com.pfa.model.Model_Register;
import com.pfa.model.Model_User_Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ServiceUser {

    public ServiceUser() {
        this.con = DatabaseConnection.getInstance().getConnection();
    }

    public Model_Message register(Model_Register data) {
        //  Check user exit
        Model_Message message = new Model_Message();

        try {
            con.setAutoCommit(false);

            String query = "SELECT COUNT(*) FROM user WHERE UserName = ?";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, data.getUserName());
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);
            resultSet.close();
            if (count == 0) {
                String insertQuery;
                insertQuery = "INSERT IGNORE INTO user (UserName, Password) VALUES   (?, ?)";

                PreparedStatement insertStatement = con.prepareStatement(insertQuery, PreparedStatement.RETURN_GENERATED_KEYS);
                insertStatement.setString(1, data.getUserName());
                insertStatement.setString(2, data.getPassword());
                insertStatement.executeUpdate();
                ResultSet r = insertStatement.getGeneratedKeys();
                r.first();
                int userID = r.getInt(1);
                r.close();

                String iQuery = "INSERT IGNORE INTO user_account (UserID,UserName) VALUES   (?, ?)";
                try (PreparedStatement insertAccStatement = con.prepareStatement(iQuery)) {
                    insertAccStatement.setInt(1, userID);
                    insertAccStatement.setString(2, data.getUserName());
                    insertAccStatement.executeUpdate();
                    insertAccStatement.close();
                }
                con.commit();
                con.setAutoCommit(true);
                message.setAction(true);
                message.setMessage("Utilisateur inséré avec succès.");
                message.setData(new Model_User_Account(userID, data.getUserName(), "", "", true));

            } else {
                message.setAction(false);
                message.setMessage("L'utilisateur existe déjà.");
            }

        } catch (SQLException e) {
            message.setAction(false);
            message.setMessage("Erreur du serveur.");
            try {
                if (con.getAutoCommit() == false) {
                    con.rollback();
                    con.setAutoCommit(true);
                }
            } catch (SQLException e1) {

            }
        }
        return message;
    }
//select UserID, `chat_application`.`user_account`.UserName, Gender, ImageString from `chat_application`.`user` join `chat_application`.`user_account` using (UserID) where `chat_application`.`user`.UserName = BINARY(?) and `chat_application`.`user`.Password = BINARY(?) and `chat_application`.`user_account`.Status = '1'

    public Model_User_Account Login(Model_Login login) throws SQLException {
        Model_User_Account data = null;
        PreparedStatement p;
        p = con.prepareStatement("select UserID, user_account.UserName, Gender, ImageString from user join user_account using (UserID) where user.UserName = BINARY(?) and user.Password = BINARY(?) and user_account.Status = '1'");
        p.setString(1, login.getUserName());
        p.setString(2, login.getPassword());
        ResultSet r = p.executeQuery();
        if (r.next()) {
            int userID = r.getInt(1);
            String userName = r.getString(2);
            String gender = r.getString(3);
            String image = r.getString(4);
            data = new Model_User_Account(userID, userName, gender, image, true);
        }
        r.close();
        p.close();
        return data;
    }

    public List<Model_User_Account> getUser(int exitUser) throws SQLException {
        List<Model_User_Account> list = new ArrayList<>();
        PreparedStatement p;
        p = con.prepareStatement("SELECT UserID, UserName, Gender, ImageString FROM user_account where user_account.`Status` = '1' and UserID<> ?");
        p.setInt(1, exitUser);
        ResultSet r = p.executeQuery();
        while (r.next()) {
            int UserID = r.getInt(1);
            String userName = r.getString(2);
            String gender = r.getString(3);
            String image = r.getString(4);

            list.add(new Model_User_Account(UserID, userName, gender, image, checkUserStatus(UserID)));
        }
        r.close();
        p.close();
        return list;
    }

    private boolean checkUserStatus(int userID){
        List<Model_Client> clients = Service.getInstance(null).getListClient();
        for(Model_Client c : clients){
            if(c.getUser().getUserID() ==userID){
                return true;
            }
        }
        return false;
    }
    private final Connection con;
}
