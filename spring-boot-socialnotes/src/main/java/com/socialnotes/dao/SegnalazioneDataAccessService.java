package com.socialnotes.dao;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.socialnotes.model.Segnalazione;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Repository;

/**
 * TODO testare il funzionamento
 */

@Repository("SegnalazioneDao")
public class SegnalazioneDataAccessService implements SegnalazioneDao {

    @Autowired
    MongoClient client;
    @Autowired
    MongoConverter converter;

    // VEDERE COME RICHIAMARE ALTRI METODI DAO
    @Override
    public boolean setSegnalazione(Segnalazione segnalazione) {
        MongoDatabase mongoDatabase = client.getDatabase("SocialNotes");
        MongoCollection<Document> collection = mongoDatabase.getCollection("Segnalazione");
        try {
            collection.insertOne(new Document()
                    .append("_id", new ObjectId())
                    .append("testo", segnalazione.getTesto())
                    .append("idPost", segnalazione.getIdPost())
                    .append("idUtente", segnalazione.getIdUtente())
            );
        } catch (MongoException me) {
            return false;
        }
        //PostDAO.updatePostSegnalazione(segnalazione.getIdPost());
        return true;
    }
}
