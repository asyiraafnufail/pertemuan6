package com.deploy.pertemuan6.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User{
    private String nama;
    private String nim;
    private String jenisKelamin;
}