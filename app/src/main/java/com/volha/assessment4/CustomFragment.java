package com.volha.assessment4;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuliya-k on 12/6/17.
 */

public class CustomFragment extends Fragment {

  private TextView textView;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment, container, false);

    textView = view.findViewById(R.id.text);
    RecyclerView recyclerView = view.findViewById(R.id.recycler_view);

    List<CustomObject> objects = createList();
    CustomAdapter adapter = new CustomAdapter(objects);
    LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
    recyclerView.setLayoutManager(layoutManager);
    recyclerView.setAdapter(adapter);

    return view;
  }

  private List<CustomObject> createList() {
    List<CustomObject> list = new ArrayList<>();
    list.add(new CustomObject(0));
    list.add(new CustomObject(1));
    list.add(new CustomObject(2));
    list.add(new CustomObject(3));
    list.add(new CustomObject(4));
    list.add(new CustomObject(5));
    list.add(new CustomObject(6));
    list.add(new CustomObject(7));
    list.add(new CustomObject(8));
    list.add(new CustomObject(9));
    list.add(new CustomObject(10));
    return list;
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    Intent intent = getActivity().getIntent();
    String emailPassed = intent.getStringExtra(LoginActivity.EMAIL_KEY);

    textView.setText(emailPassed);
  }
}
