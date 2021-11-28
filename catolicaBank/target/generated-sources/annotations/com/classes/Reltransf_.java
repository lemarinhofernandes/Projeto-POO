package com.classes;

import com.classes.Conta;
import com.classes.Transferencia;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-11-27T16:07:35")
@StaticMetamodel(Reltransf.class)
public class Reltransf_ { 

    public static volatile SingularAttribute<Reltransf, Integer> id;
    public static volatile SingularAttribute<Reltransf, Transferencia> transferenciaId;
    public static volatile SingularAttribute<Reltransf, Conta> contaId;

}