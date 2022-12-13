package solvo.yardman.models.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

//TODO добавить SDID
@Entity
@Table(name = "stakeholder")
@Getter
@Setter
public class Stakeholder {

    public Stakeholder() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "short_name")
    private String shortName;

    @Column
    private String phone;

    //TODO переименовать в contact person name
    @Column(name = "contact_face")
    private String contactFace;

    @Column
    private String email;

    //TODO добавить enum как "Организационно-правовая форма". Предзаполнить самыми распространенными - ИП, юр лица, гпх, самозанятость
    @Column
    private String type;

    //TODO добавить ИНН
}
