package com.example.dowchemicalapp;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.dowchemicalapp.databinding.FragmentSecondBinding;

import java.util.Arrays;
import java.util.List;

import com.example.dowchemicalapp.EmailSender;
import com.example.dowchemicalapp.MainActivity;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;


    public String arrayToList(String[] array) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }

        String result = sb.toString();

        return result;
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        LinearLayout linearLayout = binding.linearLayout;
        binding.spinner.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, new String[] {"To Do", "In Progress", "Done", "Overdue", "All", "Newest", "Oldest"}));
        Project P1 = new Project(new String[]{"Test Task 1"}, new String[]{"John Doe"}, new String[]{"A project about something"}, new String[]{"Jane Smith", "Bob Johnson"}, new String[]{"johndoe@email.com", "janesmith@email.com", "bobjohnson@email.com"}, new String[]{"2023-01-01"}, new String[]{"2023-02-15"}, new String[]{"In Progress"});
        Project P2 = new Project(new String[]{"Test Task 2"}, new String[]{"Jane Smith"}, new String[]{"Another project about something"}, new String[]{"John Doe", "Bob Johnson"}, new String[]{"janesmith@email.com", "johndoe@email.com", "bobjohnson@email.com"}, new String[]{"2023-03-01"}, new String[]{"2023-04-15"}, new String[]{"Done"});
        Project P3 = new Project(new String[]{"Research Study"}, new String[]{"Mark Thompson"}, new String[]{"Conduct a study to analyze consumer behavior"}, new String[]{"Emma Garcia", "Michael Johnson"}, new String[]{"markthompson@email.com", "emmagarcia@email.com", "michaeljohnson@email.com"}, new String[]{"2023-09-01"}, new String[]{"2023-12-15"}, new String[]{"Done"});
        Project P4 = new Project(new String[]{"Marketing Campaign"}, new String[]{"Alex Brown"}, new String[]{"Develop a marketing strategy for a new product launch"}, new String[]{"Jane Miller", "David Wilson"}, new String[]{"alexbrown@email.com", "janemiller@email.com", "davidwilson@email.com"}, new String[]{"2023-07-01"}, new String[]{"2023-08-31"}, new String[]{"To Do"});
        Project P5 = new Project(new String[]{"Website Redesign"}, new String[]{"Emily Davis"}, new String[]{"Revamp the company website to improve user experience"}, new String[]{"John Smith", "Sarah Johnson"}, new String[]{"emilydavis@email.com", "johnsmith@email.com", "sarahjohnson@email.com"}, new String[]{"2023-05-01"}, new String[]{"2023-06-30"}, new String[]{"Overdue"});

        List<Project> projectList = Arrays.asList(P1, P2, P3, P4, P5);

        setTaskViewer(projectList, linearLayout);

        binding.taskbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_AddTask);
            }
        });


    }


    public void setTaskViewer(List<Project> projectList, LinearLayout linearLayout){

        for (Project project : projectList) {
            TextView textView = new TextView(getContext());
            Button button = new Button(getContext());
            button.setText(arrayToList(project.getName()));
            textView.setPadding(20, 20, 20, 20);
            String dateTag = "l";
            if (Arrays.equals(project.getCompletionStatus(), new String[]{"Done"})){dateTag = "Date Submitted";}
            else {dateTag = "Due Date";}

            textView.setText("\nStatus: " + arrayToList(project.getCompletionStatus())
                    + "\nCreator: " + arrayToList(project.getCreator())
                    + "\nDescription: " + arrayToList(project.getDescription())
                    + "\nCoworkers: " + arrayToList(project.getCoworkers())
                    + "\nEmail: " + arrayToList(project.getEmail())
                    + "\nDate Assigned: " + arrayToList(project.getDateAssigned())
                    + "\n" + dateTag + ": " + arrayToList(project.getDateSubmitted()));
            textView.setTextColor(Color.BLACK);
            textView.setTextSize(20);
            textView.setBackgroundColor(Color.WHITE);
            textView.setElevation(10);
            textView.setClickable(true);


            // Set the text appearance
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                textView.setTextAppearance(android.R.style.TextAppearance_Material_Body1);
            } else {
                textView.setTextAppearance(getContext(), android.R.style.TextAppearance_Material_Body1);
            }

            // Set the padding
            int padding = getResources().getDimensionPixelSize(R.dimen.padding_medium);
            textView.setPadding(padding, -30, padding, padding);

            // Create a layout params for the text view
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            layoutParams.bottomMargin = padding;


            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    // Navigate to the ThirdFragment
                    NavHostFragment.findNavController(SecondFragment.this)
                            .navigate(R.id.secondtothird);
                }
            });


            if (Arrays.equals(project.getCompletionStatus(), new String[]{"Done"})) {
                button.setBackgroundColor(Color.parseColor("#b8d4e0"));
            } else if (Arrays.equals(project.getCompletionStatus(), new String[]{"In Progress"})) {
                button.setBackgroundColor(Color.parseColor("#f0f05d"));
            } else if (Arrays.equals(project.getCompletionStatus(), new String[]{"To Do"})) {
                button.setBackgroundColor(Color.parseColor("#79d179"));
            } else if (Arrays.equals(project.getCompletionStatus(), new String[]{"Overdue"})) {
                button.setBackgroundColor(Color.parseColor("#ed6255"));
            }
            linearLayout.addView(button);
            linearLayout.addView(textView, layoutParams);


        }




    }









    @Override
    public void onDestroyView() {

        super.onDestroyView();
        binding = null;
    }

}