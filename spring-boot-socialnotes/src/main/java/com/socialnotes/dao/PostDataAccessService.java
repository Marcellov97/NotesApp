    package com.socialnotes.dao;

    import com.mongodb.MongoException;
    import com.mongodb.client.FindIterable;
    import com.mongodb.client.MongoClient;
    import com.mongodb.client.MongoCollection;
    import com.mongodb.client.MongoDatabase;
    import com.mongodb.client.model.Filters;
    import com.mongodb.client.model.Updates;
    import com.socialnotes.model.Post;
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
                                 d.getString("nomeUtente"));
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
                                 d.getString("nomeUtente"));
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
                MongoCollection<Document> collection = mongoDatabase.getCollection("Post");
                Bson filterPost = Filters.eq("nomeUtente", nomeUtente);
                FindIterable<Document> docPosts = collection.find(filterPost);
                for (Document d : docPosts) {
                    System.out.println(d.toString());
                    post = new Post (d.getObjectId("_id").toString(),
                                     d.getString("descrizione"),
                                     d.getInteger("valutazione"),
                                     d.getBoolean("segnalato"),
                                     d.getString("nomeUtente"));
                    posts.add(post);
                }
                //resultPost.forEach((Block<? super Document>) doc -> posts.add(converter.read(Post.class, doc)));
                return posts;
        }

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
                                                .append("nomeUtente", post.getNomeUtente())
                );
            } catch (MongoException me) {
                return false;
            }
            return true;
        }

        @Override
        public boolean updatePostValutazione(String idPost, int valutazione) {
            try {
                // Ottengo le valutazioni del post dato
                LinkedList<Valutazione> valutazioniPost = new LinkedList<Valutazione>();
                Valutazione val;
                MongoDatabase mongoDatabase = client.getDatabase("SocialNotes");
                MongoCollection<org.bson.Document> collectionValutazioni = mongoDatabase.getCollection("Valutazione");
                Bson filterPost = Filters.eq("idPost", idPost);
                FindIterable<Document> docValutazioni = collectionValutazioni.find(filterPost);
                for (Document d : docValutazioni) {
                    val = new Valutazione (d.getObjectId("_id").toString(),
                            d.getInteger("valutazione"),
                            d.getString("idPost"),
                            d.getString("nomeUtente"));
                    valutazioniPost.add(val);
                    System.out.println(val.toString());
                }

                // Aggiorno la nuova media delle valutazioni
                int somma = 0;
                int n = 0;
                for (Valutazione v : valutazioniPost) {
                    somma = somma + v.getValutazione();
                    n++;
                    System.out.println("somma: " + somma + "   n: " + n);
                }
                somma = somma + valutazione;
                n++;
                Integer nuovaValutazione = somma / n;
                System.out.println("Nuova valutazione: " + nuovaValutazione);
                MongoCollection<org.bson.Document> collection = mongoDatabase.getCollection("Post");
                Bson filter = Filters.eq("_id", new ObjectId(idPost));
                Bson update = Updates.set("valutazione", nuovaValutazione);
                collection.updateOne(filter, update);
            } catch (MongoException me) {
                return false;
            }
                return true;
        }

        @Override
        public boolean updatePostSegnalazione(String idPost) {
            MongoDatabase mongoDatabase = client.getDatabase("SocialNotes");
            MongoCollection<org.bson.Document> collection = mongoDatabase.getCollection("Post");
            Bson filter = Filters.eq("_id", new ObjectId(idPost));
            Bson update = Updates.set("segnalato", true);
            try {
                collection.updateOne(filter, update);
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
