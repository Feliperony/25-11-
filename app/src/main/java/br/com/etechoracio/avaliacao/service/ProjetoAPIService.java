package br.com.etechoracio.avaliacao.service;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ProjetoAPIService{

    @GET("{num1}/{num2}")
    Call<String> exectutar(@Path("num1") String num1, @Path("num2") String num2);
}
