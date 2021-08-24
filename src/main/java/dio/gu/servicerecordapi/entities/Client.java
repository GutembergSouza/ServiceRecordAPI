package dio.gu.servicerecordapi.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Client {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String cpf;

    @Column
    private String adress;

    @OneToMany(fetch = FetchType.LAZY ,cascade={ CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE }  )
    private List<Phone> phoneList = new ArrayList<>();

}
