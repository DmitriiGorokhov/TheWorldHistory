package com.example.theworldhistory.Activities;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.theworldhistory.Fragments.AchievementsFragment;
import com.example.theworldhistory.Fragments.LeadersFragment;
import com.example.theworldhistory.Fragments.ProfileFragment;
import com.example.theworldhistory.Fragments.WorldHistoryFragment;
import com.example.theworldhistory.R;
import com.example.theworldhistory.Utilities.Constants;
import com.example.theworldhistory.Utilities.PreferenceManager;
import com.example.theworldhistory.databinding.ActivityMainBinding;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends BaseActivity {

    private ActivityMainBinding binding;
    private PreferenceManager preferenceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        preferenceManager = new PreferenceManager(getApplicationContext());
        getToken();

        openWorldHistoryFragment();
        setListeners();
        openSelectedFragment();
    }

    private void setListeners() {
        binding.worldHistoryButton.setOnClickListener(v -> openWorldHistoryFragment());
//        binding.storiesButton.setOnClickListener(v -> openStoriesFragment());
        binding.leadersButton.setOnClickListener(v -> openLeadersFragment());
        binding.achievementsButton.setOnClickListener(v -> openAchievementsFragment());
        binding.profileButton.setOnClickListener(v -> openProfileFragment());
    }

    private void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    private void getToken() {
        FirebaseMessaging.getInstance().getToken().addOnSuccessListener(this::updateToken);
    }

    private void updateToken(String token) {
        preferenceManager.putString(Constants.KEY_FCM_TOKEN, token);
        FirebaseFirestore database = FirebaseFirestore.getInstance();
        DocumentReference documentReference = database
                .collection(Constants.KEY_COLLECTION_USERS)
                .document(preferenceManager.getSting(Constants.KEY_USER_ID));
        documentReference.update(Constants.KEY_FCM_TOKEN, token)
                .addOnFailureListener(e -> showToast("Невозможно обновить токен"));
    }

    private void openWorldHistoryFragment() {
        WorldHistoryFragment worldHistoryFragment = new WorldHistoryFragment();
        LinearLayout strikeOnWorldHistory = findViewById(R.id.strike_on_world_history);
        LinearLayout lifeOnWorldHistory = findViewById(R.id.life_on_world_history);
        LinearLayout crystalOnWorldHistory = findViewById(R.id.crystal_on_world_history);
        getSupportFragmentManager().beginTransaction().replace(binding.container.getId(), worldHistoryFragment).commit();


        binding.worldHistoryButton.setImageResource(R.drawable.ic_1_2_general_bottom_world_history_active);
//        binding.storiesButton.setImageResource(R.drawable.ic_1_2_general_bottom_stories_inactive);
        binding.leadersButton.setImageResource(R.drawable.ic_1_2_general_bottom_leaders_inactive);
        binding.achievementsButton.setImageResource(R.drawable.ic_1_2_general_bottom_achievements_inactive);
        binding.profileButton.setImageResource(R.drawable.ic_1_2_general_bottom_profile_inactive);
    }

//    private void openStoriesFragment() {
//        StoriesFragment storiesFragment = new StoriesFragment();
//        LinearLayout strikeOnStories = findViewById(R.id.strike_on_stories);
//        LinearLayout lifeOnStories = findViewById(R.id.life_on_stories);
//        LinearLayout crystalOnStories = findViewById(R.id.crystal_on_stories);
//        getSupportFragmentManager().beginTransaction().replace(binding.container.getId(), storiesFragment).commit();
//
//        binding.worldHistoryButton.setImageResource(R.drawable.ic_1_2_general_bottom_world_history_inactive);
//        binding.storiesButton.setImageResource(R.drawable.ic_1_2_general_bottom_stories_active);
//        binding.leadersButton.setImageResource(R.drawable.ic_1_2_general_bottom_leaders_inactive);
//        binding.achievementsButton.setImageResource(R.drawable.ic_1_2_general_bottom_achievements_inactive);
//        binding.profileButton.setImageResource(R.drawable.ic_1_2_general_bottom_profile_inactive);
//    }

    private void openLeadersFragment() {
        LeadersFragment leadersFragment = new LeadersFragment();
        getSupportFragmentManager().beginTransaction().replace(binding.container.getId(), leadersFragment).commit();

        binding.worldHistoryButton.setImageResource(R.drawable.ic_1_2_general_bottom_world_history_inactive);
//        binding.storiesButton.setImageResource(R.drawable.ic_1_2_general_bottom_stories_inactive);
        binding.leadersButton.setImageResource(R.drawable.ic_1_2_general_bottom_leaders_active);
        binding.achievementsButton.setImageResource(R.drawable.ic_1_2_general_bottom_achievements_inactive);
        binding.profileButton.setImageResource(R.drawable.ic_1_2_general_bottom_profile_inactive);
    }

    private void openAchievementsFragment() {
        AchievementsFragment achievementsFragment = new AchievementsFragment();
        getSupportFragmentManager().beginTransaction().replace(binding.container.getId(), achievementsFragment).commit();

        binding.worldHistoryButton.setImageResource(R.drawable.ic_1_2_general_bottom_world_history_inactive);
//        binding.storiesButton.setImageResource(R.drawable.ic_1_2_general_bottom_stories_inactive);
        binding.leadersButton.setImageResource(R.drawable.ic_1_2_general_bottom_leaders_inactive);
        binding.achievementsButton.setImageResource(R.drawable.ic_1_2_general_bottom_achievements_active);
        binding.profileButton.setImageResource(R.drawable.ic_1_2_general_bottom_profile_inactive);
    }

    private void openProfileFragment() {
        ProfileFragment profileFragment = new ProfileFragment();
        getSupportFragmentManager().beginTransaction().replace(binding.container.getId(), profileFragment).commit();

        binding.worldHistoryButton.setImageResource(R.drawable.ic_1_2_general_bottom_world_history_inactive);
//        binding.storiesButton.setImageResource(R.drawable.ic_1_2_general_bottom_stories_inactive);
        binding.leadersButton.setImageResource(R.drawable.ic_1_2_general_bottom_leaders_inactive);
        binding.achievementsButton.setImageResource(R.drawable.ic_1_2_general_bottom_achievements_inactive);
        binding.profileButton.setImageResource(R.drawable.ic_1_2_general_bottom_profile_active);
    }

    private void openSelectedFragment() {
        String openFragment = getIntent().getStringExtra("openFragment");
        if (openFragment != null) {
            switch (openFragment) {
                case "openWorldHistoryFragment":
                    openWorldHistoryFragment();
                    break;
//                case "openStoriesFragment":
//                    openStoriesFragment();
//                    break;
                case "openLeadersFragment":
                    openLeadersFragment();
                    break;
                case "openAchievementsFragment":
                    openAchievementsFragment();
                    break;
                case "openProfileFragment":
                    openProfileFragment();
                    break;
            }
        }
    }
}