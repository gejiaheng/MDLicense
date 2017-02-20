package com.ge.droid.mdlicense.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.ge.droid.mdlicense.LibAdapter;
import com.ge.droid.mdlicense.MDLicenseIntent;
import com.ge.droid.mdlicense.R;
import java.util.List;

public class LibraryActivity extends AppCompatActivity {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_library);

		Intent intent = getIntent();
		List libraryList = intent.getParcelableArrayListExtra(MDLicenseIntent.EXTRA_LIBRARIES);
		int backgroundColor = intent.getIntExtra(MDLicenseIntent.EXTRA_BACKGROUND_COLOR,
				ContextCompat.getColor(this, R.color.default_background));
		String headerText = intent.getStringExtra(MDLicenseIntent.EXTRA_HEADER_TEXT);
		int headerTextColor = intent.getIntExtra(MDLicenseIntent.EXTRA_HEADER_TEXT_COLOR,
				ContextCompat.getColor(this, R.color.default_header_text_color));
		int tileColor = intent.getIntExtra(MDLicenseIntent.EXTRA_TILE_COLOR,
				ContextCompat.getColor(this, R.color.default_tile_color));
		boolean fullBleed = intent.getBooleanExtra(MDLicenseIntent.EXTRA_FULL_BLEED, false);
		int libraryNameColor = intent.getIntExtra(MDLicenseIntent.EXTRA_LIBRARY_NAME_COLOR,
				ContextCompat.getColor(this, R.color.default_library_name_color));
		int authorNameColor = intent.getIntExtra(MDLicenseIntent.EXTRA_AUTHOR_NAME_COLOR,
				ContextCompat.getColor(this, R.color.default_author_name_color));

		findViewById(R.id.root).setBackgroundColor(backgroundColor);

		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
		toolbar.getNavigationIcon().setTint(headerTextColor);
		toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				onBackPressed();
			}
		});

		RecyclerView recyclerView = (RecyclerView) findViewById(R.id.library_list);
		recyclerView.setHasFixedSize(true);
		recyclerView.setLayoutManager(new LinearLayoutManager(this));

		LicenseStyle style = new LicenseStyle.Builder()
				.headerText(headerText)
				.headerTextColor(headerTextColor)
				.libraryNameColor(libraryNameColor)
				.authorNameColor(authorNameColor)
				.tileColor(tileColor)
				.fullBleed(fullBleed)
				.build();

		recyclerView.setAdapter(new LibAdapter(recyclerView, libraryList, style));
	}

}
