/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controleur;

import DAO.Singleton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author walid
 */
public class Ajouter_Imprimante {
    Singleton conn = new Singleton();
    Connection connection = conn.getConnexion();
    
    public Ajouter_Imprimante(String ref, String marque, String modele){
        try{
            String sql = "INSERT INTO modele_imprimante(reference, marque, modele) VALUES( ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, ref);
            statement.setString(2, marque);
            statement.setString(3, modele);
            statement.executeUpdate();
            statement.close();
        }catch(SQLException e){
             e.printStackTrace();
        }
        
    }
}
