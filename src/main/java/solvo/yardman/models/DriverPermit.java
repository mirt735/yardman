package solvo.yardman.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "driver_permit")
@Getter
@Setter
public class DriverPermit {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "driver_permit_seq")
    @SequenceGenerator(name = "driver_permit_seq", sequenceName = "driver_permit_seq")
    @Column(name = "id", nullable = false)
    private Long id;

    //TODO поломать CascadeType
    @ManyToOne
    @JoinColumn(name = "driver_id", nullable = false)
    @JsonBackReference
    private Driver driver;

    @Column(name = "permit_id")
    private String permitID;

}
