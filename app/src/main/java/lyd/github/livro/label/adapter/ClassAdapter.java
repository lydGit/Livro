package lyd.github.livro.label.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import lyd.github.livro.R;
import lyd.github.livro.data.Entity.ClassOneEntity;

/**
 * @author shawn
 * @date 18/2/26
 * @desription 一级分类列表
 */

public class ClassAdapter extends BaseQuickAdapter<ClassOneEntity, BaseViewHolder> {

    public ClassAdapter() {
        super(R.layout.adapter_class);
    }

    @Override
    protected void convert(BaseViewHolder helper, ClassOneEntity item) {
        helper.setText(R.id.tv_class_name, item.getClassName());
    }


}
