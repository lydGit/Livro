package lyd.github.livro.label.model;

import java.util.List;

import lyd.github.livro.base.model.BaseViewModel;
import lyd.github.livro.data.Entity.ClassOneEntity;
import lyd.github.livro.label.data.ClassOneLiveData;

/**
 * @author shawn
 * @date 18/2/23
 * @desription
 */

public class ClassOneModel extends BaseViewModel{

    private ClassOneLiveData<List<ClassOneEntity>> mClassOneLiveData;

    public ClassOneLiveData<List<ClassOneEntity>> getmClassOneLiveData() {
        if(mClassOneLiveData==null){
            mClassOneLiveData = new ClassOneLiveData<>();
        }
        return mClassOneLiveData;
    }
}
