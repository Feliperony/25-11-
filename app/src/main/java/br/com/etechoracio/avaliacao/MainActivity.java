package br.com.etechoracio.avaliacao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import br.com.etechoracio.avaliacao.service.ProjetoAPIService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.http.Path;

public  class MainActivity extends AppCompatActivity {

    EditText editNum1;
    EditText editNum2;

    private ProjetoAPIService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editNum1 = findViewById(R.id.editNum1);
        editNum2 = findViewById(R.id.editNum2);

    }

    public void onCreateView(){
        this.service = new Retrofit.Builder().baseUrl("http://172.16.58.22:8001/api/funcoes/divisao")
                .addConverterFactory(JacksonConverterFactory.create())
                .build()
                .create(ProjetoAPIService.class);

        Call<String> call = this.service.exectutar(@Path("valor") String );
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }

    public void onProcessar(View view){

    }




}
