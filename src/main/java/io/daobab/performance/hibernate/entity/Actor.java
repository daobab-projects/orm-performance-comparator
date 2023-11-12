package io.daobab.performance.hibernate.entity;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "actor")
@Getter
@Setter
@EqualsAndHashCode
public class Actor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "last_update")
    @UpdateTimestamp
    private LocalDateTime lastUpdate;


//	@ManyToMany(fetch=FetchType.LAZY, mappedBy="actors",
//		    cascade= {CascadeType.PERSIST, CascadeType.MERGE,
//		     CascadeType.DETACH, CascadeType.REFRESH})
//			@JsonIgnore
//	List<Film> films = new ArrayList<>();


//	public void addFilm(Film film) {			//INUTILE ??
//		films.add(film);
//	}


}
