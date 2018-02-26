package lyd.github.livro.label;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import lyd.github.livro.R;
import lyd.github.livro.base.view.BaseTitleActivity;
import lyd.github.livro.data.AppDataBase;
import lyd.github.livro.data.AppDataDao;
import lyd.github.livro.data.Entity.ClassOneEntity;
import lyd.github.livro.label.model.ClassOneViewModel;

/**
 * @author shawn
 * @date 18/2/22
 * @desription 一级分类界面
 */

public class ClassOneActivity extends BaseTitleActivity {

    @InjectView(R.id.click)
    TextView click;
    private ClassOneViewModel mClassOneViewModel;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, ClassOneActivity.class);
        context.startActivity(intent);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_class_one;
    }

    @Override
    public String getTitleName() {
        return "一级分类";
    }

    @Override
    public void init() {
        mClassOneViewModel = ViewModelProviders.of(this).get(ClassOneViewModel.class);
        mClassOneViewModel.getClassOneLiveData().observe(this, new Observer<List<ClassOneEntity>>() {
            @Override
            public void onChanged(@Nullable List<ClassOneEntity> classOneEntities) {
                Log.e("lyd", " onChanged1 " + (classOneEntities == null));
                if (classOneEntities != null) {
                    Log.e("lyd", " onChanged2 " + classOneEntities.size());
                }
            }
        });

//        AppDataDao dataDao = AppDataBase.getInstance().getDao();
//        dataDao.getClassOneEntity().observe(this, new Observer<List<ClassOneEntity>>() {
//            @Override
//            public void onChanged(@Nullable List<ClassOneEntity> classOneEntities) {
//                Log.e("lyd", " dataDao1 " + (classOneEntities == null));
//                Log.e("lyd", " dataDao2 " + (classOneEntities.size()));
//            }
//        });
    }

    //    @OnClick(R.id.click)
    void add() {
        Log.e("lyd", " add ");
        final AppDataDao dataDao = AppDataBase.getInstance().getDao();
        new Thread(new Runnable() {
            @Override
            public void run() {
                dataDao.insertClassOneEntity(new ClassOneEntity("汽车", 1));
            }
        }).start();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.inject(this);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("lyd","  ButterKnife  ");
                mClassOneViewModel.insertClassOneEntity(new ClassOneEntity("船",1));
            }
        });
    }
}
