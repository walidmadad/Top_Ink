/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controleur;

import DAO.Singleton;
import java.sql.*;

/**
 *
 * @author walid
 */
public class SupprimerImprimante {
    Singleton conn = new Singleton();
    Connection connection = conn.getConnexion();
    private int id;
    public SupprimerImprimante(String ref){
        try{
            String sql = "SELECT id_imprimante FROM modele_imprimante WHERE reference = ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, ref);
           ResultSet result = statement.executeQuery();
           if (result.next()) {

            id = result.getInt("id_imprimante");
            System.out.println(id);
        } else {

            System.out.println("Aucun enregistrement trouvé pour la référence : " + ref);
        }
           result.close();
           statement.close();
           if (id != -1) {
            String deleteSql = "DELETE FROM modele_imprimante WHERE id_imprimante = ?";
            PreparedStatement deleteStatement = connection.prepareStatement(deleteSql);
            deleteStatement.setInt(1, id);
            deleteStatement.executeUpdate();
            deleteStatement.close();
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }  
        
    }
    
}
