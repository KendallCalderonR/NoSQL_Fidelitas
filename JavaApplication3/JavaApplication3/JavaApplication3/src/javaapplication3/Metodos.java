/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import Modelos.Estudiantes;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import static javaapplication3.JavaApplication3.doesCollectionExist;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;

/**
 *
 * @author Chisco
 */
public class Metodos {
    private javax.swing.JComboBox<String> cb_Colecciones;
    private javax.swing.JComboBox<String> cb_DB;
    private javax.swing.JLabel lb_Colecciones;
    private javax.swing.JLabel lb_DB;
   
    private MongoCollection<Estudiantes> Estudiantes;
    Connection conn; 
    
    public MongoDatabase  Logica() {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        Consumer<String> action = System.out::println;
        mongoClient.listDatabaseNames().forEach(action);
        // connect to database
        MongoDatabase database = mongoClient.getDatabase("NoSQL");
        
        return database;        
    }
    
    public void getCollectionEstudiante() {
        conn = Connection.getInstance();
        Estudiantes = conn.database.getCollection("Estudiantes", Estudiantes.class);
    }
    
     public  void InsercionEstudiantes(String idEstudiante,String nombreEstudiante,String años,String genero){
        
        MongoCollection<Document> collection = Logica().getCollection("Estudiantes");
        Document document = new Document();
        document.put("Estudiante_id", idEstudiante);
        document.put("Nombre_Estudiante", nombreEstudiante);
        document.put("Años", años);
        document.put("Genero", genero);
        collection.insertOne(document);
        
         JOptionPane.showMessageDialog(null, "Estudiate Ingresado Exitosamente");
    
    }
     
     public  void InsercionMaterias(String idMateria,String nombreMateria){
        
        MongoCollection<Document> collection = Logica().getCollection("Materia");
        Document document = new Document();
        document.put("Materia_id", idMateria);
        document.put("Nombre_Materia", nombreMateria);
        collection.insertOne(document);
    
        JOptionPane.showMessageDialog(null, "Materia Ingresada Exitosamente");
    }
     
     public  void InsercionEs_Ma(){
        
        MongoCollection<Document> collection = Logica().getCollection("Estudiante_Materia");
        Document document = new Document();
//        document.put("id_Es_Ma", txt_Materia_id);
//        document.put("Estudiante_id", txt_Estudiante_id);
//        document.put("Materia_id", txt_Materia_id);
        collection.insertOne(document);
    
    }
     
     
     
     
public List<Estudiantes> Seleccionar_Estudiantes(){
    
    //MongoCollection<Document> collection = Logica().getCollection("Estudiantes");
   //FindIterable<Document> iterDoc = collection.find(); 
   FindIterable<Estudiantes> iterable = Estudiantes.find();
   Iterator it = iterable.iterator();
   List<Estudiantes> allStudents = new ArrayList<>();
        while (it.hasNext()) {
            Estudiantes e = (Estudiantes) it.next();
            allStudents.add(e);
        }
        return allStudents;
//      int i = 1; 
//
//      // Getting the iterator 
//      Iterator it = iterDoc.iterator(); 
//    
//      while (it.hasNext()) {  
//         System.out.println(it.next());  
//      i++; 
//      }

}
public void Seleccionar_Materia(){
 MongoCollection<Document> collection = Logica().getCollection("Materia");
   FindIterable<Document> iterDoc = collection.find(); 
      int i = 1; 

      // Getting the iterator 
      Iterator it = iterDoc.iterator(); 
    
      while (it.hasNext()) {  
         System.out.println(it.next());  
      i++; 
      }

}
public void Seleccionar_EsXMa(){
 MongoCollection<Document> collection = Logica().getCollection("Estudiante_Materia");
   FindIterable<Document> iterDoc = collection.find(); 
      int i = 1; 

      // Getting the iterator 
      Iterator it = iterDoc.iterator(); 
    
      while (it.hasNext()) {  
         System.out.println(it.next());  
      i++; 
      }
}

public void Eliminar_Estudiante(String nombre){
    MongoCollection<Document> collection = Logica().getCollection("Estudiantes");
    collection.deleteOne(Filters.eq("Estudiante_id",nombre)); 
    JOptionPane.showMessageDialog(null, "Estudiate eliminado exitosamente");
   }
public void Eliminar_Materia(String nombre){
    MongoCollection<Document> collection = Logica().getCollection("Materia");
    collection.deleteOne(Filters.eq("Materia_id",nombre)); 
    JOptionPane.showMessageDialog(null, "Materia eliminada exitosamente");
   }
public void Eliminar_EsXMa(){
    MongoCollection<Document> collection = Logica().getCollection("Estudiante_Materia");
//    collection.deleteOne(Filters.eq("id_Es_Ma",txt_Estudiante_id)); 
   }

 public void actualizarEstudiante(String id,String nombre,String tiempo, String genero) {

    MongoCollection<Document> collection = Logica().getCollection("Estudiantes");

    Document findDocument = new Document("Estudiante_id", id);

    // Create the document to specify the update
    Document updateDocument = new Document("$set",
        new Document("Nombre_Estudiante", nombre));
    Document updateDocument2 = new Document("$set",
        new Document("Años", tiempo));
    Document updateDocument3 = new Document("$set",
        new Document("Genero", genero));

    // Find one person and delete
    collection.findOneAndUpdate(findDocument, updateDocument);
    collection.findOneAndUpdate(findDocument, updateDocument2);
    collection.findOneAndUpdate(findDocument, updateDocument3);
    
    JOptionPane.showMessageDialog(null, "Estudiate actualizado exitosamente");
  }
 
 public void actualizarMateria(String id,String nombre) {

    MongoCollection<Document> collection = Logica().getCollection("Estudiantes");

    Document findDocument = new Document("Materia_id", id);

    // Create the document to specify the update
    Document updateDocument = new Document("$set",
        new Document("Nombre_Materia", nombre));

    // Find one person and delete
    collection.findOneAndUpdate(findDocument, updateDocument);
    
    JOptionPane.showMessageDialog(null, "Materia actalizada exitosamente");
  }
 
 public DefaultTableModel CagarData(){
 
   MongoClient mongoClient = null;
   DBCursor cursor = null;

    mongoClient = new MongoClient( "localhost" , 27017 );
    DB db = mongoClient.getDB( "NoSQL" );
    DBCollection coll = db.getCollection("Estudiantes");
    cursor = coll.find();

     String[] columnNames = {"ID","Nombre","Años","Genero"};
    DefaultTableModel model = new DefaultTableModel(columnNames, 0);

    while(cursor.hasNext()) {
        DBObject obj = cursor.next();
        String Estudiante_id = (String)obj.get("Estudiante_id");
        String Nombre_Estudiante = (String)obj.get("Nombre_Estudiante");
        String Años = (String)obj.get("Años");
        String Genero = (String)obj.get("Genero");

        //System.out.println(Estudiante_id+" "+Nombre_Estudiante+" "+Años+" "+Genero);
        model.addRow(new Object[] { Estudiante_id,Nombre_Estudiante,Años,Genero });
    }
   // table.setModel(model);

    cursor.close(); 
    mongoClient.close();
    return model;

 }
  public DefaultTableModel CagarData2(){
 
   MongoClient mongoClient = null;
   DBCursor cursor = null;

    mongoClient = new MongoClient( "localhost" , 27017 );
    DB db = mongoClient.getDB( "NoSQL" );
    DBCollection coll = db.getCollection("Materia");
    cursor = coll.find();

     String[] columnNames = {"ID","Nombre"};
    DefaultTableModel model = new DefaultTableModel(columnNames, 0);

    while(cursor.hasNext()) {
        DBObject obj = cursor.next();
        String Materia_id = (String)obj.get("Materia_id");
        String Nombre_Materia = (String)obj.get("Nombre_Materia");

        //System.out.println(Estudiante_id+" "+Nombre_Estudiante+" "+Años+" "+Genero);
        model.addRow(new Object[] { Materia_id,Nombre_Materia});
    }
   // table.setModel(model);

    cursor.close(); 
    mongoClient.close();
    return model;

 }

    }


    
