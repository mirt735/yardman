package solvo.yardman.models.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

//TODO добавить SDID
@Entity
@Table(name = "driver")
@Getter
@Setter
public class Driver {

    public Driver() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // TODO sequence вернуть
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "driver_seq")
//    @SequenceGenerator(name = "driver_seq", sequenceName = "driver_seq")
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

    @OneToMany(mappedBy = "driver")
    @JsonManagedReference
    private List<DriverPermit> permits;




}
