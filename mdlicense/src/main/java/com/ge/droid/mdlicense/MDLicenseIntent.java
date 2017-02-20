package com.ge.droid.mdlicense;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.ColorInt;

import com.ge.droid.mdlicense.ui.LibraryActivity;

import java.util.ArrayList;

/**
 * Entry for the material design license Activity.
 */
public final class MDLicenseIntent {

    /**
     * ArrayList of the libraries.
     */
    public static final String EXTRA_LIBRARIES = "extra_libraries";

    /**
     * Background color of the list page. Value should be a color int.
     */
    public static final String EXTRA_BACKGROUND_COLOR = "extra_background_color";

    /**
     * Custom text of the header. Default text is "Thanks to these awesome libraries.".
     */
    public static final String EXTRA_HEADER_TEXT = "extra_header_text";

    /**
     * Color of header text. Value should be a color int.
     */
    public static final String EXTRA_HEADER_TEXT_COLOR = "extra_header_text_color";

    /**
     * Color of the list tile's background. Value should be a color int.
     */
    public static final String EXTRA_TILE_COLOR = "extra_tile_color";

    /**
     * Whether the list item is full bleed. Otherwise it will be CardView style.
     */
    public static final String EXTRA_FULL_BLEED = "extra_full_bleed";

    /**
     * Color of library name. Value should be a color int.
     */
    public static final String EXTRA_LIBRARY_NAME_COLOR = "extra_library_name_color";

    /**
     * Color of author name. Value should be a color int.
     */
    public static final String EXTRA_AUTHOR_NAME_COLOR = "extra_author_name_color";

    private final Context mContext;

    private final Intent mIntent;

    /**
     * Construct a MDLicenseIntent to fire the Intent.
     * @param intent Intent built to start {@link LibraryActivity}
     */
    private MDLicenseIntent(Context context, Intent intent) {
        mContext = context;
        mIntent = intent;
    }

    /**
     * Start the material design license page which is {@link LibraryActivity}
     */
    public void launch() {
        mContext.startActivity(mIntent);
    }

    /**
     * Builder to create the launch Intent.
     */
    public static class Builder {
        private final Intent mIntent;
        private final Context mContext;

        public Builder(Context context) {
            mContext = context;
            mIntent = new Intent(Intent.ACTION_VIEW);
            mIntent.setClass(context, LibraryActivity.class);
        }

        /**
         * Set ArrayList of libraries.
         * @param libraries ArrayList of libraries
         * @return Builder itself
         */
        public Builder libraries(ArrayList<Library> libraries) {
            mIntent.putParcelableArrayListExtra(EXTRA_LIBRARIES, libraries);
            return this;
        }

        /**
         * Set background color of the list page.
         * @param backgroundColor Background color of the list page
         * @return Builder itself
         */
        public Builder backgroundColor(@ColorInt int backgroundColor) {
            mIntent.putExtra(EXTRA_BACKGROUND_COLOR, backgroundColor);
            return this;
        }

        /**
         * Set custom text of the header.
         * @param headerText Custom text
         * @return Builder itself
         */
        public Builder headerText(String headerText) {
            mIntent.putExtra(EXTRA_HEADER_TEXT, headerText);
            return this;
        }

        /**
         * Set color of the header text.
         * @param headerTextColor Color of the header text
         * @return Builder itself
         */
        public Builder headerTextColor(@ColorInt int headerTextColor) {
            mIntent.putExtra(EXTRA_HEADER_TEXT_COLOR, headerTextColor);
            return this;
        }

        /**
         * Set background color of the list tile.
         * @param tileColor Background color of the list tile
         * @return Builder itself
         */
        public Builder tileColor(@ColorInt int tileColor) {
            mIntent.putExtra(EXTRA_TILE_COLOR, tileColor);
            return this;
        }

        /**
         * Set if the list tile be full bleed, otherwise it will be CardView style.
         * @param fullBleed If the list tile be full bleed
         * @return Builder itself
         */
        public Builder fullBleed(boolean fullBleed) {
            mIntent.putExtra(EXTRA_FULL_BLEED, fullBleed);
            return this;
        }

        /**
         * Set color of the library name.
         * @param libraryNameColor Color of the library name
         * @return Builder itself
         */
        public Builder libraryNameColor(@ColorInt int libraryNameColor) {
            mIntent.putExtra(EXTRA_LIBRARY_NAME_COLOR, libraryNameColor);
            return this;
        }

        /**
         * Set color of the author name.
         * @param authorNameColor Color of the author name
         * @return Builder itself
         */
        public Builder authorNameColor(@ColorInt int authorNameColor) {
            mIntent.putExtra(EXTRA_AUTHOR_NAME_COLOR, authorNameColor);
            return this;
        }

        /**
         * Build the {@link MDLicenseIntent}.
         * @return {@link MDLicenseIntent}
         */
        public MDLicenseIntent build() {
            return new MDLicenseIntent(mContext, mIntent);
        }
    }

}
