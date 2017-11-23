package com.example.demo.RestService;

import com.example.demo.DAO.IRSDAO;
import com.example.demo.Model.IRS;
import com.example.demo.Service.IRSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class IRSServiceRest implements IRSService {

	@Autowired
    private RestTemplate restTemplate;

	@Autowired
    private IRSDAO irsdao;

    @Override
    public IRS getIRS(String id_mahasiswa) {
        IRS irs = restTemplate.getForObject("http://localhost:8080/api/irs/view/" + id_mahasiswa, IRS.class);
        return irs;
    }

    @Override
    public List<IRS> getAllIRS(String id_mahasiswa) {
        ResponseEntity<List<IRS>> response =
                restTemplate.exchange("http://localhost:8080/api/irs/viewall/" + id_mahasiswa,
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<IRS>>() {
                        });
        List<IRS> irsList = response.getBody();
        return irsList;
    }

    @Override
    public void addIRS(IRS irs) {
        irsdao.addIrs(irs);

        String id_irs = irsdao.selectIRS(irs.getId_mahasiswa() + "").getId() + "";

        for(int i = 0 ; i < irs.getKelas_list().size(); i++){
            irsdao.addIrsKelas(id_irs, irs.getKelas_list().get(i));
        }
    }

    @Override
    public void updateIRS(IRS irs) {
        String id_irs = irsdao.selectIRS(irs.getId_mahasiswa() + "").getId() + "";
        System.out.println(id_irs);
        irsdao.deleteIrsKelas(id_irs);

        for(int i = 0 ; i < irs.getKelas_list().size(); i++){
            System.out.println(id_irs + " " + irs.getKelas_list().get(i));
            irsdao.addIrsKelas(id_irs, irs.getKelas_list().get(i));
        }
    }
}
