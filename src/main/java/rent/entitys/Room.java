package rent.entitys;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer num;


    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="busId")
    private BussinesCenter bussinesCenter;

    private Integer floor;

    private BigDecimal area;


}
