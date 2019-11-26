package br.com.etechoracio.avaliacao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import br.com.etechoracio.avaliacao.service.ProjetoAPIService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.http.Path;

public  class MainActivity extends AppCompatActivity {

    EditText TxtNum1;
    EditText TxtNum2;

    private ProjetoAPIService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TxtNum1 = findViewById(R.id.editNum1);
        TxtNum2 = findViewById(R.id.editNum2);

        this.service = new Retrofit.Builder().baseUrl("http://172.16.58.22:8001/api/funcoes/divisao/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build()
                .create(ProjetoAPIService.class);

    }

    public void onProcessar(View view){

        Call<String> call = this.service.exectutar(TxtNum1.getText().toString(), TxtNum2.getText().toString());
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String Resultado = response.body();
                Toast.makeText(getApplicationContext(),Resultado, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

                Log.e("ProjetoAPIService ", "Erro:" + t.getMessage());
            }
        });

    }




}
