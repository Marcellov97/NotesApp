package com.socialnotes.dao;

import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.socialnotes.model.Commento;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Repository;
import java.util.LinkedList;
import java.util.List;

/**
 * TODO testare il funzionamento
 */

@Repository("CommentoDao")
public class CommentoDataAccessService implements CommentoDao {

    @Autowired
    MongoClient client;
    @Autowired
    MongoConverter converter;

    @Override
    public boolean setCommento(Commento commento) {
        MongoDatabase mongoDatabase = client.getDatabase("SocialNotes");
        MongoCollection<Document> collection = mongoDatabase.getCollection("Commento");
        try {
            collection.insertOne(new Document()
                    .append("_id", new ObjectId())
                    .append("testo", commento.getTesto())
                    .append("idPost", commento.getIdPost())
                    .append("idUtente", commento.getIdUtente())
            );
        } catch (MongoException me) {
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteCommento(String idCommento) {
        try {
            MongoDatabase mongoDatabase = client.getDatabase("SocialNotes");
            MongoCollection<org.bson.Document> collectionPosts = mongoDatabase.getCollection("Commento");
            collectionPosts.deleteOne(new Document("_id", new ObjectId(idCommento)));
        } catch (MongoException me) {
            return false;
        }
            return true;
    }

    @Override
    public List<Commento> getCommentiPost(String idPost) {
        LinkedList<Commento> commenti = new LinkedList<Commento>();
        Commento commento;
        MongoDatabase mongoDatabase = client.getDatabase("SocialNotes");
        MongoCollection<org.bson.Document> collectionCommenti = mongoDatabase.getCollection("Commento");
        Bson filterPost = Filters.eq("idPost", idPost);
        FindIterable<Document> docCommenti = collectionCommenti.find(filterPost);
        for (Document d : docCommenti) {
            commento = new Commento (d.getObjectId("_id").toString(), d.getString("testo"), d.getString("idPost"), d.getString("idUtente"));
            commenti.add(commento);
        }
        return commenti;
    }

    @Override
    public void deleteCommentiPost(String idPost) {
        MongoDatabase mongoDatabase = client.getDatabase("SocialNotes");
        MongoCollection<org.bson.Document> collectionPosts = mongoDatabase.getCollection("Commento");
        collectionPosts.deleteMany(new Document("_id", new ObjectId(idPost)));
    }
}
