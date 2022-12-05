package solvo.yardman.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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

    @Column(name = "contact_face")
    private String contactFace;

    @Column
    private String email;

    @Column
    private String type;

}
