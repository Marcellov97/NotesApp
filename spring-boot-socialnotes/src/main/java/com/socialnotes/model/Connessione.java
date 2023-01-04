package com.socialnotes.model;
import com.mongodb.*;
import com.mongodb.client.MongoDatabase;

public class Connessione {
    private MongoClient mongoClient;
    private MongoDatabase mongoDatabase;

    public Connessione () {
        mongoClient = new MongoClient(
                new MongoClientURI(
                        "mongodb://localhost:27017/"
                )
        );
        mongoDatabase = mongoClient.getDatabase("Notes");
    }

    public MongoClient getMongoClient(){
        return this.mongoClient;
    }

    public MongoDatabase getMongoDatabase () {
        return this.mongoDatabase;
    }

    @Override
    public String toString() {
        return "Connessione [mongoClient=" + mongoClient + ", mongoDatabase=" + mongoDatabase + "]";
    }
}