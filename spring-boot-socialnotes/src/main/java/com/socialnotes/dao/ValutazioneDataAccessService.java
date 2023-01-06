package com.socialnotes.dao;

import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.socialnotes.model.Valutazione;
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

@Repository("ValutazioneDao")
public class ValutazioneDataAccessService implements ValutazioneDao {

    @Autowired
    MongoClient client;
    @Autowired
    MongoConverter converter;

    @Override
    public List<Valutazione> getValutazioniPost(String idPost) {
        LinkedList<Valutazione> valutazioni = new LinkedList<Valutazione>();
        Valutazione valutazione;
        MongoDatabase mongoDatabase = client.getDatabase("SocialNotes");
        MongoCollection<org.bson.Document> collectionValutazioni = mongoDatabase.getCollection("Valutazione");
        Bson filterPost = Filters.eq("idPost", idPost);
        FindIterable<Document> docValutazioni = collectionValutazioni.find(filterPost);
        for (Document d : docValutazioni) {
            valutazione = new Valutazione (d.getObjectId("_id").toString(),
                    d.getInteger("valutazione"),
                    d.getString("idPost"),
                    d.getString("idUtente"));
            valutazioni.add(valutazione);
            System.out.println(valutazione.toString());
        }
        return valutazioni;
    }

    @Override
    public boolean setValutazione(Valutazione valutazione) {
        MongoDatabase mongoDatabase = client.getDatabase("SocialNotes");
        MongoCollection<Document> collection = mongoDatabase.getCollection("Valutazione");
        try {
            collection.insertOne(new Document()
                    .append("_id", new ObjectId())
                    .append("valutazione", valutazione.getValutazione())
                    .append("idPost", valutazione.getIdPost())
                    .append("idUtente", valutazione.getIdUtente())
            );
        } catch (MongoException me) {
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteValutazione(String idValutazione) {
        try {
            MongoDatabase mongoDatabase = client.getDatabase("SocialNotes");
            MongoCollection<org.bson.Document> collectionPosts = mongoDatabase.getCollection("Valutazione");
            collectionPosts.deleteOne(new Document("_id", new ObjectId(idValutazione)));
        } catch (MongoException me) {
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteValutazioniPost(String idPost) {
        try {
            MongoDatabase mongoDatabase = client.getDatabase("SocialNotes");
            MongoCollection<org.bson.Document> collectionPosts = mongoDatabase.getCollection("Valutazione");
            collectionPosts.deleteMany(new Document("_id", new ObjectId(idPost)));
        } catch (MongoException me) {
            return false;
        }
        return true;
    }
}
