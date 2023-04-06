package com.example.theworldhistory.Activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.AppCompatButton;

import com.example.theworldhistory.R;
import com.example.theworldhistory.Utilities.Constants;
import com.example.theworldhistory.Utilities.PreferenceManager;
import com.example.theworldhistory.databinding.ActivitySettingsBinding;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class SettingsActivity extends AppCompatActivity {

    private ActivitySettingsBinding binding;
    private PreferenceManager preferenceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySettingsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        preferenceManager = new PreferenceManager(getApplicationContext());
        setInitialTagToLanguage();
        loadUserDetails();
        setCurrentMode();
        setListeners();
    }

    private void setListeners() {
        binding.settingsCancel.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.putExtra("openFragment", "openProfileFragment");
            startActivity(intent);
        });
        binding.settingsSignOut.setOnClickListener(v -> signOut());
        binding.settingsSwitchDarkMode.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                restartCurrentActivity();
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                restartCurrentActivity();
            }
        });
        binding.settingsLanguageRu.setOnClickListener(v -> {
            if (binding.settingsLanguageRu.getTag() != "active") {
                setLanguageRuActive();
                setLanguageUkInactive();
                setLanguageEsInactive();
                showToast("Выбран русский язык");
            } else {
                showToast("Русский язык уже выбран");
            }
        });
        binding.settingsLanguageUk.setOnClickListener(v -> {
            if (binding.settingsLanguageUk.getTag() != "active") {
                setLanguageUkActive();
                setLanguageRuInactive();
                setLanguageEsInactive();
                showToast("Выбран английский язык");
            } else {
                showToast("Английский язык уже выбран");
            }
        });
        binding.settingsLanguageEs.setOnClickListener(v -> {
            if (binding.settingsLanguageEs.getTag() != "active") {
                setLanguageEsActive();
                setLanguageRuInactive();
                setLanguageUkInactive();
                showToast("Выбран испанский язык");
            } else {
                showToast("Испанский язык уже выбран");
            }
        });
        binding.settingsShare.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_SUBJECT, "Хотите разгадать тайны древних цивилизаций?\n");
            intent.putExtra(Intent.EXTRA_TEXT, "https://play.google.com");
            startActivity(Intent.createChooser(intent, "Поделиться с помощью"));
        });
        binding.settingsRate.setOnClickListener(v -> {
            Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=" + "org.telegram.messenger&hl=ru&gl=US");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            try {
                startActivity(intent);
            } catch (Exception e) {
                showToast("Невозможно оценить. Ошибка:\n" + e.getMessage());
            }
        });
        binding.settingsSupport.setOnClickListener(v ->
                startActivity(new Intent(getApplicationContext(), SupportActivity.class)));
        binding.settingsPrivacyPolicy.setOnClickListener(v -> showPrivacyPolicyDialog());
        binding.settingsAboutApp.setOnClickListener(v -> showAboutAppDialog());
    }

    private void loadUserDetails() {
        binding.settingsFirstname.setText(preferenceManager.getSting(Constants.KEY_FIRSTNAME));
        binding.settingsSurname.setText(preferenceManager.getSting(Constants.KEY_SURNAME));
        binding.settingsEmail.setText(preferenceManager.getSting(Constants.KEY_EMAIL));
        binding.settingsPassword.setText(preferenceManager.getSting(Constants.KEY_PASSWORD));
        byte[] bytes = Base64.decode(preferenceManager.getSting(Constants.KEY_IMAGE), Base64.DEFAULT);
        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        binding.settingsProfileAvatar.setImageBitmap(bitmap);
    }

    private void setCurrentMode() {
        int currentMode = AppCompatDelegate.getDefaultNightMode();
        binding.settingsSwitchDarkMode.setChecked(currentMode == AppCompatDelegate.MODE_NIGHT_YES);
    }

    private void restartCurrentActivity() {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    private void setInitialTagToLanguage() {
        binding.settingsLanguageRu.setTag("active");
        binding.settingsLanguageUk.setTag("inactive");
        binding.settingsLanguageEs.setTag("inactive");
    }

    private void setLanguageRuActive() {
        binding.settingsLanguageRu.setImageResource(R.drawable.ic_70_0_flag_russia_active);
        binding.settingsLanguageRu.setBackgroundResource(R.drawable.sample_language_bottom_line_active_bg);
        binding.settingsLanguageRu.setTag("active");
    }

    private void setLanguageRuInactive() {
        binding.settingsLanguageRu.setImageResource(R.drawable.ic_70_0_flag_russia_inactive);
        binding.settingsLanguageRu.setBackgroundResource(R.color.main_bg);
        binding.settingsLanguageRu.setTag("inactive");
    }

    private void setLanguageUkActive() {
        binding.settingsLanguageUk.setImageResource(R.drawable.ic_70_0_flag_united_kingdom_active);
        binding.settingsLanguageUk.setBackgroundResource(R.drawable.sample_language_bottom_line_active_bg);
        binding.settingsLanguageUk.setTag("active");
    }

    private void setLanguageUkInactive() {
        binding.settingsLanguageUk.setImageResource(R.drawable.ic_70_0_flag_united_kingdom_inactive);
        binding.settingsLanguageUk.setBackgroundResource(R.color.main_bg);
        binding.settingsLanguageUk.setTag("inactive");
    }

    private void setLanguageEsActive() {
        binding.settingsLanguageEs.setImageResource(R.drawable.ic_70_0_flag_spain_active);
        binding.settingsLanguageEs.setBackgroundResource(R.drawable.sample_language_bottom_line_active_bg);
        binding.settingsLanguageEs.setTag("active");
    }

    private void setLanguageEsInactive() {
        binding.settingsLanguageEs.setImageResource(R.drawable.ic_70_0_flag_spain_inactive);
        binding.settingsLanguageEs.setBackgroundResource(R.color.main_bg);
        binding.settingsLanguageEs.setTag("inactive");
    }

    private void showPrivacyPolicyDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(SettingsActivity.this,
                R.style.AlertDialogTheme);
        View view = LayoutInflater
                .from(SettingsActivity.this)
                .inflate(R.layout.dialog_privacy_policy, findViewById(R.id.dialog_privacy_policy_container));
        builder.setView(view);

        ((TextView) view.findViewById(R.id.dialogPrivacyPolicyTitle)).setText(getResources().getString(R.string.settings_privacy_policy));
        ((TextView) view.findViewById(R.id.dialogPrivacyPolicyDescription)).setText(getResources().getString(R.string.settings_privacy_policy_description));
        ((AppCompatButton) view.findViewById(R.id.settingsAlertDialogPrivacyPolicyOk)).setText(getResources().getString(R.string.settings_alert_dialog_ok));

        final AlertDialog alertDialog = builder.create();

        view.findViewById(R.id.settingsAlertDialogPrivacyPolicyOk).setOnClickListener(view_ok -> alertDialog.dismiss());

        if (alertDialog.getWindow() != null)
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        alertDialog.show();
    }

    private void showAboutAppDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(SettingsActivity.this,
                R.style.AlertDialogTheme);
        View view = LayoutInflater
                .from(SettingsActivity.this)
                .inflate(R.layout.dialog_about_app, findViewById(R.id.dialogAboutAppContainer));
        builder.setView(view);

        ((TextView) view.findViewById(R.id.dialogAboutAppTitle)).setText(getResources().getString(R.string.settings_about_app));
        ((TextView) view.findViewById(R.id.dialogAboutAppDescription)).setText(getResources().getString(R.string.settings_about_app_description));
        ((AppCompatButton) view.findViewById(R.id.settingsAlertDialogAboutAppOk)).setText(getResources().getString(R.string.settings_alert_dialog_ok));

        final AlertDialog alertDialog = builder.create();

        view.findViewById(R.id.settingsAlertDialogAboutAppOk).setOnClickListener(view_ok -> alertDialog.dismiss());

        if (alertDialog.getWindow() != null)
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        alertDialog.show();
    }

    private void signOut() {
        showToast("Вы вышли из аккаута");
        FirebaseFirestore database = FirebaseFirestore.getInstance();
        DocumentReference documentReference = database
                .collection(Constants.KEY_COLLECTION_USERS)
                .document(preferenceManager.getSting(Constants.KEY_USER_ID));
        HashMap<String, Object> updates = new HashMap<>();
        updates.put(Constants.KEY_FCM_TOKEN, FieldValue. delete());
        documentReference.update(updates)
                .addOnSuccessListener(unused -> {
                    preferenceManager.clear();
                    startActivity(new Intent(getApplicationContext(), SignInActivity.class));
                    finish();
                })
                .addOnFailureListener(e -> showToast("Невозможно выйти из аккаунта"));
    }

    private void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}