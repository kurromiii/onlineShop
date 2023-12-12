package com.mftplus.onlineshop.model.entity;

import com.mftplus.onlineshop.model.entity.enums.UserRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@ToString

//there is no need for UserRepository
@NamedQueries({
        @NamedQuery(name = "User.FindByUsername",query = "select oo from userEntity oo where oo.username=:username"),
        @NamedQuery(name = "User.FindByUsernameAndPassword",query = "select oo from userEntity oo where oo.username=:username and oo.password=:password")
})

@Entity (name = "userEntity")
@Table (name = "user_tbl")
public class User {
    //no need for id, username is the primary key
    @Id
    @Column(name = "u_username", length = 10)
    private String username;

    @Column(name = "u_password", length = 10)
    private String password;

    @Column(name = "u_name", length = 10)
    private String name;

    @Column(name = "u_family", length = 10)
    private  String family;

    @Enumerated (EnumType.ORDINAL)
    private UserRole userRole;

}
