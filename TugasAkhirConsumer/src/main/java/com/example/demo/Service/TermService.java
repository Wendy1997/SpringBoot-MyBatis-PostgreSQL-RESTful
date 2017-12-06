package com.example.demo.Service;

import com.example.demo.Model.Term;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TermService {
    List<Term> getAllTerm();
    Term getTerm(String id);
}
