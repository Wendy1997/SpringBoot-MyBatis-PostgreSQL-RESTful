package com.example.demo.RestService;

import com.example.demo.Model.MataKuliah;
import com.example.demo.Model.Term;
import com.example.demo.Service.TermService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class TermServiceRest implements TermService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public List<Term> getAllTerm() {
        List<Term> termList = new ArrayList<>();
        try {
            Map<String, Object> result = restTemplate.getForObject("http://localhost:8090/api/term/get-all", Map.class);

            JSONObject jsonResult = new JSONObject(result);
            if(jsonResult.getInt("status") == HttpStatus.OK.value()) {
                JSONArray jsonKelasList = jsonResult.getJSONArray("result");

                for(int i = 0; i < jsonKelasList.length(); i++){
                    termList.add( new Term(
                            jsonKelasList.getJSONObject(i).getInt("id"),
                            jsonKelasList.getJSONObject(i).getInt("nomor_term"),
                            jsonKelasList.getJSONObject(i).getString("start_date"),
                            jsonKelasList.getJSONObject(i).getString("end_date"),
                            jsonKelasList.getJSONObject(i).getString("add_irs_date")
                    ));
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return termList;
    }

    @Override
    public Term getTerm(String id) {
       Term term = new Term();
        try {
            Map<String, Object> result = restTemplate.getForObject("http://localhost:8090/api/term/get-all", Map.class);

            JSONObject jsonResult = new JSONObject(result);
            if(jsonResult.getInt("status") == HttpStatus.OK.value()) {
                JSONArray jsonKelasList = jsonResult.getJSONArray("result");

                for(int i = 0; i < jsonKelasList.length(); i++){
                    if(jsonKelasList.getJSONObject(i).getInt("id") == Integer.parseInt(id)){
                        term = new Term(
                                jsonKelasList.getJSONObject(i).getInt("id"),
                                jsonKelasList.getJSONObject(i).getInt("nomor_term"),
                                jsonKelasList.getJSONObject(i).getString("start_date"),
                                jsonKelasList.getJSONObject(i).getString("end_date"),
                                jsonKelasList.getJSONObject(i).getString("add_irs_date")
                        );
                    }
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return term;
    }
}
