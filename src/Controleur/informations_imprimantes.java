/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controleur;
import Modele.Modele_imprimante;
import DAO.Singleton;
import java.sql.*;

/**
 *
 * @author walid
 */
public class informations_imprimantes {
    Singleton conn = new Singleton();
    Connection connection = conn.getConnexion();
    private int id;
    private String marque = null;
    private String modele = null;
    private String ref = null;
    Modele_imprimante imp;
    
    public void idFromDataBase(String reference){
        
        try{
            String sql = "SELECT id_imprimante FROM modele_imprimante WHERE reference = ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, reference);
           ResultSet result = statement.executeQuery();
           if (result.next()) {

            id = result.getInt("id_imprimante");
            System.out.println(id);
        } else {

            System.out.println("Aucun enregistrement trouvé pour la référence : " + reference);
        }
           result.close();
           statement.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }        
    }    
    public void marqueFromDataBase(){
        
        try{
            String sql = "SELECT marque FROM modele_imprimante WHERE id_imprimante = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                marque = result.getString("marque");
                imp.setMarque(marque);
            } else {

    System.out.println("Aucun enregistrement trouvé pour l'id_imprimante : " + id);
}
            result.close();
            ps.close();
            
        }catch(SQLException e){
            e.printStackTrace();            
        }       
    }
    
    public void modeleFromDataBase(){
         
        try{
            String sql = "SELECT modele FROM modele_imprimante WHERE id_imprimante = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                modele = result.getString("modele");
                imp.setModele(modele);
                
        } else {
   
            System.out.println("Aucun enregistrement trouvé pour l'id_imprimante : " + id);
        }
            result.close();
            ps.close();
            
        }catch(SQLException e){
            e.printStackTrace();            
        }        
     }
     
    public void referenceFromDataBase(){
        
        try{
            String sql = "SELECT reference FROM modele_imprimante WHERE id_imprimante = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                ref = result.getString("reference");
                imp.setReference(ref);
                
        } else {
            System.out.println("Aucun enregistrement trouvé pour l'id_imprimante : " + id);
        }
            result.close();
            ps.close();
            
        }catch(SQLException e){
            e.printStackTrace();
            
        }
        
     }
    public String afficherModele(){
        return imp.getModele();
    }
    public String afficherMarque(){
        return imp.getMarque();
    }
    public String afficherRef(){
        return imp.getReference();
    }
    
}
