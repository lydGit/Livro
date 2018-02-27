package lyd.github.livro.label;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;
import butterknife.OnClick;
import lyd.github.livro.R;
import lyd.github.livro.base.view.BaseTitleActivity;
import lyd.github.livro.base.widget.EditDialog;
import lyd.github.livro.data.Entity.ClassOneEntity;
import lyd.github.livro.label.adapter.ClassAdapter;
import lyd.github.livro.label.model.ClassOneViewModel;

/**
 * @author shawn
 * @date 18/2/22
 * @desription 一级分类界面
 */

public class ClassOneActivity extends BaseTitleActivity {

    @InjectView(R.id.rv_class_one)
    RecyclerView rvClassOne;
    @InjectView(R.id.srl_class_one)
    SwipeRefreshLayout srlClassOne;
    @InjectView(R.id.tv_common_title_edit)
    TextView tvCommonTitleEdit;

    private ClassOneViewModel mClassOneViewModel;
    private ClassAdapter classAdapter;

    /**
     * 编辑状态 true编辑中
     */
    private boolean editStatus = false;

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
        tvCommonTitleEdit.setText("编辑");
        srlClassOne.setColorSchemeResources(R.color.colorTheme);
        classAdapter = new ClassAdapter();
        classAdapter.setOnItemClickListener(new ItemClickListener());
        rvClassOne.setLayoutManager(new LinearLayoutManager(this));
        rvClassOne.setAdapter(classAdapter);
    }

    @Override
    public void initViewModel() {
        mClassOneViewModel = ViewModelProviders.of(this).get(ClassOneViewModel.class);
        mClassOneViewModel.getClassOneLiveData().observe(this, new Observer<List<ClassOneEntity>>() {
            @Override
            public void onChanged(@Nullable List<ClassOneEntity> entityList) {
                if(entityList==null){
                    entityList = new ArrayList<ClassOneEntity>();
                }
//                if(entityList.size()==0||entityList.size()>0&&entityList.get(0).getSort()>0){
//                    ClassOneEntity entity = new ClassOneEntity("＋ 添加", -10);
//                    entityList.add(0,entity);
//                }
                srlClassOne.setRefreshing(false);
                classAdapter.setNewData(entityList);
            }
        });
    }

    @OnClick(R.id.tv_common_title_edit)
    void edit() {
        Log.e("lyd"," edit ");
        ClassOneEntity entity = new ClassOneEntity("＋ 添加", -10);
        List<ClassOneEntity> entityList = classAdapter.getData();
        //根据编辑状态修改UI
        if (editStatus == false) {
            editStatus = true;
            tvCommonTitleEdit.setText("保存");
            entityList.add(0, entity);
            classAdapter.setNewData(entityList);
        } else {
            editStatus = false;
            tvCommonTitleEdit.setText("编辑");
            entityList.remove(0);
            classAdapter.setNewData(entityList);
        }
    }

    private void showAddClass() {
        Log.e("lyd","  showAddClass  ");
//        QMUIDialog.EditTextDialogBuilder dialogBuilder = new QMUIDialog.EditTextDialogBuilder(this);
//        dialogBuilder.setTitle("添加分类");
//        dialogBuilder.setPlaceholder("添加分类");
//        dialogBuilder.show();
        EditDialog editDialog = new EditDialog(this, "添加分类", "请输入分类名称", "取消", "确认");
        editDialog.setOnDialogClickListener(new EditDialog.OnDialogClickListener() {
            @Override
            public void onClick(int position, String text) {
                if (position == 1) {
                    addClass(text);
                }
            }
        });
        editDialog.show();
    }

    private void addClass(String className) {
        mClassOneViewModel.insertClassOneEntity(new ClassOneEntity(className, classAdapter.getData().size() - 1));
    }

    class ItemClickListener implements OnItemClickListener {

        @Override
        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
            //编辑状态下点击添加按钮
            if (editStatus == true && position == 0) {
                showAddClass();
            }
            //编辑状态下点击Item,修改分类名称
            else if (editStatus == true && position != 0) {

            }
            //非编辑状态下点击Item
            else if (editStatus == false) {

            }
        }
    }

}
