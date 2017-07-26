package com.example.lonny.myfreehsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private TextView titleTextView;
    private TextView linksTextView;
    private Document doc;
    private Elements links;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titleTextView=(TextView) findViewById(R.id.title);
        linksTextView=(TextView) findViewById(R.id.links);

        try {

            // need http protocol
            doc = Jsoup.connect("http://google.com").get();

            // get page title
            titleTextView.append(doc.title());



            // get all links
            links = doc.select("a[href]");
                for (Element link: links){
                    linksTextView.append(link.toString());
                }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
