package lyd.github.livro;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import lyd.github.livro.data.AppDataBase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppDataBase dataBase = AppDataBase.getInstance();
    }
}
