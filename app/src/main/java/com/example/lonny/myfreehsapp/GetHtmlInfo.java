package com.example.lonny.myfreehsapp;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;

/**
 * Created by lonny on 7/25/2017.
 */

public class GetHtmlInfo{
    private Document doc;
    private Elements  links;
    private String title;


    public GetHtmlInfo(String url) {
        try {

            this.doc = Jsoup.connect(url).get();
            this.links = this.doc.select("a[href]");
            this.title= this.doc.title();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Document getDoc() {
        return doc;
    }

    public void setDoc(Document doc) {
        this.doc = doc;
    }

    public Elements getLink() {
        return links;
    }

    public void setLink(Elements link) {
        this.links = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}


