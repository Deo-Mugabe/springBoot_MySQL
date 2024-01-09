package com.degra.songs.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Entity
@Data                   //replacing all the getters and setters
@NoArgsConstructor      //constructor of no args
@AllArgsConstructor
@Builder
public class Department {
    @Id
    @SequenceGenerator(
            name = "department_Id",
            sequenceName = "department_Id",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "department_Id"

    )

    private  Long departmentId;

    @NotBlank(message = "Please add Department Name")
//    @Length(max = 5,min = 1)
//    @Email
//    @Positive
    private  String departmentName;
    private String departmentAddress;
    private String departmentCode;


    }
