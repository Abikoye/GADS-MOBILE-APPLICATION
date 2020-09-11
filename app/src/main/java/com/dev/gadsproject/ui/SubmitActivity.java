package com.dev.gadsproject.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.dev.gadsproject.R;
import com.dev.gadsproject.databinding.ActivitySubmitBinding;
import com.dev.gadsproject.databinding.ItemListLearningLeaderBinding;
import com.dev.gadsproject.model.SkillIq;
import com.dev.gadsproject.repository.GADSClient;
import com.dev.gadsproject.repository.GADSService;
import com.google.gson.JsonObject;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubmitActivity extends AppCompatActivity {

    private ActivitySubmitBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_submit);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ImageView backImage = toolbar.findViewById(R.id.btn_back);
        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        binding.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitForm();
            }
        });
    }

    private void submitForm(){
        String name = binding.edtFirstName.getText().toString();
        String lastName = binding.edtLastName.getText().toString();
        String email = binding.edtEmail.getText().toString();
        String link = binding.edtGithub.getText().toString();

        GADSService service = GADSClient.retrofitGoogle().create(GADSService.class);
        service.submitProject(email,name,lastName,link)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        assert response.body() != null;
                        Toast.makeText(getApplicationContext(),"Submitted successfully",Toast.LENGTH_LONG).show();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"Failed to submit",Toast.LENGTH_LONG).show();
                    }
                });
    }
}