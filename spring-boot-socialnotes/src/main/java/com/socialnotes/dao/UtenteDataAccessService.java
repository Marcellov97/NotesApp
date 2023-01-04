    package com.socialnotes.dao;

    import com.mongodb.Block;
    import com.mongodb.client.MongoClient;
    import com.socialnotes.model.*;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.data.mongodb.core.convert.MongoConverter;
    import org.springframework.stereotype.Repository;
    import java.util.LinkedList;
    import java.util.List;
    import org.bson.Document;
    import org.bson.conversions.Bson;
    import org.bson.types.ObjectId;
    import com.mongodb.MongoException;
    import com.mongodb.client.FindIterable;
    import com.mongodb.client.MongoCollection;
    import com.mongodb.client.MongoDatabase;
    import com.mongodb.client.model.Filters;

    /**
     * CLASSE DI ACCESSO ALLA COLLECTION UTENTE NEL DB
     */

    @Repository("UtenteDao")
    public class UtenteDataAccessService implements UtenteDao {

        @Autowired
        MongoClient client;
        @Autowired
        MongoConverter converter;

       @Override
       public Utente getUtente(String nomeUtente) {
            MongoDatabase mongoDatabase = client.getDatabase("SocialNotes");
            MongoCollection<org.bson.Document> collection = mongoDatabase.getCollection("Utente");
            Bson filter = Filters.eq("nomeUtente", nomeUtente);
            FindIterable<Document> docs = collection.find(filter);
            Document doc = docs.first();
            Utente utente = new Utente(doc.getObjectId("_id").toString(),
                                       doc.getString("nome"),
                                       doc.getString("cognome"),
                                       doc.getString("nomeUtente"),
                                       doc.getString("email"),
                                       doc.getString("password"),
                                       doc.getBoolean("moderatore"));
            return utente;
        }

        public List<Utente> getAllUtenti () {
            List<Utente> utenti = new LinkedList<Utente>();
            MongoDatabase mongoDatabase = client.getDatabase("SocialNotes");
            MongoCollection<org.bson.Document> collection = mongoDatabase.getCollection("Utente");
            FindIterable<Document> docs = collection.find();
            Utente utente;
            for(Document doc : docs) {
                utente = new Utente(doc.getObjectId("_id").toString(),
                                    doc.getString("nome"),
                                    doc.getString("cognome"),
                                    doc.getString("nomeUtente"),
                                    doc.getString("email"),
                                    doc.getString("password"),
                                    doc.getBoolean("moderatore"));
                utenti.add(utente);
            }
            return utenti;
        }

        @Override
        public boolean setUtente(Utente utente) {
            MongoDatabase mongoDatabase = client.getDatabase("SocialNotes");
            MongoCollection<org.bson.Document> collection = mongoDatabase.getCollection("Utente");
            try {
                collection.insertOne(new Document()
                        .append("_id", new ObjectId())
                        .append("nome", utente.getNome())
                        .append("cognome", utente.getCognome())
                        .append("nomeUtente", utente.getNomeUtente())
                        .append("email", utente.getEmail())
                        .append("password", utente.getPassword())
                        .append("moderatore", utente.isModeratore())
                );
            } catch (MongoException me) {
                return false;
            }
            return true;
        }

        public boolean deleteUtente (String nomeUtente) {
            MongoDatabase mongoDatabase = client.getDatabase("SocialNotes");
            MongoCollection<org.bson.Document> collection = mongoDatabase.getCollection("Utente");
            Bson filter = Filters.eq("nomeUtente", nomeUtente);
            try {
                collection.deleteOne(filter);
            } catch (MongoException me) {
                return false;
            }
            return true;
        }

    }
