package com.example.schulungneu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG_TEST = MainActivity.class.getSimpleName();
    private List<String> mSampleQuoteList;
    private List<String> mSampleAuthorList;
    private List<Quote> mQuoteList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        logMessage();
        createQuoteList();
        createAuthorList();
        setContentView(R.layout.activity_main);
        bindAdapterToListView();
    }

    private void createQuoteList() {
        String[] sampleQuotes = getResources().getStringArray(R.array.sample_quotes);
        mSampleQuoteList = new ArrayList<>(Arrays.asList(sampleQuotes));

        Quote sampleQuote = new Quote(sampleQuotes[0], "Author 0", "0");
        mQuoteList.add(sampleQuote);
    }

    private void createAuthorList() {
        String[] sampleAuthors = getResources().getStringArray(R.array.quote_authors);
        mSampleAuthorList = new ArrayList<>(Arrays.asList(sampleAuthors));
    }

    private void bindAdapterToListView() {
        // ToDo: ArrayAdapter wechseln
        ArrayAdapter<Quote> quoteArrayAdapter =
                new ArrayAdapter<>(
                        this, // Die aktuelle Umgebung (diese Activity)
                        R.layout.list_row, // Die ID des Zeilenlayouts (der XML-Layout Datei)
                        R.id.quote_author,   // Die ID eines TextView-Elements im Zeilenlayout
                        mQuoteList); // Beispieldaten in einer ArrayList

        ListView quoteListView = (ListView) findViewById(R.id.listview_activity_main);
        quoteListView.setAdapter(quoteArrayAdapter);
    }

    private void logMessage() {
        Log.v(LOG_TAG_TEST, "test");
    }
}