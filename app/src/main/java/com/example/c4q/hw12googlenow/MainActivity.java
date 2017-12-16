package com.example.c4q.hw12googlenow;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;

import com.example.c4q.hw12googlenow.controller.ArticleAdapter;
import com.example.c4q.hw12googlenow.model.BBCmodel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class MainActivity extends AppCompatActivity {
    private String sNewsAPI;
    private List<BBCSport> list;
    private List<String> aNames;
    private BBCSport sport;
    private Button openButton;
    private BBCmodel bbcModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<>();
        ApiClient apiClient = new ApiClient();
        Retrofit retrofit = apiClient.getClient();
        final UsersApi bbcService = retrofit.create(UsersApi.class);
        Call<BBCmodel> getBBCModel = bbcService.getModel();




        getBBCModel.enqueue(new Callback<BBCmodel>() {
            @Override
            public void onResponse(Call<BBCmodel> call, Response<BBCmodel> response) {
                bbcModel = response.body();

                Log.d("MainActivitty",bbcModel.getArticles()[0].getAuthor());
                Log.d("MainActivitty",bbcModel.getArticles()[0].getTitle());
                Log.d("MainActivity",bbcModel.getArticles()[0].getDescription());
                Log.d("MainActivity",bbcModel.getArticles()[0].getPublishedAt());
                Log.d("MainActivity",bbcModel.getArticles()[0].getUrl());


            }

            @Override
            public void onFailure(Call<BBCmodel> call, Throwable t) {
                t.printStackTrace();
            }
        });
//        aNames = new ArrayList<>();
//        sNewsAPI = "https://newsapi.org/v2/top-headlines?sources=bbc-sport&apiKey=75c4a1e76269460892c3bb43746f73ad";
//       AsyncTask nice= new asyncHTTPForSports().execute(sNewsAPI);
//       openButton= (Button) findViewById(R.id.openbutton);
//        Retrofit retrofit= new Retrofit.Builder()
//                .baseUrl("https://techcrunch.com/video/crunchreport/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        Call<List<Repository>> call= ;
//
       new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {

               intiRec();
           }
       }, 5000);
//
//       openButton.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View v) {
//
//
//                Bundle bundle= new Bundle();
//               Intent intent= new Intent(MainActivity.this, SecondActivity.class);
//               for (int i = 0; i < aNames.size(); i++) {
//                   bundle.putString("nice",aNames.get(i));
//               }
//
//
//               startActivity(intent);
//
//           }
//       });
//       String news=nice.toString();
//       aNames.add(news);
//       sport.setArticle(aNames.toString());
//       list.add(sport);


//        LinearLayoutManager
//nowWeAreGoingToparseAspectsInTheArticle(sNewsAPI);


    }

    private void intiRec() {
        RecyclerView googleRecylerView = findViewById(R.id.googlerecyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        ArticleAdapter adapter = new ArticleAdapter(bbcModel.getArticles());
        googleRecylerView.setAdapter(adapter);
        googleRecylerView.setLayoutManager(linearLayoutManager);
    }

    public class asyncHTTPForSports extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... myURL) {

            String result = "";
            URL url;
            HttpURLConnection urlConnection = null;
            try {
                url = new URL(myURL[0]);
                urlConnection = (HttpURLConnection) url.openConnection();//creating a new url and creating the connection to the internet
                String response = streamToString(urlConnection.getInputStream());//we are getting the input from the url and passing to the method.
                nowWeAreGoingToparseAspectsInTheArticle(response);// we are taking the string which is a json adn parsing it.
                return result;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public String streamToString(InputStream stream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream));//we are putting the inputstream from the url
        //in to the bufferreader
        String data;
        String result = " ";
        while ((data = bufferedReader.readLine()) != null) {// the while is creating the string from the bufferreader
            result += data;


        }
        if (null != stream) {// when there is nothing else in the bufferreader we  are closing the link
            stream.close();
        }
        return result;


    }

    public void nowWeAreGoingToparseAspectsInTheArticle(String result) {
        try {
            JSONObject response = new JSONObject(result);
            JSONArray article = response.optJSONArray("articles");
            for (int i = 0; i < article.length(); i++) {
                JSONObject myArticles = article.getJSONObject(i);
                String articleTitle = myArticles.getString("title");
                aNames.add(articleTitle);
                list.add(new BBCSport(articleTitle));
                Log.d("title", articleTitle);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
