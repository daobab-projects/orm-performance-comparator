package io.daobab.performance.hibernate.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "film")
@Getter
@Setter
@EqualsAndHashCode
public class Film implements Serializable {

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name = "film_actor",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    List<Actor> actors = new ArrayList<>();
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name = "film_category",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    List<Category> categories = new ArrayList<>();
    @OneToMany(mappedBy = "film")
    List<Inventory> inventories = new ArrayList<>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private int filmId;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "release_year")
    private String releaseYear;
    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;
    @ManyToOne
    @JoinColumn(name = "original_language_id")
    private Language originalLanguage;
    @Column(name = "rental_duration")
    private byte rentalDuration;
    @Column(name = "rental_rate")
    private Double rental_rate;
    @Column(name = "length")
    private Short length;
    @Column(name = "replacement_cost")
    private Double replacement_cost;
    @Column(name = "rating")
    private String rating;


//	public void addActor(Actor actor) {
//		actors.add(actor);
//		actor.getFilms().add(this);
//	}
//
//	public void removeActor(Actor actor) {
//		actors.remove(actor);
//		actor.getFilms().add(null);
//	}
    @Column(name = "special_features")
    private String specialFeatures;
    @Column(name = "last_update")
    @UpdateTimestamp
    private LocalDateTime lastUpdate;

    public void addCategory(Category category) {
        categories.add(category);
    }


}

