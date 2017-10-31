package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Samrudh Shetty on 23-05-2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    int mcolor;

    public WordAdapter(Context context, ArrayList<Word> words, int color) {
        super(context, 0, words);
        this.mcolor = color;
    }

    public WordAdapter(Context context, ArrayList<Word> words) {
        super(context, 0, words);
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView miowkTextView = (TextView) listItemView.findViewById(R.id.miowk_text_view);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        miowkTextView.setText(currentWord.getMiowkWord());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        defaultTextView.setText(currentWord.getDefaultTranslation());

        //Find the ImageView in the list_item.xml layout with the ID
        ImageView miwokImageView = (ImageView) listItemView.findViewById(R.id.image);

        if(currentWord.hasImage()) {
            miwokImageView.setImageResource(currentWord.getImageResourceId());
            miwokImageView.setVisibility(View.VISIBLE);
        }
        else
            miwokImageView.setVisibility(View.GONE);

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_view);
       // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mcolor);
       // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
