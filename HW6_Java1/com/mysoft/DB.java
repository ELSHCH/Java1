package com.mysoft;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shcheki on 20.03.2015.
 */
public class DB {
    public static List<News> getNews(){
        ArrayList<News> News =new ArrayList<News>();
        News e =new News();
        e.setTitle("Новость первая");
        e.setText("Эта первая новость о том, как прекрасен этот мир!");
        e.setNumNews(1);
        News.add(e);

        News e1 =new News();
        e1.setTitle("Новость вторая");
        e1.setNumNews(2);
        e.setText("Эта вторая новость о том, какая чудесная сегодня погода.");
        News.add(e1);
        return News;
    }
    public static List<News> setNews(  ArrayList<News> News, News e){
        News.add(e);
        return News;
    }
}
