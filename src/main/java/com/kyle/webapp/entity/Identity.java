package com.kyle.webapp.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Xiong on 2017/5/2.
 */
@Entity
@Table(name = "identity")
public class Identity implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "identity_type")
    private String identityType;
    @Column(name = "identifier")
    private String identifier;
    @Column(name = "credential")
    private String credential;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getIdentityType() {
        return identityType;
    }

    public void setIdentityType(String identityType) {
        this.identityType = identityType;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getCredential() {
        return credential;
    }

    public void setCredential(String credential) {
        this.credential = credential;
    }

}
