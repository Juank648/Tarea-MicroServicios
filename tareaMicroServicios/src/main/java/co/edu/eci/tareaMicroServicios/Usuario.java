package co.edu.eci.tareaMicroServicios;

import java.util.Date;
import java.util.UUID;

public class Usuario {
    public String id;
    public String name;
    public String email;
    private String passwordHash;
    public String lastName;
    public Date createdAt;

    public Usuario(String name, String email, String lastName, String passwordHash) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.lastName = lastName;
        this.createdAt = new Date();
        //this.passwordHash = BCrypt.hashpw( passwordHash, BCrypt.gensalt() );
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
