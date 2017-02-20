package com.ge.droid.mdlicense;

import android.net.Uri;
import android.support.customtabs.CustomTabsIntent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ge.droid.mdlicense.ui.LicenseStyle;

import java.util.ArrayList;
import java.util.List;

public class LibAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements
		View.OnClickListener {

	private static final int VIEW_TYPE_HEADER = 0x00;
	private static final int VIEW_TYPE_LIBRARY = 0x01;

	private List<Library> mLibraries = new ArrayList<>();
	private RecyclerView mRecyclerView;
	private LicenseStyle mLicenseStyle;

	public LibAdapter(RecyclerView recyclerView, List<Library> libraries, LicenseStyle licenseStyle) {
		mRecyclerView = recyclerView;
		mLibraries.addAll(libraries);
		mLicenseStyle = licenseStyle;
	}

	public void setData(List<Library> libraries) {
		if (libraries == null)
			return;

		mLibraries.clear();
		mLibraries.addAll(libraries);
	}

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		if (viewType == VIEW_TYPE_HEADER) {
			return new HeaderViewHolder(LayoutInflater.from(parent.getContext())
					.inflate(R.layout.header, parent, false));
		} else if (viewType == VIEW_TYPE_LIBRARY) {
			View libraryItemView = LayoutInflater.from(parent.getContext())
					.inflate(mLicenseStyle.fullBleed ? R.layout.library_item_fullbleed :
							R.layout.library_item_card, parent, false);
			libraryItemView.setOnClickListener(this);
			return new LibraryViewHolder(libraryItemView);
		} else {
			return null;
		}
	}

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
		if (position == 0) {
			HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;
			if (!TextUtils.isEmpty(mLicenseStyle.headerText)) {
				headerViewHolder.mHeaderText.setText(mLicenseStyle.headerText);
			}
			headerViewHolder.mHeaderText.setTextColor(mLicenseStyle.headerTextColor);
		} else {
			LibraryViewHolder libraryViewHolder = (LibraryViewHolder) holder;
			Library library = mLibraries.get(position - 1);
			libraryViewHolder.mLibraryName.setText(library.name);
			libraryViewHolder.mAuthorName.setText(library.author);
			if (libraryViewHolder.itemView instanceof CardView) {
				((CardView)libraryViewHolder.itemView).setCardBackgroundColor(mLicenseStyle.tileColor);
			} else {
				libraryViewHolder.itemView.setBackgroundColor(mLicenseStyle.tileColor);
			}
			libraryViewHolder.mLibraryName.setTextColor(mLicenseStyle.libraryNameColor);
			libraryViewHolder.mAuthorName.setTextColor(mLicenseStyle.authorNameColor);
		}
	}

	@Override
	public int getItemViewType(int position) {
		return position == 0 ? VIEW_TYPE_HEADER : VIEW_TYPE_LIBRARY;
	}

	@Override
	public int getItemCount() {
		return mLibraries.size() + 1;
	}

	@Override
	public void onClick(View v) {
		String website = mLibraries.get(mRecyclerView.getChildAdapterPosition(v) - 1).website;
		CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
		CustomTabsIntent customTabsIntent = builder.build();
		customTabsIntent.launchUrl(v.getContext(), Uri.parse(website));
	}

	static class HeaderViewHolder extends RecyclerView.ViewHolder {
		private TextView mHeaderText;
		public HeaderViewHolder(View itemView) {
			super(itemView);

			mHeaderText = (TextView) itemView;
		}
	}

	static class LibraryViewHolder extends RecyclerView.ViewHolder {

		private TextView mLibraryName;

		private TextView mAuthorName;

		public LibraryViewHolder(View itemView) {
			super(itemView);

			mLibraryName = (TextView) itemView.findViewById(R.id.library_name);
			mAuthorName = (TextView) itemView.findViewById(R.id.author_name);
		}
	}

}
