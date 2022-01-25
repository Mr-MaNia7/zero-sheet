package com.webproject.zerosheet.user.roles;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table (name = "Roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer roleID;

    private String roleName;

    public Role() {
    }

    public Role(String roleName){
        this.roleName = roleName;
    }
}
