package com.ge.droid.mdlicense.ui;

/**
 * Convenient holder of the style.
 */
public class LicenseStyle {
    public String headerText;
    public int headerTextColor;
    public int libraryNameColor;
    public int authorNameColor;
    public int tileColor;
    public boolean fullBleed;

    public static class Builder {
        private String mHeaderText;
        private int mHeaderTextColor;
        private int mLibraryNameColor;
        private int mAuthorColor;
        private int mTileColor;
        private boolean mFullBleed;

        public Builder headerText(String headerText) {
            mHeaderText = headerText;
            return this;
        }

        public Builder headerTextColor(int headerTextColor) {
            mHeaderTextColor = headerTextColor;
            return this;
        }

        public Builder libraryNameColor(int libraryNameColor) {
            mLibraryNameColor = libraryNameColor;
            return this;
        }

        public Builder authorNameColor(int authorColor) {
            mAuthorColor = authorColor;
            return this;
        }

        public Builder tileColor(int tileColor) {
            mTileColor = tileColor;
            return this;
        }

        public Builder fullBleed(boolean fullBleed) {
            mFullBleed = fullBleed;
            return this;
        }

        public LicenseStyle build() {
            LicenseStyle style = new LicenseStyle();
            style.headerText = mHeaderText;
            style.headerTextColor = mHeaderTextColor;
            style.libraryNameColor = mLibraryNameColor;
            style.authorNameColor = mAuthorColor;
            style.tileColor = mTileColor;
            style.fullBleed = mFullBleed;
            return style;
        }
    }
}
