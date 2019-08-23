/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoDatabase;

/**
 *
 * @author Héctor
 */

public class Connection {
    public MongoClient mongo;
    private final String db;
    public MongoDatabase database;
    private static Connection instance;

    private Connection() {
        db = "NOSQL";
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        mongo = new MongoClient("localhost", MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build());
        database = mongo.getDatabase(db);

    }

    public static Connection getInstance() {
        if (instance == null) {
            instance = new Connection();
            return instance;
        } else {
            return instance;
        }
    }

}
    
