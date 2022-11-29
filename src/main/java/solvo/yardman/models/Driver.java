package solvo.yardman.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "driver")
@Getter
@Setter
public class Driver {

    public Driver() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "driver_seq")
    @SequenceGenerator(name = "driver_seq", sequenceName = "driver_seq")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    //TODO схема с ассоциированными телефонами
    @Column
    private String phone;

    @Column
    private String passport;

    @Column
    private String passportIssuedBy;

    //TODO каскад liquibase
    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<DriverPermit> permits;




}
