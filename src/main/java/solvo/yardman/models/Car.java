package solvo.yardman.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "car")
@Getter
@Setter
public class Car {

    public Car() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "reg_number")
    private String regNumber;

    @ManyToOne
    @JoinColumn(name = "car_type_id", nullable = false)
    @JsonBackReference
    private CarType carType;

    @Column(name = "carrier_id")
    private Long carrierId;

    @Column(name = "last_driver_id")
    private Long lastDriverId;

    @CreationTimestamp
    @Column(name = "created", nullable = false, updatable = false)
    private LocalDateTime created;

    @LastModifiedDate
    @Column(name = "modified", nullable = false, updatable = false)
    private LocalDateTime modified;




}
