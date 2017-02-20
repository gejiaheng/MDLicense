package com.ge.droid.mdlicense;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * A open source library.
 */
public class Library implements Parcelable {

	public Library(String name, String author, String website) {
		this.name = name;
		this.author = author;
		this.website = website;
	}

	/**
	 * Name of the library.
	 */
	public String name;

	/**
	 * Name of the author.
	 */
	public String author;

	/**
	 * Website url of the library.
	 */
	public String website;

	@Override
	public int describeContents() { return 0; }

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.name);
		dest.writeString(this.author);
		dest.writeString(this.website);
	}

	public Library() {}

	protected Library(Parcel in) {
		this.name = in.readString();
		this.author = in.readString();
		this.website = in.readString();
	}

	public static final Parcelable.Creator<Library> CREATOR = new Parcelable.Creator<Library>() {

		@Override
		public Library createFromParcel(Parcel source) {return new Library(source);}

		@Override
		public Library[] newArray(int size) {return new Library[size];}
	};
}
