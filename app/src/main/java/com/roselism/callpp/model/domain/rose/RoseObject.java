package com.roselism.callpp.model.domain.rose;

/**
 * Business Object
 * Created by simon on 2016/4/30.
 */
public abstract class RoseObject implements IBO {

    public static final String BMOB_TYPE = "bmob";

    /**
     * 对象的id
     */
    String objectId;

    /**
     * 上传日期
     */
    String createDate;

    /**
     * 最后更新日期
     */
    String updateData;

    /**
     * 数据的类型（可能是bmob 也可能是aliyun 也可能是自己写的）
     */
    String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getObjectId() {
        return objectId;
    }

    @Override
    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    @Override
    public String getCreateDate() {
        return createDate;
    }

    @Override
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @Override
    public String getUpdateData() {
        return updateData;
    }

    @Override
    public void setUpdateData(String updateData) {
        this.updateData = updateData;
    }


    /**
     * 添加方法
     */
    abstract void save(OnSaveListener<? extends RoseObject> listener);

    /**
     * 更新
     */
    abstract void update();

    /**
     * 删除
     */
    abstract void delete();
}