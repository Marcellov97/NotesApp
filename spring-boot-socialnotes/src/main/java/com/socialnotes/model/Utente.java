    package com.socialnotes.model;

    import org.bson.types.ObjectId;

    import java.util.Objects;
    import java.util.UUID;

    public class Utente {

        private String id;
        private String nome;
        private String cognome;
        private String nomeUtente;
        private String email;
        private String password;
        private boolean moderatore;

        public Utente(String id, String nome, String cognome, String nomeUtente, String email, String password, boolean moderatore) {
            this.id = id;
            this.nome = nome;
            this.cognome = cognome;
            this.nomeUtente = nomeUtente;
            this.email = email;
            this.password = password;
            this.moderatore = moderatore;
        }

        public Utente(String nome, String cognome, String nomeUtente, String email, String password, boolean moderatore) {
            this.nome = nome;
            this.cognome = cognome;
            this.nomeUtente = nomeUtente;
            this.email = email;
            this.password = password;
            this.moderatore = moderatore;
        }

        public Utente() {
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getCognome() {
            return cognome;
        }

        public void setCognome(String cognome) {
            this.cognome = cognome;
        }

        public String getNomeUtente() {
            return nomeUtente;
        }

        public void setNomeUtente(String nomeUtente) {
            this.nomeUtente = nomeUtente;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public boolean isModeratore() {
            return moderatore;
        }

        public void setModeratore(boolean moderatore) {
            this.moderatore = moderatore;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Utente utente = (Utente) o;
            return moderatore == utente.moderatore && Objects.equals(nome, utente.nome) && Objects.equals(cognome, utente.cognome) && Objects.equals(nomeUtente, utente.nomeUtente) && Objects.equals(email, utente.email) && Objects.equals(password, utente.password);
        }

        @Override
        public int hashCode() {
            return Objects.hash(nome, cognome, nomeUtente, email, password, moderatore);
        }

        @Override
        public String toString() {
            return "Utente{" +
                    "  nome='" + nome + '\'' +
                    ", cognome='" + cognome + '\'' +
                    ", nomeUtente='" + nomeUtente + '\'' +
                    ", email='" + email + '\'' +
                    ", password='" + password + '\'' +
                    ", moderatore=" + moderatore +
                    '}';
        }

    }
