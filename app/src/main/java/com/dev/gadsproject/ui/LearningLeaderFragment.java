package com.dev.gadsproject.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dev.gadsproject.R;
import com.dev.gadsproject.adapters.LearningLeaderAdapter;
import com.dev.gadsproject.model.HoursItem;
import com.dev.gadsproject.repository.GADSClient;
import com.dev.gadsproject.repository.GADSService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LearningLeaderFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LearningLeaderFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private LearningLeaderAdapter adapter;
    private RecyclerView recyclerView;
    public LearningLeaderFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LearningLeaderFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LearningLeaderFragment newInstance(String param1, String param2) {
        LearningLeaderFragment fragment = new LearningLeaderFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_learning_leader, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initAdapter();
        fetchHourLearner();
    }

    private void initAdapter(){
        adapter= new LearningLeaderAdapter(getContext());
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void fetchHourLearner(){
        GADSService service = GADSClient.getRetrofit().create(GADSService.class);
        service.fetchHoursList()
                .enqueue(new Callback<List<HoursItem>>() {
                    @Override
                    public void onResponse(Call<List<HoursItem>> call, Response<List<HoursItem>> response) {
                        assert response.body() != null;
                        adapter.addAll(response.body());
                    }

                    @Override
                    public void onFailure(Call<List<HoursItem>> call, Throwable t) {

                    }
                });
    }

}