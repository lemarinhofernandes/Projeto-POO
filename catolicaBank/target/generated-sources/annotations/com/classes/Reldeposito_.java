package com.classes;

import com.classes.Conta;
import com.classes.Deposito;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-11-27T16:07:35")
@StaticMetamodel(Reldeposito.class)
public class Reldeposito_ { 

    public static volatile SingularAttribute<Reldeposito, Integer> id;
    public static volatile SingularAttribute<Reldeposito, Conta> contaId;
    public static volatile SingularAttribute<Reldeposito, Deposito> depositoId;

}