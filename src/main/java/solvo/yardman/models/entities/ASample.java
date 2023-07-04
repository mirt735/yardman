package solvo.yardman.models.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "a_sample")
@Getter
@Setter
public class ASample extends BaseEntity
{
    public ASample() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // TODO sequence вернуть
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "sample_string")
    private String sampleString;

    @Column(name = "sample_integer")
    private Integer sampleInteger;

    @Column(name = "sample_date")
    private LocalDateTime sampleDate;

    @Column(name = "sample_time")
    private LocalDateTime sampleTime;

    @Column(name = "sample_boolean")
    private boolean sampleBoolean;

    @Column(name = "sample_email")
    private String sampleEmail;

    @Column(name = "sample_integer_select_value")
    private Integer sampleIntegerSelectValue;

    @Column(name = "sample_string_select_value")
    private Integer sampleStringSelectValue;
}
