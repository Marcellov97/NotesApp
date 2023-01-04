package com.socialnotes.dao;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.socialnotes.model.FilePost;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Repository;

/**
 * TODO testare il funzionamento
 */

@Repository("FilePostDao")
public class FilePostDataAccessService implements FilePostDao {

    @Autowired
    MongoClient client;
    @Autowired
    MongoConverter converter;

    @Override
    public boolean setFile(FilePost filePost) {
        MongoDatabase mongoDatabase = client.getDatabase("SocialNotes");
        MongoCollection<Document> collection = mongoDatabase.getCollection("File");
        try {
            collection.insertOne(new Document()
                    .append("_id", new ObjectId())
                    .append("testo", filePost.getNome())
                    .append("estensione", filePost.getEstensione())
                    .append("idPost", filePost.getIdPost())
            );
        } catch (MongoException me) {
            return false;
        }
        return true;
    }

    @Override
    public void deleteFile(String idFilePost) {
        MongoDatabase mongoDatabase = client.getDatabase("SocialNotes");
        MongoCollection<org.bson.Document> collectionPosts = mongoDatabase.getCollection("File");
        collectionPosts.deleteOne(new Document("_id", new ObjectId(idFilePost)));
    }
}
