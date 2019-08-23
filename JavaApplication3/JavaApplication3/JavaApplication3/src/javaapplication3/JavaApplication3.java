/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import IU.jmPrincipal;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.currentDate;
import static com.mongodb.client.model.Updates.set;
import com.mongodb.client.result.UpdateResult;
import java.util.Iterator;
import java.util.function.Consumer;
import org.bson.BsonDocument;
import org.bson.BsonString;
import org.bson.Document;
import org.bson.conversions.Bson;
/**
 *
 * @author Hecferme
 */
public class JavaApplication3 {
    
 

    public static boolean doesCollectionExist(MongoDatabase database, String collectionName)
    {
        boolean result = false;
        MongoIterable<String> collections = database.listCollectionNames();

        Iterator <String> it = collections.iterator();
        while(!result && it.hasNext()){
            if(it.next().equalsIgnoreCase(collectionName))
                result = true;
        }
        return result;
    }
    
    
    /**
     * @param args the command line arguments
     */
    

    
    
    public static void main(String[] args) {
        
      Metodos MT=new Metodos();
//      MT.InsercionEstudiantes();
//      MT.InsercionMaterias();
//      MT.InsercionEs_Ma();
      
      //MT.Eliminar_Estudiante();
     // MT.Seleccionar_Estudiantes();
      
    jmPrincipal pri = new jmPrincipal();
    pri.show();
    
    
  
    }
}
     
