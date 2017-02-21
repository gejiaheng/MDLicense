package com.sample.mdlicense;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ge.droid.mdlicense.Library;
import com.ge.droid.mdlicense.MDLicenseIntent;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.launch_default).setOnClickListener(this);
        findViewById(R.id.launch_custom).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.launch_default) {
            new MDLicenseIntent.Builder(this)
                    .libraries(getTestLibraries())
                    .build()
                    .launch();
        } else if (v.getId() == R.id.launch_custom) {
            new MDLicenseIntent.Builder(this)
                    .libraries(getTestLibraries())
                    .backgroundColor(ContextCompat.getColor(this, R.color.custom_background))
                    .tileColor(ContextCompat.getColor(this, R.color.custom_tile_color))
                    .libraryNameColor(ContextCompat.getColor(this, R.color.custom_library_name_color))
                    .authorNameColor(ContextCompat.getColor(this, R.color.custom_author_name_color))
                    .fullBleed(true)
                    .build()
                    .launch();
        }
    }

    private ArrayList<Library> getTestLibraries() {
        ArrayList<Library> libraries = new ArrayList<>();
        libraries.add(new Library("Retrofit", "Square", "https://github.com/square/retrofit"));
        libraries.add(new Library("Gson", "Google", "https://github.com/google/gson"));
        libraries.add(new Library("Glide", "Bump Technologies", "https://github.com/bumptech/glide"));
        libraries.add(new Library("RxBinding", "Jake Wharton", "https://github.com/JakeWharton/RxBinding"));
        libraries.add(new Library("Butter knife", "Jake Wharton", "https://github.com/JakeWharton/butterknife"));
        libraries.add(new Library("timber", "Jake Wharton", "https://github.com/JakeWharton/timber"));
        libraries.add(new Library("lottie-android", "airbnb", "https://github.com/airbnb/lottie-android"));
        libraries.add(new Library("Dagger 2", "Google", "https://github.com/google/dagger"));
        libraries.add(new Library("RxPermissions", "Thomas Bruyelle", "https://github.com/tbruyelle/RxPermissions"));
        libraries.add(new Library("android-state", "Evernote", "https://github.com/evernote/android-state"));
        return libraries;
    }
}
