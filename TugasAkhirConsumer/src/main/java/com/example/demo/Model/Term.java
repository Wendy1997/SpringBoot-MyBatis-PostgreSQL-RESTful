package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Term {
    int id;
    int nomor_term;
    String start_date;
    String end_date;
    String add_irs_date;
}