package com.socialnotes.dao;

import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.socialnotes.model.Post;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Repository;
import java.util.LinkedList;
import java.util.List;

/**
 * TODO finire di testare il funzionamento
 */

@Repository("PostDao")
public class PostDataAccessService implements PostDao {

    @Autowired
    MongoClient client;
    @Autowired
    MongoConverter converter;

    @Override
    public List<Post> getAllPost () {
        List<Post> posts = new LinkedList<>();
        Post post;
        MongoDatabase mongoDatabase = client.getDatabase("SocialNotes");
        MongoCollection<Document> collection = mongoDatabase.getCollection("Post");
        FindIterable<Document> docPosts = collection.find();
        for (Document d : docPosts) {
            post = new Post (d.getObjectId("_id").toString(),
                             d.getString("descrizione"),
                             d.getInteger("valutazione"),
                             d.getBoolean("segnalato"),
                             d.getString("idUtente"));
            posts.add(post);
        }
        //result.forEach((Block<? super Document>) doc -> posts.add(converter.read(Post.class, doc)));
        return posts;
    }

    @Override
    public List<Post> getPostsValutazione(String valutazione) {
        List<Post> posts = new LinkedList<>();
        Post post;
        MongoDatabase mongoDatabase = client.getDatabase("SocialNotes");
        MongoCollection<Document> collection = mongoDatabase.getCollection("Post");
        Bson filter = Filters.eq("valutazione", Integer.valueOf(valutazione));
        FindIterable<Document> docPosts = collection.find(filter);
        for (Document d : docPosts) {
            post = new Post (d.getObjectId("_id").toString(),
                             d.getString("descrizione"),
                             d.getInteger("valutazione"),
                             d.getBoolean("segnalato"),
                             d.getString("idUtente"));
            posts.add(post);
        }
        //result.forEach((Block<? super Document>) doc -> posts.add(converter.read(Post.class, doc)));
        return posts;
    }

    @Override
    public List<Post> getPostsUtente(String nomeUtente) {
        List<Post> posts = new LinkedList<>();
        Post post;
        MongoDatabase mongoDatabase = client.getDatabase("SocialNotes");

        MongoCollection<Document> collection = mongoDatabase.getCollection("Utente");
        Bson filter = Filters.eq("nomeUtente", nomeUtente);
        String idUtente = collection.find(filter).first().getObjectId("_id").toString();

        MongoCollection<Document> collectionPost = mongoDatabase.getCollection("Post");
        Bson filterPost = Filters.eq("idUtente", idUtente);
        FindIterable<Document> docPosts = collection.find(filterPost);
        for (Document d : docPosts) {
            post = new Post (d.getObjectId("_id").toString(),
                    d.getString("descrizione"),
                    d.getInteger("valutazione"),
                    d.getBoolean("segnalato"),
                    d.getString("idUtente"));
            posts.add(post);
        }
        //resultPost.forEach((Block<? super Document>) doc -> posts.add(converter.read(Post.class, doc)));
        return posts;
    }

    // TODO testare funzionamento
    @Override
    public boolean setPost(Post post) {
        MongoDatabase mongoDatabase = client.getDatabase("SocialNotes");
        MongoCollection<org.bson.Document> collection = mongoDatabase.getCollection("Post");
        try {
            collection.insertOne(new Document()
                    .append("_id", new ObjectId())
                    .append("descrizione", post.getDescrizione())
                    .append("valutazione", post.getValutazione())
                    .append("segnalato", post.getSegnalato())
                    .append("idUtente", post.getId())
            );
        } catch (MongoException me) {
            return false;
        }
        return true;
    }

    // TODO testare funzionamento
    @Override
    public boolean updatePostValutazione(String idPost, int valutazione) {
        /*LinkedList<Valutazione> valutazioniPost = ValutazioneDAO.getValutazioniPost(connessione, post);
        int somma = 0;
        int n = 0;
        for (Valutazione v : valutazioniPost)
            somma = somma + valutazione;
        n++;
        Integer nuovaValutazione = somma / n;
        MongoDatabase mongoDatabase = connessione.getMongoDatabase();
        MongoCollection<org.bson.Document> collection = mongoDatabase.getCollection("Post");
        Bson filter = Filters.eq("valutazione", nuovaValutazione);
        collection.updateOne(filter, new Document("_id", new ObjectId(post.getIdPost())));*/
        return true;
    }

    // TODO testare funzionamento
    @Override
    public boolean updatePostSegnalazione(String idPost) {
        MongoDatabase mongoDatabase = client.getDatabase("SocialNotes");
        MongoCollection<org.bson.Document> collection = mongoDatabase.getCollection("Post");
        Bson filter = Filters.eq("segnalato", true);
        try {
            collection.updateOne(filter, new Document("_id", new ObjectId(idPost)));
        } catch (MongoException me) {
            return false;
        }
        return true;
    }

    @Override
    public boolean deletePost(String idPost) {
        MongoDatabase mongoDatabase = client.getDatabase("SocialNotes");
        MongoCollection<org.bson.Document> collectionPosts = mongoDatabase.getCollection("Post");
        String s = "ObjectId('" + idPost + "')";
        Bson filter = Filters.eq("_id", s);
        try {
            collectionPosts.deleteOne(new Document("_id", new ObjectId(idPost)));
        } catch (MongoException me) {
            return false;
        }
        return true;
    }
}
