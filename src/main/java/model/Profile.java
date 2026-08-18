package model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import model.basemodel.BaseModel;

import java.util.Objects;

@Entity
public class Profile extends BaseModel<Long> {
    @Column(nullable = false)
    private String bio;
    @Column(unique = true, nullable = false)
    private String website;
    @OneToOne(mappedBy = "profile", cascade = CascadeType.ALL, orphanRemoval = true)
    private Author author;

    public Profile() {
    }

    public Profile(String bio, String website, Author author) {
        this.bio = bio;
        this.website = website;
        this.author = author;
    }

    public Profile(Long id, String bio, String website, Author author) {
        super(id);
        this.bio = bio;
        this.website = website;
        this.author = author;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return Objects.equals(bio, profile.bio) && Objects.equals(website, profile.website) && Objects.equals(author, profile.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bio, website, author);
    }

    @Override
    public String toString() {
        return "Profile{" +
                "bio='" + bio + '\'' +
                ", website='" + website + '\'' +
                ", author=" + author +
                '}';
    }


}
