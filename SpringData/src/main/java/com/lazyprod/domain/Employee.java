package com.lazyprod.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class Employee {

    private int id;
    private String firstName;
    private String lastName;
    private String eMail;

}
