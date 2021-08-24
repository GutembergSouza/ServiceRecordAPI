package dio.gu.servicerecordapi.entities;

import dio.gu.servicerecordapi.enums.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
     private String number;


    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PhoneType type;

}
