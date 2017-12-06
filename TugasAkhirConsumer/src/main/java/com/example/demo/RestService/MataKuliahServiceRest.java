package com.example.demo.RestService;

import com.example.demo.Model.Kurikulum;
import com.example.demo.Model.MataKuliah;
import com.example.demo.Model.ProgramStudi;
import com.example.demo.Service.MataKuliahService;
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
public class MataKuliahServiceRest implements MataKuliahService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public MataKuliah getMatkul(String id_matkul) {
        MataKuliah mataKuliah = new MataKuliah();
        try {
            Map<String, Object> result = restTemplate.getForObject("http://localhost:8090/api/selectMatkul/"+id_matkul, Map.class);

            JSONObject jsonResult = new JSONObject(result);
            if(jsonResult.getInt("status") == HttpStatus.OK.value()) {
                JSONObject jsonProdi = jsonResult.getJSONObject("result");

                JSONArray jsonMatkul = jsonProdi.getJSONArray("prasyarat_matkul");
                List<MataKuliah> prasyaratMatkul = new ArrayList<>();
                for(int j = 0; j < jsonMatkul.length(); j++){
                    prasyaratMatkul.add(getMatkul(jsonMatkul.getJSONObject(j).getInt("id") + ""));
                }

                mataKuliah = new MataKuliah(
                        jsonProdi.getInt("id"),
                        jsonProdi.getString("nama_matkul"),
                        jsonProdi.getString("kode_matkul"),
                        jsonProdi.getInt("jumlah_sks"),
                        jsonProdi.getString("deskripsi"),
                        jsonProdi.getInt("prasyarat_sks"),
                        prasyaratMatkul
                        );

            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return mataKuliah;
    }

    @Override
    public List<MataKuliah> getListMatkul(String id_univ, String id_fakultas, String id_prodi) {
        List<MataKuliah> mataKuliahList = new ArrayList<>();
        try {
            Map<String, Object> result = restTemplate.getForObject("http://localhost:8090/api/listMatkul/"+ id_univ + "/" + id_fakultas + "/" + id_prodi, Map.class);

            JSONObject jsonResult = new JSONObject(result);
            if(jsonResult.getInt("status") == HttpStatus.OK.value()) {
                JSONArray jsonKelasList = jsonResult.getJSONArray("result");

                for(int i = 0; i < jsonKelasList.length(); i++){
                    JSONArray jsonMatkul = jsonKelasList.getJSONObject(i).getJSONArray("prasyarat_matkul");
                    List<MataKuliah> prasyaratMatkul = new ArrayList<>();
                    for(int j = 0; j < jsonMatkul.length(); j++){
                        prasyaratMatkul.add(getMatkul(jsonMatkul.getJSONObject(j).getInt("id") + ""));
                    }

                    mataKuliahList.add( new MataKuliah(
                            jsonKelasList.getJSONObject(i).getInt("id"),
                            jsonKelasList.getJSONObject(i).getString("nama_matkul"),
                            jsonKelasList.getJSONObject(i).getString("kode_matkul"),
                            jsonKelasList.getJSONObject(i).getInt("jumlah_sks"),
                            jsonKelasList.getJSONObject(i).getString("deskripsi"),
                            jsonKelasList.getJSONObject(i).getInt("prasyarat_sks"),
                            prasyaratMatkul
                    ));
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return mataKuliahList;
    }

    @Override
    public Kurikulum getKurikulum(String id, String id_univ, String id_fakultas, String id_prodi) {
        Kurikulum kurikulum = new Kurikulum();
        try {
            Map<String, Object> result = restTemplate.getForObject("http://localhost:8090/api/getListKurikulum/"+ id_univ + "/" + id_fakultas + "/" + id_prodi, Map.class);

            JSONObject jsonResult = new JSONObject(result);

            if(jsonResult.getInt("status") == HttpStatus.OK.value()) {

                JSONArray jsonKurikulum = jsonResult.getJSONArray("result");

                for(int j = 0 ; j < jsonKurikulum.length(); j++){

                    if(jsonKurikulum.getJSONObject(j).getInt("id") == Integer.parseInt(id)){

                        JSONArray jsonMatkulWajib = jsonKurikulum.getJSONObject(j).getJSONArray("list_matkul_wajib");
                        List<MataKuliah> listMatkulWajib = new ArrayList<>();
                        for(int i = 0; i < jsonMatkulWajib.length(); i++){
                            listMatkulWajib.add(getMatkul(jsonMatkulWajib.getJSONObject(i).getInt("id") + ""));
                        }

                        JSONArray jsonMatkulPilihan = jsonKurikulum.getJSONObject(j).getJSONArray("list_matkul_pilihan");
                        List<MataKuliah> listMatkulPilihan = new ArrayList<>();
                        for(int i = 0; i < jsonMatkulPilihan.length(); i++){
                            listMatkulPilihan.add(getMatkul(jsonMatkulPilihan.getJSONObject(i).getInt("id") + ""));
                        }

                        kurikulum = new Kurikulum(
                                jsonKurikulum.getJSONObject(j).getInt("id"),
                                jsonKurikulum.getJSONObject(j).getString("nama_kurikulum"),
                                jsonKurikulum.getJSONObject(j).getInt("jumlah_sks_wajib"),
                                jsonKurikulum.getJSONObject(j).getInt("jumlah_sks_pilihan"),
                                jsonKurikulum.getJSONObject(j).getString("kode_univ"),
                                jsonKurikulum.getJSONObject(j).getString("kode_fakultas"),
                                jsonKurikulum.getJSONObject(j).getString("kode_prodi"),
                                jsonKurikulum.getJSONObject(j).getString("tahun_mulai"),
                                jsonKurikulum.getJSONObject(j).getString("tahun_akhir"),
                                listMatkulWajib,
                                listMatkulPilihan
                        );
                    }
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return kurikulum;
    }

    @Override
    public List<Kurikulum> getAllKurikulum(String id_univ, String id_fakultas, String id_prodi) {
        List<Kurikulum> kurikulumList = new ArrayList<>();
        try {
            Map<String, Object> result = restTemplate.getForObject("http://localhost:8090/api/getListKurikulum/"+ id_univ + "/" + id_fakultas + "/" + id_prodi, Map.class);

            JSONObject jsonResult = new JSONObject(result);
            if(jsonResult.getInt("status") == HttpStatus.OK.value()) {
                JSONArray jsonKurikulum = jsonResult.getJSONArray("result");

                for(int j = 0 ; j < jsonKurikulum.length(); j++){
                    JSONArray jsonMatkulWajib = jsonKurikulum.getJSONObject(j).getJSONArray("list_matkul_wajib");
                    List<MataKuliah> listMatkulWajib = new ArrayList<>();
                    for(int i = 0; i < jsonMatkulWajib.length(); i++){
                        listMatkulWajib.add(getMatkul(jsonMatkulWajib.getJSONObject(i).getInt("id") + ""));
                    }

                    JSONArray jsonMatkulPilihan = jsonKurikulum.getJSONObject(j).getJSONArray("list_matkul_pilihan");
                    List<MataKuliah> listMatkulPilihan = new ArrayList<>();
                    for(int i = 0; i < jsonMatkulPilihan.length(); i++){
                        listMatkulPilihan.add(getMatkul(jsonMatkulPilihan.getJSONObject(i).getInt("id") + ""));
                    }

                    kurikulumList.add( new Kurikulum(
                            jsonKurikulum.getJSONObject(j).getInt("id"),
                            jsonKurikulum.getJSONObject(j).getString("nama_kurikulum"),
                            jsonKurikulum.getJSONObject(j).getInt("jumlah_sks_wajib"),
                            jsonKurikulum.getJSONObject(j).getInt("jumlah_sks_pilihan"),
                            jsonKurikulum.getJSONObject(j).getString("kode_univ"),
                            jsonKurikulum.getJSONObject(j).getString("kode_fakultas"),
                            jsonKurikulum.getJSONObject(j).getString("kode_prodi"),
                            jsonKurikulum.getJSONObject(j).getString("tahun_mulai"),
                            jsonKurikulum.getJSONObject(j).getString("tahun_akhir"),
                            listMatkulWajib,
                            listMatkulPilihan
                    ));
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return kurikulumList;
    }


}
