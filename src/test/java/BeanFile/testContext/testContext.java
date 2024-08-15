package BeanFile.testContext;

import BeanFile.*;

public class testContext {

    private createPageBean createPageBean;
    private readPageBean readPageBean;
    private updatePageBean updatePageBean;

    public testContext() {

        createPageBean = new createPageBean();
        readPageBean = new readPageBean();
        updatePageBean = new updatePageBean();

    }

    public BeanFile.createPageBean getCreatePageBean() { return createPageBean; }

    public void setCreatePageBean(BeanFile.createPageBean createPageBean) { this.createPageBean = createPageBean; }

    public BeanFile.readPageBean getReadPageBean() { return readPageBean; }

    public void setReadPageBean(BeanFile.readPageBean readPageBean) { this.readPageBean = readPageBean; }

    public BeanFile.updatePageBean getUpdatePageBean() { return updatePageBean; }

    public void setUpdatePageBean(BeanFile.updatePageBean updatePageBean) { this.updatePageBean = updatePageBean; }

}
